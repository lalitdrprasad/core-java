package com.patterns;

import java.util.Random;

public class Alphabet {

	static void print(int n) {
		int rows = n;
		char c = 'A';
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(c++);
			}
			System.out.println();
			c = 'A';
		}
	}

	public static void main(String[] args) {
		print(new Random().nextInt(26));
		// print(8);
	}
}