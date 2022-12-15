package com.vtiger.genericUtility;

import com.aventstack.extentreports.ExtentTest;

public class ThreadSafe {
	
	private static ThreadLocal<WebDriverUtiltiy> webdriverUtiliy=new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
/**
 * 
 * @return
 */
	public static WebDriverUtiltiy getWebdriverUtiliy() {
		return webdriverUtiliy.get();
	}
/**
 * 
 * @param swebdriverUtiliy
 */
	public static void setWebdriverUtiliy(WebDriverUtiltiy swebdriverUtiliy) {
		webdriverUtiliy.set(swebdriverUtiliy);
	}
	
	/**
	 * 
	 * @return
	 */
		public static ExtentTest getExtentTest() {
			return extentTest.get();
		}
	/**
	 * 
	 * @param swebdriverUtiliy
	 */
		public static void setExtentTest(ExtentTest sExtentTest) {
			extentTest.set(sExtentTest);
		}

	
	
	
	
}
