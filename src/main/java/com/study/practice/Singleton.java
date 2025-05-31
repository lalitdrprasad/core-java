package com.study.practice;

public class Singleton {

	private static Singleton obj = null;

	private Singleton() {

	}

	static Singleton getInstance() {
		if (obj == null)
			obj = new Singleton();
		return obj;
	}

	public static void main(String[] args) {
		Singleton obj1 = getInstance();
		Singleton obj2 = getInstance();

		System.out.println(obj1 == obj2);
		System.out.println(obj1.equals(obj2));
	}
}
