package com.v18.cms;

import java.io.*;
import java.util.Scanner;

public class V3MetaData {
	int headers = 1;
	String tray = "";
	String header = "";
	String content = "";

	final String key = "data-assetid";
	final String trayTitle = "Tray title";
	final int gap = 3;
	final int idSize = 999;

	String startOfAssetTitle = "<span>";
	String endOfAssetTitle = "</span>";

	FileInputStream fis = null;
	FileOutputStream fos = null;

	String line = null;
	String assetTitle = null;

	public void getIds(String source, String destination) {
		try {
			int id = 0;
			int count = 0;
			fis = new FileInputStream(source);
			fos = new FileOutputStream(destination);
			Scanner scanner = new Scanner(fis);
			while (scanner.hasNextLine()) {
				line = scanner.nextLine().trim();

				/* Fetching Tray Name */
				if (line.contains(trayTitle)) {
					int beg = line.indexOf('>', line.indexOf(trayTitle));
					int end = line.indexOf('<', beg);
					String name = line.substring(beg + 1, end);

					// System.out.println("\n" + name);
					name = tray + name;

					fos.write(("\n").getBytes());

					for (int i = 0; i < headers; i++) {
						fos.write((name).getBytes());
						fos.write(("\t").getBytes());
					}

					fos.write(("\n").getBytes());
					count = 0;
				}

				/* Fetching Media IDs */
				if (line.contains(key)) {
					int index = line.indexOf(key) + key.length();
					int counter = 0;
					boolean flag = false;
					while (true) {
						try {
							if (Character.isDigit(line.charAt(index))) {
								flag = true;
								id = id * 10 + Character.getNumericValue(line.charAt(index));
							} else if (flag || counter > gap) {
								break;
							}
							index++;
							counter++;
						} catch (Exception e) {
							break;
						}
					}

				}

				/* Fetching Asset Name */
				if (line.startsWith(startOfAssetTitle)) {
					int beg = line.indexOf(startOfAssetTitle);
					int end = line.indexOf(endOfAssetTitle, beg);
					if (count == 0) {
						fos.write((header + "S.No.").getBytes());
						fos.write(("\t").getBytes());
						fos.write((header + "Asset Name").getBytes());
						fos.write(("\t").getBytes());
						fos.write((header + "Remarks").getBytes());
						fos.write(("\t").getBytes());
						fos.write((header + "Media ID").getBytes());
						fos.write(("\n").getBytes());

						// System.out.println("S.No.\tMedia ID\tAsset Name");
					}

					assetTitle = line.substring(beg + startOfAssetTitle.length(), end);
					count++;
					fos.write((content + count).getBytes());
					fos.write(("\t").getBytes());
					fos.write((content + assetTitle).getBytes());
					fos.write(("\t").getBytes());
					fos.write((content).getBytes());
					fos.write(("\t").getBytes());
					fos.write((content + id).getBytes());
					fos.write(("\n").getBytes());

					// System.out.println(count + "\t" + id + "\t\t" +
					// assetTitle);

					id = 0;
				}
			}

			fis.close();
			fos.close();
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String source = "source.txt";
		String destination = "res.txt";
		//String destination = "C:\\Users\\lalit\\Downloads\\res.xls";

		V3MetaData obj = new V3MetaData();
		obj.getIds(source, destination);

		String ack = "Results have been saved in the file : " + destination;
		System.out.println(ack);
	}
}