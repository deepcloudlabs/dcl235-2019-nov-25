package com.example.app;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import com.example.event.TradeEvent;

@SuppressWarnings("deprecation")
public class ClassicalObserverPatternImp {

	public static void main(String[] args) {
		Observable observable = new TradeEventObservable();
		Observer observer1 = new Observer() {

			@Override
			public void update(Observable o, Object te) {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
				}
				System.err.println(te);
			}
		};
		Observer observer2 = new Observer() { // anonymous class
			private String volume = "0.0";

			@Override
			public void update(Observable o, Object event) {
				TradeEvent te = (TradeEvent) event;
				volume = (new BigDecimal(volume)).add(new BigDecimal(te.getVolume())).toString();
				System.err.println("Volume: " + volume);
			}
		};
		System.err.println(observer1.getClass().getName());
		System.err.println(observer2.getClass().getName());
		observable.addObserver(observer1);
		observable.addObserver(observer2);

		observable.notifyObservers(new TradeEvent("GARAN", "100000", "9.35"));
		observable.notifyObservers(new TradeEvent("GARAN", "100000", "9.40"));
		observable.notifyObservers(new TradeEvent("GARAN", "100000", "9.45"));
		observable.notifyObservers(new TradeEvent("GARAN", "100000", "9.30"));
		observable.notifyObservers(new TradeEvent("GARAN", "100000", "9.25"));
	}


}

@SuppressWarnings("deprecation")
class TradeEventObservable extends Observable {

	@Override
	public void notifyObservers(Object event) {
		setChanged();
		super.notifyObservers(event);
	}

}

interface SampleInterface {
	void fun();

	void gun();
}