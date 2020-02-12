package com.test.executors.producerconsumer.type3;

public class Client {
	public static void main(String[] args) {
		// System.out.println("main starts !");

		ProducerConsumer producerConsumer = new ProducerConsumer();
		new Thread(new Thread1(producerConsumer)).start();
		new Thread(new Thread2(producerConsumer)).start();

		// System.out.println("main ends !");
	}

}
