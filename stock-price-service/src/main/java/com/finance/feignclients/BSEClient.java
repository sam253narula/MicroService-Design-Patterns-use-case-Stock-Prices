package com.finance.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finance.model.BSEStockPrice;

@FeignClient(url = "http://localhost:8081", name = "BSE-Client")
public interface BSEClient {

	@GetMapping("/getPrice")
	public BSEStockPrice getPrice(@RequestParam("stockName") String stockName);
}
