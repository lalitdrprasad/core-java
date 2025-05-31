package com.study.practice;

import java.util.Random;
import java.util.Scanner;

public class Fibonacci {
	static void generate(int n) {
		int a = -1;
		int b = 1;
		
		int tmp = 0;
		
		for (int i = 0; i < n; i++) {
			tmp = a + b;
			System.out.println(tmp);
			a = b;
			b = tmp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = new Random().nextInt(15);
		System.out.println("Length of the series : " + n);
		generate(n);
		sc.close();
	}

}
