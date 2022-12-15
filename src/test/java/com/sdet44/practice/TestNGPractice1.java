package com.sdet44.practice;

import org.testng.annotations.Test;

import com.vtiger.genericUtility.ThreadSafe;

public class TestNGPractice1  {
	
	@Test(dataProvider = "getData", dataProviderClass = TestNGDataProviderPractice2.class)
	public void testNGPractice_dataProvider(String userName, String password) {
		ThreadSafe.getExtentTest().info("Username ===> "+ userName + "    Password ===> "+ password);
	}
	

	

}
