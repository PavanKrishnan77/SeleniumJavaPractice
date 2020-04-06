package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload_1
{
	//File Upload using SendKeys
	@Test
	public void fileUpload() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.navigate().to("https://cgi-lib.berkeley.edu/ex/fup.html");
		Thread.sleep(3000);
		
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\Admin\\Desktop\\LinksData.txt");
	
		//To Upload File using sendKeys.
		//In DOM, type="file" must be there for that Specific Element.
		//Else ask Developer to make type="file", only then it will work.
	}
}
