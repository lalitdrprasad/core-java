package com.recursion;

import java.util.Scanner;

public class StringReverse {

	static String reverse(String str) {
		if (str.length() > 0) {
			return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.print("Input String : ");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();

		System.out.println(reverse(str));

	}

}
