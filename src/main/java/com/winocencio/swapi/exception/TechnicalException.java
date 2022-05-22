package com.winocencio.swapi.exception;

public class TechnicalException extends RuntimeException {

	private static final long serialVersionUID = 7947166131065889679L;

	public TechnicalException(){
		super();
	}
	
	public TechnicalException(String message) {
		super(message);
	}
	
	public TechnicalException(Throwable cause) {
		super(cause);
	}
}
