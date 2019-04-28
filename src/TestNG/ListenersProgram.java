package TestNG;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNG.TestNGListener.class)
public class ListenersProgram 
{
	@Test
	public void GoogleTitleVerify() throws AWTException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/?stype=lo&jlou=AffzVuv0YB50FrZUJ7gbyjHv-4QBEmto9vRQ5A-OtuqYxubL4eHxPK_MM2WCU0hnLRt9EBf5yHJItBwU-2ozqOxgY_N5JcyAxH_P_Yjt0nXKmg&smuh=47334&lh=Ac8k3XmbMkjAV8LB");
		System.out.println(driver.getTitle());
	}
}
