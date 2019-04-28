package Selenium;

public class ReverseInteger
{
	public static void main(String[] args)
	{
		//Using algorithm
		long num = 12345; // 54321
		long rev = 0;
		
		while(num != 0)
		{
			rev = rev * 10 + num % 10; //5432
			num = num / 10; //12
		}
		
		System.out.println("Reverse num is::"+ rev);
		
		//Using StringBuffer method
		long num1 = 12345;
		System.out.println(new StringBuffer(String.valueOf(num1)).reverse());
	}
}
