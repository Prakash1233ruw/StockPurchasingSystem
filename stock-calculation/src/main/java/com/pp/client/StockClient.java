package com.pp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "stock-price")
public interface StockClient {
	@GetMapping("/api/stockPrice/{companyName}")
	public ResponseEntity<Double> getStockPrice(@PathVariable String companyName);
}
