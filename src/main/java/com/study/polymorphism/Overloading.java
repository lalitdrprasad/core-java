package com.study.polymorphism;

class Adder {
	static int add(int a, int b) {
		return a + b;
	}

	static double add(int a, float b) {
		return a + b;
	}
}

class Overloading {
	public static void main(String[] args) {
		System.out.println(Adder.add(11, 11));
		System.out.println(Adder.add(11, 11.2f	));
		
	}
}
