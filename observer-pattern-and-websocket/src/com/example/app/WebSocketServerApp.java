package com.example.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class WebSocketServerApp {

	public static void main(String[] args) throws Exception {
		Server server = new Server(7001);
        WebSocketHandler wsHandler = new WebSocketHandler() {
            @Override
            public void configure(WebSocketServletFactory factory) {
                factory.register(LotteryWebSocketServerEndpoint.class);
            }
        };
        server.setHandler(wsHandler);
        server.start();
        server.join();
	}

}
