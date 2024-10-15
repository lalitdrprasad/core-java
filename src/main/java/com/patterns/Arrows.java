package com.patterns;

import java.util.Random;

public class Arrows {
	static void print(int n) {
		int rows = n;
		int cols = n;
		System.out.println(" N = " + n);

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (i > rows / 2 - 3 && i<rows/2+5) {
					
					 if ((i == j || i == rows / 2 + 1 || i + j == rows + 1))
						System.out.print(" *");
					else
						System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		print(new Random().nextInt(15) * 2 + 1);
		// print(15);
	}
}
