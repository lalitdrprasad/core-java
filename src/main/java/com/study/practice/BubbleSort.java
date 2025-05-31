package com.study.practice;

import java.util.Random;

public class BubbleSort {
	static int[] swap(int ar[], int location, int last) {
		int temp = ar[location];
		ar[location] = ar[last - 1];
		ar[last - 1] = temp;
		return ar;
	}

	static int largest(int ar[], int n) {
		int x = 0;
		for (int i = 1; i < n; i++) {
			if (ar[x] < ar[i]) {
				x = i;
			}
		}
		return x;
	}

	static int[] sort(int ar[], int n) {
		if (n > 0) {
			sort(swap(ar, largest(ar, n), n), n - 1);
		}
		return ar;
	}

	static void display(int ar[]) {
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int n = new Random().nextInt(20);
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = new Random().nextInt(100);
		}
		display(ar);
		display(sort(ar, n));

	}

}
