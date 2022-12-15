package com.sdet44.practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.vtiger.genericUtility.ThreadSafe;
import com.vtiger.genericUtility.WebDriverUtiltiy;
import com.vtiger.objectRepository.CommonPage;
import com.vtiger.objectRepository.LoginPage;

public class TestNGClass {
protected WebDriver driver;
protected CommonPage commonPage;
protected WebDriverUtiltiy webdiverUtility ;
	

	
	@BeforeClass(groups = "baseclass", alwaysRun = true)
	public void testSetup() {
		webdiverUtility = new WebDriverUtiltiy();
		ThreadSafe.setWebdriverUtiliy(webdiverUtility);
		driver=webdiverUtility.launchApplication("chrome", 10, "http://localhost:8888");
		
	}
	@AfterClass(groups = "baseclass", alwaysRun = true)
	public void testTearDown() {
		webdiverUtility.closeBrowser();
	}
	@BeforeMethod(groups = "baseclass", alwaysRun = true)
	public void methodSetup() {
		LoginPage loginPage=new LoginPage(driver);
		 commonPage=new CommonPage(driver);
		loginPage.loginAction("admin", "admin");
		
	}
	@AfterMethod(groups = "baseclass",alwaysRun = true)
	public void methodTearDown() {
		commonPage.signOutAction(webdiverUtility);
	}
}
