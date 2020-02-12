package com.test;

public class Elevator {

	private int floors;
	private boolean flag;
	private int choice;
	private int defaultFloor;

	public Elevator() {
		floors = 10;
		flag = true;
		choice = 0;
		defaultFloor = 5;
	}

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public int getDefaultFloor() {
		return defaultFloor;
	}

	public void setDefaultFloor(int defaultFloor) {
		this.defaultFloor = defaultFloor;
	}

	public void elevatorDown() {
		System.out.println("elevatorDown() called");
	}

	public void elevatorUp(int floor) {
		System.out.println("elevatorUp() called");

	}

}
