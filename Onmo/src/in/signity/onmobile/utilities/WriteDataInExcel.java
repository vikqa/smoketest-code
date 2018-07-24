package in.signity.onmobile.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataInExcel {

	@SuppressWarnings("resource")
	public static void writeSettingsData(String sheet, String website, String email, String country, String pop,
			String endpoint, String profile, String cn, String cnu, String so, String dec, String com, String path) {
		String filepath = ".\\testData\\runTimeData.xlsx";
		try {
			FileInputStream file = new FileInputStream(new File(filepath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet Ssheet = workbook.getSheet(sheet);
			XSSFSheet spreadsheet = null;
			if (Ssheet != null) {
				int index = workbook.getSheetIndex(sheet);
				workbook.removeSheetAt(index);

			}
			
			spreadsheet = workbook.createSheet(sheet);
			XSSFRow row;
			Map<String, Object[]> info = new TreeMap<String, Object[]>();
			info.put("1", new Object[] { "website", "email", "country", "pop", "endpoint", "Profile", "ContactName",
					"ContactNumber", "ServiceOffered", "Description", "Company Name", "Image Path" });
			info.put("2",
					new Object[] { website, email, country, pop, endpoint, profile, cn, cnu, so, dec, com, path });
			int rowid = 0;
			Set<String> keyid = info.keySet();
			for (String key : keyid) {
				row = spreadsheet.createRow(rowid++);
				Object[] objectArr = info.get(key);
				int cellid = 0;
				for (Object obj : objectArr) {
					Cell cell = row.createCell(cellid++);
					cell.setCellValue((String) obj);
				}
			}
			FileOutputStream out = new FileOutputStream(new File(filepath));
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("resource")
	public static void writeEP(String sheet, String Region, String VLAN, String Bandwidth, String loc) {
		String filepath = ".\\testData\\runTimeData.xlsx";
		try {
			FileInputStream file = new FileInputStream(new File(filepath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet Ssheet = workbook.getSheet(sheet);
			XSSFSheet spreadsheet = null;
			if (Ssheet != null) {
				int index = workbook.getSheetIndex(sheet);
				workbook.removeSheetAt(index);

			}
			spreadsheet = workbook.createSheet(sheet);
			XSSFRow row;
			Map<String, Object[]> info = new TreeMap<String, Object[]>();
			info.put("1", new Object[] { "Region", "VLAN", "Bandwidth", "Location" });
			info.put("2", new Object[] { Region, VLAN, Bandwidth, loc });
			int rowid = 0;
			Set<String> keyid = info.keySet();
			for (String key : keyid) {
				row = spreadsheet.createRow(rowid++);
				Object[] objectArr = info.get(key);
				int cellid = 0;
				for (Object obj : objectArr) {
					Cell cell = row.createCell(cellid++);
					cell.setCellValue((String) obj);
				}
			}
			FileOutputStream out = new FileOutputStream(new File(filepath));
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@SuppressWarnings("resource")
	public static void writeApprovedEP(String sheet, String Region, String VLAN, String Bandwidth, String loc, String pe) {
		String filepath = ".\\testData\\runTimeData.xlsx";
		try {
			FileInputStream file = new FileInputStream(new File(filepath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet Ssheet = workbook.getSheet(sheet);
			XSSFSheet spreadsheet = null;
			if (Ssheet != null) {
				int index = workbook.getSheetIndex(sheet);
				workbook.removeSheetAt(index);

			}
			spreadsheet = workbook.createSheet(sheet);
			XSSFRow row;
			Map<String, Object[]> info = new TreeMap<String, Object[]>();
			info.put("1", new Object[] { "Region", "VLAN", "Bandwidth", "Location", "Provider Endpoint" });
			info.put("2", new Object[] { Region, VLAN, Bandwidth, loc, pe });
			int rowid = 0;
			Set<String> keyid = info.keySet();
			for (String key : keyid) {
				row = spreadsheet.createRow(rowid++);
				Object[] objectArr = info.get(key);
				int cellid = 0;
				for (Object obj : objectArr) {
					Cell cell = row.createCell(cellid++);
					cell.setCellValue((String) obj);
				}
			}
			FileOutputStream out = new FileOutputStream(new File(filepath));
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//	@SuppressWarnings("resource")
//	public static void writeEPAtParticularCell(String sheet, String header, String value, int col) {
//		String filepath = ".\\testData\\runTimeData.xlsx";
//		try {
//			FileInputStream file = new FileInputStream(new File(filepath));
//			XSSFWorkbook workbook = new XSSFWorkbook(file);
//			XSSFSheet Ssheet = workbook.getSheet(sheet);
////			XSSFSheet spreadsheet = null;
////			if (Ssheet != null) {
////				int index = workbook.getSheetIndex(sheet);
////				workbook.removeSheetAt(index);
////
////			}
////			spreadsheet = workbook.createSheet(sheet);
//			XSSFRow row;
//			Map<String, Object[]> info = new TreeMap<String, Object[]>();
//			info.put("1", new Object[] { header });
//			info.put("2", new Object[] { value });
//			int rowid = 0;
//			Set<String> keyid = info.keySet();
//			for (String key : keyid) {
//				row = Ssheet.createRow(rowid++);
//				Object[] objectArr = info.get(key);
//				int cellid = col;
//				for (Object obj : objectArr) {
//					Cell cell = row.createCell(cellid++);
//					cell.setCellValue((String) obj);
//				}
//			}
//			FileOutputStream out = new FileOutputStream(new File(filepath));
//			workbook.write(out);
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}

	@SuppressWarnings("resource")
	public static void writeAllImages(String sheet, Map<String, Object[]> info) {
		{
			String filepath = ".\\testData\\runTimeImagesData.xlsx";
			try {
				FileInputStream file = new FileInputStream(new File(filepath));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet Ssheet = workbook.getSheet(sheet);
				XSSFSheet spreadsheet = null;
				if (Ssheet != null) {
					int index = workbook.getSheetIndex(sheet);
					workbook.removeSheetAt(index);

				}
				spreadsheet = workbook.createSheet(sheet);
				XSSFRow row;
				int rowid = 0;
				Set<String> keyid = info.keySet();
				for (String key : keyid) {
					row = spreadsheet.createRow(rowid++);
					Object[] objectArr = info.get(key);
					int cellid = 0;
					for (Object obj : objectArr) {
						Cell cell = row.createCell(cellid++);
						cell.setCellValue((String) obj);
					}
				}
				FileOutputStream out = new FileOutputStream(new File(filepath));
				workbook.write(out);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("resource")
	public static void writeAllEndPoints(String sheet, Map<String, Object[]> info) {
		{
			String filepath = ".\\testData\\runTimeEndPoints.xlsx";
			try {
				FileInputStream file = new FileInputStream(new File(filepath));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet Ssheet = workbook.getSheet(sheet);
				XSSFSheet spreadsheet = null;
				if (Ssheet != null) {
					int index = workbook.getSheetIndex(sheet);
					workbook.removeSheetAt(index);

				}
				spreadsheet = workbook.createSheet(sheet);
				XSSFRow row;
				int rowid = 0;
				Set<String> keyid = info.keySet();
				for (String key : keyid) {
					row = spreadsheet.createRow(rowid++);
					Object[] objectArr = info.get(key);
					int cellid = 0;
					for (Object obj : objectArr) {
						Cell cell = row.createCell(cellid++);
						cell.setCellValue((String) obj);
					}
				}
				FileOutputStream out = new FileOutputStream(new File(filepath));
				workbook.write(out);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("resource")
	public static void writeAllEndPointsForSorting(String sheet, Map<Date, Object[]> info) {
		{
			String filepath = ".\\testData\\runTimeEndPoints.xlsx";
			try {
				FileInputStream file = new FileInputStream(new File(filepath));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet Ssheet = workbook.getSheet(sheet);
				XSSFSheet spreadsheet = null;
				if (Ssheet != null) {
					int index = workbook.getSheetIndex(sheet);
					workbook.removeSheetAt(index);

				}
				spreadsheet = workbook.createSheet(sheet);
				XSSFRow row;
				int rowid = 0;
				Set<Date> keyid = info.keySet();
				for (Date key : keyid) {
					row = spreadsheet.createRow(rowid++);
					Object[] objectArr = info.get(key);
					int cellid = 0;
					for (Object obj : objectArr) {
						Cell cell = row.createCell(cellid++);
						cell.setCellValue((String) obj);
					}
				}
				FileOutputStream out = new FileOutputStream(new File(filepath));
				workbook.write(out);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("resource")
	public static void writeAllEndPointsForFilter(String sheet, Map<Date, Object[]> info) {
		{
			String filepath = ".\\testData\\runTimeEndPoints.xlsx";
			try {
				FileInputStream file = new FileInputStream(new File(filepath));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet Ssheet = workbook.getSheet(sheet);
				XSSFSheet spreadsheet = null;
				if (Ssheet != null) {
					int index = workbook.getSheetIndex(sheet);
					workbook.removeSheetAt(index);

				}
				spreadsheet = workbook.createSheet(sheet);
				XSSFRow row;
				int rowid = 0;
				Set<Date> keyid = info.keySet();
				for (Date key : keyid) {
					row = spreadsheet.createRow(rowid++);
					Object[] objectArr = info.get(key);
					int cellid = 0;
					for (Object obj : objectArr) {
						Cell cell = row.createCell(cellid++);
						cell.setCellValue((String) obj);
					}
				}
				FileOutputStream out = new FileOutputStream(new File(filepath));
				workbook.write(out);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
