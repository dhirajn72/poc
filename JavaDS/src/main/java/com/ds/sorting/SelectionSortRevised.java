/**
 * 
 */
package com.ds.sorting;

import java.util.Arrays;

/**
 * @author dhiraj
 *
 */
public class SelectionSortRevised {

	public static void sort(int[] arr) {

		int len = arr.length;

		for (int i = 0; i < len - 1; i++) {

			int mid_ind = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[mid_ind]) {
					mid_ind = j;
				}

			}
			int temp = arr[mid_ind];
			arr[mid_ind] = arr[i];
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

	public static void main(String[] args) {
		SelectionSortRevised ob = new SelectionSortRevised();
		// int arr[] = { 64, 25, 12, 22, 11 };

		int arr[] = { -634, -524, -5, 4, 42, 2643, 23, -9520, 1852, 3, -510, -510, 3, 3, 3, 15 };

		System.out.println("Unsorted array: " + Arrays.toString(arr));
		ob.sort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);

	}

}
