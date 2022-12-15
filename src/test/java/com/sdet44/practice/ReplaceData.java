package com.sdet44.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ReplaceData {
//	@FindBys({@FindBy(id = ""),@FindBy(name = "" ),@FindBy(xpath = "" )})
//	public WebElement abc; //and 
//	
//	@FindAll({@FindBy(id = ""),@FindBy(name = "" ),@FindBy(xpath = "" )})
//	public WebElement cd;
	
public static void main(String[] args) {
	String s="My name is %s";
	String replaceData="Mohan";
	
	String formattedString = String.format(s, replaceData);
	System.out.println(formattedString);
}
	
}
