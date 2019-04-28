package TestNG;

import org.testng.annotations.Test;

public class TestNGOtherFeatures 
{
	//Sequence of TestNG Annotations:
	//@BeforeSuite
	//@BeforeTest
	//@BeforeClass
	//@BeforeMethod
	//@Test
	//@AfterMethod
	//@AfterClass
	//@AfterTest
	//@AfterSuite

	//In TestNG,
	//@BeforeMethod
	//@Test
	//@AfterMethod
	//The Pair will be created only for these 3 Annotations.

	//@BeforeMethod will be executed each time Before @Test.
	//@AfterMethod will be executed each time After @Test.

	//@BeforeSuite
	//@BeforeTest
	//@BeforeClass
	//@AfterSuite
	//@AfterTest
	//@AfterClass
	//All above Annotation will be executed only one time.


	//Assertion is a very important feature in TestNG.

	//1. 
	//Assert.assertEquals(actual, expected);
		
	//2. 
	//boolean a = "Logo";
	//Assert.assertTrue(a, True);


	//Other Features in TestNG:
	//groups.
	//dependsOnMethods.
	//invocationCount.
	//expectedExceptions.

	//groups in TestNG:
	//Use of Grouping, While generating reports we get very customized reports like as per below scenario.
	//Method Test1 & Test2 will come under Test.
	//Method google will come under Title.
	//Method googleLogoTest will come under Logo.

	@Test(groups="Title")
	public void google()
	{
	}

	@Test(groups="Logo")
	public void googleLogoTest()
	{
	}

	@Test(groups="Test")
	public void Test1()
	{
	}

	@Test(groups="Test")
	public void Test2()
	{
	}

	//dependsOnMethods in TestNG:
	//As per below example, Since HomePageTest method is dependent on loginTest method.
	//HomePageTest method will be executed only if loginTest method gets passed else HomePageTest will be failed.

	//@Test
	public void loginTest()
	{
	}

	@Test(dependsOnMethods="loginTest")
	public void HomePageTest()
	{
	}

	//invocationCount in TestNG:
	//As per below example -> Using this feature, we can execute specific method for any number of times.

	@Test(invocationCount=10)
	public void sum()
	{
		int a = 10;
		int b = 20;
		int c = a + b;
		System.out.println("The Sum is : " +c);
	}

	//expectedExceptions in TestNG:
	//As per below example, we know there is an error in program.
	//We are pretty sure that it will give NumberformatException and we are putting that next to expectedExceptions.

	//@Test(expectedExceptions=NumberformatException.class)
	//public void Test()
	//{
		//int x = "100A";
		//Integer.parseInt(x);
	//}
}
