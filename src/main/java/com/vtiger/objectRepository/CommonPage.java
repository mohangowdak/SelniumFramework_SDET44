package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtility.WebDriverUtiltiy;

public class CommonPage {
	@FindBy(linkText = "Organizations") 
	private WebElement orgnizationTab;
	
	@FindBy(linkText = "Calendar") 
	private WebElement calenderTab;
	@FindBy(linkText = "Contacts") 
	private WebElement contactsTab;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") 
	private WebElement administratorIcon;
	@FindBy(linkText = "Sign Out") 
	private WebElement signOutLink;

	private WebDriver driver;
	
	public CommonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrgnazation() {
		orgnizationTab.click();
	}
	public void clickContact() {
		contactsTab.click();
	}
	public CalenderPage clickCalender() {
		calenderTab.click();
		return new CalenderPage(driver);
	}
	public void signOutAction(WebDriverUtiltiy webDriverUtiltiy) {
		webDriverUtiltiy.mouseHover(administratorIcon);
		signOutLink.click();
	}

}
