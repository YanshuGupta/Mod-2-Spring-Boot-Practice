package com.cg.exception;

@SuppressWarnings("serial")
public class EmptyRecordException extends Exception{

	public EmptyRecordException() {
		super();
	}
	
	public EmptyRecordException(String message) {
		super(message);
	}
}
