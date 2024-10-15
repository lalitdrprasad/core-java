package com.recursion;

import java.util.Scanner;

public class ReverseString {
	static String reverse(String str, String res, int n) {

		if (--n >= 0) {
			return reverse(str, res + str.charAt(n), n);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.print("Input String : ");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String res = "";
		scanner.close();
		System.out.println(reverse(str, res, str.length()));

	}

}
