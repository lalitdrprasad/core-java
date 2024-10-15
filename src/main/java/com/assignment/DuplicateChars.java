//Java Program to find duplicate characters in a string.
package com.assignment;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicateChars {

	static String duplicates(String str) {

		char ar[] = str.toCharArray();
		String res = "";
		Arrays.sort(ar);
		for (int i = 0; i < ar.length - 1; i++) {
			if (ar[i] == ar[i + 1]) {
				if (!res.contains("" + ar[i])) {
					res += ar[i] + "  ";
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String str = sc.nextLine();
		String res = duplicates(str);
		if (res.length() == 0)
			System.out.println("Duplicates : No Duplicate Character Found");
		else
			System.out.println("Duplicates : " + res);
		sc.close();

	}
}
