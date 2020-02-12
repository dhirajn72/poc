/**
 * 
 */
package com.spring.aop;

/**
 * @author dhiraj
 *
 */

public class Logging {

	public void beginLogging() {
		System.out.println("Logging-beginLogging()");
	}

	public void endLogging() {
		System.out.println("Logging-endLogging()");
	}
	
	public void throwsException() {
		System.out.println("Logging-throwsException()");
	}

}