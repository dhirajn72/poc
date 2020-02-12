package com.test.collections;

import java.util.Arrays;

/**
 * Custom implementation of ArrayList
 * 
 * @author dhiraj
 *
 * @param <E>
 */
public class ArrayList<E> {

	private static final int INITIAL_CAPACITY = 10;
	private Object[] elemenArray = {};
	private int size = 0;

	/**
	 * Default Constructor
	 */
	public ArrayList() {
		elemenArray = new Object[INITIAL_CAPACITY];
	}

	/**
	 * Method to add element
	 * 
	 * @param e
	 */
	public void add(E e) {
		if (size == elemenArray.length) {
			increaseArraySize();
		}
		elemenArray[size++] = e;

	}

	/**
	 * Method to increase Array Size
	 * 
	 */
	private void increaseArraySize() {
		elemenArray = Arrays.copyOf(elemenArray, INITIAL_CAPACITY * 2);
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size "
					+ index);
		}
		return (E) elemenArray[index - 1];
	}

	/**
	 * Method to remove element
	 * 
	 * @param index
	 * @return
	 */
	public Object remove(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size "
					+ index);
		}
		Object removedElement = elemenArray[index - 1];

		for (int i = index - 1; i < size - 1; i++) {
			elemenArray[i] = elemenArray[i + 1];
		}
		size--;
		return removedElement;
	}

	/**
	 * Method to display array elements
	 */
	public void display() {
		for (int i = 0; i <= size - 1; i++) {
			System.out.println(elemenArray[i] + " ");
		}
	}

	/**
	 * Returns size of ArrayList
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

}
