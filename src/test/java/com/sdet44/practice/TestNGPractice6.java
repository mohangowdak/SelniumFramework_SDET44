package com.sdet44.practice;

import org.testng.annotations.Test;

public class TestNGPractice6  extends TestNGClass{
	
	@Test(groups = "abc")
	public void organizationModuleTestCase() {
		commonPage.clickOrgnazation();
	}
	
}
