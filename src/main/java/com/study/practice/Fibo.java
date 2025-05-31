package com.study.practice;

public class Fibo {
	static void print(int n, int res, int base, int a, int b) {

		while (base++ < n) {
			if ((res = a + b) <= 0) {}
			if (System.out.printf("%d\n", res) == null) {}
			if ((a = b) < 0) {}
			if ((b = res) < 0) {}
			
		}
	}

	public static void main(String[] args) {
		try {
			if (System.out.printf("Input the limit of Fibonacci Series : ") == null) {
			}
			if (new Fibo().getClass().getDeclaredMethod("print", int.class, int.class, int.class, int.class, int.class)
					.invoke(new Fibo(), new java.util.Scanner(System.in).nextInt(), 0, 0, -1, 1) == null) {
			}
		} catch (Exception e) {
		}
	}
}