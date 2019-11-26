package com.example.app;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class LotteryWebSocketServerEndpoint {
	private static final Random random = new SecureRandom();

	@OnWebSocketConnect
	public void onMessage(Session session) {
		IntStream.range(0, 1000).forEach(i -> {
			try {
				session.getRemote().sendString(random.ints(1, 50).distinct().limit(6).sorted().boxed()
						.map(Object::toString).collect(Collectors.joining(",", "[", "]")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@OnWebSocketClose
	public void onClose(int statusCode, String reason) {
		System.out.println("Close: statusCode=" + statusCode + ", reason=" + reason);
	}

	@OnWebSocketError
	public void onError(Throwable t) {
		System.out.println("Error: " + t.getMessage());
	}

	@OnWebSocketMessage
	public void onMessage(String message) {
		System.out.println("Message: " + message);
	}
}
