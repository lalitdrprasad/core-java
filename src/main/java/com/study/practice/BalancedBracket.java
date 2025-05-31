package com.study.practice;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input String");
		String str = scanner.nextLine();

		Stack<Character> stack = new Stack<Character>();

		boolean insertMode = true;
		boolean result = true;

		for (char c : str.toCharArray()) {
			if (c == '(') {
				if (insertMode) {
					stack.push(c);
				} else if (stack.size() == 0) {
					insertMode = true;
					stack.push(c);
				} else {
					result = false;
					break;
				}
			} else if (c == ')') {
				if (stack.size() == 0) {
					result = false;
					break;
				} else {
					insertMode = false;
					stack.pop();
				}
			}
		}
		if (stack.size() == 0 && result)
			System.out.println(true);
		else
			System.out.println(false);
		scanner.close();
	}
}
