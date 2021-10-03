package com.finance.resttemplateclients;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.finance.model.NSEStockPrice;

@Service
public class NSERestTemplateClient {

	@Autowired
	RestTemplate restTemplate;

	@Async
	public CompletableFuture<NSEStockPrice> getNSEStockPrice(String stockName) {
		String nseURL = "http://localhost:8082/getPrice?stockName=" + stockName;
		NSEStockPrice nseStockPrice = restTemplate.getForObject(nseURL, NSEStockPrice.class);
		CompletableFuture<NSEStockPrice> nseCompletableFuture = CompletableFuture.completedFuture(nseStockPrice);
		return nseCompletableFuture;
	}

}
