package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_2 
{
	@Test(dataProvider="getData")
	public void dataProviderTest(String userName, String password) 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com/index.html");

		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);

		WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginButton);

		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() 
	{
		Object[][] data = new Object[2][2];

		data[0][0] = "Reddy77077";
		data[0][1] = "Saibaba77";

		data[1][0] = "Reddy77077";
		data[1][1] = "Saibaba77";

		return data;
	}
}
