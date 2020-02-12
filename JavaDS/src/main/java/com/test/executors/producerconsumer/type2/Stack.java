package com.test.executors.producerconsumer.type2;

class Stack {
	int x;
	boolean flag = false;

	public synchronized void push(int x) {

		if (flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		this.x = x;
		System.out.println("x is pushed:" + x);
		flag = true;
		notify();
	}

	public synchronized int pop() {

		if (!flag) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("x is popped:" + x);

		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		flag = false;
		notify();
		return x;
	}

}
