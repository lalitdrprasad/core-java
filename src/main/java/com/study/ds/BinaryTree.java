package com.study.ds;

import java.util.Random;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}
}

public class BinaryTree {

	TreeNode root;

	public void addNode(int data) {
		TreeNode newNode = new TreeNode(data);

		if (root == null) {
			root = newNode;
		} else {
			TreeNode current = root;
			TreeNode parent;

			while (true) {
				parent = current;
				if (current.data == data) {
					System.out.println("Duplicate Entry for : " + data);
					return;
				}

				else if (data < current.data) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	TreeNode deleteRec(TreeNode root, int data) {
		if (root == null)
			return root;

		if (data < root.data)
			root.left = deleteRec(root.left, data);

		else if (data > root.data)
			root.right = deleteRec(root.right, data);

		else {

			if (root.left == null)
				return root.right;

			else if (root.right == null)
				return root.left;

			root.data = minValue(root.right);

			root.right = deleteRec(root.right, root.data);
		}

		return root;
	}

	int minValue(TreeNode root) {
		int minv = root.data;
		while (root.left != null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	void deleteNode(int data) {
		root = deleteRec(root, data);
		System.out.println(root.data);
	}

	public void preOrderTraversal(TreeNode current) {
		if (current != null) {
			System.out.print(current.data + " ");
			preOrderTraversal(current.left);
			preOrderTraversal(current.right);
		}
	}

	public void inOrderTraversal(TreeNode current) {
		if (current != null) {
			inOrderTraversal(current.left);
			System.out.print(current.data + " ");
			inOrderTraversal(current.right);
		}
	}

	public void postOrderTraversal(TreeNode current) {
		if (current != null) {
			postOrderTraversal(current.left);
			postOrderTraversal(current.right);
			System.out.print(current.data + " ");
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		for (int i = 1; i <= 20; i++) {
			int n = new Random().nextInt(1, 50);
			tree.addNode(n);
		}
		System.out.println();
		tree.preOrderTraversal(tree.root);
		System.out.println();
		tree.inOrderTraversal(tree.root);
		System.out.println();
		tree.postOrderTraversal(tree.root);
		System.out.println();
		tree.deleteNode(15);
		tree.inOrderTraversal(tree.root);

	}
}