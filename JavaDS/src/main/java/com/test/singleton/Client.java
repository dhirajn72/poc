package com.test.singleton;

public class Client {
	public static void main(String[] args) {

		System.out.println(SingletonType1.getInstance());
		System.out.println(SingletonType2.getInstance());
		System.out.println(SingletonType3.getInstance());
		System.out.println(SingletonType1.getInstance());
		System.out.println(SingletonType2.getInstance());
		System.out.println(SingletonType3.getInstance());
		

	}
}
