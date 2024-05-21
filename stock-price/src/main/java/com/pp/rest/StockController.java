package com.pp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pp.service.IStockPriceService;

@RestController
@RequestMapping("/api")
public class StockController {
@Autowired
private	IStockPriceService service;


@GetMapping("/stockPrice/{companyName}")
public ResponseEntity<Double> getStockPrice(@PathVariable String companyName){
 Double price = service.fetchByCompanyName(companyName);
 return new ResponseEntity<Double>(price,HttpStatus.OK);
}
}
