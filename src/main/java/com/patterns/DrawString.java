package com.patterns;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class DrawString {

	String character = null;
	String space = "  ";/* space between two character of letter */
	int matrixSize = 8;
	int sleep = 10;/*
					 * time delay for animation effect while printing the characters
					 */

	private void printA(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if ((i == 1) || (j == 1) || (j == cols) || (i == rows / 2)) {
				if (i == 1 && (j == 1 || j == cols)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printB(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;

		for (int j = 1; j <= cols; j++) {
			if ((i == 1) || (j == 1) || (j == cols) || (i == rows / 2) || (i == matrixSize)) {

				if ((i == 1 || i == rows / 2 || i == rows) && (j == cols)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printC(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if ((i == 1) || (j == 1) || (i == rows)) {

				if ((i == 1 || i == rows) && (j == 1)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printD(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if ((i == 1) || (j == 1) || (j == cols) || (i == rows)) {

				if ((i == 1 || i == matrixSize) && (j == cols)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printE(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if ((i == 1) || (j == 1) || (i == rows) || i == rows / 2) {

				if ((i == 1 || i == rows) && (j == 1)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printF(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if ((i == 1) || (j == 1) || (i == rows / 2)) {

				if (i == 1 && (j == 1)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printG(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if ((i == 1) || (j == 1) || (i == rows) || (j == cols && i >= rows / 2)
					|| (i == rows / 2 && j > cols / 2)) {

				if ((i == 1 || i == rows) && (j == 1 || j == cols) || (i == rows / 2 && j == cols)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printH(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if ((j == 1) || (j == cols) || (i == rows / 2)) {

				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printI(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize;
		if (cols % 2 == 0)
			cols++;

		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i == rows || j == cols / 2 + 1) {
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printJ(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize;
		for (int j = 1; j < cols; j++) {
			if ((i == 1 || j == cols / 2) || (j == 1 && i > rows / 4 + rows / 2) || (i == rows && j <= cols / 2)) {

				if ((i == rows) && (j == 1 || j == cols / 2)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printK(int i, String character) {
		int cols = matrixSize / 2;
		for (int j = 1; j <= cols + 1; j++) {
			if (j == 1 || i + j == cols + 2 || i - j == cols - 1) {
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printL(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j < cols; j++) {
			if (j == 1 || (i == rows && j <= cols)) {
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printM(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize;
		for (int j = 1; j <= cols; j++) {
			if (j == 1 || j == cols - 1 || (i <= rows / 2) && ((i == j || i + j == cols))) {
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printN(int i, String character) {
		int cols = matrixSize;
		for (int j = 1; j <= cols; j++) {
			if (j == 1 || j == cols || i == j) {
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printO(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i == rows || j == 1 || j == cols) {
				if ((i == 1 && j == 1) || (i == rows && j == cols) || (i == rows && j == 1) || (i == 1 && j == cols)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printP(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i == rows / 2 + 1 || j == 1 || (j == cols && i <= rows / 2 + 1)) {
				if ((j == cols) && (i == 1 || i == rows / 2 + 1)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printQ(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i == rows || j == 1 || j == cols || (i - j <= cols / 3 && i - 1 > rows / 2)) {
				if ((i == 1 && j == 1) || (i == rows && j == cols) || (i == rows && j == 1) || (i == 1 && j == cols)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printR(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i == rows / 2 + 1 || j == 1 || (j == cols && i <= rows / 2)
					|| (i - j == cols - rows / 3 - 1)) {
				if ((j == cols) && (i == 1 || i == rows / 2 + 1)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printS(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if ((i == 1 || i == rows || i == rows / 2 || j == 1) && i <= rows / 2
					|| ((j == cols || i == rows) && i >= rows / 2)) {
				if ((j == 1) && (i == 1 || i == rows / 2) || (j == cols) && (i == rows || i == rows / 2)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printT(int i, String character) {
		int cols = matrixSize;
		if (cols % 2 == 0)
			cols++;

		for (int j = 1; j <= cols; j++) {
			if (i == 1 || j == cols / 2 + 1) {
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printU(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if (i == rows || j == 1 || j == cols) {
				if ((i == rows && j == cols) || (i == rows && j == 1)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printV(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize * 2;
		for (int j = 1; j <= cols; j++) {
			if (i == j || i + j == cols) {
				print(character.substring(1));
			} else
				System.out.print(" ");
		}
		System.out.print(space);
	}

	private void printW(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize;
		for (int j = 1; j < cols; j++) {
			if (j == 1 || j == cols - 1 || (i > rows / 2) && ((i - j == 1 || i + j == cols + 1))) {
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printX(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize;
		for (int j = 1; j <= cols; j++) {
			if (i == j || i + j == rows + 1) {
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printY(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize;
		for (int j = 1; j < cols; j++) {
			if (((i <= rows / 2) && (i == j || i + j == cols)) || (i > rows / 2 && j == cols / 2))
				print(character);
			else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void printZ(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize;
		if (cols % 2 == 0)
			cols++;
		for (int j = 1; j < cols; j++) {
			if (i == 1 || i == rows || i + j == cols)
				print(character);
			else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void print0(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i == rows || j == 1 || j == cols || i + j - 2 == cols) {
				if ((i == 1 && j == 1) || (i == rows && j == cols) || (i == rows && j == 1) || (i == 1 && j == cols)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void print1(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize / 2 + 1;
		for (int j = 1; j <= cols; j++) {
			if (i == rows || j == cols / 2 + 1 || i == rows || (i < cols && i + j == cols / 2 + 2)) {
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void print2(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if ((i == 1 || i == rows || i == rows / 2 || j == cols) && i <= rows / 2
					|| ((j == 1 || i == rows) && i >= rows / 2)) {
				if ((j == cols && (i == 1 || i == rows / 2)) || (j == 1 && (i == rows || i == rows / 2))) {
					System.out.print(" ");
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void print3(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i == rows || i == rows / 2 || j == cols) {
				if ((i == 1 || i == rows || i == rows / 2) && (j == cols)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void print4(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= matrixSize; j++) {
			if (i == rows / 2 + 1 || i + j == cols || j == cols) {
				print(character);
			} else
				System.out.print(space);
		}
		System.out.print(space);
	}

	private void print5(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i == rows || i == rows / 2 || j == 1 || j == cols) {
				if ((i != 1 && i < rows / 2 && j == cols) || (i != rows && i > rows / 2 && j == 1)
						|| ((i == rows / 2 || i == rows) && j == cols)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else {
				System.out.print(space);
			}
		}
		System.out.print(space);
	}

	private void print6(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i == rows || i == rows / 2 || j == 1 || j == cols) {
				if (((i == 1 || i == rows) && (j == 1 || j == cols) && (i >= j))
						|| (i != 1 && i < rows / 2 && j == cols)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else {
				System.out.print(space);
			}
		}
		System.out.print(space);
	}

	private void print7(int i, String character) {
		space = "  ";
		int cols = matrixSize;
		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i + j - 1 == cols) {
				print(character);
			} else {
				System.out.print(space);
			}
		}
		System.out.print(space);
	}

	private void print8(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i == rows || i == rows / 2 || j == 1 || j == cols) {
				if ((i == 1 || i == rows) && (j == 1 || j == cols) || (i == rows / 2 && (j == 1 || j == cols))) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else {
				System.out.print(space);
			}
		}
		System.out.print(space);
	}

	private void print9(int i, String character) {
		int rows = matrixSize;
		int cols = matrixSize - matrixSize / 4;
		for (int j = 1; j <= cols; j++) {
			if (i == 1 || i == rows || i == rows / 2 + 1 || j == 1 || j == cols) {
				if ((i > rows / 2 && j == 1 && i != rows) || (i == 1 && (j == 1 || j == cols))
						|| (i == rows && j == cols)) {
					System.out.print(space);
					continue;
				}
				print(character);
			} else {
				System.out.print(space);
			}
		}
		System.out.print(space);
	}

	private void print(String str) {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print(str);
	}

	public void design(String str, char c) {

		str = str.replaceAll("[^\\w]+", " ").trim().replaceAll("\\s+", " ");

		character = " " + c;

		String[] setOfWords = str.split(" ");

		for (String word : setOfWords) {
			for (int i = 1; i <= matrixSize; i++) {
				for (int j = 0; j < word.length(); j++) {

					try {
						this.getClass()
								.getDeclaredMethod(("print" + word.toUpperCase().charAt(j)), int.class, String.class)
								.invoke(this, i, character);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
			}
			System.out.println("\n");
		}
	}

	public void design(String str) {

		str = str.replaceAll("[^\\w]+", " ").trim().replaceAll("\\s+", " ");

		String[] setOfWords = str.split(" ");

		for (String word : setOfWords) {
			for (int i = 1; i <= matrixSize; i++) {
				for (int j = 0; j < word.length(); j++) {
					// Design character with character it self.
					character = (" " + word.toUpperCase().charAt(j)).toUpperCase();
					if (new String("" + str.charAt(j)).equals(" ")) {
						System.out.print(space);
						System.out.print(space);
						continue;
					}
					try {
						this.getClass()
								.getDeclaredMethod(("print" + word.toUpperCase().charAt(j)), int.class, String.class)
								.invoke(this, i, character);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
			}
			System.out.println("\n");
		}
	}

	public void designOneLine(String str, char c) {

		character = " " + c;

		// Remove special Characters from String
		str = str.replaceAll("[^\\w]+", " ").trim().replaceAll("\\s+", " ");
		System.out.println("\n");
		for (int i = 1; i <= matrixSize; i++) {
			System.out.print("\t");
			for (int j = 0; j < str.length(); j++) {
				if (new String("" + str.charAt(j)).equals(" ")) {
					System.out.print(space);
					System.out.print(space);
					continue;
				}
				try {
					this.getClass().getDeclaredMethod(("print" + str.toUpperCase().charAt(j)), int.class, String.class)
							.invoke(this, i, character);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
		}
		System.out.println("\n\t");
	}

	public static void main(String[] args) {
		DrawString obj = new DrawString();
		Scanner sc = new Scanner(System.in);
		System.out.print("String to be designed : ");
		String str = sc.nextLine();

		System.out.println(
				
			"1 for Default Characters\n" + 
			"2 for multiline output with given character\n"+
			"3 for One line output with given character"
		);
		
		switch (sc.nextInt()) {
		case 1:
			obj.design(str);
			break;
		case 2:
			System.out.print("Charater to be used : ");
			obj.design(str, sc.next().charAt(0));
			break;
		case 3:
			System.out.print("Charater to be used : ");
			obj.designOneLine(str, sc.next().charAt(0));
			break;
		default:
			System.out.println("Invalid Input");
		}

		sc.close();
		obj = null;
	}
}