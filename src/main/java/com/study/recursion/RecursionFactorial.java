package com.study.recursion;

public class RecursionFactorial {
	static int factorial(int n) {
		if (n == 1)
			return 1;
		else
			return (n * factorial(n - 1));
	}

	public static void main(String[] args) {
		System.out.println(factorial(6));
	}
}
