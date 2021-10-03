package com.finance.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.feignclients.BSEClient;
import com.finance.feignclients.NSEClient;
import com.finance.model.BSEStockPrice;
import com.finance.model.NSEStockPrice;
import com.finance.model.StockPrices;
import com.finance.resttemplateclients.BSERestTemplateClient;
import com.finance.resttemplateclients.NSERestTemplateClient;

import io.swagger.annotations.ApiOperation;

@RestController
public class StockPriceController {

	@Autowired
	BSEClient bseClient;

	@Autowired
	NSEClient nseClient;

	@Autowired
	BSERestTemplateClient bseRestTemplateClient;

	@Autowired
	NSERestTemplateClient nseRestTemplateClient;

	@GetMapping("/getStockPrices")
	public StockPrices getStockPrice(String stockName) {
		BSEStockPrice bsePrice = bseClient.getPrice(stockName);
		NSEStockPrice nsePrice = nseClient.getPrice(stockName);
		return new StockPrices(nsePrice.getPrice(), bsePrice.getPrice());
	}

	// Async call with restTemplate and Spring Boot Async Configuration, Feign
	// Client does'nt supports Async calls yet
	// Feign Client Async Issue Form Link :
	// https://github.com/OpenFeign/feign/issues/361
	
	// Below when we make parallel call to NSE and BSE, it is called as Scatter and Gather Design Pattern
	@ApiOperation(value = "This API is much faster becuse we are doing async or call it parallel call to nse and bse apis")
	@GetMapping("/getStockPricesFaster")
	public StockPrices getStockPricesFaster(String stockName) throws InterruptedException, ExecutionException {
		CompletableFuture<BSEStockPrice> bseCompletedFuture = bseRestTemplateClient.getBSEStockPrice(stockName);
		CompletableFuture<NSEStockPrice> nseCompletableFuture = nseRestTemplateClient.getNSEStockPrice(stockName);
		StockPrices prices = new StockPrices(bseCompletedFuture.get().getPrice(),
				nseCompletableFuture.get().getPrice());
		return prices;
	}

	@GetMapping("/getNSEStockPrice")
	public NSEStockPrice getNSEStockPrice(String stockName) {
		return nseClient.getPrice(stockName);
	}

	@GetMapping("getBSEStockPrice")
	public BSEStockPrice getBSEStockPrice(String stockName) {
		return bseClient.getPrice(stockName);
	}

}
