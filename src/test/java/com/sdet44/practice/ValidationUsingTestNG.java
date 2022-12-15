package com.sdet44.practice;

import org.testng.annotations.Test;

public class ValidationUsingTestNG {

	@Test
	public void test() {

	String s="a";
	if (s.equals("b")) {
		System.out.println("pass");
	}
	else {
		System.out.println("Fail");
	}
		
		
	}
	
	

}
