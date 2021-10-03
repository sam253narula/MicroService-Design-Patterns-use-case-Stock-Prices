package com.finance.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finance.model.NSEStockPrice;

@FeignClient(url = "http://localhost:8082", name = "NSE-Client")
public interface NSEClient {
	
	@GetMapping("/getPrice")
	public NSEStockPrice getPrice(@RequestParam("stockName") String stockName);
	

}
