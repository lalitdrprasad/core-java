package com.study.practice;

import java.util.Scanner;

public class SumUptoN {
	public static void main(String[] args) {
		int res = 0;

		System.out.print("Enter the limit : ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while (n > 0)
			res = res + n--;
		System.out.print(res);
		scanner.close();
	}
}