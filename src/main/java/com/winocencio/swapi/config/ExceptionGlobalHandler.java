package com.winocencio.swapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.winocencio.swapi.exception.TechnicalException;

@RestControllerAdvice
public class ExceptionGlobalHandler {
	
	private static Logger logger = LoggerFactory.getLogger(ExceptionGlobalHandler.class);

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> handleMethodNotSuported(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
		logger.info("Method Not Supported - {}",httpRequestMethodNotSupportedException.getMessage());
		return new ResponseEntity<>(httpRequestMethodNotSupportedException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> handleMethodNotSuported(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
		logger.info("ArgumentTypeMismatch - {}",methodArgumentTypeMismatchException.getMessage());
		return new ResponseEntity<>("Invalid argument",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RestClientException.class)
	public ResponseEntity<String> handleRestClient(RestClientException restClientException) {
		logger.error("Error on SWAPI service - {}",restClientException.getMessage());
		return new ResponseEntity<>("Error on SWAPI service.",HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleHttpClientError(HttpClientErrorException httpClientErrorException) {
		logger.info(httpClientErrorException.getMessage());
		return new ResponseEntity<>(httpClientErrorException.getStatusCode());
	}
	
	@ExceptionHandler(TechnicalException.class)
	public ResponseEntity<String> handleTechnicalException(TechnicalException technicalException) {
		logger.error("TechnicalException : ",technicalException);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
