package com.vtiger.genericUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vtiger.objectRepository.CommonPage;
import com.vtiger.objectRepository.LoginPage;

public class BaseClass extends BaseClassVariables{
	//workspace 2
	//workspace 1

	//baseclass updated by workspace2

	//modified by workspace1

	/**
	 * create object for generic utility
	 * read data from property file	
	 * open excel file
	 * launch browser, application and setup browser
	 * create object for common Pom classes
	 * 
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	@BeforeClass
	public void classSetup() throws EncryptedDocumentException, IOException {
		//create object for generic utility		
		excelUtility= new ExcelUtility();
		fileUtility=new FileUtility();
		javaUtiltiy=new JavaUtiltiy();
		webDriverUtiltiy=new WebDriverUtiltiy();

		//read data from property file
		fileUtility.openPropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		String browser=fileUtility.getDataFromPropertyFile(PropertyFileKeys.BROWSER.convertToString());
		String url=fileUtility.getDataFromPropertyFile( PropertyFileKeys.URL.convertToString());
		long timeout= (Long) javaUtiltiy.stringToAnyDataType(fileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.convertToString()), "long");
		String randomNumberLimit = fileUtility.getDataFromPropertyFile(PropertyFileKeys.RANDOM_NUMBER_LIMIT.convertToString());
		randomNumber=javaUtiltiy.getRandomNumber((Integer) javaUtiltiy.stringToAnyDataType(randomNumberLimit,"int"));

		//open excel file
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);

		//launch browser, application and setup browser
		driver = webDriverUtiltiy.launchApplication(browser, timeout, url);

		//create object for common Pom classes
		login=new LoginPage(driver);
		commonPage=new CommonPage(driver);
	}
	
	/**
	 * used to login to the application
	 */
	@BeforeMethod
	public void methodSetup() {
		String username=fileUtility.getDataFromPropertyFile(PropertyFileKeys.USERNAME.convertToString());
		String password=fileUtility.getDataFromPropertyFile(PropertyFileKeys.PASSWORD.convertToString());
		login.loginAction(username, password);
	}
	
	/**
	 * used to signout from application
	 */
	@AfterMethod
	public void methodTearDown() {
		commonPage.signOutAction(webDriverUtiltiy);
	}
	
	
	/**
	 * used to close the browser, close property file and excel file
	 * @throws IOException
	 */
	@AfterClass
	public void classTearDown() throws IOException {
		webDriverUtiltiy.closeBrowser(excelUtility, fileUtility);
	}

}
