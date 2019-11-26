package com.example.app;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;

public class EventDrivenObserverPatternWebSocketClient {

	public static void main(String[] args) throws Exception {
		var client = new BinanceWebsocketClient();
		HttpClient.newHttpClient().newWebSocketBuilder()
				.buildAsync(URI.create("wss://stream.binance.com:9443/ws/btcusdt@trade"), client);
		Thread.sleep(60_000);
	}

}

class BinanceWebsocketClient implements WebSocket.Listener {

	@Override
	public void onOpen(WebSocket webSocket) {
		System.out.println("Connected to binance!");
		webSocket.request(1);
	}

	@Override
	public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
		System.out.println(data);
		webSocket.request(1);
		return null;
	}

}