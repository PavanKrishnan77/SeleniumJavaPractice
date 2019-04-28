package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotationsOrder 
{
	public class TestNGBasics 
	{
		@BeforeSuite //1st Method to Execute
		public void setUp()
		{
			System.out.println("Setup System for Property for Chrome");
		}
		@BeforeClass //2nd Method to Execute
		public void launchBrowser()
		{
			System.out.println("Launch Chrome Browser");
		}
		@BeforeTest //3rd Method to Execute
		public void login()
		{
			System.out.println("Login to Application");
		}
		@BeforeMethod //4th, 7th Method to Execute
		public void enterURL()
		{
			System.out.println("Enter the URL");
		}
		@Test(priority=1) //5th Method to Execute
		public void googleTitleText()
		{
			System.out.println("Google Title Text");
		}
		@Test(priority=2) //8th Method to Execute
		public void checkImage()
		{
			System.out.println("Image Displayed");
		}
		@AfterMethod //6th, 9th Method to Execute
		public void logOut()
		{
			System.out.println("Logout from Application");
		}
		@AfterTest //10th Method to Execute
		public void deleteAllCookies()
		{
			System.out.println("Delete All Cookies");
		}
		@AfterClass //11th Method to Execute
		public void closeBrowser()
		{
			System.out.println("Close Browser");
		}
		@AfterSuite //12th Method to Execute
		public void generateTestReport()
		{
			System.out.println("Generate Test Browser");
		}
	}
}
