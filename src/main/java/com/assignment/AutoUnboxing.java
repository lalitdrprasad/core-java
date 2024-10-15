package com.assignment;

public class AutoUnboxing {

	public static void main(String[] args) {
		Integer i = 10;
		Integer j =20;
		int man = i.intValue();
		int au = j;
		System.out.println("By Method : "+man);
		System.out.println("Automatically : "+au);
	}

}
