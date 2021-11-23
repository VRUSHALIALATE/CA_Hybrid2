package com.mindtree.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RetreiveExcelData {

	public static ArrayList<String> getData(String testCase) throws IOException
	{
		//CRAETED OBJEC FOR CALLING GETXCELSHEETPATH METHOD TO GET EXCEL FILE PATH.  
		ReadPropertyFile rp = new ReadPropertyFile();
		
		ArrayList<String> testCaseData = new ArrayList<>();
		//CREATE FILE OBJECT WHICH WILL READ DATA FROM FILE.
		
				FileInputStream fis = new FileInputStream(rp.getExcelSheetPath());
				
				//GIVE ACCESS XSSFWORKBOOK OBJECT TO RETRIEVE DATA
				XSSFWorkbook excel = new XSSFWorkbook(fis);
				
				int sheets = excel.getNumberOfSheets();
				
				for(int i=0; i<sheets; i++)
				{
					if(excel.getSheetAt(i).getSheetName().equalsIgnoreCase("Sheet1"))
					{
					  	
					   // GOT ENTIRE SINGLE SHEET OUT OF SHEETS.
					   XSSFSheet sheet = excel.getSheetAt(i);
					   
					   //***IDENTIFY TESTCASE COLUMN BY SCNING 1ST ROW.
					   
					   //AS SHEET CONSISTS OF ROWS AND ROW CONSISTS OF COLUMN.
					   //HERE FIRST OF ALL SCAN ALL ROWS AND GET SPECIFIED ROW
					   Iterator<Row> rows = sheet.iterator();
					   
					   //got first row
					   Row firstRow = rows.next();
						   
					   // CREATED ITERATOR TO SCAN EACH CELL OF ROW 
					   Iterator<Cell> cells = firstRow.cellIterator();
					   
					   int columnIndex=0;
					   //TO GET TESTCASES COLUMN BY SCANNING ROW.
					   while(cells.hasNext())
					   {
						  Cell cell =  cells.next();
						   if(cell.getStringCellValue().equalsIgnoreCase("TestCases")) 
							     break;
						   
						   columnIndex++;
					   }
					   
					  //U System.out.println("column no: "+columnIndex);
					 
					   //ONCE WE GOT TESTCASES COLUMN NOW WE NEED TO SCAN THAT COLUMN TO IDENTIFY PURCHASE.
					   
					   while(rows.hasNext())
					   {
						   Row r = rows.next();
						   Cell c1 = r.getCell(columnIndex);
						  
						 
						  // APPLY C1 NULL CHECK POINT, BECAUSE THERE ARE MULTIPLE ROWS IN SHEET BUT WE HAVE TO STOP BEFORE THE ROW WHICH DOES NOT CONTAIN DATA. 
						   if(c1.getStringCellValue().equalsIgnoreCase(testCase))
						   {
							   Iterator<Cell> cv = r.cellIterator();
							   while(cv.hasNext())
							   {
								  Cell c2 = cv.next();
								  
								  testCaseData.add(c2.getStringCellValue());
							   } 
							   
							   break;
						   }
					   }   
					}
				}
				
		    excel.close();
				
		return testCaseData;		
	}
}

