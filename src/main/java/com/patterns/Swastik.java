package com.patterns;

import java.util.Random;

public class Swastik {

	static void print(int n) throws InterruptedException {

		for (int i = 1; i <= n; i++) {
			System.out.print("\n\t");
			for (int j = 1; j <= n; j++) {
				if (((i <= n / 2 && (j == 1 || j == 2)) || (i > n / 2 && (j == n || j == n - 1))
						|| (i == n / 2 || i == n / 2 + 1))
						|| ((j > n / 2 && (i == 1 || i == 2)) || (j <= n / 2 && (i == n || i == n - 1))
								|| (j == n / 2 || j == n / 2 + 1))) {
					Thread.sleep(30);
					System.out.print("%&");
				} else
					System.out.print("  ");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println("\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		print(new Random().nextInt(8, 15) * 2);
	}
}