package com.study.algorythm;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Stock {
	public static Map<String, Integer> initialStock = new HashMap<>();
	public static Map<String, Integer> currentStock = new HashMap<>();

	public static int bicyclesManufactured = 0;
	private static int seats;
	private static int frames;
	private static int brakeSets;
	private static int brakePaddles;
	private static int brakeCables;
	private static int levers;
	private static int brakeShoes;
	private static int handlebars;
	private static int wheels;
	private static int tires;
	private static int chains;
	private static int crankSet;
	private static int paddles;

	public static final int getSeats() {
		return seats;
	}

	public static final int getFrames() {
		return frames;
	}

	public static final int getBrakeSets() {
		return brakeSets;
	}

	public static final int getBrakePaddles() {
		return brakePaddles;
	}

	public static final int getBrakeCables() {
		return brakeCables;
	}

	public static final int getLevers() {
		return levers;
	}

	public static final int getBrakeShoes() {
		return brakeShoes;
	}

	public static final int getHandlebars() {
		return handlebars;
	}

	public static final int getWheels() {
		return wheels;
	}

	public static final int getTires() {
		return tires;
	}

	public static final int getChains() {
		return chains;
	}

	public static final int getCrankSet() {
		return crankSet;
	}

	public static final int getPaddles() {
		return paddles;
	}

	public static final void setSeats(int seats) {
		Stock.seats = seats;
	}

	public static final void setFrames(int frames) {
		Stock.frames = frames;
	}

	public static final void setBrakeSets(int brakeSets) {
		Stock.brakeSets = brakeSets;
	}

	public static final void setBrakePaddles(int brakePaddles) {
		Stock.brakePaddles = brakePaddles;
	}

	public static final void setBrakeCables(int brakeCables) {
		Stock.brakeCables = brakeCables;
	}

	public static final void setLevers(int levers) {
		Stock.levers = levers;
	}

	public static final void setBrakeShoes(int brakeShoes) {
		Stock.brakeShoes = brakeShoes;
	}

	public static final void setHandlebars(int handlebars) {
		Stock.handlebars = handlebars;
	}

	public static final void setWheels(int wheels) {
		Stock.wheels = wheels;
	}

	public static final void setTires(int tires) {
		Stock.tires = tires;
	}

	public static final void setChains(int chains) {
		Stock.chains = chains;
	}

	public static final void setCrankSet(int crankSet) {
		Stock.crankSet = crankSet;
	}

	public static final void setPaddles(int paddles) {
		Stock.paddles = paddles;
	}

	public static Map<String, Integer> getStock() throws IllegalArgumentException, IllegalAccessException {
		Map<String, Integer> stock = new HashMap<>();
		Field[] fields = Stock.class.getDeclaredFields();
		for (Field f : fields) {
			if (f.getType().toString().equals("int"))
				stock.put(f.getName(), f.getInt(f));
		}
		return stock;
	}

	private static void dismantleBrakeSets() {
		while (Stock.getBrakeSets() > 0) {
			Stock.setBrakeSets(Stock.getBrakeSets() - 1);
			Stock.setBrakeCables(Stock.getBrakeCables() + BrakeSet.getBrakeCables());
			Stock.setBrakePaddles(Stock.getBrakePaddles() + BrakeSet.getBrakePaddles());
			Stock.setBrakeShoes(Stock.getBrakeShoes() + BrakeSet.getBrakeShoes());
			Stock.setLevers(Stock.getLevers() + BrakeSet.getLevers());
		}
	}
	public static void generateStock() throws IllegalArgumentException, IllegalAccessException {
		Scanner scanner = Generate_BoM.scanner;
		System.out.print("Seats = ");
		Stock.setSeats(scanner.nextInt());
		System.out.print("frames = ");
		Stock.setFrames(scanner.nextInt());
		System.out.print("Brake Set = ");
		Stock.setBrakeSets(scanner.nextInt());
		System.out.print("Brake Paddles = ");
		Stock.setBrakePaddles(scanner.nextInt());
		System.out.print("Brake Cables = ");
		Stock.setBrakeCables(scanner.nextInt());
		System.out.print("Levers = ");
		Stock.setLevers(scanner.nextInt());
		System.out.print("Brake Shoes = ");
		Stock.setBrakeShoes(scanner.nextInt());
		System.out.print("Handlebars = ");
		Stock.setHandlebars(scanner.nextInt());
		System.out.print("Wheels = ");
		Stock.setWheels(scanner.nextInt());
		System.out.print("Tires = ");
		Stock.setTires(scanner.nextInt());
		System.out.print("Chains = ");
		Stock.setChains(scanner.nextInt());
		System.out.print("Crank Set = ");
		Stock.setCrankSet(scanner.nextInt());
		System.out.print("Paddles = ");
		Stock.setPaddles(scanner.nextInt());
		Stock.updateValues();
	}
	
	public static void defaultStock() throws IllegalArgumentException, IllegalAccessException {
		seats = 50;
		frames = 80;
		brakeSets = 25;
		brakePaddles = 100;
		brakeCables = 75;
		levers = 60;
		brakeShoes = 150;
		handlebars = 100;
		wheels = 60;
		tires = 80;
		chains = 100;
		crankSet = 50;
		paddles = 150;

		updateValues();
	}

	public static void updateValues() throws IllegalArgumentException, IllegalAccessException {

		dismantleBrakeSets();
		initialStock = getStock();
		currentStock = getStock();
		BrakeSet.brakeSetParts = BrakeSet.getBrakeSetParts();
		Bicycle.bicycleParts = Bicycle.getBicycleParts();
	}
}
