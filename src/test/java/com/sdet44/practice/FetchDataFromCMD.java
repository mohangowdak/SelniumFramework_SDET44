package com.sdet44.practice;

import org.testng.annotations.Test;

public class FetchDataFromCMD {
	@Test
	public void test() {
		String url = System.getProperty("url");
		String userName = System.getProperty("username");
		String password = System.getProperty("password");
		System.out.println();
		System.out.println("url of website : "+url);
		System.out.println("userName of app : "+userName);
		System.out.println("password of app : "+password);
	}
}
