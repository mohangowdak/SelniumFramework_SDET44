package com.sdet44.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OnlineBanking {


	public static void main(String[] args) throws AWTException, IOException ,FileNotFoundException, InterruptedException
	{
		//reading data from property file
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser").trim();
		String url = p.getProperty("url").trim();
		long waitingTime = Long.parseLong(p.getProperty("timeout"));
		//generating random number
		int Random = new Random().nextInt(1000);
		//int mobileNo = new Random().nextInt(10);
		int days = new Random().nextInt(1);
		//opening the browser
		WebDriver driver=null;//data 1
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		//		option.addArguments("--disable-popup-blocking");
		//
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-extensions");
		options.setExperimentalOption("prefs", prefs);

		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver= new ChromeDriver(options);
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver= new FirefoxDriver();
		}
		else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();

			driver= new InternetExplorerDriver();
		}
		else {
			System.out.println("please enter valid browser");
		}		
		driver.manage().window().maximize();
		driver.get(url);//data 2
		String actualTitle = "Online Banking System ".trim();
		String expectedTitle = driver.getTitle().trim();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("pass");
		}

		driver.manage().timeouts().implicitlyWait(waitingTime, TimeUnit.SECONDS); //data 3
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,200)", "");
		FileInputStream fis1=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);


		driver.findElement(By.xpath("//li[text()='Open Account']")).click();

		/*	Sheet sheet = wb.getSheet("OpenAccountAndApprove");
		int lastRowNum = sheet.getLastRowNum();
	//sheet.getRow(0).getL
		String expectedTestCase="OpenAccountAndApprove";
		String expKey="Name";
		String value="";
		for(int i=0;i<lastcellno;i++) {
			String ActualTestCase=

		}*/





		String name = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='name'] ")).sendKeys(name);

		driver.findElement(By.xpath("//select[@name='gender'] ")).click();
		driver.findElement(By.xpath("//option[text()='Female'] ")).click();
		String mobileNo = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(3).getStringCellValue();
		driver.findElement(By.xpath(" //input[@name='mobile']")).sendKeys(mobileNo);

		String email = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(4).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='email'] ")).sendKeys( email);

		String landline = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(5).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='landline'] ")).sendKeys(landline);

		String panNo = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(7).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='pan_no'] ")).sendKeys(panNo);
		driver.findElement(By.xpath(" //input[@name='dob']")).click();

		String dob = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(6).getStringCellValue();
		driver.findElement(By.xpath(" //input[@name='dob']")).sendKeys(dob);



		//String citizen = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell().getStringCellValue();
		driver.findElement(By.xpath("//input[@name='citizenship'] ")).sendKeys("z");



		String homeAdd = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(8).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='homeaddrs'] ")).sendKeys(homeAdd );

		String offAdd  = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(9).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='officeaddrs']")).sendKeys(offAdd);
		driver.findElement(By.xpath("//select[@name='state']")).click();
		driver.findElement(By.xpath("//option[text()='California']")).click();
		driver.findElement(By.xpath("//select[@name='city']")).click();
		driver.findElement(By.xpath("//option[text()='Fresno']")).click();



		String arealoc = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(14).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='arealoc']")).sendKeys(arealoc);

		String pin = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(13).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='pin']")).sendKeys(pin);

		String nominee = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(15).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='nominee_name']")).sendKeys(nominee);

		String nomineeAcc = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(16).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='nominee_ac_no']")).sendKeys(nomineeAcc);
		driver.findElement(By.xpath("//select[@name='acctype']")).click();
		driver.findElement(By.xpath("//option[text()='Saving']")).click();
		driver.findElement(By.xpath("//input[@name='submit']")).click();



		driver.findElement(By.xpath("//input[@name='cnfrm-submit']")).click();
		String applicationFormText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(applicationFormText);

		//String applicationNumber = applicationFormText.split(" Application Number :")[0].trim();

		//System.out.println(applicationNumber);

		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();

		String staffId = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(18).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(staffId);

		String staffpasswrd = wb.getSheet("OpenAccountAndApprove").getRow(1).getCell(19).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(staffpasswrd);
		//		driver.findElement(By.xpath("")).sendKeys("password");
		//		driver.manage().window().mi
		//driver.close();




	}


}
