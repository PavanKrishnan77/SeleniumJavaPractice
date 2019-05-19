package Selenium;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserWindowPopup_1 
{
	@Test
	public void browserPopup() throws AWTException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.popuptest.com/goodpopups.html");
		System.out.println("The Parent Window Name is : " +driver.getTitle());
		
		//Getting Window Handle before Clicking on Link
		String parentWindow1 = driver.getWindowHandle();
		
		//Click on Link to navigate to another window
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		
		//Getting Window Handles after Clicking on Link
		Set<String> allWindows1 = driver.getWindowHandles();
		int count = allWindows1.size();
		System.out.println(count);
		
		for(String child : allWindows1)
		{
			if(!parentWindow1.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				System.out.println("The Child Window Name is :: " +driver.getTitle());
				driver.close();
			}
		}
		driver.quit();
	}
}
