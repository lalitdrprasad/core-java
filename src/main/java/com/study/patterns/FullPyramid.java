package com.study.patterns;

import java.util.Random;

public class FullPyramid {
	static void print(int n) {
		int rows = n;
		int cols = n * 2 - 1;
		System.out.println("Rows = " + rows);
		System.out.println("Cols = " + cols);

		for (int i = 1; i <= rows; i++) {
			int tmp = i-1;
			System.out.printf("Row - %2d : ", i);
			for (int j = 1; j <= cols; j++) {
				if (j > rows - i && j < rows + i) {
					if (j <= cols / 2+1)
						System.out.printf("%4d", ++tmp);
					else
						System.out.printf("%4d", --tmp);
				} else
					System.out.print("    ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		print(new Random().nextInt(15));
		// print(15);
	}
}
