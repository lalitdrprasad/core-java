package com.study.practice;

final class Employee {
	private final String PAN_CARD_NUMBER;

	public Employee(String pancardNumber) {
		this.PAN_CARD_NUMBER = pancardNumber;
	}

	public String getPancardNumber() {
		return PAN_CARD_NUMBER;
	}
}

public class ImmutableDemo {
	public static void main(String ar[]) {
		Employee e = new Employee("EGQUU7685K");
		String s1 = e.getPancardNumber();
		System.out.println("Pancard Number: " + s1);
	}
}