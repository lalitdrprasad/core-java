package com.practice;

import java.util.Arrays;

public class Anagram {
	static boolean checkAnagram(String str1, String str2) {
		
		char ar1[] = str1.toCharArray();
		char ar2[] = str2.toCharArray();

		Arrays.sort(ar1);
		Arrays.sort(ar2);

		str1 = new String(ar1);
		str2 = new String(ar2);

		return str1.equalsIgnoreCase(str2);
	}

	public static void main(String[] args) {
		String str1 = "ABCdd";
		String str2 = "BdACd";

		System.out.println(checkAnagram(str1, str2));
	}
}