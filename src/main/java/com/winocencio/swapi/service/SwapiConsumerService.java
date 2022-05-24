package com.winocencio.swapi.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.winocencio.swapi.exception.TechnicalException;
import com.winocencio.swapi.model.People;
import com.winocencio.swapi.model.Specie;

@Service
public class SwapiConsumerService {

private RestTemplate restTemplate;

//	TODO @Value("${SWAPI_URL}")
	private static final String URL_PATH_ROOT = "https://swapi.py4e.com/api/";
	private static final String URL_PATH_GET =  URL_PATH_ROOT + "%s/%s";
	private static final String URL_PATH_FIND = URL_PATH_ROOT + "%s/?search=%s";
	
	private static Logger logger = LoggerFactory.getLogger(SwapiConsumerService.class);
	
	public SwapiConsumerService() {
		this.restTemplate = new RestTemplate();
	}
	
	public People getPeople(Integer id) {
		return this.get("people", id, People.class);
	}
	
	public Specie getSpecie(Integer id) {
		return this.get("species", id, Specie.class);
	}
	
	public List<People> findPeoples(String name) {
		return this.find("people", name, People[].class);
	}
	
	private <T> T get(String entityPath,Integer argument,Class<T> type) {
		logger.info("Getting {} from SWAPI!",entityPath);
		
		ResponseEntity<T> response = restTemplate.getForEntity(getURI(URL_PATH_GET, entityPath,String.valueOf(argument)), type);
		
		if(!response.getStatusCode().equals(HttpStatus.OK))
			throw new RestClientException("error: " + response.getStatusCode());
		
		return response.getBody();
	}
	
	
	private <T> List<T> find(String entityPath,String argument,Class<T[]> clasz) {
		logger.info("Getting {} from SWAPI!",entityPath);
		
		ResponseEntity<String> response = restTemplate.getForEntity(getURI(URL_PATH_FIND,entityPath, argument), String.class);
		
		if(!response.getStatusCode().equals(HttpStatus.OK))
			throw new RestClientException("error: " + response.getStatusCode());
		
		T[] arrayObjectT = getArrayFromBody(clasz, response.getBody(),"results");
		
		if(arrayObjectT == null || arrayObjectT.length == 0)
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		
		return Arrays.asList(arrayObjectT);
	}

	private URI getURI(String url,String entityPath, String argument){
		try {
			return new URI(String.format(url, entityPath,argument));
		} catch(URISyntaxException e) {
			throw new TechnicalException(e.getCause());
		}
	}

	private <T> T[] getArrayFromBody(Class<T[]> clasz, String body,String arrayField){
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(body).get(arrayField);
			return mapper.treeToValue(jsonNode, clasz);
		} catch (JsonProcessingException e) {
			throw new TechnicalException(e.getCause());
		} 
	}
	
}