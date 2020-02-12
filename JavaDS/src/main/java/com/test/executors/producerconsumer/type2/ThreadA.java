package com.test.executors.producerconsumer.type2;

class ThreadA extends Thread {
	Stack stack;

	public ThreadA(Stack stack1, String name) {
		this.stack = stack1;
		Thread thread = new Thread(this, name);
		thread.start();
	}

	@Override
	public void run() {
		int a = 1;
		for (int i = 0; i < 10; i++) {
			stack.push(a++);
		}
	}
}
