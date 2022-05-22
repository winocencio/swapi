package com.winocencio.swapi.controller;


import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winocencio.swapi.model.People;
import com.winocencio.swapi.service.PeopleService;

@RestController
@RequestMapping(path="/people")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;
	
	@GetMapping("/{id}")
	public ResponseEntity<People> getById(@PathVariable @NotBlank @NumberFormat Integer id){
		
		People people = peopleService.getById(id);
		return new ResponseEntity<>(people,HttpStatus.OK);
	}
	
	@GetMapping("/findByName/{name}")
	public ResponseEntity<List<People>> findByName(@PathVariable @NotBlank String name){
		
		List<People> peoples = peopleService.findByName(name);
		return new ResponseEntity<>(peoples,HttpStatus.OK);
	}
}
