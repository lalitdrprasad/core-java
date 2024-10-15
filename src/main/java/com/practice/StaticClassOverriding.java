package com.practice;

class OuterClass {
	static class InnerClass {
		static void main() {
			System.out.println("OuterClass.InnerClass.main()");
		}
	}

	static void callInner() {
		System.out.println("Parent");
		InnerClass.main();
	}
}

public class StaticClassOverriding extends OuterClass {

	static void callInner() {
		System.out.println("Child");
		InnerClass.main();
	}

	public static void main(String[] args) {
		StaticClassOverriding.callInner();
	}
}