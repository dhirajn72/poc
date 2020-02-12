/**
 * 
 */
package com.test.executors.repeat;

/**
 * @author dhiraj
 *
 */
public class Thread1 implements Runnable {
	private ProducerAndConsumer producerAndConsumer;

	/**
	 * 
	 */
	public Thread1(ProducerAndConsumer producerAndConsumer) {
		this.producerAndConsumer = producerAndConsumer;
		new Thread(this).start();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		int a = 0;
		for (int i = 0; i < 10; i++) {
			producerAndConsumer.push(a++);
			;
		}

	}

}
