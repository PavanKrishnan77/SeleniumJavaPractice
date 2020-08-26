package Selenium;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HashMapInSelenium 
{
	public WebDriver driver;
	
	@Test
	public void hashMapInSelenium()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/index.html");
		
		String adminCredentails = loginCredentials().get("admin");
		String array[] = adminCredentails.split(":");
		
		driver.findElement(By.name("username")).sendKeys(array[0]);
		driver.findElement(By.name("password")).sendKeys(array[1]);
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginButton);
		
		String actualHomePageTitle = driver.getTitle();
		String expectedHomePageTitle = "CRMPRO";
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
		
		driver.quit();
	}
	
	public static HashMap<String, String> loginCredentials()
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("admin", "Reddy77077:Saibaba77");
		hashMap.put("user", "Pavan:Pavan");
		
		return hashMap;
	}
}
