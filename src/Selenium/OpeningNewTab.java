package Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpeningNewTab
{
	@Test
	public void openingNewTab() throws AWTException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		
		//Below Code is to Open New Tab using Robot Class
		for(int i=0; i<=1; i++)
		{
			Robot robot = new Robot();
		
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_T);
		
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
			//Switch to New Tab
			driver.switchTo().window((String) tabs.get(i));
		}
		driver.get("http://www.facebook.com");
	}
}
