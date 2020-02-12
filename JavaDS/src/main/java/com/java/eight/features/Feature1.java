/**
 * 
 */
package com.java.eight.features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author dhiraj
 *
 */
public class Feature1 {
	public static void main(String[] args) {

		List<Integer> integers = new ArrayList<Integer>();
		integers.add(78);
		integers.add(67);
		integers.add(35);
		integers.add(90);
		integers.add(35);

		integers.forEach(new Consumer<Integer>() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.util.function.Consumer#accept(java.lang.Object)
			 */
			public void accept(Integer t) {
				System.out.println(t);
			}
		});

		System.out.println("**********");
		CustomConsumer customConsumer = new CustomConsumer();
		integers.forEach(customConsumer);

	}
}

class CustomConsumer implements Consumer<Integer> {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.function.Consumer#accept(java.lang.Object)
	 */
	public void accept(Integer t) {
		System.out.println("under CustomConsumer");
		System.out.println(t);

	}
}
