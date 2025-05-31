package com.study.toc;

import java.util.*;

public class CKY {
	static String lhs[] = { "S", "S", "A", "A", "A", "B", "B", "B", "C", "C", "C" };
	static String rhs[] = { "AB", "BB", "CC", "AB", "a", "BB", "CA", "b", "BA", "AA", "b" };
	static String rm[][];
	static int n;
	static int cnt = 0;

	static void setValue(int l) {
		n = l;
		rm = new String[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				rm[i][j] = new String("");
			}
		}
	}

	static void rec(String s) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < rhs.length; j++) {
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
			for (int i = 0; i <= n - d; i++) {
				int j = d + i;
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
		for (int i = 0; i <= n; i++) {
			System.out.print("\n\n\t" + i);
			for (int j = 0; j <= n; j++) {
				System.out.print("\t" + rm[i][j]);
				if ("".equals(rm[i][j]))
					System.out.print("-");
			}
			System.out.println("");
		}
		if (rm[0][n].contains("S"))
			System.out.println("\nGiven String Can Be Generated");
		else
			System.out.println("\nGiven String Can Not Be Generated");
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nGiven Grammar");
		for (int i = 0; i < lhs.length; i++)
			System.out.println(lhs[i] + "->" + rhs[i]);
		while (true) {
			System.out.print("\nEnter -1 to exit or input the string : ");
			String s = sc.next();
			setValue(s.length());
			if (s.equals("-1"))
				break;
			rec(s);
			display();
		}
	}
}