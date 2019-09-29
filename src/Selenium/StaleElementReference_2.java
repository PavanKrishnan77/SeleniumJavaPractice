package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaleElementReference_2 
{
	WebDriver driver;
	
	@Test(priority=1)
	public void staleElementReference() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("http://www.pavantestingtools.com/");
		
		driver.findElement(By.xpath("//button[@id='close']")).click();
		
		WebElement link = driver.findElement(By.xpath("//ul[@class='menupbt nav-menu']//a[contains(text(), 'Training')]"));
		
		Thread.sleep(3000);
		
		link.click();
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//button[@id='close']")).click();
		
		Thread.sleep(3000);
		
		//Below Line of Code will throw StaleElementReferenceException.
		//So Put it in Try Block and Again Inspect that Element in Catch Block and Perform Action.
		//link.click();
		
		try
		{
			link.click();
		}
		catch (StaleElementReferenceException e) 
		{
			link = driver.findElement(By.xpath("//ul[@class='menupbt nav-menu']//a[contains(text(), 'Training')]"));
			link.click();
		}
	}
}
