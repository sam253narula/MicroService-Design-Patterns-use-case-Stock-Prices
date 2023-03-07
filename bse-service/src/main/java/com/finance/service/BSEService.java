package com.finance.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.Entity.BSEStockPrice;

@Service
public class BSEService {

	@Autowired
	EntityManager entityManager;

	public List<BSEStockPrice> getStockPrice(String stockName) {
		TypedQuery<BSEStockPrice> query = entityManager.createQuery(
				"SELECT bsesp FROM BSEStockPrice bsesp WHERE bsesp.name = '" + stockName + "'", BSEStockPrice.class);
		return query.getResultList();
	}
}
