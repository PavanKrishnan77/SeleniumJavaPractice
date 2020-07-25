package Selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownValuesValidation 
{
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");
	}

	@Test
	public void dropDownValuesValidation() 
	{
		WebElement tools = driver.findElement(By.id("tools"));

		List<String> expectedDropDownValues = Arrays.asList("AutoIT", "Cucumber", "Docker", "Selenium");

		List<String> actualDropDownValues = DropDownValuesValidation.dropDownValues(tools);
		
		Assert.assertEquals(actualDropDownValues, expectedDropDownValues, "Tools Dropdown Values are not Matched");
	}

	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}

	public static List<String> dropDownValues(WebElement element) 
	{
		Select select = new Select(element);
		List<WebElement> dropDownValues = select.getOptions();

		List<String> toolsDropDownValues = new ArrayList<String>();

		for(WebElement listOfDropDownValues : dropDownValues) 
		{
			toolsDropDownValues.add(listOfDropDownValues.getText());
		}
		return toolsDropDownValues;
	}
}
