/**
 * 
 */
package com.java.eight.features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author dhiraj
 *
 */
public class Feature3 {

	public static void main(String[] args) {

		List<Integer> integers = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			integers.add(i);
		}

		Stream<Integer> stream = integers.stream();
		Stream<Integer> parStream = integers.parallelStream();

		Stream<Integer> stream2 = stream.filter(p -> p > 90);
		Stream<Integer> stream3 = parStream.filter(p -> p > 90);

		stream2.forEach(p -> System.out.println(p));
		System.out.println("************");
		stream3.forEach(p -> System.out.println(p));

	}

}
