package com.example.app;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

public class ParallelOkexRestClientWithNewHttpClientApi {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		List.of("btc_usdt", "eth_btc", "ltc_btc", "xrp_btc", "eos_btc", "neo_btc").parallelStream().forEach(symbol -> {
			URI restUri;
			try {
				restUri = new URI("https://www.okex.com/api/v1/depth.do?symbol=" + symbol + "&limit=200");
				HttpRequest request = HttpRequest.newBuilder().GET().uri(restUri).build();
				client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body)
						.thenAccept(System.err::println).join();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		});

	}
}
