package com.collection;

import java.util.*;

public class SetDemo {

	public static void main(String[] args) {
		
		HashSet<Integer> s1 = new HashSet<Integer>();
		LinkedHashSet<Integer> s2 = new LinkedHashSet<Integer>();
		TreeSet<Integer> s3 = new TreeSet<Integer>();
		
		
		for(int i = 0;i<15; i++) {
			int r = random();
			System.out.print(r + "  ");
			s1.add(r);
			s2.add(r);
			s3.add(r);
			
		}
		System.out.println();
		Iterator<Integer> i1 = s1.iterator();
		Iterator<Integer> i2 = s2.iterator();
		Iterator<Integer> i3 = s3.iterator();
		
		while(i1.hasNext()) {
			System.out.print(i1.next() + "  ");
		}
		System.out.println();
		while(i2.hasNext()) {
			System.out.print(i2.next() + "  ");
		}
		System.out.println();
		while(i3.hasNext()) {
			System.out.print(i3.next() + "  ");
		}
		
	}
	public static int random() {
		Random rand = new Random();
		return rand.nextInt(50)+10;
	}
	
	

}
