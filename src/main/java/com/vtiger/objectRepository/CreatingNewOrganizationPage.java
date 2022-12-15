package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
@FindBy(name = "accountname") private WebElement organizationNameTextfield;
@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveButton;
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterOrgnazationName(String organizationName) {
		organizationNameTextfield.sendKeys(organizationName);
	}
	public void clickSave() {
		saveButton.click();
	}
	
}
