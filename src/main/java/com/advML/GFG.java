package com.advML;

import java.util.ArrayList;
import java.util.stream.Stream;

public class GFG {

	public static void main(String[] args) {

		ArrayList<String> gfgNames = new ArrayList<>();

		gfgNames.add("Dean");
		gfgNames.add("castee");
		gfgNames.add("robert");

		Stream<String> streamOfNames = gfgNames.stream();

		System.out.print(streamOfNames);
	}
}
