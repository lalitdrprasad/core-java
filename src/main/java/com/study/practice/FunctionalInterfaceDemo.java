package com.study.practice;

@FunctionalInterface
interface Factorial {
	long calculate(int x);
}

public class FunctionalInterfaceDemo {
	public static void main(String args[]) {
		
		Factorial s = (int x) -> {
			int res = 1;

			for (int i = 2; i <= x; i++)
				res = res * i;

			return res;
		};

		int a = 17;
		long ans = s.calculate(a);
		System.out.println(ans);
	}
}
