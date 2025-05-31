package com.study.practice;

public class Unlucky13 {
	static int unlucky = 13;

	public static void main(String args[]) throws Exception {

		System.out.println(find(4));
	}

	static int find(int n) {

		String s = "0";
		for (int i = 0; i < n; i++) {
			s = s + "9";
		}
		int res = 0;
		int number = Integer.parseInt(s);
		System.out.println(number);
		System.out.println("----------");
		int counter = 0;
		for (int i = 0; i <= number; i++) {
			if ((i + "").contains("13")) {
				counter++;
				System.out.println(i);
			}
		}
		
		System.out.println("----------");
		System.out.println(counter);
		if (n > 1)
			res = number / 100 + 1;
		if (n > 2)
			res = res + (number / 1000 + 1) * 10;
		return res;
	}
}