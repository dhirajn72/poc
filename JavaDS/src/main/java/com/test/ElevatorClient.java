package com.test;

import java.util.Scanner;

public class ElevatorClient {
	public static void main(String[] args) {

		Elevator elevator = new Elevator();
		char ch;

		do {
			System.out.println("Enter your floor number: ");
			Scanner scanner = new Scanner(System.in);
			int floor = Integer.valueOf(scanner.next());

			/*
			 * FIX ME !!
			 */
			if (elevator.getDefaultFloor() == floor) {

				System.out.println("Door opens !");

			} else if (elevator.getDefaultFloor() < floor) {

				for (int i = elevator.getDefaultFloor(); elevator
						.getDefaultFloor() >= floor; i++) {
					elevator.elevatorUp(i);
					System.out.println("Reached floor :" + i);
				}

			} else if (elevator.getDefaultFloor() > floor) {

				for (int i = elevator.getDefaultFloor(); elevator
						.getDefaultFloor() >= floor; i--) {
					elevator.elevatorDown();
					System.out.println("Reached floor :" + i);
				}

			}
			System.out.println("\n\nDo you want to continue (Type y or n) \n");
			ch = scanner.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}

}
