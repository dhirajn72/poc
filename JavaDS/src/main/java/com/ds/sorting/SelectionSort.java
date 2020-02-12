/**
 * 
 */
package com.ds.sorting;

import java.util.Arrays;

/**
 * @author dhiraj
 *
 */
// Java program for implementation of Selection Sort
public class SelectionSort {
	void sort(int arr[]) {

		int length = arr.length;
		for (int i = 0; i < length - 1; i++) {

			int min_idx = i;

			for (int j = i + 1; j < length; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;

		}
	}

	// Prints the array
	void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();

	}

	// Driver code to test above
	public static void main(String args[]) {
		SelectionSort ob = new SelectionSort();
		// int arr[] = { 64, 25, 12, 22, 11 };

		int arr[] = { -634, -524, -5, 4, 42, 2643, 23, -9520, 1852, 3, -510, -510, 3, 3, 3, 15 };

		System.out.println("Unsorted array: " + Arrays.toString(arr));
		ob.sort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}
}