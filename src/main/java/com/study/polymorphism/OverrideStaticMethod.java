package com.study.polymorphism;

class ParentWithStaticMethod {
	static void m1() {
		System.out.println("ParentWithStaticMethod.m1()");
	}
}

public class OverrideStaticMethod extends ParentWithStaticMethod {
	static void m1() {
		System.out.println("OverrideStaticMethod.m1()");
	}

	public static void main(String[] args) {
		ParentWithStaticMethod.m1();
		OverrideStaticMethod.m1();

	}
}
