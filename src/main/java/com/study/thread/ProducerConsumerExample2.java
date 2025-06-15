package com.study.thread;

public class ProducerConsumerExample2 {

	private final Object lock = new Object();

	private int currentStock = 0;

	public void produce() throws InterruptedException {

		while (true) {
			synchronized (lock) {
				if (currentStock == 5)
					lock.wait();
				while (currentStock < 5) {
					System.out.println("Item Produced: " + ++currentStock);
					Thread.sleep(500);
				}
				lock.notify();
			}
		}

	}

	public void consume() throws InterruptedException {

		while (true) {
			synchronized (lock) {
				if (currentStock == 0)
					lock.wait();
				while (currentStock > 0) {
					System.out.println("Item Consumed- Remaining Items :" + --currentStock);
					Thread.sleep(500);
				}
				lock.notify();
			}
		}

	}

	public static void main(String[] args) {

		ProducerConsumerExample2 pc = new ProducerConsumerExample2();

		Runnable runnable = () -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);

		t1.start();
		t2.start();
	}
}
