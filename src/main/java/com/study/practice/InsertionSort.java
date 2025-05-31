package com.study.practice;

import java.util.Random;

public class InsertionSort {
	static int swaps = 0;

	static int[] sort(int ar[], int n) {
		for (int i = 0; i < n; i++) {
			int current = ar[i];
			int j = i;
			while (j > 0 && current < ar[j - 1]) {
				ar[j] = ar[j - 1];
				j--;
				swaps++;
			}
			ar[j] = current;
			System.out.printf("Iteration : %2d - ", i + 1);
			display(ar);
		}
		return ar;
	}

	static void display(int ar[]) {
		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%4d", ar[i]);
			
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int n = new Random().nextInt(20) + 5;
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = new Random().nextInt(100);
		}
		System.out.print("Given Array : ");
		display(ar);
		System.out.println("\nSorting using Insertion Sort");
		sort(ar, n);

	}

}
