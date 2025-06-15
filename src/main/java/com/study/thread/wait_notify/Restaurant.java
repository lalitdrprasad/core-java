package com.study.thread.wait_notify;

class Restaurant {
	private boolean tableAvailable = true;

	public synchronized void enterRestaurant(String customerName) {
		try {
			while (!tableAvailable) {
				System.out.println(customerName + " is waiting for a table...");
				wait();
			}
			System.out.println(customerName + " got the table and is eating...");
			try {
				Thread.sleep(2000); // Eating for 2 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tableAvailable = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void leaveRestaurant(String customerName) {
		System.out.println(customerName + " is done eating and left the table.");
		tableAvailable = true;
		notify();
	}
}