package com.test.executors.producerconsumer.type2;

class ThreadB extends Thread {
	Stack stack;

	public ThreadB(Stack stack1, String name) {

		this.stack = stack1;
		Thread thread = new Thread(this, name);
		thread.start();

	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			stack.pop();
		}
	}
}
