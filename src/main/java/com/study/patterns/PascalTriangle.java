package com.study.patterns;

import java.util.Random;

public class PascalTriangle {
	static void print(int n) {
		int rows = n;
		int cols = n * 2 - 1;
		System.out.println("Rows = " + rows);
		System.out.println("Cols = " + cols);
		int ar[][] = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				ar[i][j] = 1;
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if ((i + j >= cols / 2 && j <= i + cols / 2) && (rows + i + j) % 2 != 0) {
					if (i + j == cols / 2 || j == i + cols / 2) {
						ar[i][j] = 1;
					} else {
						ar[i][j] = ar[i - 1][j - 1] + ar[i - 1][j + 1];
					}
				} else {
					ar[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			System.out.printf("Row - %2d : ", i);
			for (int j = 0; j < cols; j++) {
				if (ar[i][j] != -1)
					System.out.printf("%3d", ar[i][j]);
				else
					System.out.print("   ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		print(new Random().nextInt(10));
	}
}