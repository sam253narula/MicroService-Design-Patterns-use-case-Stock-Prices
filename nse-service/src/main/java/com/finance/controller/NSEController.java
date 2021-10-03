package com.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.Entity.NSEStockPrice;
import com.finance.service.NSEService;

@RestController
public class NSEController {

	@Autowired
	NSEService nseService;
	
	@GetMapping("/getPrice")
	public NSEStockPrice getPrice(String stockName) {
		return nseService.getStockPrice(stockName).get(0);
	}

}
















