package com.test.executors;

/**
 * @author dhiraj
 *
 */
public class Thread1 implements Runnable {
	private ProducerConsumer producerConsumer;

	public Thread1(ProducerConsumer producerConsumer) {
		this.producerConsumer = producerConsumer;
		Thread t1 = new Thread(this,"Thread-A");
		t1.start();
	}

	public void run() {
		int a = 0;
		for (int i = 0; i < 10; i++) {
			producerConsumer.produce(a++);
		}
	}
}
