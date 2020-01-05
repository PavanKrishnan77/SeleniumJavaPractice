package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BootStrapDropdown_1 
{
	//Below are Steps to Handle BootStrap DropDown in Selenium
	//Click on given Dropdown.
	//Get all the tags while are available under "li" tags.
	//Get text of each "li//a" or "div//a"
	//Match the Text and Click on it.
		
	@Test
	public void bootStrap() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
			
		driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown')]")).click();
			
		List<WebElement> dropdownValues = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
		System.out.println(dropdownValues.size());
		
		//To Print all Dropdown Values
		/*for(int i=0; i<dropdownValues.size(); i++)
		{
			System.out.println(dropdownValues.get(i).getText()); 
		}*/
		
		//To Print all Dropdown Values and Click on all Dropdown Values
		/*for(int i=0; i<dropdownValues.size(); i++)
		{
			System.out.println(dropdownValues.get(i).getText()); 
			dropdownValues.get(i).click();
		}*/
		
		//To Select Particular value from Dropdown
		for(int i=0; i<dropdownValues.size(); i++)
		{
			System.out.println(dropdownValues.get(i).getText()); 
			if(dropdownValues.get(i).getText().contains("Angular"))
			{
				dropdownValues.get(i).click();
				break;
			}
		}
	}	
}
