package com.collection;

import java.util.*;

public class ListDemo {

	public static void main(String[] args) {

		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new LinkedList<Integer>();
		List<Integer> l3 = new Vector<Integer>();
		List<Integer> l4 = new Stack<Integer>();

		for (int i = 0; i < 15; i++) {
			int r = random();
			System.out.print(r + "  ");
			l1.add(r);
			l2.add(r);
			l3.add(r);
			l4.add(r);
		}
		
		System.out.println();
		Iterator<Integer> i1 = l1.iterator();
		Iterator<Integer> i2 = l2.iterator();
		Iterator<Integer> i3 = l3.iterator();
		Iterator<Integer> i4 = l4.iterator();

		while (i1.hasNext()) {
			System.out.print(i1.next() + "  ");
		}
		System.out.println();
		while (i2.hasNext()) {
			System.out.print(i2.next() + "  ");
		}
		System.out.println();
		while (i3.hasNext()) {
			System.out.print(i3.next() + "  ");
		}
		System.out.println();
		while (i4.hasNext()) {
			System.out.print(i4.next() + "  ");
		}

	}

	public static int random() {
		Random rand = new Random();
		return rand.nextInt(50) + 10;
	}
}
