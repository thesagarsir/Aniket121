package ReadExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WriteDataFromBrowser {
	WebDriver driver = null;

	@BeforeMethod
	void writeinExcel() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thesa\\Desktop\\chrone 92\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Selaneuim/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/button")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	void m1() throws Exception {
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='table table-hover']"));
		for (WebElement web : ele) {
			String sb = web.getText();
			System.out.println("This is tha data  =  " + sb);}

		/*	FileInputStream fis = new FileInputStream("websitedata.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			FileOutputStream fos = new FileOutputStream(
					"websitedata.xlsx");
			Sheet sheet = wb.createSheet("Sheet1");
			Cell cell = sheet.createRow(100).createCell(200);
			cell.setCellValue(sb);
			wb.write(fos);
*/
		}

	
	}


