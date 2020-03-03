package Selenium;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DisableChromeNotification 
{
	//Program to Disable Chrome is being Controlled by Automated Test Software.
	@Test
	public void disableChromeNotification() 
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com");
		
		driver.quit();
	}
}	
