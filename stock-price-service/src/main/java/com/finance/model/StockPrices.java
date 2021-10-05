package com.finance.model;

public class StockPrices {
	private final double nsePrice;
	private final double bsePrice;

	public StockPrices(double nsePrice, double bsePrice) {
		super();
		this.nsePrice = nsePrice;
		this.bsePrice = bsePrice;
	}

	public double getNsePrice() {
		return nsePrice;
	}

	public double getBsePrice() {
		return bsePrice;
	}

	@Override
	public String toString() {
		return "StockPrices [nsePrice=" + nsePrice + ", bsePrice=" + bsePrice + "]";
	}

}
