package com.v18.cms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CustomEditorials {
	final String trayTitle = "Tray title";

	final String trayTypeKey = "data-text=\"Description\"";
	final String trayTypeLineEnd = "</div>";

	final String trayStatusBeg = "<span";
	final String trayStatusEnd = "</span></div>";

	final String startOfAssetTitle = "<span>";
	final String endOfAssetTitle = "</span>";

	final String startOfImageAddress = "<img class=\" responsive-img\" src=\"";
	final String endOfImageAddress = "\">";

	final String key = "data-assetid";
	final int minIdSize = 99999;

	// MAXIMUM GAP BETWEEN KEY AND ID
	final int gap = 2;

	final String[] statusList = { "inactive", "published", "editing", "inactive-draft" };

	final String[] requiredStatus = { "published", "editing" };
	final String[] requiredType = { "Custom editorial assets", "Custom editorial max(150) assets",
			"Custom editorial rail as fallback" };

	final String showPageNameBeg = "Working on Draft for ";
	final String showPageNameEnd = "<span class=\"chip\">";

	final int headers = 1;
	final String trayInitial = "";
	final String headerInitial = "";
	final String contentInitial = "";

	FileInputStream fis = null;
	FileOutputStream fos = null;

	/***************************
	 * MAIN METHOD START
	 ***************************/
	public static void main(String[] args) {

		CustomEditorials obj = new CustomEditorials();

		String jio_src = "jio_src.txt";
		String jio_res = "jio_res.txt";

		obj.fetchData(jio_src, jio_res);

		String v3_src = "v3_src.txt";
		String v3_res = "v3_res.txt";

		obj.fetchData(v3_src, v3_res);

		String ack = "Results have been saved ";
		System.out.println(ack);

	}

	/***************************
	 * MAIN METHOD END
	 ***************************/

	String getTrayName(String line) {
		String name = null;
		if (line.contains(trayTitle)) {
			int beg = line.indexOf('>', line.indexOf(trayTitle));
			int end = line.indexOf('<', beg);
			name = line.substring(beg + 1, end);
		}
		return name;
	}

	String getTrayType(String line) {
		String trayType = "";
		if (line.contains(trayTypeKey)) {
			int index = line.lastIndexOf(trayTypeLineEnd);

			while (line.charAt(--index) != '>')
				trayType = line.charAt(index) + trayType;
		}

		if (trayType.length() < 1)
			trayType = null;

		return trayType;
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
			int gapCounter = 0;
			boolean flag = false;
			while (true) {
				if (Character.isDigit(line.charAt(index))) {
					flag = true;
					assetId = assetId * 10 + Character.getNumericValue(line.charAt(index));
				} else if (flag || gapCounter > gap) {
					break;
				}
				index++;
				gapCounter++;
			}
		}
		return assetId;
	}

	String getImageAddress(String line) {
		String imageAddress = null;
		if (line.startsWith(startOfImageAddress)) {
			int beg = line.indexOf(startOfImageAddress);
			int end = line.indexOf(endOfImageAddress, beg);
			imageAddress = line.substring(beg + startOfImageAddress.length(), end);
		}
		return imageAddress;
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

	String getshowPageName(String line) {
		String showPageName = null;
		if (line.contains(showPageNameBeg)) {
			showPageName = line.substring(line.indexOf(showPageNameBeg) + showPageNameBeg.length(),
					line.indexOf(showPageNameEnd));
		}
		return showPageName;
	}

	boolean isValidId(int id) {
		if (id < minIdSize)
			return false;
		return true;
	}

	public void fetchData(String source, String destination) {
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(destination);

			Scanner scanner = new Scanner(fis);

			String line = null;
			String currentShowPage = null;

			String trayName = null;
			String trayType = null;
			String trayStatus = null;
			String curretTrayName = null;

			String assetName = null;
			String imageAddress = null;
			String showPageName = null;

			int assetId = 0;
			int counter = 0;

			boolean isValidTray = false;

			while (scanner.hasNextLine()) {
				line = scanner.nextLine().replace("&nbsp;", " ").replace("&amp;", "").replace("  ", " ").trim();

				if (trayName == null)
					trayName = getTrayName(line);

				if (trayType == null)
					trayType = getTrayType(line);

				if (trayStatus == null)
					trayStatus = getTrayStatus(line);

				if (showPageName == null) {
					showPageName = getshowPageName(line);
					if (showPageName != null) {
						currentShowPage = showPageName;
						showPageName = null;
					}
				}

				if (trayName != null && trayType != null && trayStatus != null) {
					if (Arrays.asList(requiredType).contains(trayType)
							&& Arrays.asList(requiredStatus).contains(trayStatus)) {
						counter = 0;
						isValidTray = true;
						curretTrayName = trayInitial + currentShowPage + ": " + trayName;
					} else {
						isValidTray = false;
					}

					trayName = null;
					trayType = null;
					trayStatus = null;
				}

				if (isValidTray) {

					if (assetId == 0)
						assetId = getAssetId(line);

					if (assetName == null)
						assetName = getAssetName(line);

					if (imageAddress == null)
						imageAddress = getImageAddress(line);

					if (assetId != 0 && assetName != null && imageAddress != null) {
						if (isValidId(assetId)) {
							if (counter == 0) {
								// Print Tray Name
								fos.write(("\n").getBytes());
								for (int i = 0; i < headers; i++) {
									fos.write((curretTrayName + "\t").getBytes());
								}
								fos.write(("\n" + headerInitial + "S.No.").getBytes());
								fos.write(("\t" + headerInitial + "Asset Name").getBytes());
								fos.write(("\t" + headerInitial + "Remarks").getBytes());
								fos.write(("\t" + headerInitial + "Media ID").getBytes());
								fos.write(("\t" + headerInitial + "Image URL").getBytes());
								fos.write(("\n").getBytes());
							}

							fos.write((contentInitial + ++counter).getBytes());
							fos.write(("\t" + contentInitial + assetName).getBytes());
							fos.write(("\t" + contentInitial).getBytes());
							fos.write(("\t" + contentInitial + assetId).getBytes());
							fos.write(("\t" + contentInitial + imageAddress).getBytes());
							fos.write(("\n").getBytes());
						}
						assetName = null;
						imageAddress = null;
						assetId = 0;
					}
				}

			}

			scanner.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
