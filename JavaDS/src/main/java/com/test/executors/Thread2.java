package com.test.executors;

/**
 * @author dhiraj
 *
 */
public class Thread2 implements Runnable {
	private ProducerConsumer producerConsumer;

	public Thread2(ProducerConsumer producerConsumer) {
		this.producerConsumer = producerConsumer;
		Thread t1 = new Thread(this, "Thread-B");
		t1.start();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			producerConsumer.consumed();
		}
	}

}
