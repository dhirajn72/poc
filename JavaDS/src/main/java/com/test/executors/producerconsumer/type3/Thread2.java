package com.test.executors.producerconsumer.type3;

public class Thread2 implements Runnable {
	private ProducerConsumer producerConsumer;

	public Thread2(ProducerConsumer producerConsumer) {
		this.producerConsumer = producerConsumer;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			producerConsumer.consumed();
		}

	}

}
