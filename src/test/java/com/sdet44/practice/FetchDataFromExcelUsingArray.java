package com.sdet44.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingArray {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int lastRowNumber = sheet.getLastRowNum(); //return index ==> index
		short lastcellNumber = sheet.getRow(0).getLastCellNum(); //return count/size ==> count-1
		//declaration
		String[][] arr=new String[lastRowNumber][lastcellNumber];
	//intiallization
		for (int i = 0; i <lastRowNumber; i++) {
			for (int j = 0; j <lastcellNumber; j++) {
				arr[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
//utilization
		for (int i = 0; i <arr.length; i++) {
			for (int j = 0; j <arr[i].length; j++) {
			System.out.println(arr[i][j]);
			}
		}
		
		
	}
}
