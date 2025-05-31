package com.study.toc;

import java.util.*;

public class CKY2 {
	static String lhs[];
	static String rhs[];
	static String rm[][];
	static String start;
	static String word;
	static int len, pr;

//******************************************************************************************************************
	static String getString(String s) {
		Scanner sc = new Scanner(System.in);
		System.out.print(s);
		return (sc.nextLine());
	}

//******************************************************************************************************************
	static int getInt(String s) {
		Scanner sc = new Scanner(System.in);
		System.out.print(s);
		try {
			return sc.nextInt();
		} catch (Exception e) {
			System.out.print("\nInvalid Input\n");
			System.exit(1);
			return 0;
		}
	}

	static {
		System.out.println(
				"*****Catenation Of All the Nonterminal Of LHS Will Be Considered As A Single Nonterminal*****");
	}

//****************************************************************************************************************************
	static void getGrammar() {
		pr = getInt("\ninput the total no of production rules of your grammar : ");
		if (pr <= 0) {
			System.out.println("\nInvalid Number Of Production Rules ");
			System.exit(0);
		}
		lhs = new String[pr];
		rhs = new String[pr];
		for (int i = 0; i < pr; i++) {
			lhs[i] = new String();
			rhs[i] = new String();
		}
		start = getString("Which Nonterminal Will Be The Start Symbol : ");
		for (char c : start.toCharArray()) {
			if (Character.isUpperCase(c) || (Character.isDigit(c))) {
				if (Character.isDigit(start.charAt(0))) {
					System.out.println("\nInvalid Start Symbol");
					System.exit(0);
				}
			} else {
				System.out.println("\nInvalid Start Symbol");
				System.exit(0);
			}
		}
		for (int i = 0; i < pr; i++) {
			String rule = getString("input production no " + (i + 1) + " : ");
			String ar[] = rule.split("->");
			for (char c : ar[0].toCharArray()) {
				if (Character.isUpperCase(c) || (Character.isDigit(c))) {
					if (lhs[i].equals("") && (Character.isDigit(c))) {
						System.out.print("\nInput The Grammar Which Is In CHOMSKY NORMAL FORM");
						System.exit(0);
					}
					lhs[i] = "" + lhs[i] + c;
				} else {
					System.out.print("\nInput The Grammar Which Is In CHOMSKY NORMAL FORM");
					System.exit(0);
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
				if (Character.isLowerCase(ar[1].charAt(0)) || (Character.isDigit(ar[1].charAt(0)))) {
					rhs[i] = "" + ar[1].charAt(0);
				} else {
					System.out.print("\nInput The Grammar Which Is In CHOMSKY NORMAL FORM");
					System.exit(0);
				}
				break;
			case 2:
				for (int x = 0; x < 2; x++) {
					if (Character.isUpperCase(ar[1].charAt(x)))
						rhs[i] = "" + rhs[i] + ar[1].charAt(x);
					else {
						System.out.print("\nInput The Grammar Which Is In CHOMSKY NORMAL FORM");
						System.exit(0);
					}
				}
				break;
			default:
				System.out.print("\nInput The Grammar Which Is In CHOMSKY NORMAL FORM");
				System.exit(0);
			}
		}
		System.out.println("\nGiven Grammar");
		for (int i = 0; i < pr; i++)
			System.out.println(lhs[i] + "->" + rhs[i]);
	}

//**********************************************************************************************************
	static void createRM() {
		len = word.length();
		rm = new String[len + 1][len + 1];
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j <= len; j++) {
				rm[i][j] = new String("");
			}
		}
	}

//************************************************************************************************************
	static String getWord() {
		return (word = getString("\nEnter -1 to exit or input the string : "));
	}

//************************************************************************************************************
	static void recognize() {
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < rhs.length; j++) {
				String k = word.substring(i, i + 1);
				if (k.equals(rhs[j])) {
					if (rm[i][i + 1].equals(""))
						rm[i][i + 1] = lhs[j];
					else
						rm[i][i + 1] = rm[i][i + 1] + "," + lhs[j];
				}
			}

		}
		for (int d = 2; d <= len; d++) {
			for (int i = 0; i <= len - d; i++) {
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

//******************************************************************************************************************
	static void output() {
		System.out.println("");
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j <= len; j++) {
				System.out.print("\t" + rm[i][j]);
				if ("".equals(rm[i][j]))
					System.out.print("-");
			}
			System.out.println("");
		}
		if (rm[0][len].contains(start))
			System.out.println("\nGiven String Can Be Generated");
		else
			System.out.println("\nGiven String Can Not Be Generated");
	}

//******************************************************************************************************************
	public static void main(String args[]) {
		getGrammar();
		while (!getWord().equals("-1")) {
			createRM();
			recognize();
			output();
		}
	}
}