package com.winocencio.swapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwapiApplication {

	private static Logger logger = LoggerFactory.getLogger(SwapiApplication.class);
	
	public static void main(String[] args) {
		logger.info("Starting the SWAPI api with recommendation.");
		SpringApplication.run(SwapiApplication.class, args);
		logger.info("SWAPI api with recommendation started and ready to receive requests.");
	}

}
