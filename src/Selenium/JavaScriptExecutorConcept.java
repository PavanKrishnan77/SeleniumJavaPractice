package Selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class JavaScriptExecutorConcept 
{
	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");	
		
		WebDriver driver = new ChromeDriver(); //To Launch Chrome Browser.
		
		driver.manage().window().maximize(); //To Maximize Window.
		driver.manage().deleteAllCookies(); //To delete all the Cookies.
		
		//Dynamic Waits
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com"); //To Enter URL
		
		driver.findElement(By.name("username")).sendKeys("pavanreddy");
		driver.findElement(By.name("password")).sendKeys("Saibaba77");
		//driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		//executeScript -- To execute JavaScript code.
		WebElement loginBtn = driver.findElement(By.xpath("//input[contains(@type,'submit')]")); //login button
		
		flash(loginBtn, driver); //To Highlight the Element.
		
		drawBorder(loginBtn, driver); //To draw a Border.
		
		//To take Screenshot:
		//Take screenshot and store as a File Format.
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//Now copy the screenshot to desired location using copyFile //Method
		FileHandler.copy(src, new File("C:\\Users\\Admin\\Desktop"));
		
		//To Generate Alert.
		//generateAlert(driver, "There is an issue with Login button on Login Page");
		
		//Click on any element by using JavaScript Executor.
		clickElementByJS(loginBtn, driver);
		
		//To Refresh the Page:
		//By using Selenium:
		driver.navigate().refresh(); 
		
		//By using JavaScript Executor:
		refreshBrowserByJS(driver);
		
		//To Get the Title of the Page by JavaScript:
		System.out.println(getTitleByJS(driver));
		
		//To Get the Page Text:
		System.out.println(getPageInnerText(driver));
		
		//To Scroll Page Down:
		//scrollPageDown(driver);
		
		WebElement forgotPwdLink = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
		scrollIntoView(forgotPwdLink, driver);	
	}
	
	public static void flash(WebElement element, WebDriver driver) 
	{
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i <  10; i++) 
        {
            changeColor("rgb(0,200,0)", element,driver); //1
            changeColor(bgcolor, element,driver); //2
        }
    }
	
    public static void changeColor(String color, WebElement element, WebDriver driver) 
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);
        try 
        {
            Thread.sleep(20);
        }  
        catch (InterruptedException e) 
        {
        }
     }
	
    public static void drawBorder(WebElement element, WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
    
    public static void generateAlert(WebDriver driver, String message)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("alert('"+message+"')");
    }
    
    public static void clickElementByJS(WebElement element, WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].click();", element);	
    }
	
    public static void refreshBrowserByJS(WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("history.go(0)");
    }
    
    public static String getTitleByJS(WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	String title = js.executeScript("return document.title;").toString();
    	return title;
    }
    
    public static String getPageInnerText(WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	String pageText = js.executeScript("return document.documentElement.innerText;").toString();
    	return pageText;
    }
    
    public static void scrollPageDown(WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    public static void scrollIntoView(WebElement element, WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
