package com.test.executors.producerconsumer.type3;

public class Thread1 implements Runnable {
	private ProducerConsumer producerConsumer;

	public Thread1(ProducerConsumer producerConsumer) {
		this.producerConsumer = producerConsumer;
	}

	public void run() {
		int x = 0;
		for (int i = 0; i < 10; i++) {
			producerConsumer.produced(x++);
		}
	}
}
