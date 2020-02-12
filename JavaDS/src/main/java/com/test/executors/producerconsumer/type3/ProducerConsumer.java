package com.test.executors.producerconsumer.type3;

/**
 * @author dhiraj
 *
 */
public class ProducerConsumer {

	private boolean flag = false;
	private int data;

	/**
	 * @param x
	 */
	public synchronized void produced(int x) {
		if (flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.data = x;
		System.out.println("procuded: " + data);
		flag = true;
		notify();

	}

	/**
	 * 
	 */
	public synchronized void consumed() {

		if (!flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("consumed: " + data);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		flag = false;
		notify();

	}

}
