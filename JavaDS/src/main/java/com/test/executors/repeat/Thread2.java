/**
 * 
 */
package com.test.executors.repeat;

/**
 * @author dhiraj
 *
 */
public class Thread2 implements Runnable {

	private ProducerAndConsumer producerAndConsumer;

	/**
	 * 
	 */
	public Thread2(ProducerAndConsumer producerAndConsumer) {
		this.producerAndConsumer = producerAndConsumer;
		new Thread(this).start();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		for (int i = 0; i < 10; i++) {
			producerAndConsumer.pop();
		}

	}

}
