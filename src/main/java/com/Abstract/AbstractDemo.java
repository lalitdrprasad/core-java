package com.Abstract;

abstract class Animal {
	public abstract void animalSound();

	public void sleep() {
		System.out.println("Zzz");
	}
}

class Pig extends Animal {
	public void animalSound() {

		System.out.println("The pig says: wee wee");
	}
}

public class AbstractDemo {
	public static void main(String[] args) {
		Animal myPig = new Pig(); // Create a Pig object
		myPig.animalSound();
		myPig.sleep();
	}
}