package TestNG;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGPriorityExample
{
	WebDriver driver;
	
	@BeforeMethod //1st, 4th Method to Execute
	public void setUP()
	{
		String key="webdriver.chrome.driver"; //Path of Driver Executable
		String value="./Driver/chromedriver.exe";
		System.setProperty(key, value);
		driver=new ChromeDriver(); //Type Casting
		driver.manage().window().maximize(); //Maximizing the Browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit Wait
		driver.get("http://localhost/login.do"); //Enter the Url
		System.out.println("Opening the Browser");
	}
	
	@Test(priority=1) //2nd Method to Execute
	public void actiTimeTest() throws InterruptedException
	{
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(2000);
		System.out.println("Login to actiTime");
		Thread.sleep(2000);
	}
	
	@Test(priority=2) //5th Method to Execute
	public void loginPage()
	{
		String titleActual=driver.getTitle();
		String titleExpected="actiTIME - Login";
		if(titleActual.equalsIgnoreCase(titleExpected))
		{
			System.out.println("Login Successful");
		}
		else
		{
			System.out.println("Login Failure");
		}
		//System.out.println("Checking Login Successful Or No");
	}
	
	@AfterMethod //3rd, 6th Method to Execute
	public void tearDown()
	{
		driver.close();
		System.out.println("Closing the Browser");
	}
}
