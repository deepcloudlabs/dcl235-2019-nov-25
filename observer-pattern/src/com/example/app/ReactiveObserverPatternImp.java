package com.example.app;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import com.example.event.TradeEvent;

public class ReactiveObserverPatternImp {

	public static void main(String[] args) throws Exception {
		SubmissionPublisher<TradeEvent> publisher = new SubmissionPublisher<>();
		publisher.subscribe(new AlgoTrader());
		publisher.subscribe(new TradeVolumeSignal());
		List<TradeEvent> events = List.of(new TradeEvent("GARAN", "100000", "9.35"),
				new TradeEvent("GARAN", "200000", "9.25"), new TradeEvent("GARAN", "300000", "9.45"),
				new TradeEvent("GARAN", "200000", "9.30"), new TradeEvent("GARAN", "100000", "9.35"));
		events.forEach(publisher::submit);
		TimeUnit.SECONDS.sleep(10);
		publisher.close();
		System.err.println("Done.");
	}

}

class AlgoTrader implements Subscriber<TradeEvent> {

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(TradeEvent event) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println(event);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println(throwable);

	}

	@Override
	public void onComplete() {
		System.err.println("AlgoTrader is completed.");
	}

}

class TradeVolumeSignal implements Subscriber<TradeEvent> {

	private Subscription subscription;
	private String volume = "0.0";

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(TradeEvent event) {
		volume = (new BigDecimal(volume)).add(new BigDecimal(event.getVolume())).toString();
		System.err.println("Volume: " + volume);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println(throwable);

	}

	@Override
	public void onComplete() {
		System.err.println("TradeVolumeSignal is completed.");
	}

}