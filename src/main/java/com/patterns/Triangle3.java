package com.patterns;

import java.util.Random;

public class Triangle3 {

	static void print(int n) {

		for (int row = 0; row < n; row++) {
			for (int space = n - 1; space > row; --space) {
				System.out.print("  ");
			}
			for (int col = 0; col <= row; col++)
				System.out.print("*   ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		print(new Random().nextInt(1, 20));
	}
}
