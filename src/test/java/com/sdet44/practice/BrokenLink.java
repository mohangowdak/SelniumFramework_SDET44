package com.sdet44.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.vtiger.genericUtility.WebDriverUtiltiy;

public class BrokenLink {
	public static void main(String[] args) throws IOException {
		//UPDATED 
		WebDriverUtiltiy webDriverUtiltiy=new WebDriverUtiltiy();
		WebDriver driver = webDriverUtiltiy.launchApplication("chrome", 10, "https://facebook.com");
		List<WebElement> listOfLink = driver.findElements(By.xpath("//a"));
		for (int i = 0; i < listOfLink.size(); i++) {
			String url = listOfLink.get(i).getAttribute("href");
			try {
				URL u=new URL(url);
				URLConnection urlConnection= u.openConnection();
				HttpURLConnection httpConnection = (HttpURLConnection)urlConnection;
				int statusCode=httpConnection.getResponseCode();
				if(statusCode!=200) {
					System.out.println("Broken Link ====>"+url+"=====> "+httpConnection.getResponseMessage());
				}
			}
			catch (Exception e) {
				System.out.println("Some thing wrong with this URL ===> " + url);
			}
		}
	}
}