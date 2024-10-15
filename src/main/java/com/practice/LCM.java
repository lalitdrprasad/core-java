package com.practice;

import java.util.Random;

public class LCM {

	static int find(int a, int b) {
		int tmp = 0;
		while ((++tmp * a) % b != 0)
			;
		return tmp * a;
	}

	public static void main(String[] args) {
		int limit = 500;
		System.out.println(" a  :  b  = LCM");
		for (int i = 0; i < 10; i++) {
			int a = new Random().nextInt(limit) + 1;
			int b = new Random().nextInt(limit) + 1;
			System.out.printf("%3d : %3d = %3d\n", a, b, find(a, b));
		}
	}
}
