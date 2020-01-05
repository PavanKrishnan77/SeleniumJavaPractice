package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SuppressFirefoxLogs 
{
	@Test
	public void suppressFirefoxLogs() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
		//#######################################################//
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		//#######################################################//
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	}
}
