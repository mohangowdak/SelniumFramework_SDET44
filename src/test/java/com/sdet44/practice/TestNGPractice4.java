package com.sdet44.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice4  extends TestNGClass{
	
	@Test(groups = "abc")
	public void calenderModuleTestCase() {
		commonPage.clickCalender();
	
	}
	
}
