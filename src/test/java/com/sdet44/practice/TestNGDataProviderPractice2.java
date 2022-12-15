package com.sdet44.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.genericUtility.ExcelUtility;
import com.vtiger.genericUtility.IConstantPath;

public class TestNGDataProviderPractice2  {
	
	@Test(dataProvider = "getData")
	public void test3(String userName, String password) {
		System.out.println("Username ===> "+ userName + "    Password ===> "+ password);
		System.out.println();
	}
	
	@DataProvider
	public String[][] getData() throws EncryptedDocumentException, IOException {
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		String[][] arr = excelUtility.getDataFromExcel("Sheet1");	 
		return arr; 
	}

	

}
