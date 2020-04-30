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

public class DropdownValuesPrintUsingStreams 
{
	@Test
	public void dropdownValuesPrintUsingStreams()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");
		
		WebElement ascend = driver.findElement(By.id("tools"));
		
		DropdownValuesPrintUsingStreams.fetchDropdownValues(ascend);
		
		driver.quit();
	}
	
	//Function to Print Dropdown Values using Streams.
	public static void fetchDropdownValues(WebElement element)
	{
		Select dropdownValues = new Select(element);
		List<String> listOfTools = dropdownValues.getOptions().stream().map(elements -> elements.getText()).collect(Collectors.toList());
		System.out.println("The List of Tools are ::: " +listOfTools);
	}
}
