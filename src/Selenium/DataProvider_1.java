package Selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_1 
{
	@Test(priority=1, dataProvider="getData")
	public void dataProvider(String userName, String password)
	{
		System.out.println("The Username is ::: " +userName);
		System.out.println("The Password is ::: " +password);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Declaring 2 Rows and 2 Columns.
		Object[][] data = new Object[2][2];
		
		data[0][0] = "FirstUserName";
		data[0][1] = "FirstPassword";
		
		data[1][0] = "SecondUserName";
		data[1][1] = "SecondPassword";
		
		return data;
	}
}
