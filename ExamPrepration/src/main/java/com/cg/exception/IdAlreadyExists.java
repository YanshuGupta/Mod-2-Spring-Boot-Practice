package com.cg.exception;

@SuppressWarnings("serial")
public class IdAlreadyExists extends Exception {

	public IdAlreadyExists() {
		super();
	}
	
	public IdAlreadyExists(String message) {
		super(message);
	}
}
