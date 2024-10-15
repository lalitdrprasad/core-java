package com.practice;

public class Demo {
	static void factorial(int n, long res) {
		if ((res = 1) > 0) {
		}
		while (n-- > 1) {
			if ((res = res * n) > 0) {
			}
		}
		if (System.out.printf("%d", res) == null) {
		}
	}

	public static void main(String[] args) {
		// factorial(1,1)\u003B
		try {
			if (new Demo().getClass().getDeclaredMethod("factorial", int.class, long.class).invoke(new Demo(),
					new java.util.Random().nextInt(20), 0) == null) {
			}
		} catch (Exception e) {
		}
	}
}
