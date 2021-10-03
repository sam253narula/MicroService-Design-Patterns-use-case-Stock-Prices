package com.finance.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class NSEStockPrice {
	@Id
	private Long id;
	private String name;
	private double price;
}