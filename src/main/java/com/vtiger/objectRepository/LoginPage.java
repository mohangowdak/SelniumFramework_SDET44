package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//POM design pattern --> classname should be same as pageName and end with page
public class LoginPage {
	private WebDriver driver;
	//only for static elements
	@FindBy(name = "user_name") private WebElement userNameTextField;
	@FindBy(name = "user_password") private WebElement passwordTextField;
	@FindBy(id = "submitButton") private WebElement loginButton;
		
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//business library
	public void enterUserName(String username) {
		userNameTextField.sendKeys(username);
		
	}
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}
	public void clickLogin() {
		loginButton.click();
	}
	
	public CommonPage loginAction(String userName, String password) {
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
		return new CommonPage(driver);
	}
	
	
	
	
}
