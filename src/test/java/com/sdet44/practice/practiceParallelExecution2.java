package com.sdet44.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practiceParallelExecution2 {@Parameters("browser")
@Test
public void test(String browser) throws InterruptedException {
System.out.println("practiceParallelExecution2 ===> "+Thread.currentThread().getId());
WebDriver driver=null;
if(browser.equals("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
else if(browser.equals("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
	driver.manage().window().maximize();
	driver.get("https://www.google.com");
	Thread.sleep(3000);
	driver.quit();
}

@Parameters("browser")
@Test
public void test1(String browser) throws InterruptedException {
System.out.println("practiceParallelExecution2 ===> "+Thread.currentThread().getId());
WebDriver driver=null;
if(browser.equals("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
else if(browser.equals("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
	driver.manage().window().maximize();
	driver.get("https://www.google.com");
	Thread.sleep(3000);
	driver.quit();
}

@Parameters("browser")
@Test
public void test2(String browser) throws InterruptedException {
System.out.println("practiceParallelExecution2 ===> "+Thread.currentThread().getId());
WebDriver driver=null;
if(browser.equals("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
else if(browser.equals("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
	driver.manage().window().maximize();
	driver.get("https://www.google.com");
	Thread.sleep(3000);
	driver.quit();
}}
