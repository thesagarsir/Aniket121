package MoneyControl;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MoneyControl {
	@Test
	void Test_1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.moneycontrol.com/stocks/marketstats/indexcomp.php?optex=NSE&opttopic=indexcomp&index=9");

		HashedMap<String, String> nifty = new HashedMap<String, String>();
		nifty.put("SBI", MyConstant.SBI);
		nifty.put("Axis", MyConstant.Axis);
		nifty.put("Reliance", MyConstant.Reliance);
		nifty.put("TCS", MyConstant.TCS);
		nifty.put("ITC", MyConstant.ITC);
		for (String key : nifty.keySet()) {

			String xPath = nifty.get(key);
			String perOfChange = driver.findElement(By.xpath(xPath)).getText();
			ArrayList<String> al = new ArrayList<String>();
			al.add(perOfChange);

			Collections.sort(al);
			System.out.println(key + "   " + al);
		}

	}
}
