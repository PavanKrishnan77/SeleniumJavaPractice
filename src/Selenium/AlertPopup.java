package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertPopup
{
	public static WebDriver driver;
	
	@Test
	public void alertWindowPopup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		Thread.sleep(2000);
//		
//		alert.accept(); //To Accept Alert Popup
//	
//		alert.dismiss(); //To Dismiss Alert Popup
		
		//Function to Accept Alert Popup
		AlertPopup.acceptAlertPopup();
		
		//Function to Dismiss Alert Popup
		//AlertPopup.dismissAlertPopup();
	}
	
	public static void acceptAlertPopup() throws InterruptedException
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.accept();
			System.out.println("Alert Accepted Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Something Went Wrong -- Please Check" +e.getMessage());
		}
	}
	
	public static void dismissAlertPopup() throws InterruptedException
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.dismiss();
			System.out.println("Alert Dismissed Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Something Went Wrong -- Please Check" +e.getMessage());
		}
	}
}
