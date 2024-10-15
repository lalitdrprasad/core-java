package com.recursion;

public class CountDidits {
	
	static int counter = 0;

	static int count(int n) {
		if (n != 0) {
			count(n / 10);
			++counter;
		}
		return counter;
	}

	public static void main(String[] args) {
		System.out.println(count(97979797));
	}

}
