package com.vtiger.organization;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryTypeTest {
	
	public static void main(String[] args) {
		int randomNumber=new Random().nextInt(1000);
		String expectedOrganizationName="Sdet44_"+randomNumber; //data1 --> testdata
		String expectedIndustry="Banking"; //data2 --> testdata
		String expectedType= "Analyst"; //data3--> testdata

		String browser="chrome"; //data4 --> commondata
		 WebDriver driver=null;
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			 driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("Please enter valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //data5 --> commondata
		driver.get("http://localhost:8888/"); //data6 --> commondata
//WebElement userName = driver.findElement(By.name("user_name"));
//WebElement password = driver.findElement(By.name("user_password"));
//WebElement login=driver.findElement(By.id("submitButton"));
//userName.sendKeys("admin"); //data5
//	password.sendKeys("admin"); //data6
//	driver.navigate().refresh();
//	userName.sendKeys("admin"); //data5
//	password.sendKeys("admin"); //data6
//		login.click();
		
		
		LoginPage repo=new LoginPage(driver);
		
		repo.enterUserName("admin"); //data7 --> commondata
		repo.enterPassword("admin"); //data8 --> commondata
		driver.navigate().refresh();
		repo.enterUserName("admin"); 
		repo.enterPassword("admin"); 
		repo.clickLogin();
//		
	
		/*
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(expectedOrganizationName);
		
		WebElement industryDropdown = driver.findElement(By.xpath("//select[@name='industry']"));
		WebElement typeDropdown =driver.findElement(By.xpath("//select[@name='accounttype']"));
		
		Select industry=new Select(industryDropdown);
		industry.selectByValue(expectedIndustry);
		
		Select type=new Select(typeDropdown);
		type.selectByValue(expectedType);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actualOrganizationName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		String actualIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		String actualType = driver.findElement(By.id("dtlview_Type")).getText();
		
		if(actualOrganizationName.equals(expectedOrganizationName) && actualIndustry.equals(expectedIndustry) &&  actualType.equals(expectedType) ) {
			System.out.println("TestCase pass ---> Organization created Successfully");
		}
		else {
			System.out.println("TestCase Fail ---> Organization not created");
		}
		
		WebElement adminstratorEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(adminstratorEle).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		*/
	}

}
