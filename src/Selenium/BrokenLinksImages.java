package Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinksImages 
{
	//Collect all the Links in the Web Page based on "a" and "img" tags.
	//Send HTTP Request for the Link and Read HTTP Response Code.
	//Find out whether the Link is Valid or Broken based on HTTP Response Code.
	//Repeat this for all the Links Captured.
	@Test
	public void brokenLinksImages() throws InterruptedException, MalformedURLException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//driver.get("https://makemysushi.com/404?");
		
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("Reddy77077");
		driver.findElement(By.name("password")).sendKeys("Saibaba77");
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginButton);
		
		driver.switchTo().frame("mainpanel");
		
		//Links are available in //a tag.
		//Images are available in //img tag.
		
		//1.
		//Get the List of all the Links and Images.
		//All Links and Images will be Stored in linksList Variable.
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Size of Full Links and Images ::: " +linksList.size());
		
		//We will Test Only Links which are having href. [Active Links].
		//"a" tags which are not having href, we will Ignore.
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2.
		//Iterate linksList and Exclude all Links and Images which does not have href attribute.
		for(int i=0; i<linksList.size(); i++)
		{
			System.out.println(linksList.get(i).getAttribute("href"));
			if(linksList.get(i).getAttribute("href") != null && (! linksList.get(i).getAttribute("href").contains("javascript")))
			{
				activeLinks.add(linksList.get(i));
			}
		}
		
		//Get the Size of Active Links and Images from activeLinks.
		System.out.println("Size of Active Links and Images ::: " +activeLinks.size());
		
		//3.
		//Check the href url with HttpConnection API.
		//Http Status Codes
		//200 - OK.
		//404 - Not Found.
		//500 - Internal Error.
		//400 - Bad Request.
		for(int j=0; j<activeLinks.size(); j++)
		{
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "====>" +response);
		}
	}
}
