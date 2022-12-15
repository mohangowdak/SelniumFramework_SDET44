package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtility.JavaUtiltiy;
import com.vtiger.genericUtility.WebDriverUtiltiy;

public class CalenderPage {
	@FindBy(xpath = "//a[text()='All Events & Todos']/preceding::img[@title='Open Calendar...']") 
	private WebElement openCalenderButton;

	@FindBy(xpath = "//td[@class='calHdr']//b") 
	private WebElement currentMonthYearText;

	@FindBy(xpath = "//img[@src='themes/images/small_right.gif']") 
	private WebElement nextButton;
	
	@FindBy(xpath = "//img[@src='themes/images/small_left.gif']") 
	private WebElement prevButton;

	private String currentMonthYearTextXpath="//td[@class='calHdr']//b";

	private String currentDay="//a[text()='%s']";
	
	public CalenderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public CalenderPage clickOpenCalender() {
		openCalenderButton.click();
		return this;
	}
	private By stringToBy(String s) {
		return By.xpath(s);
	}
	private WebElement stringToWebElement(WebDriver driver, String s, String replaceData) {
		return driver.findElement(By.xpath(String.format(s, replaceData)));
	}

	public void handleCalender(WebDriver driver, JavaUtiltiy javaUtiltiy, WebDriverUtiltiy webDriverUtiltiy , String reqMonth, String reqYear, String reqDate) {
		String currentMonthYear = currentMonthYearText.getText();
		String[] monthYearArr = javaUtiltiy.splitString(currentMonthYear, " ");
		String currentMonth=monthYearArr[0];
		String currentYear=monthYearArr[1];

		while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear))) {
			nextButton.click();
			webDriverUtiltiy.waitTillElementTextInVisible(stringToBy(currentMonthYearTextXpath), currentMonthYear);
			currentMonthYear = currentMonthYearText.getText();
			monthYearArr = javaUtiltiy.splitString(currentMonthYear, " ");
			currentMonth=monthYearArr[0];
			currentYear=monthYearArr[1];
		}
		stringToWebElement(driver, currentDay, reqDate).click();
	}
	
	public void handleCalenderPastAndFuture(WebDriver driver, JavaUtiltiy javaUtiltiy, WebDriverUtiltiy webDriverUtiltiy , String reqMonth, String reqYear, String reqDate) {
		int requiredMonth=javaUtiltiy.getMonthInMMFormat(reqMonth);
		int requiredYear=(Integer) javaUtiltiy.stringToAnyDataType(reqYear, "int");

		
		String currentMonthYear = currentMonthYearText.getText();
		String[] monthYearArr = javaUtiltiy.splitString(currentMonthYear, " ");
		int currentMonth=javaUtiltiy.getMonthInMMFormat(monthYearArr[0]);
		int currentYear=(Integer) javaUtiltiy.stringToAnyDataType(monthYearArr[1], "int");

		while(requiredMonth>currentMonth || requiredYear>currentYear ) {
			nextButton.click();
			webDriverUtiltiy.waitTillElementTextInVisible(stringToBy(currentMonthYearTextXpath), currentMonthYear);
			currentMonthYear = currentMonthYearText.getText();
			monthYearArr = javaUtiltiy.splitString(currentMonthYear, " ");
			currentMonth=javaUtiltiy.getMonthInMMFormat(monthYearArr[0]);
			currentYear=(Integer) javaUtiltiy.stringToAnyDataType(monthYearArr[1], "int");
		}
		
		while(requiredMonth<currentMonth || requiredYear<currentYear ) {
			prevButton.click();
			webDriverUtiltiy.waitTillElementTextInVisible(stringToBy(currentMonthYearTextXpath), currentMonthYear);
			currentMonthYear = currentMonthYearText.getText();
			monthYearArr = javaUtiltiy.splitString(currentMonthYear, " ");
			currentMonth=javaUtiltiy.getMonthInMMFormat(monthYearArr[0]);
			currentYear=(Integer) javaUtiltiy.stringToAnyDataType(monthYearArr[1], "int");
		}
		stringToWebElement(driver, currentDay, reqDate).click();
	}


}
