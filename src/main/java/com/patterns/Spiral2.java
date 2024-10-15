package com.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spiral2 {
	static List<String> list = new ArrayList<String>();
	static int i, j, count, n;

	static void increaseJ() {
		while (count != n * n - 1) {
			String index = i + "," + (j + 1);
			if (!list.contains(index) && j + 1 < n) {
				j++;
				count++;
				list.add(index);
			} else
				increaseI();
		}
	}

	static void increaseI() {
		while (count != n * n - 1) {
			String index = (i + 1) + "," + j;
			if (!list.contains(index) && i + 1 < n) {
				i++;
				count++;
				list.add(index);
			} else
				decreaseJ();
		}
	}

	static void decreaseJ() {
		while (count != n * n - 1) {
			String index = i + "," + (j - 1);
			if (!list.contains(index) && j >= 1) {
				j--;
				count++;
				list.add(index);
			} else
				decreaseI();
		}
	}

	static void decreaseI() {
		while (count != n * n - 1) {
			String index = (i - 1) + "," + j;
			if (!list.contains(index) && i >= 1) {
				i--;
				count++;
				list.add(index);
			} else
				increaseJ();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Square Matrix Dimention Size = ");
		n = scanner.nextInt();
		list.add(i + "," + j);
		int r, c;
		increaseJ();
		count = 0;
		int ar[][] = new int[n][n];
		String index[];
		System.out.println("Simple Array");
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				 index = list.get(count).split(",");
				r = Integer.parseInt(index[0]);
				c = Integer.parseInt(index[1]);
				ar[r][c] = ++count;
				System.out.printf("%5d", count);
			}
			System.out.println();
		}
		
		System.out.println("\nSpiral Array");
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.printf("%5d", ar[i][j]);
			}
			System.out.println();
		}

		scanner.close();
	}
}
