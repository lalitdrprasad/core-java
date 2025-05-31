package com.study.assignment;

public class AutoBoxing {

	public static void main(String[] args) {
		int i = 10;
		int j =20;
		Integer man = Integer.valueOf(i);
		Integer ab = j;
		System.out.println("By Method : "+man);
		System.out.println("Automatically : "+ab);
	}
}
