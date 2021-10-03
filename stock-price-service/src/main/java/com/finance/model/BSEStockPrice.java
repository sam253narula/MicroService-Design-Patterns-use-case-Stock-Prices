package com.finance.model;

import lombok.Data;

@Data
public class BSEStockPrice {

	private Long id;
	private String name;
	private double price;
}
