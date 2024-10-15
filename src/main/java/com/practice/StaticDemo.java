package com.practice;

public class StaticDemo {

	public static void main(String[] args) {
		m1();
	}
	
	static void m1() {
		System.out.println("Static Method");
		new StaticDemo().m2();
	}
	void m2() {
		System.out.println("Non Static Method");
	}

}
