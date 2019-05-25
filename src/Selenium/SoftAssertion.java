package Selenium;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion 
{
	//Soft Assertion: If soft assertion is getting failed, Test Case will not be marked as passed-
	//-and next lines or test cases will be executed.
	@Test(priority=1)
	public void softAssertion()
	{
		//It is always good to create an object of Soft Assertion for each Test Case
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("Open the Browser");
		softAssert.assertEquals(true, false, "Browser is not getting Opened");
		
		System.out.println("Enter the URL");
		System.out.println("Enter UserName");
		System.out.println("Enter Password");
		softAssert.assertEquals(true, false, "User Entered Wrong Credentials");
		
		System.out.println("Click on Login Button");
		
		softAssert.assertAll();
		//Above statement will mark our test case fail if any error is existed in Test Case.
	}
	
	//Below Test Will be executed as well though in above test cases errors exists.
	//This is the biggest advantage of using Soft Assertion.
	
	@Test(priority=2)
	public void homePage()
	{
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("Verify User is on Home Page");
		softAssert.assertEquals(true, false, "User Not on Home Page");
		
		softAssert.assertAll();
	}
}
