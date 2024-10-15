package com.java8;

import java.util.Scanner;

interface FunctionalInterface {

	public boolean isPrime(int n);

}

public class LambdaExpression {
	private static Scanner sc;
	static FunctionalInterface refObj;

	public static void main(String[] args) {

		refObj = n -> {

			boolean b = true;
			if (n == 1 || n == 2 || n == 0)
				b = true;
			else if (n % 2 == 0)
				b = false;

			for (int i = 3; i < n / 2; i = i + 2) {
				if (n % i == 0) {
					b = false;
					break;
				}
			}
			return b;
		};

		sc = new Scanner(System.in);
		System.out.print("Enter Number : ");
		int n = sc.nextInt();
		System.out.println(refObj.isPrime(n));
		sc.close();
	}
}
