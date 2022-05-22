package com.winocencio.swapi.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winocencio.swapi.model.People;
import com.winocencio.swapi.model.Specie;

@Service
public class PeopleService {

	@Autowired
	private RestConsumerService restConsumerService;
	
	private static Logger logger = LoggerFactory.getLogger(PeopleService.class);
	
	public People getById(Integer id) {
		logger.info("Listing people with relationships and recommendations by id: {}",id);
		People people = restConsumerService.getPeople(id);
		
		setSimilars(people);
		
		return people;
	}

	private void setSimilars(People people) {
		logger.info("Setting similars peoples by species.");
		people.setPeopleSimiliarIds(new ArrayList<>());
		
		for (Integer specieId : people.getSpecieIds()) {
			Specie specie = restConsumerService.getSpecie(specieId);
			
			specie.getPeopleIds().remove(people.getId());
			people.getPeopleSimiliarIds().addAll(specie.getPeopleIds());
			
			if(people.getPeopleSimiliarIds().size() > 2) {
				people.setPeopleSimiliarIds(people.getPeopleSimiliarIds().subList(0, 3));
				break;
			}
		}
	}
	
	public List<People> findByName(String name) {
		logger.info("Listing peoples with relationships and recommendations by name: {}", name);
		List<People> findPeoples = restConsumerService.findPeoples(name);
		
		findPeoples.stream().forEach(this::setSimilars);
		
		return findPeoples;
	}
}