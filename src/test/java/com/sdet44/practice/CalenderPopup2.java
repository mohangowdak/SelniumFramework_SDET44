package com.sdet44.practice;

import org.openqa.selenium.WebDriver;

import com.vtiger.genericUtility.JavaUtiltiy;
import com.vtiger.genericUtility.WebDriverUtiltiy;
import com.vtiger.objectRepository.LoginPage;

public class CalenderPopup2 {

	public static void main(String[] args) throws InterruptedException {
		String reqMonth="April";
		String reqYear="2021";
		String reqDay="20";	

		WebDriverUtiltiy webDriverUtiltiy=new WebDriverUtiltiy();
		JavaUtiltiy javaUtiltiy=new JavaUtiltiy();
		WebDriver driver = webDriverUtiltiy.launchApplication("chrome", 10, "http://localhost:8888");
		new LoginPage(driver).loginAction("admin", "admin").clickCalender().clickOpenCalender().handleCalenderPastAndFuture(driver, javaUtiltiy, webDriverUtiltiy, reqMonth, reqYear, reqDay);	
	}
}
