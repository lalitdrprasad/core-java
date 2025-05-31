package com.study.practice;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LargestRepeatedSubstring {
	public static Set<String> find(String str) {
		String subStr = null;
		int size = 0, tmpSize = -1;
		int len = str.length();
		Set<String> res = new HashSet<>();
		for (int i = len - 1; i >= 0; i--) {
			if (i < size)
				break;
			for (int j = 0; j < i; j++) {
				subStr = str.substring(j, i);
				if (subStr.length() < size) {
					break;
				}
				if (res.contains(subStr)) {
					continue;
				}
				if ((str.indexOf(subStr, str.indexOf(subStr) + 1) != -1)) {
					tmpSize = subStr.length();
					if (tmpSize != size)
						res.removeAll(res);
					size = tmpSize;
					res.add(subStr);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String str = "";
		int n = new Random().nextInt(500);
		while (n-- > 0) {
			str = str + (char) (new Random().nextInt(5) + 65);
		}
		System.out.println(str);
		Set<String> res = find(str);
		if (res.size() == 0)
			System.out.println("No Repeated String Found");
		else
			System.out.println(res);
	}
}