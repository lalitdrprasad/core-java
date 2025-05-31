package com.study.polymorphism;

class Bike {
	int speedlimit = 90;

	public void method() {
		System.out.println("Bike.bikeMethod() : Won't invoke with child class reference");
	}
}

interface Demo {

	int x = 0; // By default public static final

	static void method() {
		System.out.println("demo.method()");
	}
}

public class Honda extends Bike implements Demo {
	int speedlimit = 150;

	@Override
	public void method() {
		System.out.println("Honda.method()");
	}

	public static void main(String args[]) {
		Bike obj = new Honda();
		Honda obj1 = new Honda();

		System.out.println(Demo.x); // static varible
		obj.method();
		obj1.method();
		System.out.println(obj.speedlimit);// 90
		System.out.println(obj1.speedlimit);// 150

	}
}
