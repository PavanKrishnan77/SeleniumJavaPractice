package Selenium;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownValueSelectUsingStreams 
{
	@Test
	public void dropDownValueSelectUsingStreams() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");
		
		WebElement ascend = driver.findElement(By.id("tools"));
		
		DropDownValueSelectUsingStreams.printDropDownValues(ascend);
		DropDownValueSelectUsingStreams.selectDropDownValue(ascend);
		
		driver.quit();
	}
	
	//Function to Print Dropdown Values.
	public static void printDropDownValues(WebElement element)
	{
		Select dropdownValues = new Select(element);
		dropdownValues.getOptions().stream().map(elements -> elements.getText()).collect(Collectors.toList()).forEach(elements -> System.out.println(elements));
	}

	//Function to Select a Value from Dropdown using Streams.
	public static void selectDropDownValue(WebElement element)
	{
		Select dropdownValues = new Select(element);
		dropdownValues.getOptions().stream().filter(values -> values.getAttribute("value").matches("Docker")).forEach(values -> values.click());
	}
}
