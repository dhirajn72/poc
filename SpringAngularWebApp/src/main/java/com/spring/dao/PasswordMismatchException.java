/**
 * 
 */
package com.spring.dao;

/**
 * @author dhiraj
 *
 */
public class PasswordMismatchException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PasswordMismatchException(String message) {
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
