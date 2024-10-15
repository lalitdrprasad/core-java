package com.assessment;

public class IsConsecutivelyOccured {
	public static void main(String[] args) {

		long n = 9111216066l;
		int x = 6;
		int count = 0;
		while (n != 0) {
			int tmp = (int) (n % 10);
			if (tmp == x) {
				count++;
				if (count == 4)
					break;
			} else
				count = 0;
			n = n / 10;
		}
		if (count == 4)
			System.out.println(true);
		else
			System.out.println(false);
	}
}
