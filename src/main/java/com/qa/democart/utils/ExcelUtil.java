package com.qa.democart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	//Data driven approach means getting data from the external file(May be Excel)
	// get Data() method will get data from the Excel sheet
	// Object[][] ---> the data is stored into the two dimensional array
	// The same 2 dimentioal array dat is given to the "Data Provider" (@DP) which is in "Test Layer classes" 
   // from the @DP to @Test (both are in the same Test class)
	
	/**
	 * Go to "demo.opencart.com"
	 * Click "Register page"
	 * fill the data in the excel sheet
	 * Data should come from the excel sheet, and we shouldn't do the hard coded values
	 */
	
	/**
	 * Selenium don't provide any API to interact with Excel sheet
	 * To interact with excel sheet we need to add "Apache POI API" dependency
	 * Apache POI API, 3rd party library which is freely available
	 */
	
	// Now we have to create one utility which will read the excel sheet
	
	public static Workbook book;// this will give you the complete reference of the book, there we have all the Excel  sheet names
	public static Sheet sheet; // this will give you the particular sheet
	public static String TEST_DATA_SHEET_PATH=".\\src\\test\\resources\\testdata\\TestDemoCart.xlsx";
	
	// we have to create one method where we need to interact with the sheet
	
	public static Object[][] getTestData(String sheetName) {
		   Object data[][]=null;
		
		try {
			FileInputStream fis=new FileInputStream(TEST_DATA_SHEET_PATH);
			//Workbookfactory class has create method (Apache POI provides this class)
			try {
				book= WorkbookFactory.create(fis); // this create method returns one "Workbook" reference, so it will store in the reference variable
				
				sheet=book.getSheet(sheetName); // now the control is on my particular excel sheet on top, now we need to read the dat in rows and columns
				
				//to store the data in the form of rows and columns which data structure we need to follow(2 D array)
				
				/**
				 * Object data[][]=new Object[4][6]; // here we need to mention how many rows and columns, but I am not sure that how many rows and columns
				 * here we can't hard code, so we have to prefer other way
				 */
				
				 data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; 
				
				// now I need to read the rows and column data, for that I need to use for loop
				// for i=0; the j loop will be executed 6 times(bcz 6 columns are there)
				
				for(int i=0;i<sheet.getLastRowNum();i++) {
					for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
						data[i][j]=sheet.getRow(i+1).getCell(j).toString();  //actual data is started from [row1][column0], and convert them into stoString
						//[1][0] file first then [1][1], [1][2], [1][3], [1][4], [1][5], [1][6] after that inner loop exit and go back to outer loop(next row)
						//[2][0] file first then [2][1], [2][2], [2][3], [2][4], [2][5], [2][6] after that inner loop exit and go back to outer loop
					}
				}
				
				
			} catch (InvalidFormatException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} 
		
		return data;
	}
	
	
	
	
}
