package SeleneumListner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

public class SeleneuimListner implements ITestListener {
	Logger log = Logger.getLogger(SeleneuimListner.class);

	public void onTestStart(ITestResult result) {

		log.info("I am on Start");
	}

	public void onTestSuccess(ITestResult result) {
		log.info("I am onTestSuccess");
		
	}

	public void onTestFailure(ITestResult result) {
		log.info("I am onTestFailure");

	}

	public void onTestSkipped(ITestResult result) {
		log.info("I am onTestSkipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("I am onTestSkipped");

	}

	public void onStart(ITestContext context) {
		log.info("I am onTestSkipped");

	}

	public void onFinish(ITestContext context) {
		log.info("I am onFinish(ITest");
	}

}
