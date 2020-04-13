package Selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileDownload
{
	//File Download using AutoIT
	@Test
	public void fileDownload() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.navigate().to("https://www.selenium.dev/downloads/");
		
		Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\AutoITFileDownload.exe");
		Thread.sleep(5000);
		
		File file = new File("C:\\Users\\Admin\\Downloads\\selenium-server-4.0.0-alpha-5.jar");
		if(file.exists())
		{
			System.out.println("File is Downloaded Successfully");
		}
		else
		{
			System.out.println("File is not Downloaded");
		}
	}
}