package com.exception;

import java.util.Scanner;

public class Bank {
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
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1 to Balance Enquery");
			System.out.println("2 to Deposite");
			System.out.println("3 to withdraw");
			System.out.println("0 to Exit");
			int ch = sc.nextInt();
			sc.close();
			switch (ch) {
			case 1:
				System.out.println(bank.checkBalance());
				break;
			case 2:
				System.out.println("Amount : ");
				bank.deposite(sc.nextFloat());
				break;
			case 3:
				System.out.println("Amount : ");
				bank.withdraw(sc.nextFloat());

				break;
			case 0:
				System.exit(0);
			default:
				System.exit(0);

			}
		} while (true);

	}

}
