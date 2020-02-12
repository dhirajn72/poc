package com.test.executors.producerconsumer.type;

/**
 * @author dhiraj
 *
 */
public class Client {
	public static void main(String[] args) {

		try {
			ProducerConsumer producerConsumer = new ProducerConsumer();
			Thread1 thread1 = new Thread1(producerConsumer);
			Thread2 thread2 = new Thread2(producerConsumer);

			new Thread(thread1, "A").start();
			new Thread(thread2, "B").start();

		} catch (Exception e) {
			System.out.println("Exception caught in main");
			e.printStackTrace();

		}

	}
}
