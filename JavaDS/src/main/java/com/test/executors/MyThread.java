package com.test.executors;

/**
 * @author dhiraj
 *
 */
public class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			System.out.println(i + " -->" + this.getName());
		}
	}

	public MyThread() {
		System.out.println(this.getName() + "#######starts ########");
		this.start();
	}
}
