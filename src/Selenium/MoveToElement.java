package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MoveToElement
{
	@Test
	public void moveToElement() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");
		
		WebElement mouseHover= driver.findElement(By.xpath("//a[@class='menulink']"));
		
		//Using Normal Way
		//Actions actions = new Actions(driver);
		//actions.moveToElement(mouseHover).build().perform();
		//Thread.sleep(2000);
		
		//Using Function
		moveToElement(driver, mouseHover);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//ul[@class='submenu']//li//a[text()='Courses']")).click();
	}
	
	public static void moveToElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
}
