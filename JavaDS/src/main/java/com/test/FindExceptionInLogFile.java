package com.test;

import java.io.File;
import java.util.Scanner;

public class FindExceptionInLogFile {
	public static void main(String[] args) {

		try {

			File dir = new File(
					"/home/dhiraj/com/myfolder/learning/workspace/JavaDS/src/resources/");

			for (File file : dir.listFiles()) {
				//System.out.println(file);
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String nextLine = scanner.nextLine();
					boolean result = nextLine.contains("Exception");
					if (result) {
						System.err.println(file + " contains logged exception");
					}

				}
				scanner.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done !");
	}
}
