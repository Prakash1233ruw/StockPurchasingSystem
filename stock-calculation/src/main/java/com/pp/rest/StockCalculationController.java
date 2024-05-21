package com.pp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pp.client.StockClient;

@RestController
@RequestMapping("/api")
public class StockCalculationController {
    @Autowired
	private StockClient service;
    
    @GetMapping("calc/{companyName}/{quantity}")
    public ResponseEntity<?> calculate(@PathVariable String companyName, @PathVariable Integer quantity){
    	ResponseEntity<?> responseEntity=null;
    	Double totalPrice=null;
    	
    	try {
    	responseEntity = service.getStockPrice(companyName);
    	int status=responseEntity.getStatusCode().value();
    	if(status==200) {
    		Double price = (Double)responseEntity.getBody();
    		totalPrice=price*quantity;
    		String response="the total price is : "+ totalPrice;
    		responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
    	}
    	}catch (Exception e) {
    		responseEntity=new ResponseEntity<>("Company not found",HttpStatus.BAD_REQUEST);

		}
    	
    	return responseEntity;
    }
}
