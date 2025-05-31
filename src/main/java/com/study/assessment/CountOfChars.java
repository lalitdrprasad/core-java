package com.study.assessment;
import java.util.HashMap;

public class CountOfChars<E> {

	public void count(String str) {

		char[] chars = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (Character ch : chars) {
			Integer count = map.get(ch);
			if (count == 0) {
				map.put(ch, 1);
			}
		}
	}
}
