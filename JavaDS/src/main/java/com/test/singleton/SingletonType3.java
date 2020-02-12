package com.test.singleton;

public class SingletonType3 {

	private SingletonType3() {
		System.out.println("SingletonType3()-DC");
	}

	private static SingletonType3 INSTANCE = null;
	static {
		if (INSTANCE == null) {
			INSTANCE = new SingletonType3();
		}
	}

	public static SingletonType3 getInstance() {
		return INSTANCE;
	}
}
