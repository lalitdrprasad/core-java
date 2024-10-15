package com.practice;

import java.util.*;

public class ArrayToListUsingMethod {

	public static <T> List<T> convert(T ar[]) {

		List<T> list = Arrays.asList(ar);
		return list;
	}

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Size of Array : ");
		int size = sc.nextInt();
		Integer ar[] = new Integer[size];

		System.out.println("Enter the elements");
		for (int i = 0; i < size; i++) {
			ar[i] = sc.nextInt();
		}
		
		System.out.println(convert(ar));
		sc.close();
	}
}
