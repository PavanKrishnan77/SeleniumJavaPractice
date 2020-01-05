package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownFunctions_2 
{
	@Test
	public void dropDownSelectFunction() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		driver.get("http://www.facebook.com");
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

		Select select = new Select(day);
		
		select.selectByIndex(10);
		
		//To Check Dropdown is Multi-Selected or No
		System.out.println(select.isMultiple());
		
		//To Print Size of Dropdown
		List<WebElement> listDays = select.getOptions();
		System.out.println(listDays.size()-1);
		int TotalDays = listDays.size()-1;
		System.out.println("Total Days are: "+ TotalDays);
		
		//To Print all Values from Dropdown
		for(int i=0; i<listDays.size(); i++)
		{
			String dayValues = listDays.get(i).getText();
			System.out.println(dayValues);
			if(dayValues.equals("15"))
			{
				listDays.get(i).click();
				break;
			}
		}
	}
}
