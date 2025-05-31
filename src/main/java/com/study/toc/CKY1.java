package com.study.toc;

import java.util.*;

public class CKY1 {
	static String lhs[];
	static String rhs[];
	static String rm[][];
	static String start;
	static String s;
	static int n, i, j;

	static void setValue() {
		rm = new String[n + 1][n + 1];
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= n; j++) {
				rm[i][j] = new String("");
			}
		}
	}

	static void rec(String s) {
		for (i = 0; i < n; i++) {
			for (j = 0; j < rhs.length; j++) {
				String k = s.substring(i, i + 1);
				if (k.equals(rhs[j])) {
					if (rm[i][i + 1].equals(""))
						rm[i][i + 1] = lhs[j];
					else
						rm[i][i + 1] = rm[i][i + 1] + "," + lhs[j];
				}
			}

		}
		for (int d = 2; d <= n; d++) {
			for (i = 0; i <= n - d; i++) {
				j = d + i;
				for (int k = i + 1; k < j; k++) {
					char a[] = rm[i][k].toCharArray();
					char b[] = rm[k][j].toCharArray();
					for (char x : a) {
						for (char y : b) {
							for (String z : rhs) {
								if (z.equals(("" + x + y))) {
									for (int p = 0; p < rhs.length; p++) {

										if (z.equals(rhs[p])) {
											if (rm[i][j].equals(""))
												rm[i][j] = lhs[p];
											else if (!rm[i][j].contains(lhs[p]))
												rm[i][j] = rm[i][j] + "," + lhs[p];
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	static void display() {
		System.out.print("\t");
		for (int i = 0; i <= n; i++)
			System.out.print("\t" + i);
		System.out.println("");
		for (i = 0; i <= n; i++) {
			System.out.println("\n\t" + i);
			for (j = 0; j <= n; j++) {
				System.out.print("\t" + rm[i][j]);
				if ("".equals(rm[i][j]))
					System.out.print("-");
			}
			System.out.println("");
		}
		if (rm[0][n].contains(start))
			System.out.println("\nGiven String Can Be Generated");
		else
			System.out.println("\nGiven String Can Not Be Generated");
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		System.out.print("\ninput the total no of production rules of your grammar : ");
		int pr = sc1.nextInt();
		lhs = new String[pr];
		rhs = new String[pr];
		for (i = 0; i < pr; i++) {
			lhs[i] = new String();
			rhs[i] = new String();
		}
		System.out.println("\n***********Use ^ for Null**********");
		System.out.println(
				"*****Catenation Of All the Nonterminal Of LHS Will Be Considered As A Single Nonterminal*****");
		System.out.print("Which Nonterminal Will Be The Start Symbol : ");
		start = sc.next();
		for (i = 0; i < pr; i++) {
			System.out.print("input production no " + (i + 1) + " : ");
			s = sc.next();
			String ar[] = s.split("->");
			for (char c : ar[0].toCharArray()) {
				if (Character.isUpperCase(c) || (Character.isDigit(c))) {
					if (lhs[i].equals("") && (Character.isDigit(c))) {
						System.out.print("\nInput The Grammar Which Is In CHOMSKY NORMAL FORM");
						return;
					}
					lhs[i] = "" + lhs[i] + c;
				} else {
					System.out.print("\nInput The Grammar Which Is In CHOMSKY NORMAL FORM");
					return;
				}
			}
			int k = 0;
			try {
				k = ar[1].length();
			} catch (Exception e) {
			}
			switch (k) {
			case 1:
				char c = ar[1].charAt(0);
				if (Character.isLowerCase(ar[1].charAt(0)) || (Character.isDigit(ar[1].charAt(0)))
						|| (ar[1].charAt(0) == 94)) {
					if ((ar[1].charAt(0) == 94) && (lhs[i].equals(start))) {
						rhs[i] = "" + ar[1].charAt(0);
					} else if ((ar[1].charAt(0) == 94) && (lhs[i] != start)) {
						System.out.print("\nInput The Grammar Which Is In CHOMSKY NORMAL FORM");
						return;
					} else {
						rhs[i] = "" + ar[1].charAt(0);
					}
				} else {
					System.out.print("\nInput The Grammar Which Is In CHOMSKY NORMAL FORM");
					return;
				}
				break;
			case 2:
				for (int x = 0; x < 2; x++) {

					if (Character.isUpperCase(ar[1].charAt(x)))
						rhs[i] = "" + rhs[i] + ar[1].charAt(x);
					else {
						System.out.print("\nInput The Grammar Which Is In CHOMSKY NORMAL FORM");
						return;
					}
				}
				break;
			default:
				System.out.print("\nInput The Grammar Which Is In CHOMSKY NORMAL FORM");
				return;
			}
		}

		System.out.println("\nGiven Grammar");
		for (i = 0; i < pr; i++)
			System.out.println(lhs[i] + "->" + rhs[i]);
		while (true) {
			System.out.print("\nEnter -1 to exit or input the string : ");
			s = sc.next();
			n = s.length();
			setValue();
			if (s.equals("-1"))
				break;
			rec(s);
			display();
		}
	}
}