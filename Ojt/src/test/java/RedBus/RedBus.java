package RedBus;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RedBus {

	static WebDriver driver = null;

	@Test

	void initilization() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thesa\\Desktop\\chrone 92\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		WebElement profile = driver.findElement(By.id("i-icon-profile"));
		profile.click();
		String Parent_Windoe = driver.getWindowHandle();
		System.out.println("parent" + Parent_Windoe);
		WebElement signin = driver.findElement(By.id("signInLink"));
		Actions action = new Actions(driver);
		action.moveToElement(signin);
		signin.click();
		System.out.println("Check");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modalIframe']")));
		Thread.sleep(3000);
		driver.findElement(By.id("newFbId")).click();
		Set<String> child = driver.getWindowHandles();
		for (String win : child) {
			System.out.println("all child" + win);
			if (!win.equals(Parent_Windoe)) {
				driver.switchTo().window(win);
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1234");
				driver.findElement(By.id("pass")).sendKeys("12345");

			}
		}

	}

}
