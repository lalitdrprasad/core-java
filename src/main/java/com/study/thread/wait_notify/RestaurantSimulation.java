package com.study.thread.wait_notify;

public class RestaurantSimulation {
	
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();

		Customer c1 = new Customer(restaurant, "Lalit");
		Customer c2 = new Customer(restaurant, "Ravi");
		Customer c3 = new Customer(restaurant, "Anjali");

		c1.start();
		c2.start();
		c3.start();
	}
}
