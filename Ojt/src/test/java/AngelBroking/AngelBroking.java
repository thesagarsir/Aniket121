package AngelBroking;

import org.openqa.selenium.Alert;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AngelBroking {
	WebDriver driver = null;
int count;
	@Test

	void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thesa\\Desktop\\Chrome94\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://trade.angelbroking.com/Login");
	}
@BeforeMethod
	void writeResult(ITestResult resul) {
	if(resul.isSuccess()) {
		ReadData.writeDatainexcelCell("AngelLogin.xlsx",count, 3, "pass","Sheet1");
	}
	else {
		ReadData.writeDatainexcelCell("AngelLogin.xlsx",count, 3, "Fail","Sheet1");
		count++;
	}

	}

	@Test(dataProvider = "logingdata")
	void checkLoginCrediential(String Tcid, String Username, String Password) {
		driver.findElement(By.xpath("//input[@id='txtUserID']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys();
		driver.findElement(By.xpath("//a[@id='loginBtn']")).click();

	}

	@DataProvider
	public String[][] logingdata() {
		int row = ReadData.getrow("Sheet1", "AngelLogin.xlsx");
		int col = ReadData.getcolumn("AngelLogin.xlsx", "Sheet1", row);

		String[][] data = new String[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				String value = ReadData.getDataFromCell("AngelLogin.xlsx", "Sheet1", i, j);
				data[i - 1][j] = value;
			}

		}
		return data;

	}

}
