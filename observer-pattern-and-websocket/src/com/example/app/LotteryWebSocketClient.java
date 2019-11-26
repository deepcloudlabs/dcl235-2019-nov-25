package com.example.app;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public class LotteryWebSocketClient {

	public static void main(String[] args) throws Exception {
		var client = new LotteryWSClient();
		HttpClient.newHttpClient().newWebSocketBuilder().buildAsync(URI.create("ws://localhost:7001/"), client);
		TimeUnit.SECONDS.sleep(5);
	}

}

class LotteryWSClient implements WebSocket.Listener {

	@Override
	public void onOpen(WebSocket webSocket) {
		System.out.println("Connected to server!");
		webSocket.request(1);
	}

	@Override
	public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
		System.out.println(data);
		webSocket.request(1);
		return null;
	}

}