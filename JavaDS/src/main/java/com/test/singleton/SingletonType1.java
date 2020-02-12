package com.test.singleton;

public class SingletonType1 {

	private SingletonType1() {
		System.out.println("SingletonType1()-DC");
	}

	private final static SingletonType1 INSTANCE = new SingletonType1();

	public static SingletonType1 getInstance() {
		return INSTANCE;
	}

}
