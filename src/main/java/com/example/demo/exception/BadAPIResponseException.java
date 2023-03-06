package com.example.demo.exception;


import com.example.demo.enums.ErrorConstants;

public class BadAPIResponseException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6802713204755223111L;

	public BadAPIResponseException(ErrorConstants message, Exception e) {
		
		super( ErrorConstants.getAsJson(message), e );
		
	}	
}