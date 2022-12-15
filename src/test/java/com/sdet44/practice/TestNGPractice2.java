package com.sdet44.practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vtiger.genericUtility.ThreadSafe;


public class TestNGPractice2 {
	
	@Test(groups = {"sanity", "firefox"})
	public void testNGPractice2_demo1() {
		ThreadSafe.getExtentTest().info("Test");
	}
	@Test(groups = {"sanity", "a"}, alwaysRun	 = true)
	public void testNGPractice2_demo2() {
		ThreadSafe.getExtentTest().info("Test 5");
	}
	
	
	@Test(groups = {"sanity", "b"})
	public void testNGPractice2_demo3() {
		ThreadSafe.getExtentTest().info("Test 7 ");
	}
	
	
	
	@Parameters(value = {"browser","username"})
	@Test
	public void testNGPractice2_demo4(String browser, String username) {
		
		ThreadSafe.getExtentTest().info("Test 2 --->  brwoser name====> "+ browser);
		ThreadSafe.getExtentTest().info("Test 2 --->  user name====> "+ username);
	}
	
	@Parameters("url")
	@Test
	public void testNGPractice2_demo5(String url) {
		
		ThreadSafe.getExtentTest().info("Test 1");
		ThreadSafe.getExtentTest().info("Test 2 --->  url name====> "+ url);
	}
	

	

}
