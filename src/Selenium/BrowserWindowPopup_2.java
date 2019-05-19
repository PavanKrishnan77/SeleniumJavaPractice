package Selenium;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserWindowPopup_2 
{
	@Test
	public void browserPopup() throws AWTException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.popuptest.com/goodpopups.html");
		System.out.println("The Parent Window Name is : " +driver.getTitle());
		
		//Click on Link to navigate to another window
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		
		//Getting Window Handles after Clicking on Link
		Set<String> allWindows1 = driver.getWindowHandles();
		int count = allWindows1.size();
		System.out.println(count);
		
		//Using Iterator
		Iterator<String> it = allWindows1.iterator();
		String parentWindow = it.next();
		System.out.println("The Parent Window ID is ::: " +parentWindow);
		
		String childWindow = it.next();
		System.out.println("The Child Window ID is :::: " +childWindow);
		
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		System.out.println("The Child Window is ::::::: " +driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println("The Parent Window is :::::: " +driver.getTitle());
		
		driver.quit();
	}
}
