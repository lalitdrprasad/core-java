//Program to find Second highest number
package com.study.assignment;

import java.util.Scanner;

public class SecondHighest {

	static int findSecondHighest(int ar[]) {
		int first = 0;
		int second = 0;
		if (ar[0] > ar[1]) {
			first = ar[0];
			second = ar[1];
		} else {
			first = ar[1];
			second = ar[0];
		}

		for (int i = 2; i < ar.length; i++) {
			if (ar[i] > second) {
				if (ar[i] > first) {
					second = first;
					first = ar[i];
				} else {
					second = ar[i];
				}
			}
		}

		return second;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of array : ");
		int size = sc.nextInt();
		int ar[] = new int[size];
		if (size <= 1) {
			System.out.println("Size must be greater than 1");
			System.exit(0);
		}

		System.out.println("Enter elements one by one");
		for (int i = 0; i < size; i++) {
			ar[i] = sc.nextInt();
		}

		System.out.println("Second Highest of Array is : " + findSecondHighest(ar));
		sc.close();
	}

	

}
