package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableHandling
{
	@Test
	public void webTable() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//<<<---- To Handle WebTable Rows ---->>>
		//<<<<<<< tr - Rows - Vertically>>>>>>>
		//<<<<<<< td - Columns - Vertically>>>>>>>
		
		//To Find Size of Rows to Iterate in For Loop
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Total Number of Rows are ::: " +rowCount);
		
		System.out.println("*******************************");
		
		//Below are to find the Sequence of Xpath in WebTable to write Customized Xpath
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		String beforeXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath = "]/td[1]";
		
		//To Print all First Row Values Vertically
		/*for(int i=2; i<=rowCount; i++)
		{
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}*/
		
		System.out.println("*******************************");
		
		//To Print all First Row Values Vertically and break the loop when Expected value is found
		/*for(int i=2; i<=rowCount; i++)
		{
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
			if(element.getText().equals("Island Trading"))
			{
				System.out.println("Company Name ::: " +element.getText()+ " is found" + " at Position : " +(i-1));
				break;
			}
		}*/
		
		System.out.println("*******************************");
		
		//To Print all Second Row Values Vertically
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		//*[@id="customers"]/tbody/tr[7]/td[2]
		
		/*String secondRowXpath = "]/td[2]";
		for(int i=2; i<=rowCount; i++)
		{
			String secondXpath = beforeXpath + i + secondRowXpath;
			WebElement element = driver.findElement(By.xpath(secondXpath));
			System.out.println(element.getText());
		}*/
		
		System.out.println("*******************************");
		
		//To Print all Third Row Values Vertically
		//*[@id="customers"]/tbody/tr[2]/td[3]
		//*[@id="customers"]/tbody/tr[3]/td[3]
		//*[@id="customers"]/tbody/tr[7]/td[3]
		
		/*String thirdRowXpath = "]/td[3]";
		for(int i=2; i<=rowCount; i++)
		{
			String thirdXpath = beforeXpath + i + thirdRowXpath;
			WebElement element = driver.findElement(By.xpath(thirdXpath));
			System.out.println(element.getText());
		}*/
		
		System.out.println("*******************************");
		System.out.println("*******************************");
		
		//To Print all First Row Values Horizontally
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[2]/td[3]
		 
		/*String firstXpath = "//*[@id=\"customers\"]/tbody/tr[2]/td[";
		String secondXpath = "]";
		
		List<WebElement> columnSize = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));
		int columnCount = columnSize.size();
		System.out.println("Total Number of Columns are ::: " +columnCount);
		
		System.out.println("*******************************");
		
		for(int i=1; i<=columnCount; i++)
		{
			String mainXpath = firstXpath + i + secondXpath;
			WebElement element = driver.findElement(By.xpath(mainXpath));
			System.out.println(element.getText());
		}*/
		
		//<<<---- To Handle WebTable Columns ---->>>
		//<<<<<<< tr - Headers - Horizontally >>>>>>>
	
		//Below are to find the Sequence of Xpath in WebTable to write Customized Xpath
		//*[@id="customers"]/tbody/tr[1]/th[1]
		//*[@id="customers"]/tbody/tr[1]/th[2]
		//*[@id="customers"]/tbody/tr[1]/th[3]
		
		String columnFirstXpath = "//*[@id=\"customers\"]/tbody/tr[1]/th[";
		String columnSecondXpath = "]";
		
		List<WebElement> columnCounts = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));
		int columnSizes = columnCounts.size();
		System.out.println("Total Number of Columns are ::: " +columnSizes);
		
		System.out.println("*******************************");
		
		for(int i=1; i<=columnSizes; i++)
		{
			String mainXpath = columnFirstXpath + i + columnSecondXpath;
			WebElement element = driver.findElement(By.xpath(mainXpath));
			System.out.println(element.getText());
		}
	}
}
