package com.test.executors.producerconsumer.type;

/**
 * @author dhiraj
 *
 */
public class ProducerConsumer {

	private boolean flag = false;
	private int data;

	public ProducerConsumer() {
	}

	/**
	 * @param x
	 */
	public synchronized void produce(int x) {

		if (flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		this.data = x;
		System.out.println(Thread.currentThread().getName() + " produced: "
				+ data);
		flag = true;
		notify();
	}

	/**
	 * @return
	 */
	public synchronized int consume() {

		if (!flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		System.out.println(Thread.currentThread().getName() + " consumed: "
				+ data);
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		flag = false;
		notify();
		return data;

	}
}