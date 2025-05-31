package com.study.patterns;

import java.util.Random;

public class Rectangle {
	static void print(int n) {

		for (int row = 0; row < n; row++) {

			for (int space = 0; space < row; ++space) {
				System.out.print(" ");
			}

			for (int col = 0; col < n; col++)
				System.out.print("* ");
			System.out.println();
		}
		System.out.println();
		for (int row = 0; row < n; row++) {

			for (int space = row; space < n; ++space) {
				System.out.print(" ");
			}

			for (int col = 0; col < n; col++)
				System.out.print("* ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		print(new Random().nextInt(1, 20));
	}

}
