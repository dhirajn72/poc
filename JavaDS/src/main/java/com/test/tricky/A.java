package com.test.tricky;

public class A {
	A a = new A();
	static {
		System.out.println("Loaded");
	}

	/**
	 * From Java 1.7 onwards, If main method is not available, class won't be loaded
	 * 
	 * 
	 * @param args
	 */
	/*
	public static void main(String[] args) {

	}
	*/
}
