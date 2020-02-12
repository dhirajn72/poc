/**
 * 
 */
package com.test.executors.repeat;

/**
 * @author dhiraj
 *
 */
public class Client {
	public static void main(String[] args) {

		try {
			ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
			new Thread1(producerAndConsumer);
			new Thread2(producerAndConsumer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
