package com.practice;

public class StringPermutations {

	public static void main(String[] args) {
		String str = "PQR";
		int len = str.length();
		for (int i = 0; i < Math.pow(len, len); i++) {
			String pos = convert(i, len);
			String res = "";
			for (int j = 0; j < pos.length(); j++) {
				res = res + str.charAt(Integer.parseInt("" + pos.charAt(j)));
			}
			System.out.println(res);
		}
	}

	public static String convert(int n, int base) {
		String res = "";
		while (n != 0) {
			res = res + n % base;
			n = n / base;
		}

		res = new StringBuffer(res).reverse().toString();
		while (res.length() != base) {
			res = "0" + res;
		}
		return res;
	}
}