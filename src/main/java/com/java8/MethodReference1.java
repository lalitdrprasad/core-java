package com.java8;

public class MethodReference1 {

	public static void runImp() {
		System.out.println("thread created");
	}

	
	public static void main(String args[]) {

		Runnable r = MethodReference1::runImp;
		Thread t = new Thread(r);
		t.start();
	}
}
