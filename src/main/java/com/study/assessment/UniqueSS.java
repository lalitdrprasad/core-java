package com.study.assessment;
import java.util.HashSet;

public class UniqueSS {

	public static void main(String[] args) {
		String input = "ababydjjsgiug";
		int res = 0;
		String ssRes = "";
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < i; j++) {
				String ss = input.substring(j, i);
				HashSet<Object> hashSet = new HashSet<>();
				for (int x = 0; x < ss.length(); x++) {
					hashSet.add(ss.charAt(x));
				}
				int size = hashSet.size();
				if (size == ss.length() && size > res) {
					ssRes = ss;
					res = size;
				}
			}
		}
		System.out.println(ssRes);
		System.out.println(res);
	}
}
