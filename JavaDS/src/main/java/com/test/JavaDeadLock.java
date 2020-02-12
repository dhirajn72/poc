package com.test;

/**
 * Java Program for deadlock situation
 * 
 * @author dhiraj
 *
 */
public class JavaDeadLock {

	private static Object ob1 = new Object();
	private static Object ob2 = new Object();

	/**
	 * First Thread
	 * 
	 * @author dhiraj
	 *
	 */
	static class Thread1 implements Runnable {
		public void run() {
			synchronized (ob1) {
				System.out.println("Locked ob1");
				synchronized (ob2) {
					System.out.println("Waiting for ob2");
				}
			}
		}
	}

	/**
	 * Second Thread
	 * 
	 * @author dhiraj
	 *
	 */
	static class Thread2 implements Runnable {
		public void run() {
			synchronized (ob2) {
				System.out.println("Locked ob2");
				synchronized (ob1) {
					System.out.println("Waiting for ob1");
				}
			}
		}
	}

	/**
	 * Main method to test the deadlock program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main starts!");
		Thread thread1 = new Thread(new Thread1());
		Thread thread2 = new Thread(new Thread2());
		thread1.start();
		thread2.start();

		System.out.println("Main Ends!");

	}
}
