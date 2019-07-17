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

//Usage of above Function:
//String homePage = driver.getWindowHandle();
//TestUtil.switchWindow(driver, homePage, homePage);
//String contactsPage = driver.getWindowHandle();
//TestUtil.switchWindow(driver, homePage, contactsPage);
//driver.switchTo().window(homePage);
//driver.switchTo().window(contactsPage);