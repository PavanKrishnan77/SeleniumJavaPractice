package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragandDrop_1 
{
	@Test
	public void dragandDrop() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);
		
		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
		Thread.sleep(2000);
		
		//Using Normal Way:
		//Actions actions = new Actions(driver);
		//actions.dragAndDrop(dragElement, dropElement).release().build().perform();	
		
		//Using Function:
		dragAndDrop(driver, dragElement, dropElement);
	}
	
	public static void dragAndDrop(WebDriver driver, WebElement elementOne, WebElement elementTwo)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(elementOne, elementTwo).release().build().perform();
	}
}
