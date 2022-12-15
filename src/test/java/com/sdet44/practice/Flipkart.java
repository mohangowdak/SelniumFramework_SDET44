package com.sdet44.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.vtiger.genericUtility.WebDriverUtiltiy;

public class Flipkart {
	public static void main(String[] args) {
		WebDriverUtiltiy webdriverUtiltiy=new WebDriverUtiltiy();
		
		WebDriver driver = webdriverUtiltiy.launchApplication("chrome", 10, "http://localhost:8888");
WebElement userNameelement = driver.findElement(By.xpath("//input[@name='user_name']"));
WebElement passwordelement = driver.findElement(By.xpath("//input[@name='user_password']"));
WebElement loginelement = driver.findElement(By.xpath("//input[@id='submitButton']"));
		String userName="admin";
		String pasword="admin";
webdriverUtiltiy.enterValueUsingJs(userNameelement, userName);
webdriverUtiltiy.enterValueUsingJs(passwordelement, pasword);
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].click()",loginelement);
	WebElement ele = driver.findElement(By.xpath("//b[contains(text(),'Top Opportunities')]"));
	
	
	js.executeScript("arguments[0].scrollIntoView()", ele);
	}

}
