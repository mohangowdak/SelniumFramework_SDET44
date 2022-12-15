package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	@FindBy(id = "dtlview_Last Name") private WebElement lastNameText;
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a") private WebElement organizationNameText;

	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
/**
 * This method is used fectch actual organization Name which is selected in create contact page 
 * @return
 */
	public String getActualOrganizationName() {
		return	organizationNameText.getText();
	}
	
	/**
	 * This method is used fectch actual lastName which is enter in create contact page 
	 * @return
	 */
	public String getActualLastName() {
		return	lastNameText.getText();
	}

}
