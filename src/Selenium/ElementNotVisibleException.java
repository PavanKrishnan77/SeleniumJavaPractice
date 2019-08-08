package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementNotVisibleException 
{
	@Test
	public void hiddenElement() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
	
		List<WebElement> radioButtons = driver.findElements(By.id("male"));
		int count = radioButtons.size();
		System.out.println("Total Radio Buttons ::: " +count);
		
		for(int i=0; i<count; i++)
		{
			int x = radioButtons.get(i).getLocation().getX();
			if(x!=0)
			{
				radioButtons.get(i).click();
				break;
			}
		}
	}
}
