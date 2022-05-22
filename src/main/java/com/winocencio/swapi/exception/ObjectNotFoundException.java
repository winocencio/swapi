package com.winocencio.swapi.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7891249064835169415L;

	public ObjectNotFoundException(){
		super();
	}
	
	public ObjectNotFoundException(String message) {
		super(message);
	}
}
