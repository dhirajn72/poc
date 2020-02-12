/**
 * 
 */
package com.test.executors.repeat;

/**
 * @author dhiraj
 *
 */
public class ProducerAndConsumer {

	private boolean flag = false;
	private int data;

	public synchronized void push(int data) {

		if (flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.data = data;
		System.out.println("Produced : " + data);
		flag = true;
		notify();
	}

	public synchronized void pop() {

		if (!flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		System.out.println("Consumed : " + data--);
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		flag = false;
		notify();

	}

}
