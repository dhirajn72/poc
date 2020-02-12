/**
 * 
 */
package com.java.eight.features;

/**
 * @author dhiraj
 *
 */
public class Feature2 implements Interface1, Interface2 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.java.eight.features.Interface1#print()
	 */
	@Override
	public void print() {
		System.out.println("ovverriden method print()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.java.eight.features.Interface1#printAgain()
	 */

	@Override
	public void printAgain() {
		System.out.println("Feature2 : printAgain()");

	}

	public static void main(String[] args) {

		Feature2 feature2 = new Feature2();
		feature2.print();
		feature2.printAgain();
		// feature2.printMessage();
		Interface1.printMessage();

	}

}
