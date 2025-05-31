package com.study.recursion;

import java.util.Random;

public class PrimeNumber {
	static int dividor = 3;

	static boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		if (n % dividor == 0) {
			return false;
		} else if (dividor < n / 2) {
			dividor += 2;
			return isPrime(n);
		}
		return true;
	}

	public static void main(String[] args) {
		int n = new Random().nextInt(100);
		System.out.println(n + " : " + isPrime(500));
	}
}
