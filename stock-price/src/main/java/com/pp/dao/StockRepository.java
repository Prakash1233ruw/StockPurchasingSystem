package com.pp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pp.model.StockPrice;

public interface StockRepository extends JpaRepository<StockPrice,Integer>{
 public StockPrice findByCompanyName(String companyName);
	
}
