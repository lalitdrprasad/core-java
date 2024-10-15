package com.leetcode;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	private Node head;

	public LinkedList() {
		this.head = null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void display() {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		Node current = head;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public void delete(int data) {
		if (head == null) {
			System.out.println("List is empty, nothing to delete.");
			return;
		}

		if (head.data == data) {
			head = head.next;
			return;
		}

		Node current = head;
		Node previous = null;
		while (current != null && current.data != data) {
			previous = current;
			current = current.next;
		}

		if (current == null) {
			System.out.println("Data not found in the list.");
		} else {
			previous.next = current.next;
		}
	}
}

public class LinkedListImplementation {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);

		System.out.println("Linked List:");
		list.display();

		System.out.println("\nDeleting 30 from the list:");
		list.delete(30);

		list.display();
	}
}
