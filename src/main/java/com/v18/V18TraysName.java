package com.v18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class V18TraysName {

	final String trayTitle = "Tray title";

	final String trayTypeKey = "data-text=\"Description\"";
	final String trayLineTag = "</div>";

	final String queryKey = "data-filter=\"query\"";
	final String queryValue = "value=";

	final String key = "data-assetid";

	final String trayStatusBeg = "<span";
	final String trayStatusEnd = "</span></div>";

	final String showPageNameBeg = "Working on Draft for ";
	final String showPageNameEnd = "<span class=\"chip\">";
	
	final String[] statusList = { "inactive", "published", "editing", "inactive-draft" };

	final int gap = 1;

	static int counter = 0;
	String startOfassetName = "<span>";
	String endOfassetName = "</span>";

	FileInputStream fis = null;
	FileOutputStream fos = null;

	String getTrayName(String line) {
		String name = null;
		if (line.contains(trayTitle)) {
			int beg = line.indexOf('>', line.indexOf(trayTitle));
			int end = line.indexOf('<', beg);
			name = line.substring(beg + 1, end);
		}
		return name;
	}

	String getQuery(String line) {
		String query = "";
		if (line.contains(queryKey)) {
			int index = line.indexOf(queryValue) + queryValue.length() + gap;
			while (line.charAt(index) != '"')
				query = query + line.charAt(index++);
		}
		if (query.length() < 1)
			query = null;
		return query;
	}

	String getTrayType(String line) {
		String trayType = "";
		if (line.contains(trayTypeKey)) {
			int index = line.lastIndexOf(trayLineTag);

			while (line.charAt(--index) != '>')
				trayType = line.charAt(index) + trayType;
		}
		if (trayType.length() < 1)
			trayType = null;

		return trayType;
	}

	String getTrayStatus(String line) {
		String trayStatus = "";
		if (line.contains(trayStatusBeg) && line.contains(trayStatusEnd)) {
			int index = line.lastIndexOf(trayStatusEnd);

			while (line.charAt(--index) != '>')
				trayStatus = line.charAt(index) + trayStatus;
		}

		if (Arrays.asList(statusList).contains(trayStatus))
			return trayStatus;
		return null;
	}

	void updateCount(String line) {

		if (line.contains(key))
			counter++;

	}

	String getshowPageName(String line) {
		String showPageName = null;
		if (line.contains(showPageNameBeg)) {
			showPageName = line.substring(line.indexOf(showPageNameBeg) + showPageNameBeg.length(),
					line.indexOf(showPageNameEnd));
		}
		return showPageName;
	}

	public void fetchData(String source, String destination) {

		try {

			fis = new FileInputStream(source);
			fos = new FileOutputStream(destination);
			Scanner scanner = new Scanner(fis);

			String trayName = null;
			String query = null;
			String trayType = null;
			String trayStatus = null;
			String line = null;
			String showPageName = null;
			String currentShowPage = null;
			while (scanner.hasNextLine()) {

				line = scanner.nextLine().replace("&nbsp;", " ").replace("&amp;", "").replace("  ", " ").trim();

				trayName = getTrayName(line);
				query = getQuery(line);
				trayType = getTrayType(line);
				trayStatus = getTrayStatus(line);
				
				if (showPageName == null) {
					showPageName = getshowPageName(line);
					if (showPageName != null) {
						currentShowPage = showPageName;
						showPageName = null;
					}
				}
				if (trayName != null) {
					if (counter != 0) {
						fos.write(("\t" + counter).getBytes());
						counter = 0;
					}
					fos.write(("\n").getBytes());
					fos.write((currentShowPage+": "+trayName).getBytes());
					// System.out.print("\n" + trayName + "\t");
				}

				if (query != null) {
					fos.write(("\t").getBytes());
					fos.write((query).getBytes());
					// System.out.println(query);
				}
				if (trayType != null) {
					fos.write(("\t").getBytes());
					fos.write((trayType).getBytes());
					// System.out.println(trayType);
				}
				if (trayStatus != null) {
					fos.write(("\t").getBytes());
					fos.write((trayStatus).getBytes());
					// System.out.println(trayStatus);
				}
				updateCount(line);

			}
			fos.write(("\t" + counter).getBytes());
			scanner.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String v3_src = "v3_src.txt";
		String v3_res = "v3_res.txt";
		
		String jio_src = "jio_src.txt";
		String jio_res = "jio_res.txt";

		V18TraysName obj = new V18TraysName();

		obj.fetchData(v3_src, v3_res);
		obj.fetchData(jio_src, jio_res);

		System.out.println("Results have been saved ");
	}
}