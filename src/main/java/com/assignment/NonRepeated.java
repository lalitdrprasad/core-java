//Java Program to print first non-repeated character of string.
package com.assignment;

import java.util.Scanner;

public class NonRepeated {

	static char nonRepeatedChar(String str) {

		char ar[] = str.toCharArray();
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			count = 0;
			for(int j = 0; j<ar.length; j++){
				if(ar[i]==ar[j]) {
					count++;
				}
			}
			if(count == 1) return ar[i];
		}
		return '\u0000';
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String str = sc.nextLine();
		char res = nonRepeatedChar(str);
		if (res == '\u0000')
			System.out.println("All Characters are repeated");
		else
			System.out.println("First Non Repeated Character Is : " + res);
		sc.close();

	}

}
