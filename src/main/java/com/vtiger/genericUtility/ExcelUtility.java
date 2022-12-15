package com.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//excelutility updated in sdet44 branch

/**
 * This class is contains excel reusable methods
 * @author MOHAN GOWDA
 *
 */
public class ExcelUtility {
	private Workbook workbook ;
	private FileInputStream fisExcel;
	private DataFormatter df;

	/**
	 * This method is used to open the stream of excel and workbook
	 * @param excelPath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void openExcel(String excelPath) throws EncryptedDocumentException, IOException {
		fisExcel=new FileInputStream(excelPath);
		workbook = WorkbookFactory.create(fisExcel);
		df=new DataFormatter();
	}

	/**
	 * This method is used to close the excel
	 * @throws IOException
	 */
	public void closeExcel() throws IOException {
		workbook.close();
		fisExcel.close();
	}

	/**
	 * This method is used to store the data into excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param data
	 */
	public void setDataToExcel( String sheetName, int rowNumber, int cellNumber, String data) {
		workbook.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(data);
	}

	/**
	 * This method is used to save the workbook
	 * @param savePath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveWorkbook(String savePath) throws FileNotFoundException, IOException {
		workbook.write(new FileOutputStream(savePath));
	}


	/**
	 * This method is used to fetch the data from excel using row and cell index
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public String getDataFromExcel( String sheetName, int rowNumber, int cellNumber) {
		String data = df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber));
		return data;
	}

	/**
	 * This method is used to fetch data from excel based on key and testcaseName
	 * @param sheetName
	 * @param expectedTestCase
	 * @param expectedKey
	 * @return
	 */
	public String getDataFromExcel(String sheetName, String expectedTestCase,String expectedKey) {
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRowNumber = sheet.getLastRowNum(); //return index ==> index
		short lastcellNumber = sheet.getRow(0).getLastCellNum(); //return count/size ==> count-1
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
		return value;
	}

	/**
	 * This method is used to fetch data from excel based on key
	 * @param sheetName
	 * @param expectedKey
	 * @return
	 */
	public String getDataFromExcel(String sheetName, String expectedKey) {
		Sheet sheet = workbook.getSheet(sheetName);
		short lastcellNumber = sheet.getRow(0).getLastCellNum(); //return count/size ==> count-1
		String value="";
		for (int i = 0; i <lastcellNumber; i++) {
			String actualKey = sheet.getRow(0).getCell(i).getStringCellValue();
			if (actualKey.equals(expectedKey)) {
				value = sheet.getRow(1).getCell(i).getStringCellValue();
				break;
			}
		}
		return value;
	}

	/**
	 * This method is used to fetch multiple data from excel and store in String[][]
	 * @param sheetName
	 * @return
	 */
	public String[][] getDataFromExcel(String sheetName) {	
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRowNumber = sheet.getLastRowNum(); //return index ==> index
		short lastcellNumber = sheet.getRow(0).getLastCellNum(); //return count/size ==> count-1
		String[][] arr=new String[lastRowNumber][lastcellNumber];
		for (int i = 0; i <lastRowNumber; i++) {
			for (int j = 0; j <lastcellNumber; j++) {
				arr[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		return arr;
	}
	
	public List<String> getMulDataFromExcel(String sheetName) {	
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRowNumber = sheet.getLastRowNum(); //return index ==> index
		short lastcellNumber = sheet.getRow(0).getLastCellNum(); //return count/size ==> count-1
		List<String> list=new ArrayList<>();
		
		
		for (int i = 0; i <lastRowNumber; i++) {
			for (int j = 0; j <lastcellNumber; j++) {
				 list.add(df.formatCellValue(sheet.getRow(i+1).getCell(j)));
			}
		}
		return list;
	}
}
