package ReadExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ReadExcelDta {
	static WebDriver driver = null;
	static Workbook wb = null;
	static FileOutputStream fos = null;
	static FileInputStream fis = null;
	static Row row = null;
	static Sheet sheet = null;
	


/*	void readdata() {
		try {
			fis = new FileInputStream("UsernameData.xlsx");
			wb = WorkbookFactory.create(fis);
			sheet = wb.getSheet("login");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int row = sheet.getLastRowNum();
         for(i=0;i<=row;i++)
	}*/

	@Test
	static void ReadDta() {
		try {
			FileInputStream fis = new FileInputStream("UsernameData.xlsx");
			wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("login");
			Cell c = sheet.getRow(1).getCell(2);
			DataFormatter df = new DataFormatter();
			df.formatCellValue(c);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static public String gatefromExcel(String sheetname, int row, int col) {
		DataFormatter df = new DataFormatter();
		try {
			FileInputStream fis = new FileInputStream("UsernameData.xlsx");
			wb = WorkbookFactory.create(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetname);
		Cell c = sheet.getRow(row).getCell(col);
		return df.formatCellValue(c);
	}

	static public void writeData(String filepath, String sheetName, int row, int col, String value) {
		try {
			fis = new FileInputStream(filepath);
			wb = WorkbookFactory.create(fis);
			sheet = wb.getSheet(sheetName);
			Cell c = sheet.createRow(row).createCell(col);
			c.setCellValue(value);
			fos = new FileOutputStream(filepath);
			wb.write(fos);
			wb.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void m1() {
		writeData("UsernameData.xlsx", "login", 6, 5, "Aniket");

	}

}
