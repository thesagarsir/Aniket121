package com.naukari;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Naukari {
	WebDriver driver = null;
	Logger log = Logger.getLogger(Naukari.class);

	@BeforeMethod
	void test_1() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thesa\\Desktop\\Chrome94\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");

	}

	@Test
	void test_2() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		log.info("Toal no of Window = " + child);
	//	System.out.println("Toal no of Window = " + child);
		for (String win : child) {
			log.info(win);
			if (!win.equals(parent)) {
				driver.switchTo().window(win);
				driver.close();
				log.info("All is well");

			}

		}
	}

	@Test
	void jobs() {
		driver.findElement(By.xpath("//li[@class='mActive']")).click();
		System.out.println("check");

	}

}
