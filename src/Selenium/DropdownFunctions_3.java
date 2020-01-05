package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownFunctions_3 
{
	static WebDriver driver;
	
	//Select Dropdown Value without using Select Class
	@Test
	public void dropDownSelectFunction() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		driver.get("http://www.facebook.com");
		
		String day_xpath = "//select[@id='day']//option";
		String month_xpath = "//select[@id='month']//option";
		String year_xpath = "//select[@id='year']//option";
		
		selectDropDownValue(day_xpath, "10");
		selectDropDownValue(month_xpath, "May");
		selectDropDownValue(year_xpath, "1998");
	}
	
	public static void selectDropDownValue(String xpathValue, String value)
	{
		List<WebElement> monthList = driver.findElements(By.xpath(xpathValue));
		System.out.println(monthList.size());
		
		for(int i=0; i<monthList.size(); i++)
		{
			System.out.println(monthList.get(i).getText());
			if(monthList.get(i).getText().equals(value))
			{
				monthList.get(i).click();
				break;
			}
		}
	}
}
