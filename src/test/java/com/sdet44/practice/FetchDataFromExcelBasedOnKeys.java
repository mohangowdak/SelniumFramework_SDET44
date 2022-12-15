package com.sdet44.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelBasedOnKeys {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Contacts");
		int lastRowNumber = sheet.getLastRowNum(); //return index ==> index
		short lastcellNumber = sheet.getRow(0).getLastCellNum(); //return count/size ==> count-1
		System.out.println(lastRowNumber); //9
		System.out.println(lastcellNumber); //10 
		String expectedTestCase="CreateContactWithOrganizationTest";
		String expectedKey="LastName";
		String value="";
		for (int i = 0; i <=lastRowNumber; i++) {
			String actualTestcase = sheet.getRow(i).getCell(0).getStringCellValue();
			if (actualTestcase.equals(expectedTestCase)) {
				for (int j = 1; j < lastcellNumber-1; j++) {
					String actualKey = sheet.getRow(i).getCell(j).getStringCellValue();
					if (actualKey.equals(expectedKey)) {
						 value = sheet.getRow(i+1).getCell(j).getStringCellValue();
						 break;
					}
				}
				break;
			}
		}
		System.out.println(value);
	}
}
