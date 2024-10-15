package com.thread;

public class ThreadDemo2 {

	public static void main(String[] args) {

		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i <= 10; i++) {

					System.out.println(i + " - " + Thread.currentThread().getName());
				}
			}
		});

		th1.start();

		for (int i = 11; i <= 20; i++) {
			System.out.println(i + " - " + Thread.currentThread().getName());
		}
	}

}
