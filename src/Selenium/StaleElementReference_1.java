package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaleElementReference_1 
{
	WebDriver driver;
	
	@Test(priority=1)
	public void staleElementReference()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("PavanReddy");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Test@123");
		
		driver.navigate().refresh();
		
		//Below Line of Code will throw StaleElementReferenceException.
		//So Put it in Try Block and Again Inspect that Element in Catch Block and Perform Action.
		//userName.sendKeys("PavanReddy");
		
		try
		{
			userName.sendKeys("PavanReddy");
		}
		catch(StaleElementReferenceException e) 
		{
			userName = driver.findElement(By.name("username"));
			userName.sendKeys("PavanReddy");
		}
	}
}
