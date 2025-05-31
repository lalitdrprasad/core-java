package com.study.ds;

import java.util.Random;

public class LinkedList {

	Node root = null;

	void insert(int n) {
		Node node = new Node(n);
		if (root == null) {
			root = node;
		} else {
			Node current = root;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	boolean delete(int n) {
		Node current = root;
		Node prev = current;
		while (current != null) {
			if (current.data == n) {
				if (current == root) {
					root = current.next;
				} else {
					prev.next = current.next;
				}
				return true;
			} else {
				prev = current;
				current = current.next;
			}
		}
		return false;
	}

	void traverse() {
		Node current = root;
		while (current != null) {
			System.out.print(current.data + "\t");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int data = random.nextInt(10, 20);
			list.insert(data);
		}

		list.traverse();
		System.out.println();
		int data = random.nextInt(10, 20);
		if (list.delete(data)) {
			System.out.println(data + " has been Deleted...\nUpdated list");
			list.traverse();
		} else {
			System.out.println(data + " Not found to delete");
		}

	}
}
