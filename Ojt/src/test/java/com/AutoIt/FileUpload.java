
package com.AutoIt;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
	WebDriver driver = null;
 	
	
	@Test
	void test_1() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\thesa\\Desktop\\AutoItChrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://javabykiran.com/playground/");
		driver.findElement(By.linkText("File Upload")).click();
		driver.findElement(By.xpath("//input[@id='file']")).click();
		Runtime.getRuntime().exec("D:\\AutoitScript\\autoitscript(27-09-2021)");
	}	
	
	
}












































































