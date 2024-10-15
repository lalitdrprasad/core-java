package com.exception;

import java.util.Scanner;

class MinimumBalanceException extends Exception {
	private static final long serialVersionUID = 1L;

	MinimumBalanceException() {
		super("Can't Withdraw, You don't have sufficient balance");
	}
}

public class UserDefinedExeption {
	private float balance = 1000;
	final private int min = 1000;

	public float checkBalance() {
		return balance;
	}

	public void deposite(float amt) {
		balance += amt;
		System.out.println("Total balance : " + checkBalance());
	}

	public void withdraw(float amt) throws MinimumBalanceException {

		if (balance - amt < min) {
			throw new MinimumBalanceException();
		} else {
			balance -= amt;
			System.out.println("Total balance : " + checkBalance());
		}
	}

	public static void main(String args[]) throws MinimumBalanceException {
		UserDefinedExeption UserDefinedExeption = new UserDefinedExeption();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1 to Balance Enquery");
			System.out.println("2 to Deposite");
			System.out.println("3 to withdraw");
			System.out.println("0 to Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println(UserDefinedExeption.checkBalance());
				break;
			case 2:
				System.out.println("Amount : ");
				UserDefinedExeption.deposite(sc.nextFloat());
				break;
			case 3:
				System.out.println("Amount : ");
				UserDefinedExeption.withdraw(sc.nextFloat());

				break;
			case 0:
				System.exit(0);
			default:
				System.exit(0);

			}
		} while (true);
	}
}
