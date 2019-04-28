package TestNG;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersProgram
{
	@Test
	@Parameters({"url", "emailID", "Password"})
	public void loginUsingParameters(String url, String emailID, String Password) throws AWTException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailID);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Password);
		driver.findElement(By.id("u_0_2")).click();
	}
}
