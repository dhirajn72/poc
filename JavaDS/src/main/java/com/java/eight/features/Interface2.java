/**
 * 
 */
package com.java.eight.features;

/**
 * 
 * If the inteface is marked with {@code:  java.lang.FunctionalInterface}, then
 * only one method is allowed inside the interface, but there can be more than
 * one default and static methods. Remember! default and static methods must
 * contain body
 * 
 * @author dhiraj
 *
 */
@FunctionalInterface
public interface Interface2 {

	void print();

	default void printAgain() {
		System.out.println("@FunctionalInterface Interface2 : printAgain()");
	}

	static void printMessage() {
		System.out.println("@FunctionalInterface Interface1 : printMessage()");
	}
}
