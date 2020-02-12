package com.test.executors;

public class Client {
	public static void main(String[] args) {

		System.out.println("main starts !");
		ProducerConsumer producerConsumer = new ProducerConsumer();

		new Thread1(producerConsumer);
		new Thread2(producerConsumer);

		System.out.println("main ends !");

	}
}
