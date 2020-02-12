package com.test.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

	public static void main(String[] args) {

		System.out.println("main starts");
		ExecutorService service = Executors.newFixedThreadPool(5);
		service.execute(new MyThread());
		service.execute(new MyThread());
		service.execute(new MyThread());
		service.execute(new MyThread());
		service.execute(new MyThread());

		System.out.println("main ends");
		service.shutdown();

	}

}
