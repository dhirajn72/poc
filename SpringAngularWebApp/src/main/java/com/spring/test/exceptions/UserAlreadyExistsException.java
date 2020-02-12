/**
 * 
 */
package com.spring.test.exceptions;

/**
 * @author dhiraj
 *
 */
public class UserAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UserAlreadyExistsException(String email) {
		super(email);
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
