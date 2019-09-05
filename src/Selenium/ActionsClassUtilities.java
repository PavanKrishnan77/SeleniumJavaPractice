package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassUtilities 
{
	public static WebDriver driver;
	
	//Function to Mouse Hover and Click Or Select an Element using Actions Class.
	public static void moveToElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
		
	//Function to Drag and Drop using Actions Class.
	public static void dragAndDrop(WebDriver driver, WebElement elementOne, WebElement elementTwo)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(elementOne, elementTwo).release().build().perform();
	}
	
	//Function to Right Click using Actions Class.
	public static void rightClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	
	//Function to Double Click using Actions Class.
	public static void doubleClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}
}
