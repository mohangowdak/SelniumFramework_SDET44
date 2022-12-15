package com.sdet44.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		try {	 
		Sheet sheet = workbook.getSheet("Sheet4");
		Row row = sheet.getRow(4);
		Cell cell = row.getCell(2);
		String toStrigOutput = cell.toString();
		DataFormatter df=new DataFormatter();
		String dataformatterOutput = 	df.formatCellValue(cell);
		System.out.println("dataformatterOutput  === > "+dataformatterOutput); //prefered 
		System.out.println("toStrigOutput  === > "+toStrigOutput);
		}finally { 
			workbook.close();
			fis.close();
			System.out.println("workbook closed");
		}
	}
}