package in.signity.onmobile.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadFromEXcel {	
	
	@SuppressWarnings("unused")
	public static ArrayList<String> readDataFromExcelRow(int sheet, int rowNo) {		
		ArrayList<String> data = new ArrayList<String>();
		int rownum = 0;
		int colnum = 0;
		final DataFormatter df = new DataFormatter();
		try {
			FileInputStream file = new FileInputStream(getFile());			
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);			
			XSSFSheet xSheet = workbook.getSheetAt(sheet);			
			Iterator<Row> rowIterator = xSheet.iterator();			
			Row r = rowIterator.next();
			int rowcount = xSheet.getLastRowNum();
			int colcount = r.getPhysicalNumberOfCells();
			if (rowNo < rowcount) {
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					if (rowNo == rownum) {
						Iterator<Cell> cellIterator = row.cellIterator();
						colnum = 0;
						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							data.add(df.formatCellValue(cell));
							colnum++;
						}
					}
					rownum++;
				}
			} else {
				//throw new SkipException("Invalid row no");
			}
			file.close();
		} catch (Exception e) {
			
		}

		return data;
	}	
	
	@SuppressWarnings("unused")
	public static ArrayList<String> readDataFromExcelColumn(String filename, String sheet, int columnNo) {		
		ArrayList<String> data = new ArrayList<String>();
		int rownum = 0;
		int colnum = 0;
		final DataFormatter df = new DataFormatter();
		try {
			FileInputStream file = new FileInputStream(getFile(filename));
			// Create Workbook instance holding reference to .xlsx file
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get workbook
			XSSFSheet xSheet = workbook.getSheet(sheet);
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = xSheet.iterator();
			// ignore the first row , it may be header
		
			Row r = rowIterator.next();
			int rowcount = xSheet.getLastRowNum();
			int colcount = r.getPhysicalNumberOfCells();
			if (columnNo <= colcount) {
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();

					Iterator<Cell> cellIterator = row.cellIterator();
					colnum = 0;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if ((columnNo - 1) == colnum) {
							data.add(df.formatCellValue(cell));							
						}
						colnum++;
					}
					rownum++;
				}
			} else {
				String test = "";
				
			}
			file.close();
		} catch (Exception e) {
			
		}

		return data;
	}

	public static Object[][] readFromExcel(int sheet) {		
		Object[][] data = null;
		int rownum = 0;
		int colnum = 0;
		final DataFormatter df = new DataFormatter();
		try {
			FileInputStream file = new FileInputStream(getFile());
			// Create Workbook instance holding reference to .xlsx file
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);			
			XSSFSheet xSheet = workbook.getSheetAt(sheet);
			Iterator<Row> rowIterator = xSheet.iterator();
			Row r = rowIterator.next();
			int rowcount = xSheet.getLastRowNum();
			int colcount = r.getPhysicalNumberOfCells();
			data = new Object[rowcount][colcount];
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				colnum = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					data[rownum][colnum] = df.formatCellValue(cell);
					colnum++;
				}
				rownum++;
			}
			file.close();
		} catch (Exception e) {
			
		}

		return data;
	}
	
	public static Object[][] readFromExcel(String sheet) {		
		Object[][] data = null;
		int rownum = 0;
		int colnum = 0;
		final DataFormatter df = new DataFormatter();
		try {
			FileInputStream file = new FileInputStream(getFile());			
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);			
			XSSFSheet xSheet = workbook.getSheet(sheet);
			Iterator<Row> rowIterator = xSheet.iterator();
			Row r = rowIterator.next();
			int rowcount = xSheet.getLastRowNum();
			int colcount = r.getPhysicalNumberOfCells();
			data = new Object[rowcount][colcount];
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				colnum = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					data[rownum][colnum] = df.formatCellValue(cell);
					colnum++;
				}
				rownum++;
			}
			file.close();
		} catch (Exception e) {
			
		}

		return data;
	}
	
	public static Object[][] readFromExcel(String fileName, String sheet) {		
		Object[][] data = null;
		int rownum = 0;
		int colnum = 0;
		final DataFormatter df = new DataFormatter();
		try {
			FileInputStream file = new FileInputStream(getFile(fileName));			
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);			
			XSSFSheet xSheet = workbook.getSheet(sheet);
			Iterator<Row> rowIterator = xSheet.iterator();
			Row r = rowIterator.next();
			int rowcount = xSheet.getLastRowNum();
			int colcount = r.getPhysicalNumberOfCells();
			data = new Object[rowcount][colcount];
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				colnum = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					data[rownum][colnum] = df.formatCellValue(cell);
					colnum++;
				}
				rownum++;
			}
			file.close();
		} catch (Exception e) {
			
		}

		return data;
	}

	private static File getFile() throws FileNotFoundException {
		String filepath = "";
		File here = new File(filepath);
		return new File(here.getAbsolutePath());

	}
	
	private static File getFile(String fileName) throws FileNotFoundException {
		String filepath = ".\\testData\\"+fileName+".xlsx";
		File here = new File(filepath);
		return new File(here.getAbsolutePath());

	}
	
//	private static File getFile(String filepath ) throws FileNotFoundException {
//		
//		File here = new File(filepath);
//		return new File(here.getAbsolutePath());
//
//	}		
	
	@SuppressWarnings("unused")
	public static ArrayList<String> readRunTimeDataFromExcelRow(String filename,String sheet, int rowNo) {		
		ArrayList<String> data = new ArrayList<String>();
		int rownum = 0;
		int colnum = 0;
		final DataFormatter df = new DataFormatter();
		try {
			FileInputStream file = new FileInputStream(filename);			
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);			
			XSSFSheet xSheet = workbook.getSheet(sheet);			
			Iterator<Row> rowIterator = xSheet.iterator();			
			Row r = rowIterator.next();
			int rowcount = xSheet.getLastRowNum();
			int colcount = r.getPhysicalNumberOfCells();
			if (rowNo < rowcount) {
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					if (rowNo == rownum) {
						Iterator<Cell> cellIterator = row.cellIterator();
						colnum = 0;
						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							data.add(df.formatCellValue(cell));
							colnum++;
						}
					}
					rownum++;
				}
			} else {
				//throw new SkipException("Invalid row no");
			}
			file.close();
		} catch (Exception e) {
			
		}

		return data;
	}	
}
