package com.recursion;

public class StkDepth {

	static long depth = 0L;

	static void deep() throws StackOverflowError {
		depth++;
		deep();
	}

	public static void main(String[] args) {
		try {
			deep();
		} catch (StackOverflowError e) {
			System.out.println(depth);
		}
	}

}