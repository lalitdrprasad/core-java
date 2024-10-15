package com.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spiral1 {
	static List<String> list = new ArrayList<String>();
	static int i, j, count, rows, cols;

	static void increaseJ() {
		while (count != rows * cols - 1) {
			String index = i + "," + (j + 1);
			if (!list.contains(index) && j + 1 < cols) {
				j++;
				count++;
				list.add(index);
			} else
				increaseI();
		}
	}

	static void increaseI() {
		while (count != rows * cols - 1) {
			String index = (i + 1) + "," + j;
			if (!list.contains(index) && i + 1 < rows) {
				i++;
				count++;
				list.add(index);
			} else
				decreaseJ();
		}
	}

	static void decreaseJ() {
		while (count != rows * cols - 1) {
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
		while (count != rows * cols - 1) {
			String index = (i - 1) + "," + j;
			if (!list.contains(index) && i >= 1) {
				i--;
				count++;
				list.add(index);
			} else
				increaseJ();
		}
	}

	static void prepareSpriral() {
		list.add(i + "," + j);
		increaseJ();
	}

	static int[][] createSpiral(int ar[][]) {
		int r, c;
		int value = 0;
		int output[][] = new int[rows][cols];
		String[] index;
		for (i = 0; i < rows; i++) {
			for (j = 0; j < cols; j++) {

				index = list.get(value).split(",");
				r = Integer.parseInt(index[0]);
				c = Integer.parseInt(index[1]);
				value++;
				output[r][c] = ar[i][j];
			}
		}
		return output;
	}

	static void display(int[][] ar) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				System.out.printf("%5d", ar[r][c]);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Number of Rows = ");
		rows = scanner.nextInt();
		System.out.print("Number of Columns = ");
		cols = scanner.nextInt();

		if (rows <= 0 || cols <= 0) {
			System.out.println("Invalid Size");
			System.exit(0);
		}
		int temp = 0;
		int ar[][] = new int[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				ar[r][c] = ++temp;
			}
		}

		System.out.println("Given Array");
		display(ar);
		System.out.println("\nSpiral Form");
		prepareSpriral();
		display(createSpiral(ar));
		scanner.close();
	}
}
