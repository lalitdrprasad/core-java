package com.study.collection;

import java.util.*;

public class Queue_Demo {

	public static void main(String[] args) {

		Queue<Integer> q1 = new ArrayDeque<Integer>();
		Queue<Integer> q2 = new PriorityQueue<Integer>();

		for (int i = 0; i < 15; i++) {
			int r = random();
			System.out.print(r + "  ");
			q1.add(r);
			q2.add(r);
		}
		System.out.println("\nDeleltion Order of ArrayDeque");

		while (!q1.isEmpty()) {
			System.out.print(q1.remove() + "  ");
		}
		System.out.println("\nDeleltion Order of PriorityQueue");
		while (!q2.isEmpty()) {
			System.out.print(q2.remove() + "  ");
			

		}
	}

	public static int random() {
		Random rand = new Random();
		return rand.nextInt(50) + 10;
	}

}
