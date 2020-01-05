package Selenium;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownAscescendingOrder_No 
{
	@Test
	public void dropdownAscending() throws AWTException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");
		
		//To Verify whether Dropdown values are in Ascescending Order or Not
		//Result : If all Dropdown values are in Ascescending Order <> Result <<Pass>> else <<Fail>>
		//Result <<Fail>>
		WebElement ascend = driver.findElement(By.id("tools1"));
		Select tools = new Select(ascend);
		
		//Actual List
		List actualList = new ArrayList();
		
		List<WebElement> myTools = tools.getOptions();
		
		for(WebElement elements : myTools)
		{
			String data = elements.getText();
			actualList.add(data); //Here we are adding all dropdown options into actualList
			System.out.println(data);
		}
		
		System.out.println("*************************************");
		
		//Temporary List and Added all the Data into tempList
		List tempList = new ArrayList();
		tempList.addAll(actualList);
		System.out.println(tempList);
		
		//It will sort in Ascending Order 
		Collections.sort(tempList);
		
		//To Check in Descending Order
		//Collections.sort(tempList,Collections.reverseOrder());
		
		Assert.assertTrue(actualList.equals(tempList));
		
		driver.close();
	}
}
