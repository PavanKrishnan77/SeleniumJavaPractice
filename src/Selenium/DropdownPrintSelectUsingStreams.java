package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownPrintSelectUsingStreams 
{
	@Test
	public void dropDownPrintSelectUsingStreams()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");
		
		WebElement ascend = driver.findElement(By.id("tools"));
		
		DropDownPrintSelectUsingStreams.fetchDropdownValues(ascend);
		DropDownPrintSelectUsingStreams.printDropDownValues(ascend);
		DropDownPrintSelectUsingStreams.selectDropDownValue(ascend, "Selenium");
	}
	
	//Function to Select a Value from Drop Down using Streams.
	public static void selectDropDownValue(WebElement element, String valueToBeSelected)
	{
		Select dropdownValues = new Select(element);
		dropdownValues.getOptions().stream().filter(values -> values.getAttribute("value").matches(valueToBeSelected)).forEach(values -> values.click());
	}
		
	//Function to Print Drop Down Values using Streams.
	public static void printDropDownValues(WebElement element)
	{
		Select dropdownValues = new Select(element);
		dropdownValues.getOptions().stream().map(elements -> elements.getText()).collect(Collectors.toList()).forEach(elements -> System.out.println(elements));
	}
	
	//Function to Print Drop Down Values using Streams with List.
	public static void fetchDropdownValues(WebElement element)
	{
		Select dropdownValues = new Select(element);
		List<String> listOfTools = dropdownValues.getOptions().stream().map(elements -> elements.getText()).collect(Collectors.toList());
		System.out.println("The List of Tools Available are ::: " +listOfTools);
	}
}
