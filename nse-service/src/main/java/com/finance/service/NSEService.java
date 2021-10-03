package com.finance.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.Entity.NSEStockPrice;

@Service
public class NSEService {
	@Autowired
	EntityManager entityManager;

	public List<NSEStockPrice> getStockPrice(String stockName) {
		TypedQuery<NSEStockPrice> query = entityManager.createQuery(
				"SELECT nsesp FROM NSEStockPrice nsesp WHERE nsesp.name = '" + stockName + "'", NSEStockPrice.class);
		return query.getResultList();
	}
}
