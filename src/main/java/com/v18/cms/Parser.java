package com.v18.cms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Parser {

	final private static String trayTitle = "Tray title";

	final private static String trayTypeKey = "data-text=\"Description\"";
	final private static String trayTypeLineEnd = "</div>";

	final private static String trayStatusBeg = "<span";
	final private static String trayStatusEnd = "</span></div>";

	final private static String startOfAssetTitle = "<span>";
	final private static String endOfAssetTitle = "</span>";

	final private static String startOfImageAddress = "<img class=\" responsive-img\" src=\"";
	final private static String endOfImageAddress = "\">";

	final private static String key = "data-assetid";
	final private static int minIdSize = 99999;

	// MAXIMUM GAP BETWEEN KEY AND ID
	final private static int gap = 2;

	final private static String[] statusList = { "inactive", "published", "editing", "inactive-draft" };

	final private static String[] requiredStatus = { "published", "editing" };
	final private static String[] requiredType = { "Custom editorial assets", "Custom editorial max(150) assets",
			"Custom editorial rail as fallback" };

	final private static String showPageNameBeg = "Working on Draft for ";
	final private static String showPageNameEnd = "<span class=\"chip\">";

	final private static String queryKey = "data-filter=\"query\"";
	final private static String queryValue = "value=";

	private static int counter = 0;

	public static int fetchMediaIds(String fileName, String sheetName, String outputFile) {
		int rowCount = 0;
		int columnCount = 0;
		try {

			File file = new File(outputFile);

			FileInputStream myWB = null;
			XSSFWorkbook workbook = null;

			if (file.exists()) {
				myWB = new FileInputStream(file);
				workbook = new XSSFWorkbook(myWB);
			} else {
				workbook = new XSSFWorkbook();

			}

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				sheet = workbook.createSheet(sheetName);
			} else {
				workbook.removeSheetAt(workbook.getSheetIndex(sheetName));
				sheet = workbook.createSheet(sheetName);
			}
			try (FileInputStream fis = new FileInputStream(fileName); Scanner scanner = new Scanner(fis)) {

				String line = null;
				String currentShowPage = null;

				String trayName = null;
				String trayType = null;
				String trayStatus = null;
				String curretTrayName = null;

				String assetName = null;
				String imageAddress = null;
				String showPageName = null;
				String remark = "";

				int assetId = 0;
				int counter = 0;

				boolean isValidTray = false;

				Row row = null;
				Cell cell = null;

				while (scanner.hasNextLine()) {

					line = scanner.nextLine().replace("&nbsp;", " ").replace("&amp;", "").replace("  ", " ").trim();

					if (trayName == null) {
						trayName = getTrayName(line);
					}

					if (trayType == null) {
						trayType = getTrayType(line);
					}

					if (trayStatus == null) {
						trayStatus = getTrayStatus(line);
					}

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
							curretTrayName = currentShowPage + ": " + trayName;
						} else {
							isValidTray = false;
						}

						trayName = null;
						trayType = null;
						trayStatus = null;
					}

					if (isValidTray) {

						if (assetId == 0) {
							assetId = getAssetId(line);
						}

						if (assetName == null) {
							assetName = getAssetName(line);
						}

						if (imageAddress == null) {
							imageAddress = getImageAddress(line);
						}

						if (assetId != 0 && assetName != null && imageAddress != null) {
							if (isValidId(assetId)) {
								if (counter == 0) {
									// Print Tray Name
									row = sheet.createRow(++rowCount);
									columnCount = 0;

									cell = row.createCell(columnCount++);
									cell.setCellValue(curretTrayName);

									row = sheet.createRow(++rowCount);
									columnCount = 0;

									cell = row.createCell(columnCount++);
									cell.setCellValue("S.No.");

									cell = row.createCell(columnCount++);
									cell.setCellValue("Asset Name");

									cell = row.createCell(columnCount++);
									cell.setCellValue("Remarks");

									cell = row.createCell(columnCount++);
									cell.setCellValue("Media ID");

									cell = row.createCell(columnCount++);
									cell.setCellValue("Image URL");

									row = sheet.createRow(++rowCount);
									columnCount = 0;
								}

								cell = row.createCell(columnCount++);
								cell.setCellValue(++counter);

								cell = row.createCell(columnCount++);
								cell.setCellValue(assetName);

								// Remark Cell
								cell = row.createCell(columnCount++);
								cell.setCellValue(remark);
								cell = row.createCell(columnCount++);
								cell.setCellValue(assetId);

								cell = row.createCell(columnCount++);
								cell.setCellValue(imageAddress);

								row = sheet.createRow(++rowCount);
								columnCount = 0;
							}
							assetName = null;
							imageAddress = null;
							assetId = 0;
						}
					}

				}

				fis.close();

				try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
					workbook.write(outputStream);
				}
			}

		} catch (IOException e) {
			System.out.println(e);
		}
		return rowCount;
	}

	public static void fetchTrayDetails(String fileName, String sheetName, String outputFile) {

		try {

			File file = new File(outputFile);

			FileInputStream myWB = null;
			XSSFWorkbook workbook = null;

			if (file.exists()) {
				myWB = new FileInputStream(file);
				workbook = new XSSFWorkbook(myWB);
			} else {
				workbook = new XSSFWorkbook();

			}

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				sheet = workbook.createSheet(sheetName);
			} else {
				workbook.removeSheetAt(workbook.getSheetIndex(sheetName));
				sheet = workbook.createSheet(sheetName);
			}

			try (FileInputStream fis = new FileInputStream(fileName); Scanner scanner = new Scanner(fis)) {

				int columnCount = 0;
				int rowCount = 0;
				Row row = sheet.createRow(rowCount++);
				Cell cell = null;
				String showPageName = null;
				String currentShowPage = null;
				boolean isQueryAvailable = false;

				while (scanner.hasNextLine()) {
					String line = scanner.nextLine().replace("&nbsp;", " ").replace("&amp;", "").replace("  ", " ")
							.trim();

					String trayName = getTrayName(line);
					String query = getQuery(line);
					String trayType = getTrayType(line);
					String trayStatus = getTrayStatus(line);

					if (showPageName == null) {
						showPageName = getshowPageName(line);
						if (showPageName != null) {
							currentShowPage = showPageName;
							showPageName = null;
						}
					}

					if (trayName != null) {
						if (rowCount != 1) {
							if (!isQueryAvailable) {
								cell = row.createCell(columnCount++);
							}
							isQueryAvailable = false;
							cell = row.createCell(columnCount++);
							cell.setCellValue(counter);
							counter = 0;

						}
						row = sheet.createRow(rowCount++);
						columnCount = 0;
						cell = row.createCell(columnCount++);
						cell.setCellValue(currentShowPage + ": " + trayName);
					}

					if (query != null) {
						isQueryAvailable = true;
						cell = row.createCell(columnCount++);
						cell.setCellValue(query);
					}

					if (trayType != null) {
						cell = row.createCell(columnCount++);
						cell.setCellValue(trayType);
					}
					if (trayStatus != null) {
						cell = row.createCell(columnCount++);
						cell.setCellValue(trayStatus);
					}

					updateCount(line);
				}

				// Last tray assets count
				cell = row.createCell(columnCount++);
				if (!isQueryAvailable) {
					cell = row.createCell(columnCount++);
				}
				cell.setCellValue(counter);
			}
			try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
				workbook.write(outputStream);
			}
		} catch (IOException e) {
		}
	}

	private static String getTrayName(String line) {
		String name = null;
		if (line.contains(trayTitle)) {
			int beg = line.indexOf('>', line.indexOf(trayTitle));
			int end = line.indexOf('<', beg);
			name = line.substring(beg + 1, end);
		}
		return name;
	}

	private static String getTrayType(String line) {
		String trayType = "";
		if (line.contains(trayTypeKey)) {
			int index = line.lastIndexOf(trayTypeLineEnd);

			while (line.charAt(--index) != '>') {
				trayType = line.charAt(index) + trayType;
			}
		}

		if (trayType.length() < 1) {
			trayType = null;
		}

		return trayType;
	}

	private static String getAssetName(String line) {
		String assetTitle = null;
		if (line.startsWith(startOfAssetTitle)) {
			int beg = line.indexOf(startOfAssetTitle);
			int end = line.indexOf(endOfAssetTitle, beg);
			assetTitle = line.substring(beg + startOfAssetTitle.length(), end);
		}
		return assetTitle;
	}

	static int getAssetId(String line) {
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

	private static String getImageAddress(String line) {
		String imageAddress = null;
		if (line.startsWith(startOfImageAddress)) {
			int beg = line.indexOf(startOfImageAddress);
			int end = line.indexOf(endOfImageAddress, beg);
			imageAddress = line.substring(beg + startOfImageAddress.length(), end);
		}
		return imageAddress;
	}

	private static String getTrayStatus(String line) {
		String trayStatus = "";
		if (line.contains(trayStatusBeg) && line.contains(trayStatusEnd)) {
			int index = line.lastIndexOf(trayStatusEnd);

			while (line.charAt(--index) != '>') {
				trayStatus = line.charAt(index) + trayStatus;
			}
		}

		if (Arrays.asList(statusList).contains(trayStatus)) {
			return trayStatus;
		}
		return null;
	}

	private static String getshowPageName(String line) {
		String showPageName = null;
		if (line.contains(showPageNameBeg)) {
			showPageName = line.substring(line.indexOf(showPageNameBeg) + showPageNameBeg.length(),
					line.indexOf(showPageNameEnd));
		}
		return showPageName;
	}

	private static boolean isValidId(int id) {
		if (id < minIdSize) {
			return false;
		}
		return true;
	}

	private static String getQuery(String line) {
		String query = "";
		if (line.contains(queryKey)) {
			int index = line.indexOf(queryValue) + queryValue.length() + gap;
			while (line.charAt(index) != '"') {
				query = query + line.charAt(index++);
			}
		}
		if (query.length() < 1) {
			query = null;
		}
		return query;
	}

	private static void updateCount(String line) {

		if (line.contains(key)) {
			counter++;
		}

	}

	public static void addTestSheet(String sheetName, String outputFile, int rows)
			throws FileNotFoundException, IOException {
		File file = new File(outputFile);

		FileInputStream myWB = null;
		XSSFWorkbook workbook = null;

		if (file.exists()) {
			myWB = new FileInputStream(file);
			workbook = new XSSFWorkbook(myWB);
		} else {
			workbook = new XSSFWorkbook();

		}

		XSSFSheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			sheet = workbook.createSheet(sheetName);
		} else {
			workbook.removeSheetAt(workbook.getSheetIndex(sheetName));
			sheet = workbook.createSheet(sheetName);
		}

		Cell cell = null;
		XSSFFormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

		for (int rowCount = 0; rowCount <= rows; rowCount++) {
			Row row = sheet.createRow(rowCount );
			if (rowCount  == 0) {
				cell = row.createCell(12);
				cell.setCellValue("Tray");

				cell = row.createCell(13);
				cell.setCellValue("Media ID");

				cell = row.createCell(14);
				cell.setCellValue("Image URL");

				continue;
			}
			char columnName = 'A';
			String formula = null;
			for (int columnCount = 0; columnCount <= 14; columnCount++, columnName++) {
				cell = row.createCell(columnCount);
				if (columnCount <= 4) {

					formula = "IF(0=" + workbook.getSheetAt(0).getSheetName() + "!" + columnName + (rowCount) + ",\"\","
							+ workbook.getSheetAt(0).getSheetName() + "!" + columnName + (rowCount) + ")";

				} else if (columnCount == 5 || columnCount == 11) {
					formula = "CONCATENATE(\"\",\"\")";
					
					// Reset Column value before A
					columnName = 64;
				} else if (columnCount <= 10) {
					workbook.getSheetAt(0);
					formula = "IF(0=" + workbook.getSheetAt(1).getSheetName() + "!" + columnName + (rowCount) + ",\"\","
							+ workbook.getSheetAt(1).getSheetName() + "!" + columnName + (rowCount) + ")";

				} else if (columnCount == 12) {
					formula = "IF(A" + rowCount + "=G" + rowCount + ",\"\",\"False\")";

				} else if (columnCount == 13) {
					formula = "IF(D" + rowCount + "=J" + rowCount + ",\"\",\"False\")";

				} else if (columnCount == 14) {
					formula = "IF(E" + rowCount + "=K" + rowCount + ",\"\",\"False\")";

				}
				cell.setCellFormula(formula);
				formulaEvaluator.evaluateFormulaCell(cell);
			}

		}
		try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
			workbook.write(outputStream);
		}
	}

	public static void main(String[] args) throws IOException {

		String jio_src = "D:\\Lalit\\V18\\cms.txt";

		String result = "Result.xlsx";

		int x = fetchMediaIds(jio_src, "JIO", result);

		System.out.println("Done");

	}
}
