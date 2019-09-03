package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WriteDataToExcel 
{
	public static void main(String []args)
	{
		try 
		{
			//Specify the File Path.
			File source = new File("Filepath/ExcelSheetName.xlsx");
		 
			//Load the File.
			FileInputStream fis = new FileInputStream(source);
		 
			//Load the Workbook.
			//XSSFWorkbook workBook = new XSSFWorkbook(fis);
		 
			//Get the Sheet which you want to Modify or Create.
			//XSSFSheet sheet1 = workBook.getSheetAt(0);
	
			//Here createCell will Create Column and setCellvalue will set the value.
			//sheet1.getRow(0).createCell(2).setCellValue("2.41.0");
			//sheet1.getRow(1).createCell(2).setCellValue("2.5");
			//sheet1.getRow(2).createCell(2).setCellValue("2.39");
 
			//Here we need to Specify where you want to Save File.
			FileOutputStream fout = new FileOutputStream(new File("Location of File/Filename.xlsx"));
		 
			//Finally Write Content. 
			//workBook.write(fout);
		 
			//Close the File.
			fout.close();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}		 
}
