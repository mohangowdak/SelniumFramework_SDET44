package com.sdet44.practice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebtable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
		String page = driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText();
		
		int pageNumber = Integer.parseInt(page.split(" ")[1]);
		boolean count=false;
		String expectedeOrgName="org7";
		for(int j=0;j<pageNumber;j++) {
			List<WebElement> listOrg = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
			
			for(int i=1;i<listOrg.size();i++) {
				String actualOrgName = listOrg.get(i).getText();
				System.out.println(actualOrgName);
				if (actualOrgName.equals(expectedeOrgName)) {
					driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(i+2)+"]/td/input")).click();
					count=true;
					break;
				}
			}
			if(count) break;
			
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			
			WebElement statusBar = driver.findElement(By.xpath("//div[@id='status']"));
			wait.until(ExpectedConditions.invisibilityOf(statusBar));
		}
		
		
	}

}
