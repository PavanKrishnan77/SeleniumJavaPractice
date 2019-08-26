package Selenium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		BufferedReader reader;
		
		try
		{
			reader = new BufferedReader(new FileReader("C:/Users/Admin/Desktop/Missed_Letters.txt"));
			String line = reader.readLine();
			
			while(line != null)
			{
				System.out.println(line);
				//To Read Next Line
				line = reader.readLine();
			}
			reader.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
