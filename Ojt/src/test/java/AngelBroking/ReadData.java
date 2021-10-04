package AngelBroking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {
	static Workbook wb = null;
	static Sheet sheet = null;
	static Row ro = null;
	static Cell cell = null;
	static FileOutputStream fos = null;
	static FileInputStream fis = null;

	static int getrow(String sheetname, String Filepath) {
		try {
			FileInputStream fis = new FileInputStream(Filepath);
			wb = WorkbookFactory.create(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetname);
		int row = sheet.getLastRowNum();
		return row;

	}

	static int getcolumn(String Filepath, String name, int ro) {
		try {
			fis = new FileInputStream(Filepath);
			wb = WorkbookFactory.create(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = wb.getSheet(name);
		int column = sheet.getRow(ro).getLastCellNum();
		return column;

	}

	public static void writeDatainexcelCell(String filepath, int rownum, int column, String value, String sheetname) {
		try {
			fis = new FileInputStream(filepath);
			wb = WorkbookFactory.create(fis);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetname);
		ro = sheet.getRow(rownum);

		ro.getCell(column).setCellValue(value);

		try {
			fos = new FileOutputStream(filepath);
			wb.write(fos);
			wb.close();
			fos.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void writeDataInCell(String filePath, String sheetName, int row, int col, String value) {

		try {
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// if (wb.getSheet(sheetName) != null)
		sheet = wb.getSheet(sheetName);
		// else
		// sheet = wb.createSheet(sheetName);

		// if (sheet.getRow(row) != null)
		ro = sheet.getRow(row);
		// else
		// ro = sheet.createRow(row);

		// if (ro.getCell(col) != null)
		ro.getCell(col).setCellValue(value);
		// else
		// ro.createCell(col).setCellValue(value);

		try {
			fos = new FileOutputStream(filePath);
			wb.write(fos);
			wb.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void main(String[] args) {
		writeDataInCell("UsernameData.xlsx", "login", 5, 0, "sanket");
		System.out.println("all is well");
		int m = getrow("Sheet1", "AngelLogin.xlsx");

		String data = getDataFromCell("AngelLogin.xlsx", "Sheet1", 1, 2);
		System.out.println("for check " + data);
		System.out.println("data is  =" + data);
		int column = getcolumn("AngelLogin.xlsx", "Sheet1", m);
		System.out.println(column);

		// writeDatainexcelCell("UsernameData.xlsx", 7, 0, "Akshay", "login");
		// System.out.println("got it");

	}

	void getalldata(String filepath, String name, int rown) {
		DataFormatter df = new DataFormatter();
		try {
			fis = new FileInputStream("TestData.xlsx");
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet("login");
		int rows = sheet.getLastRowNum();// 4
		for (int i = 0; i <= rows; i++) {// 0, 1, 2 ,3
			int cols = sheet.getRow(i).getLastCellNum();
			System.out.println("no. of cols for row: " + i + " are " + cols);
			for (int j = 0; j < cols; j++) {
				Cell c = sheet.getRow(i).getCell(j);
				System.out.print(df.formatCellValue(c) + "  ");
			}
			System.out.println();
		}

	}

	public static String getDataFromCell(String filePath, String sheetName, int row, int col) {
		DataFormatter df = new DataFormatter();
		try {
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetName);
		Cell c = sheet.getRow(row).getCell(col);
		return df.formatCellValue(c);
	}
}
