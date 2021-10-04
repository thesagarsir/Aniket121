package ReadExcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JbkWebste {
	WebDriver driver = null;

	@BeforeMethod
	void launchurl() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thesa\\Desktop\\chrone 92\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Selaneuim/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	void verifyByusingCorrectCrediential() {
		By email = By.id("email");
		By pass = By.id("password");
		WebElement emal = driver.findElement(email);
		emal.sendKeys(ReadExcelDta.gatefromExcel("login", 1, 1));
		WebElement pas = driver.findElement(pass);
		pas.sendKeys(ReadExcelDta.gatefromExcel("login", 1, 2));
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		String actual = driver.getTitle();
		System.out.println(actual);
		if (actual.equals("JavaByKiran | Dashboard")) {
			Assert.assertEquals(actual, "JavaByKiran | Dashboard");
		} else {
			ReadExcelDta.writeData("UsernameData.xlsx", "login", 1, 3, "Pass");
		}
	}
@Test
	void verifyByusingWrongCrediential() {
		By email = By.id("email");
		By pass = By.id("password");
		WebElement emal = driver.findElement(email);
		emal.sendKeys(ReadExcelDta.gatefromExcel("login", 2, 1));
		WebElement pas = driver.findElement(pass);
		pas.sendKeys(ReadExcelDta.gatefromExcel("login", 2, 2));
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		String actual = driver.getTitle();
		System.out.println(actual);
		if (actual.equals("JavaByKiran | Dashboard")) {
			Assert.assertEquals(actual, "JavaByKiran | Dashboard");
		} else {
			ReadExcelDta.writeData("UsernameData.xlsx", "login", 2,3,"Fail");
		}
	}
@Test
	void verifyByusingInvalidCrediential() {
		By email = By.id("email");
		By pass = By.id("password");
		WebElement emal = driver.findElement(email);
		emal.sendKeys(ReadExcelDta.gatefromExcel("login", 3, 1));
		WebElement pas = driver.findElement(pass);
		pas.sendKeys(ReadExcelDta.gatefromExcel("login", 3, 2));
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		String actual = driver.getTitle();
		System.out.println(actual);
		if (actual.equals("JavaByKiran | Dashboard")) {
			Assert.assertEquals(actual, "JavaByKiran | Dashboard");
		} else {
			ReadExcelDta.writeData("UsernameData.xlsx", "login", 3, 3, "Fail");
		}
	}
@AfterMethod
void closeBrowser() {
	driver.close();
	
	
}
}