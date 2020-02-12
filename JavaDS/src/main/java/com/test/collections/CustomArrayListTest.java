package com.test.collections;

public class CustomArrayListTest {
	public static void main(String[] args) {

		try {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			arrayList.add(34);// 0
			arrayList.add(25);// 1
			arrayList.add(87);// 2
			arrayList.add(13);// 3
			arrayList.add(90);// 4
			arrayList.add(56);// 5
			arrayList.add(49);// 6
			arrayList.display();
			System.out.println("*********");
			System.out.println(arrayList.get(7));
			System.out.println("*********");
			System.out.println(arrayList.size());
			System.out.println("*********");
			System.out.println("Removed element: " + arrayList.remove(8)); // java.lang.IndexOutOfBoundsException
																			// Exception
			arrayList.display();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
