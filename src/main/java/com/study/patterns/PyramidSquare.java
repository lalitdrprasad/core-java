package com.study.patterns;

import java.util.Random;

public class PyramidSquare {
	public static void main(String[] args) {

		int n = new Random().nextInt(25) + 5;
		System.out.println("Number of lines : " + n);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 || j == 1 || i == n || j == n)
					System.out.print("# ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
