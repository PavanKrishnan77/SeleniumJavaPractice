package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorConcept 
{
	@Test
	public void javaScriptExecutorConcept()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");	
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies(); 
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("Reddy77077");
		driver.findElement(By.name("password")).sendKeys("Saibaba77");
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
	
		//highlightElementByJavaScript(loginButton, driver); 
		
		//drawElementBorderByJavaScript(loginButton, driver); 
		
		//generateAlertByJavaScript(driver, "There is an issue with Login Button on Login Page");
		
		//clickElementByJavaScript(loginButton, driver);
		
		//refreshBrowserByJavaScript(driver);
		
		//getPageTitleByJavaScript(driver);
		
		//getPageInnerTextByJavaScript(driver);
		
		//scrollDownPageByJavaScript(driver);
		
		WebElement documentsLinks = driver.findElement(By.xpath("//h3[contains(text(), 'Documents')]"));
		scrollIntoElementByJavaScript(documentsLinks, driver);
	}
	
	//To Highlight WebElement by using JavaScript Executor.
	public static void highlightElementByJavaScript(WebElement element, WebDriver driver) 
	{
        JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
        String backgroundColor = element.getCssValue("backgroundColor");
        for(int i=0; i<10; i++) 
        {
        	changeColorByJavaScript("rgb(0, 200, 0)", element, driver);
        	changeColorByJavaScript(backgroundColor, element, driver);
        }
    }
	
	//To Change the Color of WebElement by using JavaScript Executor.
    public static void changeColorByJavaScript(String color, WebElement element, WebDriver driver) 
    {
    	JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
    	javaScript.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try 
        {
            Thread.sleep(2000);
        }  
        catch (InterruptedException e) 
        {
        	
        }
    }
	
    //To Draw a Border for WebElement by using JavaScript Executor.
    public static void drawElementBorderByJavaScript(WebElement element, WebDriver driver)
    {
    	JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
    	javaScript.executeScript("arguments[0].style.border='3px solid red'", element);
    }
    
    //To Generate an Alert by using JavaScript Executor.
    public static void generateAlertByJavaScript(WebDriver driver, String alertMessage)
    {
    	JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
    	javaScript.executeScript("alert('" + alertMessage + "')");
    }
    
    //To Click on any WebElement by using JavaScript Executor.
    public static void clickElementByJavaScript(WebElement element, WebDriver driver)
    {
    	JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
    	javaScript.executeScript("arguments[0].click();", element);	
    }
	
    //To Refresh Browser by using JavaScript Executor.
    public static void refreshBrowserByJavaScript(WebDriver driver)
    {
    	JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
    	javaScript.executeScript("history.go(0)");
    }
    
    //To Get Title of the Page by using JavaScript Executor.
    public static void getPageTitleByJavaScript(WebDriver driver)
    {
    	JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
    	String pageTitle = javaScript.executeScript("return document.title;").toString();
    	System.out.println("The Title of the Page is ::: " +pageTitle);
    }
    
    //To Get the Page Inner Text by using JavaScript Executor.
    public static void getPageInnerTextByJavaScript(WebDriver driver)
    {
    	JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
    	String pageText = javaScript.executeScript("return document.documentElement.innerText;").toString();
    	System.out.println("The Text of the Page is ::: " +pageText);
    }
    
    //To Scroll Down the Page by using JavaScript Executor..
    public static void scrollDownPageByJavaScript(WebDriver driver)
    {
    	JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
    	javaScript.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    //To Scroll into WebElement View by using JavaScript Executor..
    public static void scrollIntoElementByJavaScript(WebElement element, WebDriver driver)
    {
    	JavascriptExecutor javaScript = ((JavascriptExecutor) driver);
    	javaScript.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
