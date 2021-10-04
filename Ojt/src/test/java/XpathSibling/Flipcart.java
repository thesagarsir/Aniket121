package XpathSibling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipcart {
	WebDriver driver=null;
	
	@Test
	void test_1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thesa\\Desktop\\Chrome94\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("window close");
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='✕']")).click();
		driver.findElement(By.xpath("//img[@alt='Fashion']")).click();

	}
}
