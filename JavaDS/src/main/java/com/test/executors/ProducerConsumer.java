package com.test.executors;

/**
 * @author dhiraj
 *
 */
public class ProducerConsumer {

	private boolean flag = false;
	private int data;

	public ProducerConsumer() {
	}

	public synchronized void produce(int data) {

		if (flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.data = data;
		System.out.println(Thread.currentThread().getName() + " produced: "
				+ data);
		flag = true;
		notify();

	}

	public synchronized void consumed() {

		if (!flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName() + " consumed: "
				+ data--);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		flag = false;
		notify();
	}
}
