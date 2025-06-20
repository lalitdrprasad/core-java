package com.study.polymorphism;

class Base {
	void method(int a) {
		System.out.println("Base class method called with integer a = " + a);
	}

	void method(double d) {
		System.out.println("Base class method called with double d =" + d);
	}
}

class Derived extends Base {
	@Override
	void method(double d) {
		System.out.println("Derived class method called with double d =" + d);
	}
}

public class Test {
	public static void main(String[] args) {
		new Derived().method(10); // Parent Class Integer
		new Derived().method(10d); // Child class Double
	}
}