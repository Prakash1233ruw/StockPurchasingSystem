package com.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.dao.StockRepository;
import com.pp.exception.StockNotFoundException;
import com.pp.model.StockPrice;
@Service
public class StockServiceImpl implements IStockPriceService{

	@Autowired
	private StockRepository repository;
	@Override
	public Double fetchByCompanyName(String companyName) {
		
	StockPrice stockPrice = repository.findByCompanyName(companyName) ;
	if(stockPrice==null) {
		throw new StockNotFoundException("Stock price is not available for the given company ");
	}
	     return stockPrice.getCompanyPrice();
	}

}
