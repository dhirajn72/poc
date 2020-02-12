/**
 * 
 */
package com.spring.aop;

/**
 * @author dhiraj
 *
 */

public class Security {

	public void verifyUser() {
		System.out.println("Security-verifyUser()");
		throw new NullPointerException();
	}

	public void verifyUsername() {
		System.out.println("Security-verifyUsername()");
	}

	public void verifyPassword() {
		System.out.println("Security-verifyPassword()");
	}

}