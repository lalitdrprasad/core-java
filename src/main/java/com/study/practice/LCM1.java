package com.study.practice;

import java.util.Random;

public class LCM1 {
	public static void main(String[] args) {
		int limit = 10;
		System.out.println(" a  :  b  = LCM");
		for (int i = 0; i < 10; i++) {
			int a = new Random().nextInt(limit) + 1;
			int b = new Random().nextInt(limit) + 1;

			System.out.printf("%3d : %3d = %3d\n", a, b, calculate(a, b));

		}
	}

	private static int calculate(int a, int b) {
		int bigger = a > b ? a : b;
		int result = bigger;
		while (true) {
			if (result % a == 0 && result % b == 0)
				return result;
			else
				result += bigger;
		}
	}
}
