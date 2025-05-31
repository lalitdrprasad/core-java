package com.study.exception;

class InvalidAgeException extends Exception {
	private static final long serialVersionUID = 1L;

	InvalidAgeException(String s) {
		super(s);
	}
}

public class TestCustomException1 {

	static void validate(int age) throws InvalidAgeException {
		if (age < 18)
			throw new InvalidAgeException("not valid");
		else
			System.out.println("welcome to vote");
	}

	public static void main(String args[]) {
		try {
			validate(17);
		} catch (Exception ex) {
			System.out.println("Exception occured: " + ex);
		}
	}
}
