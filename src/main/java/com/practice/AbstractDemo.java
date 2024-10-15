package com.practice;

abstract class Animal {
	int n = 5;

	Animal() {
		System.out.println("Abstract Class Constructor");
	}

	 abstract void animalSound();

	public void sleep() {
		System.out.println("Zzz");
	}

}

class Pig extends Animal {
	int n = 10;
	public void animalSound() {
		
		System.out.println("The pig says: wee wee");
	}
}

public class AbstractDemo {
	public static void main(String[] args) {
		Pig myPig = new Pig(); // Create a Pig object
		Animal animal = new Pig();
		
		myPig.animalSound();
		myPig.sleep();
		
		
		System.out.println(myPig.n);
		System.out.println(animal.n);
	}
}