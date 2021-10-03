package com.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.Entity.BSEStockPrice;
import com.finance.service.BSEService;

@RestController
public class BSEController {
	
	@Autowired
	BSEService bseService;
	
	@GetMapping("/getPrice")
	public BSEStockPrice getPrice(String stockName) {
		return bseService.getStockPrice(stockName).get(0);
	}

}
















