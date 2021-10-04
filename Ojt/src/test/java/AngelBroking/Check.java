package AngelBroking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Check {

	WebDriver driver = null;

	@Test
	void Test_1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thesa\\Desktop\\chrone 92\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");

	}
}
