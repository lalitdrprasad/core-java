package com.practice;

public class VolatileExample extends Thread {

	// Initializing volatile variables
	// a, b
	static volatile int a = 0, b = 0;

	// Defining a static void method
	static void method_one() {
		a++;
		b++;
	}

	public void run() {
		System.out.println(this.getName());
		for (int i = 0; i < 5; i++) {
			method_one();
			method_two();
		}
	}

	// Defining static void method
	static void method_two() {
		System.out.println("a=" + a + " b=" + b);
	}

	public static void main(String[] args) {

		// Creating an instance t1 of
		// Thread class
		Thread t1 = new Thread(new VolatileExample());
		Thread t2 = new Thread(new VolatileExample());
		Thread t3 = new Thread(new VolatileExample());
		Thread t4 = new Thread(new VolatileExample());

		t1.setName("Thread - 1");
		t2.setName("Thread - 2");
		t3.setName("Thread - 3");
		t4.setName("Thread - 4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
