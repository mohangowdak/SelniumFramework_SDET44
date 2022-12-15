package com.sdet44.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.vtiger.genericUtility.ExcelUtility;
import com.vtiger.genericUtility.IConstantPath;
import com.vtiger.genericUtility.WebDriverUtiltiy;

public class SpiceJet {

	public static void main(String[] args) throws Throwable {
		WebDriverUtiltiy webDriverUtiltiy=new WebDriverUtiltiy();
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		String tripType=excelUtility.getDataFromExcel("Spicejet", "TripType").toUpperCase();
		String fromCity=excelUtility.getDataFromExcel("Spicejet", "FromCity").toUpperCase();
		String toCity=excelUtility.getDataFromExcel("Spicejet", "ToCity").toUpperCase();
		String returnDate="";
		String depatureDate=excelUtility.getDataFromExcel("Spicejet", "DepatureDate");
		if(tripType.equals("ROUND")) returnDate=excelUtility.getDataFromExcel("Spicejet", "ReturnDate");
		spiceJetAutomation(webDriverUtiltiy, tripType,fromCity, toCity, depatureDate, returnDate);
	}	
	
	private static void spiceJetAutomation(WebDriverUtiltiy webDriverUtiltiy, String tripType,String fromCity, String toCity,
		String depatureDate, String returnDate) throws InterruptedException {
		WebDriver driver = webDriverUtiltiy.launchApplication("chrome", 10, "https://www.spicejet.com/");
		if(tripType.equals("ROUND")) driver.findElement(By.xpath("//div[text()='round trip']")).click();
		driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//div[text()='From']/following-sibling::div/input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).sendKeys(fromCity);
		driver.findElement(By.xpath("//div[text()='"+toCity+"']")).click();
		List<WebElement> listMonthYear = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
		handleCalenderPopup(listMonthYear, depatureDate.split("-")[0], depatureDate.split("-")[2],  depatureDate.split("-")[1], driver); 
		if(tripType.equals("ROUND")) handleCalenderPopup(listMonthYear,returnDate.split("-")[0], returnDate.split("-")[2],  returnDate.split("-")[1], driver); 
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		driver.findElement(By.xpath("//div[text()='Children']/parent::div[@class='css-1dbjc4n']/following-sibling::div/div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid']")).click();
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		webDriverUtiltiy.waitAndClick(10, driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")), 1000);
	}

	private static void handleCalenderPopup(List<WebElement> listMonthYear, String reqMonth, String reqYear, String reqDate, WebDriver  driver) {
		int count = 0;
		for (int i = 0; i < listMonthYear.size(); i++) {
			WebElement currentMonthYearElement=listMonthYear.get(i);
			String	currentMonthYear=currentMonthYearElement.getText();
			String currentMonth=currentMonthYear.split(" ")[0];
			String currentYear=currentMonthYear.split(" ")[1];
			if(currentMonth.equals(reqMonth) && currentYear.equals(reqYear)) {
				count=i+1;
				break;
			}
		}
		if(count>=1) {
			driver.findElement(By.xpath("(//div[text()='"+reqDate+"'])["+count+"]")).click();
		}
		else {
			System.out.println("Please enter valid month and year");
		}
	}



}
