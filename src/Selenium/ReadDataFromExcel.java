package Selenium;

import java.io.File;
import java.io.FileInputStream;

public class ReadDataFromExcel 
{
	public static void main(String []args)
	{
		try 
		{
			//Specify the Path of File.
			File source = new File("Filepath/ExcelSheetName.xlsx");
		 
			//To Load File.
			FileInputStream fis = new FileInputStream(source);
		 
			//To Load Workbook.
			//XSSFWorkbook workBook = new XSSFWorkbook(fis);
		   
			//Load Sheet - Here we are Loading First Sheet Only.
		    //XSSFSheet sheet1 = workBook.getSheetAt(0);
		 
		    //getRow() - Specify which Row we want to Read.
		    //getCell() - Specify which Column to Read.
		    //getStringCellValue() - Specify that we are Reading String Data.
		 
			//System.out.println(sheet1.getRow(0).getCell(0).getStringCellValue());
			//System.out.println(sheet1.getRow(0).getCell(1).getStringCellValue());
			//System.out.println(sheet1.getRow(1).getCell(0).getStringCellValue());
			//System.out.println(sheet1.getRow(1).getCell(1).getStringCellValue());
			//System.out.println(sheet1.getRow(2).getCell(0).getStringCellValue());
			//System.out.println(sheet1.getRow(2).getCell(1).getStringCellValue());
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
