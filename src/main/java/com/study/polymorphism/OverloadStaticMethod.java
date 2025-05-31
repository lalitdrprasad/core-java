package com.study.polymorphism;

class Parent {
	int x = 100;

	public void display() {
		System.out.println("Parent Class - Non Static");
	}

	public static void display1() {
		System.out.println("Parent Class - Static");
	}
}

class Child extends Parent {
	int x = 500;

	@Override
	public void display() {
		System.out.println("Child Class - Non Static");
	}

	// This is method hiding not overriding
	public static void display1() {
		System.out.println("Child Class - Static");
	}
}

public class OverloadStaticMethod {
	public static void main(String args[]) {
		Child child = new Child();
		Parent parent = new Child();

		parent.display();
		parent.display1();
		
		child.display();
		child.display1();
		
		System.out.println(parent.x);
		System.out.println(child.x);
	}
}