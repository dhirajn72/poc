package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffledOutput {
	public static void main(String[] args) {

		String q1 = "A?";
		String q2 = "B?";
		String q3 = "C?";
		String q4 = "D?";
		String q5 = "E?";

		List<String> questions = new ArrayList<String>();
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		questions.add(q5);
		
		Collections.shuffle(questions);
		System.out.println(questions);

	}

}
