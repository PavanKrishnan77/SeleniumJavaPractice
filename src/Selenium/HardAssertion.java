package Selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion 
{
	//Hard Assertion: If hard assertion is getting failed, Immediately Test Case will be marked as failed-
	//-and Test Case Execution will be terminated even if few Test cases needs to be executed after it.
	@Test
	public void hardAssertion()
	{
		System.out.println("Open the Browser");
		Assert.assertEquals(true, true, "Browser is not getting Opened"); 
		//<<Hard Assertion>> -- Here it Won't Fail because Actual and Expected both are True.
		
		System.out.println("Enter the URL");
		System.out.println("Enter UserName");
		System.out.println("Enter Password");
		Assert.assertEquals(true, false, "User Entered Wrong Credentials");
		//<<Hard Assertion>> -- Here it Will Fail because Actual is True and Expected is False.
		
		System.out.println("Click on Login Button");
	}
	
	//Note:
	//Disadvantage of <<Hard Assertion>> is that even if "Click on Login Button" is ignore because of Assertion Error.
	//Above Test Case will be shown as Passed since other test cases is there below.
	//Below Test case will be shown as Failed When we execute.
	//To overcome from this, we use Soft Assertion.
	
	//Below Test Won't be executed since above Test is getting failed because of Assertion Error.
	@Test
	public void homePage()
	{
		System.out.println("Verify User is on Home Page");
	}
}
