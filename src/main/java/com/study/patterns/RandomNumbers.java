package com.study.patterns;

import java.util.Random;

public class RandomNumbers {
	public static void main(String[] args) {
		for (int i = 0; i < 215; i++)
			System.out.println((new Random().nextInt(4)+1) * 2);
	}
}
