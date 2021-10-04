package ReadExcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {
	public static void main(String []args) {
	System.setProperty("webdriver.chrome.driver" ,"C:\\\\Users\\\\thesa\\\\Desktop\\\\chrone 92\\\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//input[@placeholder='From']")).click();
	driver.findElement(By.xpath("//p[text()='Delhi, India']")).click();

}}
