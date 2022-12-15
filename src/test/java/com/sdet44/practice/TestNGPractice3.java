package com.sdet44.practice;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.vtiger.genericUtility.ThreadSafe;

public class TestNGPractice3  extends TestNGClass{
	
	@Test(groups = "abc")
	public void testNGPractice3_demo1() {
		ThreadSafe.getExtentTest().info("Test1");
	}
	

	@Test(groups = "efg")
	public void testNGPractice3_demo2() {
		ThreadSafe.getExtentTest().info("Test2");
	}
	
	

	@Test(groups = "abc", alwaysRun = true)
	public void testNGPractice3_demo3() {
		ThreadSafe.getExtentTest().info("Test3");
	}
	
	

	

}
