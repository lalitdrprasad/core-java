
//Java Program to reverse a string without in built function.

package com.assignment;

import java.util.Scanner;

public class ReverseStr {

	static String reverseStr(String str) {
		String tmp = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			tmp = tmp + str.charAt(i);
		}
		return tmp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String str = sc.nextLine();
		System.out.println("Reverse : " + reverseStr(str));
		sc.close();
	}

}
