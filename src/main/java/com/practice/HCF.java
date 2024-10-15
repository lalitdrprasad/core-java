package com.practice;

import java.util.Random;

public class HCF {

	static int find(int a, int b) {
		while (!(a % b == 0 || b % a == 0)) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a < b ? a : b;
	}

	public static void main(String[] args) {
		int limit = 1000;
		System.out.println(" a  :  b  =  HCF");
		for (int i = 0; i < 10; i++) {
			int a = new Random().nextInt(limit) + 1;
			int b = new Random().nextInt(limit) + 1;
			System.out.printf("%3d : %3d = %3d\n", a, b, find(a, b));
		}

	}
}
