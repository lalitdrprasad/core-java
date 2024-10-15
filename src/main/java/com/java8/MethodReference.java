package com.java8;

import java.util.Random;
import java.lang.FunctionalInterface;

@FunctionalInterface
interface EvenOdd {
	public boolean check(int n);
}

public class MethodReference {

	public boolean isEven(int n) {
		return n % 2 == 0;
	}

	public static void main(String[] args) {

		/*
		 * List<Integer> list = new ArrayList<Integer>(); for (int i = 0; i < 20; i++) {
		 * list.add(new Random().nextInt(91) + 9); }
		 */
		MethodReference mr = new MethodReference();
		EvenOdd obj = mr::isEven;

		int n = new Random().nextInt();

		if (obj.check(n))
			System.out.println(n + " IS EVEN");
		else
			System.out.println(n + " IS ODD");
	}

}
