package com.vtiger.contacts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericUtility.BaseClass;
import com.vtiger.genericUtility.SheetName;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactsPage;
import com.vtiger.objectRepository.CreatingNewContactPage;
import com.vtiger.objectRepository.CreatingNewOrganizationPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPage;

public class CreateContactWithOrganizationTest extends BaseClass {
//testcase updated
@Test
	public void createContactWithOrganizationTest() throws IOException {
	//read data from excel file
		String expectedOrganizationName =excelUtility.getDataFromExcel(SheetName.CONTACTS.convertToString(),2,1)+randomNumber;
		String expectedLastName=excelUtility.getDataFromExcel(SheetName.CONTACTS.convertToString(),2,1)+randomNumber;
		String partialTextChildWindow=excelUtility.getDataFromExcel(SheetName.CONTACTS.convertToString(),2,1);
		String partialTextMainWindow=excelUtility.getDataFromExcel(SheetName.CONTACTS.convertToString(),2,1);
		
		//create object for Pom classes
		OrganizationPage organizationPage=new OrganizationPage(driver);
		CreatingNewOrganizationPage creatingNewOrganizationPage=new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
		ContactsPage contactsPage=new ContactsPage(driver);
		CreatingNewContactPage creatingNewContactPage=new CreatingNewContactPage(driver);
		ContactInformationPage contactInformationPage=new ContactInformationPage(driver);

		commonPage.clickOrgnazation();
		organizationPage.clickCreateOrgnazation();
		creatingNewOrganizationPage.enterOrgnazationName(expectedOrganizationName);
		creatingNewOrganizationPage.clickSave();
		String actualOrganizationName = organizationInformationPage.getActualOrganizationName();
		javaUtiltiy.verifyUsingIF_Else(actualOrganizationName, expectedOrganizationName, "Oragnization Created Successfully");
		commonPage.clickContact();
		contactsPage.clickCreateContact();
		creatingNewContactPage.enterLastName(expectedLastName);
		creatingNewContactPage.selectOrganization(driver, webDriverUtiltiy, partialTextChildWindow, expectedOrganizationName, partialTextMainWindow);
		creatingNewContactPage.clickSave();
		String actualLastName = contactInformationPage.getActualLastName();
		String actualSelectedOrgName = contactInformationPage.getActualOrganizationName();
//		Assert.assertEquals(actualLastName, expectedLastName);
//		Assert.assertEquals(actualSelectedOrgName, expectedOrganizationName);
		Assert.assertTrue(actualLastName.equals(expectedLastName) && actualSelectedOrgName.equals(expectedOrganizationName));
		System.out.println("TestCase Pass");
		
		
	}

}
