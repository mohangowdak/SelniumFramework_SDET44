package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtility.WebDriverUtiltiy;

public class CreatingNewContactPage {
	@FindBy(name = "lastname") private WebElement lastNameTextfield;
	@FindBy(xpath = "//td[contains(.,'Organization Name') and @class='dvtCellLabel']/following-sibling::td/img") private WebElement organizationNameButton;
	@FindBy(id = "search_txt") private WebElement searchTextfield;
	@FindBy(name = "search") private WebElement searchButon;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveButton;
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterLastName(String lastName) {
		lastNameTextfield.sendKeys(lastName);
	}
	public void selectOrganization(WebDriver driver, WebDriverUtiltiy webDriverUtiltiy, String partialTextChildWindow, String expectedOrganizationName, String partialTextMainWindow) {
		organizationNameButton.click();
		webDriverUtiltiy.switchWindow(partialTextChildWindow,"url");
		searchTextfield.sendKeys(expectedOrganizationName);
		searchButon.click();
		WebElement organizationTextElement =driver.findElement(By.linkText(expectedOrganizationName));
		webDriverUtiltiy.waitTillElementVisible( organizationTextElement);
		driver.findElement(By.linkText(expectedOrganizationName)).click();
		webDriverUtiltiy.switchWindow(partialTextMainWindow,"url");
	}
	public void clickSave() {
		saveButton.click();
	}

}
