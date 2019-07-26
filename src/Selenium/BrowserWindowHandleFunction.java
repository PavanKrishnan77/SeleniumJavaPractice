package Selenium;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class BrowserWindowHandleFunction 
{
	public void switchWindow(WebDriver driver, String firstWindow, String secondWindow)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windows : windowHandles)
		{
			if(!windows.equals(firstWindow) && !windows.equals(secondWindow))
			{
				driver.switchTo().window(windows);
			}
		}
	}
}

//Pre-Requisite:
//Understand the above Function Logic:

//Usage of above Function:

//1.
//Get the Unique Address of First Window [Window-1] and Store it in Variable Called homePage.
//String homePage = driver.getWindowHandle();

//2.
//Call Function and Pass homePage Parameter as below and Switch to Window-2.
//TestUtil.switchWindow(driver, homePage, homePage);

//3.
//Get the Unique Address of Second Window [Window-2] and Store it in Variable Called contactsPage.
//String contactsPage = driver.getWindowHandle();

//4.
//Call Function and Pass homePage and contactsPage Parameters as below and Switch to Window-3.
//TestUtil.switchWindow(driver, homePage, contactsPage);

//5.
//Once after performing actions in Window-2 and Window-3, you can switch to any Window.
//driver.switchTo().window(homePage);
//driver.switchTo().window(contactsPage);

//6.
//If there are 4 windows we can add one more parameter in function and follow the Same.