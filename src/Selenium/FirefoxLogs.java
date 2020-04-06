package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxLogs 
{
	@Test
	public void firefoxLogs() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
		//Below Statement to be added to Generate Firefox Logs.
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./FirefoxLog.txt");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("Reddy77077");
		driver.findElement(By.name("password")).sendKeys("Saibaba77");
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginButton);
		
		driver.quit();
	}
}
