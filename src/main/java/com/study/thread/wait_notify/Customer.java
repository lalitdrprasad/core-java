package com.study.thread.wait_notify;

class Customer extends Thread {
	private Restaurant restaurant;
	private String customerName;

	public Customer(Restaurant restaurant, String name) {
		this.restaurant = restaurant;
		this.customerName = name;
	}

	public void run() {
		restaurant.enterRestaurant(customerName);

		restaurant.leaveRestaurant(customerName);
	}
}