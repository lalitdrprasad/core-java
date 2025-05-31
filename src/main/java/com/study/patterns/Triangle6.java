package com.study.patterns;

import java.util.Random;

public class Triangle6 {

	static void print(int n) {

		int count = 0;

		for (int row = 0; row < n; row++) {
			for (int space = n - 1; space > row; --space) {
				System.out.print("   ");
			}
			for (int col = 0; col <= row; col++)
				System.out.printf("%6d", ++count);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		print(new Random().nextInt(1, 20));
	}
}
