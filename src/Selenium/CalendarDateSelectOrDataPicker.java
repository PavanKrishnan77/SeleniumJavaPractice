package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDateSelectOrDataPicker 
{
	//Selecting Calendar Date Using JavaScriptExecutor
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.makemytrip.com");
		
		WebElement date = driver.findElement(By.xpath("//div[contains(@class,'fsw_inputBox dates inactiveWidget')]//label"));
		String dateValue = "27-07-2019";
		
		selectDateByJS(driver, date, dateValue);	
	}
		
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateValue)
	{
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateValue+"');", element);	
	}	
}
