package com.study.recursion;

public class OneToN {

	public static void main(String[] args) {
		print(5);
	}

	static void print(int n) {
		if (n > 1)
			print(n - 1);
		System.out.println(n);
	}
}
