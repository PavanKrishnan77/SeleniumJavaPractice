package CrossBroswerTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass 
{
	WebDriver driver;
	
	@Test
	@Parameters("Browser")
	public void verifyFacebookTitle(String broswerName) throws InterruptedException
	{
		if(broswerName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(broswerName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		driver.get("http://www.facebook.com");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.quit();
	}
}

