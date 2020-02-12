package com.test.singleton;

public class SingletonType2 {

	private SingletonType2() {
		System.out.println("SingletonType2()-DC");
	}

	private static SingletonType2 INSTANCE = null;

	public static SingletonType2 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonType2();
		}
		return INSTANCE;
	}
}
