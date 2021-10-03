package com.finance.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class StockPrices {
	private final double nsePrice;
	private final double bsePrice;
}
