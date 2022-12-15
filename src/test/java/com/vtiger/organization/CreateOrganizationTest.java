package com.vtiger.organization;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {
	
	public static void main(String[] args) {
		int randomNumber=new Random().nextInt(1000);
		String expectedOrganizationName="Sdet44_"+randomNumber; //data1
		
		String browser="chrome"; //data2
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //data3
		driver.get("http://rmgtestingserver:8888/"); //data4
		
		driver.findElement(By.name("user_name")).sendKeys("admin"); //data5
		
		driver.findElement(By.name("user_password")).sendKeys("admin"); //data6
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(expectedOrganizationName); 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actualOrganizationName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actualOrganizationName.equals(expectedOrganizationName)) {
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
	}

}
