package Selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardEvents 
{
	Actions actions;
	
	@Test
	public void keyboardEvents() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		actions = new Actions(driver);

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Java");
		
		actions.sendKeys(Keys.SPACE)
		.pause(Duration.ofSeconds(1))
		.sendKeys("Selenium")
		.pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(1))
		.sendKeys("Automation")
		.pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(1))
		.sendKeys("Automation@Gmail.com")
		.pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(1))
		.sendKeys(Keys.ENTER)
		.build().perform();
	}
}
