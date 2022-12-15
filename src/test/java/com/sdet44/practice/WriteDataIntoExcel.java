package com.sdet44.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
	public static void main(String[] args) throws Exception {
		//Step-1 ==> create object for fileinputsteam -> convert from physical file into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		//step 2 ==> open the workbook
		Workbook workbook = WorkbookFactory.create(fis);
		//step 3 ==> get the control on particular sheet
		Sheet sheet = workbook.getSheet("Contacts");
		//step 4 ==> get the control on particular row
		Row row = sheet.getRow(10);
		//step 5 ==> get the control on particular cell and create the cell
		Cell cell = row.createCell(9);
		//step 6 ==> set the data into cell
		cell.setCellValue("pass");
		//step 7 ==> save the the excel file
		FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
		workbook.write(fos);
		//step 8 ==> close the workbook and stream
		workbook.close();
		fis.close();
		System.out.println("data updated successfully");
	}
}
