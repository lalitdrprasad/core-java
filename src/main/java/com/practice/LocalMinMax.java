package com.practice;

import java.util.Scanner;

public class LocalMinMax {
	static int next, prev, current;

	static void minima(int arr[], int size) {
		System.out.println("Minimas : ");
		if (size == 1) {
			System.out.println(arr[0]);
			return;
		}
		for (int i = 0; i < size; i++) {

			if (i > 0 && i < size - 1) {

				current = arr[i];
				next = arr[i + 1];
				prev = arr[i - 1];

				if (current < prev && current < next)
					System.out.println("Array[ " + i + " ]  = " + current);
			} else if (i == 0) {
				current = arr[i];
				next = arr[i + 1];
				if (current < next)
					System.out.println("Array[ " + i + " ]  = " + current);
			} else if (i == size - 1) {
				current = arr[i];
				prev = arr[i - 1];
				if (current < prev)
					System.out.println("Array[ " + i + " ]  = " + current);
			}
		}
	}

	static void maxima(int arr[], int size) {
		System.out.println("Maximas : ");
		if (size == 1) {
			System.out.println(arr[0]);
			return;
		}
		for (int i = 0; i < size; i++) {

			if (i > 0 && i < size - 1) {
				current = arr[i];
				next = arr[i + 1];
				prev = arr[i - 1];

				if (current > prev && current > next)
					System.out.println("Array[ " + i + " ]  = " + current);
			} else if (i == 0) {
				current = arr[i];
				next = arr[i + 1];
				if (current > next)
					System.out.println("Array[ " + i + " ]  = " + current);
			} else if (i == size - 1) {
				current = arr[i];
				prev = arr[i - 1];
				if (current > prev)
					System.out.println("Array[ " + i + " ]  = " + current);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the size of array");
		int size = sc.nextInt();
		int arr[] = new int[size];

		System.out.println("Enter the elements one by one");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		minima(arr, size);
		maxima(arr, size);

		sc.close();
	}

}
