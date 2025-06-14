package com.study.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapIterate {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();

		map.put("1", "lalit");
		map.put("2", "prasad");
		map.put("3", "KAtghara");
		map.put("4", "Barwaha");

		Set<Entry<String, String>> entrySet = map.entrySet();
		entrySet.forEach(entry -> System.out.println(entry.getValue()));
		entrySet.forEach(entry -> System.out.println(entry));
		
		
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
		}
		
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		
		iterator.forEachRemaining(entry -> System.out.println(entry.getValue()));
	}
}