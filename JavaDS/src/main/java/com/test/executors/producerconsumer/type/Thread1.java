package com.test.executors.producerconsumer.type;

/**
 * @author dhiraj
 *
 */
public class Thread1 implements Runnable {
	private ProducerConsumer producerConsumer;

	public Thread1(ProducerConsumer producerConsumer) {
		this.producerConsumer = producerConsumer;
	}

	public void run() {
		int a = 0;
		for (int i = 0; i < 10; i++) {
			producerConsumer.produce(a++);
		}
	}
}
