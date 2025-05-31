package com.study.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		
		 HashMap<Object, Object> hashMap = new HashMap<>();
		 LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
		 TreeMap<Object, Object> treeMap = new TreeMap<>();
		 
		 System.out.print("Insertion Order \t");
		 for (int i = 1; i<=5 ; i++){
			 int n = new Random().nextInt(100)+50;
			 
			 System.out.print(n+"\t");
			 hashMap.put(n, "V"+n);
			 treeMap.put(n, "V"+n);
			 linkedHashMap.put(n, "V"+n);
		 }

		 System.out.print("\nLinked Hash Map \t");
		 for(Map.Entry<Object,Object> key: linkedHashMap.entrySet()){
			 System.out.print(key.getKey()+"\t");
		 }
		 System.out.print("\nHash Map \t\t");
		 
		 for(Map.Entry<Object,Object> key: hashMap.entrySet()){
			 System.out.print(key.getKey()+"\t");
		 }
		 System.out.print("\nTree Map \t\t");

		 for(Map.Entry<Object,Object> key: treeMap.entrySet()){
			 System.out.print(key.getKey()+"\t");
		 }
	}

}
