package com.study.practice;

import java.util.Random;

public class Armstrong {
	
	static int tmp = 0;

	static boolean check(int n) {

		int power = ("" + n).length();
		int tmp = n, res = 0;

		while (tmp > 0) {

			res = (int) (res + Math.pow(tmp % 10, power));
			tmp /= 10;
		}

		if (res == n)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		int n = new Random().nextInt(Integer.MAX_VALUE);
		System.out.println("Armstrong upto : " + n);
		for (int i = 1; i < n; i++) {
			if (check(i))
				System.out.println(i);
		}
	}
}
