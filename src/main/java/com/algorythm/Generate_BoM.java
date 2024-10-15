package com.algorythm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Generate_BoM {
	final static int brakeSetsFor1 = 2;
	static Scanner scanner = new Scanner(System.in);
	static int bicycles = 200;
	public static Map<String, Integer> boM = new HashMap<>();

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		int ch = 0;
		try {
			System.out.print("Enter number of bicycles : ");
			bicycles = scanner.nextInt();
		} catch (Exception e) {
		}
		try {
			System.out.print("Press 1 to Create New Stock List or press any number to go with default stock : ");
			ch = scanner.nextInt();
		} catch (Exception e) {
		}

		if (ch == 1)
			Stock.generateStock();
		else
			Stock.defaultStock();
		scanner.close();
		generateBoM(bicycles);

		while (Bicycle.manufactureBicycle())
			;
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		System.out.println("   Item\t\t\tRatio\t\tBoM\t\tOn Hand\t\tRequired\tRemaining Stock");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		Map<String, Integer> initialStock = Stock.initialStock;
		Map<String, Integer> currentStock = Stock.currentStock;
		Map<String, Integer> ratioList = getRatio();
		for (String key : boM.keySet()) {
			int bom = boM.get(key);
			int initial = initialStock.get(key);
			int current = currentStock.get(key);
			int ratio = ratioList.get(key);
			if (bom >= initial) {
				System.out.println("   " + key + "\t\t" + ratio + "\t\t" + bom + "\t\t" + initial + "\t\t"
						+ (bom - initial) + "\t\t" + current);
			} else
				System.out.println(
						"   " + key + "\t\t" + ratio + "\t\t" + bom + "\t\t" + initial + "\t\t0" + "\t\t" + current);
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		System.out.println("Total Number of Bicycles Manufactured : " + Stock.bicyclesManufactured);
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");

		System.out.println("Note - \n1. All Brake sets have been converted into individual parts");
		System.out.println("2. As mentioned Bicycle will require 2 Brake Set and each set have 1 set of lever ");
		System.out.println("So we are assuming 1 set of lever = 2 Levers\n Hence, 1 Bicycle needs 4 Levers");
	}

	public static Map<String, Integer> getRatio() {
		Map<String, Integer> ratio = new HashMap<>();
		for (String key : Bicycle.bicycleParts.keySet()) {
			if (Stock.initialStock.containsKey(key)) {
				ratio.put(key, Bicycle.bicycleParts.get(key));
			}
		}

		for (String key : BrakeSet.brakeSetParts.keySet()) {
			if (Stock.initialStock.containsKey(key)) {
				ratio.put(key, BrakeSet.brakeSetParts.get(key) * brakeSetsFor1);
			}
		}
		return ratio;
	}

	public static void generateBoM(int n) {
		boM = getRatio();
		for (String key : boM.keySet()) {
			boM.put(key, boM.get(key) * n);
		}
	}
}