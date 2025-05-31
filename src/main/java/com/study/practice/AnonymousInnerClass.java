package com.study.practice;

interface AIC {

	public void m1();

	public void m2();

	public void m3();

}

public class AnonymousInnerClass{

	public static void main(String[] args) {

		AIC obj = new AIC() {

			@Override
			public void m1() {
				System.out.println("Hello From m1");

			}

			@Override
			public void m2() {
				System.out.println("Hello From m2");

			}

			@Override
			public void m3() {
				System.out.println("Hello From m3");

			}
		};
		
		obj.m1();
		obj.m2();
		obj.m3();

	}

}
