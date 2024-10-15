package com.recursion;

import java.util.Random;

public class EvenOdd {
	
	static void check(int n) {
		if (n-- > 1)
			check(n);
		if (n % 2 == 0)
			System.out.println(n + " is Even");
		else
			System.out.println(n + " is Odd");
	}

	public static void main(String[] args) {
		check(new Random().nextInt());
	}

}
