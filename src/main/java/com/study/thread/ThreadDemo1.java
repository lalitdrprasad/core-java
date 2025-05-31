package com.study.thread;

public class ThreadDemo1 implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("From " + Thread.currentThread().getName() + " : " + i);
		}
	}

	public static void main(String args[]) throws Exception {
		Thread th0 = new Thread(new ThreadDemo1());
		Thread th1 = new Thread(new ThreadDemo1());

		Thread th2 = new Thread(new ThreadDemo1());
		th0.setName("0");
		th1.setName("1");
		th2.setName("2");

		System.out.println("Start Main");
		th0.start();
		th1.start();
		th2.start();
		Thread.sleep(10);
		System.out.println("End Main");
	}
}