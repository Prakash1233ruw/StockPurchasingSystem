package com.pp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestApiExceptionHandler {
	 @ExceptionHandler(StockNotFoundException.class)
		public ResponseEntity<?> handleExceptionForTestResult(StockNotFoundException e){
			ErrorDetails details=new ErrorDetails("404 Not Found", e.getMessage(), LocalDateTime.now());
			return new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST);
		}
	     
	     @ExceptionHandler(Exception.class)
	 	public ResponseEntity<?> handleExceptionGlobally(Exception e){
	     	 
	 		ErrorDetails details=new ErrorDetails("404 Not Found", e.getMessage(), LocalDateTime.now());
	 		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	 	}
}
