/**
 * 
 */
package com.spring.test.exceptions;

/**
 * @author dhiraj
 *
 */
public class EmailDoesNotExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EmailDoesNotExistsException(String message) {
		super(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
