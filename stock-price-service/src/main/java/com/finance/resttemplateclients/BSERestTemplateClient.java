package com.finance.resttemplateclients;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.finance.model.BSEStockPrice;

@Service
public class BSERestTemplateClient {

	@Autowired
	RestTemplate restTemplate;

	@Async
	public CompletableFuture<BSEStockPrice> getBSEStockPrice(String stockName) {
		String bseURL = "http://localhost:8081/getPrice?stockName=" + stockName;
		CompletableFuture<BSEStockPrice> bseCompletedFuture = null;
		try {
			BSEStockPrice bseStockPrice = restTemplate.getForObject(bseURL, BSEStockPrice.class);
			bseCompletedFuture = CompletableFuture.completedFuture(bseStockPrice);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return bseCompletedFuture;
	}
}
