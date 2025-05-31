package com.study.practice;

import java.util.Random;

public class HCF1 {
	public static void main(String[] args) {
		int limit = 100;
		System.out.println(" a  :  b  =  HCF");
		for (int i = 0; i < 10; i++) {
			int a = new Random().nextInt(limit) + 1;
			int b = new Random().nextInt(limit) + 1;
			System.out.printf("%3d : %3d = %3d\n", a, b, calculate(a, b));
		}

	}

	private static int calculate(int a, int b) {
		int result = a < b ? a : b;
		while (true) {
			if (a % result == 0 && b % result == 0)
				return result;
			else
				result /= 2;
		}
	}
}
