package com.v18;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class V3MetaDataConsol {

	final String key = "data-assetid";
	final String trayTitle = "Tray title";

	final int idLimit = 999;
	final int gap = 3;

	String startOfAssetTitle = "<span>";
	String endOfAssetTitle = "</span>";

	FileInputStream fis = null;

	String getTrayName(String line) {
		String name = null;
		if (line.contains(trayTitle)) {
			int beg = line.indexOf('>', line.indexOf(trayTitle));
			int end = line.indexOf('<', beg);
			name = line.substring(beg + 1, end);
		}
		return name;
	}

	String getAssetName(String line) {
		String assetTitle = null;
		if (line.startsWith(startOfAssetTitle)) {
			int beg = line.indexOf(startOfAssetTitle);
			int end = line.indexOf(endOfAssetTitle, beg);
			assetTitle = line.substring(beg + startOfAssetTitle.length(), end);
		}
		return assetTitle;
	}

	int getAssetId(String line) {
		int assetId = 0;
		if (line.contains(key)) {
			int index = line.indexOf(key) + key.length();
			int counterer = 0;
			boolean flag = false;
			while (true) {
				if (Character.isDigit(line.charAt(index))) {
					flag = true;
					assetId = assetId * 10 + Character.getNumericValue(line.charAt(index));
				} else if (flag || counterer > gap) {
					break;
				}
				index++;
				counterer++;
			}
		}
		if (assetId < idLimit)
			assetId = 0;
		return assetId;
	}

	public void fetchData(String source) {
		try {

			fis = new FileInputStream(source);
			Scanner scanner = new Scanner(fis);

			String trayName = null;
			String assetName = null;
			String line = null;

			int assetId = 0;
			int counter = 0;

			while (scanner.hasNextLine()) {

				line = scanner.nextLine().trim();

				trayName = getTrayName(line);
				assetName = getAssetName(line);
				assetId = getAssetId(line);

				if (trayName != null) {
					System.out.println();
					System.out.println(trayName);
					counter = 0;
				}

				if (assetId != 0) {
					counter++;
					System.out.printf("%-6d", counter);
					System.out.print(assetId + "\t");
					// System.out.println(assetId);
				}

				if (assetName != null) {
					System.out.println(assetName);
				}
			}

			scanner.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		V3MetaDataConsol obj = new V3MetaDataConsol();
		obj.fetchData("D:\\Lalit\\V18\\cms.txt");

	}
}
