package com.study.practice;

import java.util.Random;

public class Palindrom {
	static int tmp = 0;

	static boolean check(int n) {

		int tmp = n, res = 0;
		while (tmp > 0) {
			res = res * 10 + tmp % 10;
			tmp /= 10;
		}
		if (res == n)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int n = new Random().nextInt(100000);
		// int n = 151;
		System.out.println("Palindrom upto " + n);
		for (int i = 1; i <= n; i++) {
			if (check(i)) {
				System.out.printf("%-8d", i);
				if (++tmp % 15 == 0)
					System.out.println();

			}

		}
	}

}
