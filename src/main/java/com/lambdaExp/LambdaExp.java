package com.lambdaExp;

@FunctionalInterface
interface FunctionalInterfaceDemo{
	public void display();
	
	// an interface having @FunctionalInterface with single abstract method is known as functional interface.
}


public class LambdaExp {
	public static void main(String[] args) {
		
		FunctionalInterfaceDemo obj = () -> {
			System.out.println("Lambda Expression");
		};
		obj.display();
	}
}
