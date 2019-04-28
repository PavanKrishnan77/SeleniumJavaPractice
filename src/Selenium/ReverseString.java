package Selenium;

public class ReverseString 
{
	public static void main(String[] args) 
	{
		//Reverse a String: 
		//Difference between String and StringBuffer
		//Do we have reverse function in String?
		
		String s = "Hello World";
		
		//Using for loop 
		int len = s.length(); //8
		String rev = "";
		
		for(int i =len-1; i>=0; i--)
		{
			rev = rev + s.charAt(i); //muineleS
		}
		
		System.out.println(rev);
		
		//2Using StringBuffer class:
		StringBuffer sf = new StringBuffer(s);
		System.out.println(sf.reverse());	
	}
}
