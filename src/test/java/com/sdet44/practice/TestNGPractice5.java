package com.sdet44.practice;

import org.testng.annotations.Test;

public class TestNGPractice5  extends TestNGClass{
	
	@Test(groups = "abc")
	public void contactModuleTestCase() {
		commonPage.clickContact();
	}
	
}
