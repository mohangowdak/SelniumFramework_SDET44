package com.vtiger.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains common web driver actions 
 * @author MOHAN GOWDA
 *
 */
public class WebDriverUtiltiy {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions act;
	private JavascriptExecutor js;

	/**
	 * This method is used to 
	 * launch browser based on browser key
	 * maximize the browser
	 * provide implicit wait
	 * lauch application by using url
	 * @param browser
	 * @return
	 */
	public WebDriver launchApplication(String browser, long timeout, String url) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.get(url);
		intiallizeExplicitWait(timeout);
		intiallizeActions();
		intiallizeJavaScriptExecutor();
		return driver;
	}

	public WebDriver launchApplication(String browser) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
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
		
		intiallizeActions();
		intiallizeJavaScriptExecutor();
		return driver;
	}

	/**
	 * This method is used to intiallize Action class
	 */
	private void intiallizeActions() {
		act=new Actions(driver);
	}

	/**
	 * This method is used to intiallize the Webdriver wait
	 * @param timeout
	 */
	private void intiallizeExplicitWait(long timeout) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeout)); 
	}

	/**
	 * This method is used to intiallize the JavascriptExecutor
	 */
	private void intiallizeJavaScriptExecutor() {
		js = (JavascriptExecutor)driver; 
	}

	/**
	 * This method is used to wait untill element click
	 * @param duration
	 * @param element
	 * @param pollingTime
	 * @throws InterruptedException
	 */
	public void waitAndClick(int duration, WebElement element, long pollingTime) throws InterruptedException {
		int count=0;
		while(count<duration) {//duration=10
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(pollingTime);//polling time = 1000
				count++;
			}
		}
	}

	/**
	 * This method is used to wait controller till specified element visible
	 * @param driver
	 * @param timeout
	 * @param element
	 */

	public void waitTillElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to wait the controller till element changed the text
	 * @param element
	 * @param text
	 */
	public void waitTillElementTextInVisible(By element, String text) {
		wait.until(ExpectedConditions.invisibilityOfElementWithText(element, text));
	}

	/**
	 * This method is used to wait the controller till alert popup displayed
	 */
	public void waitTillAlertPresent() {
		wait.until(ExpectedConditions.alertIsPresent());
	}



	/**
	 * This method is used to switch the window based on partial URL
	 * @param driver
	 * @param partialText
	 */
	public void switchWindow(String partialURLorTitle, String strategy) {
		Set<String> windowIDs = driver.getWindowHandles();
		for (String id : windowIDs) {
			driver.switchTo().window(id);
			if(strategy.equals("url")) {
				String actualUrl = driver.getCurrentUrl();
				if(actualUrl.contains(partialURLorTitle)) {
					break;
				}
			}
			else if(strategy.equals("title")) {
				String actualTitle = driver.getTitle();
				if(actualTitle.contains(partialURLorTitle)) {
					break;
				}
			}
		}
	}



	/**
	 * This method is used to mouse hover on the specified element
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		act.moveToElement(element).perform();
	}



	/**
	 * This method is used to double click on the specified element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebElement element) {
		act.doubleClick(element).perform();
	}

	/**
	 * This method is used to double click on the web page
	 * @param driver
	 */
	public void doubleClick() {
		act.doubleClick().perform();
	}

	/**
	 * This method is used to right click on the web page
	 * @param driver
	 */
	public void rightClick() {
		act.contextClick().perform();
	}

	/**
	 * This method is used to right click on the specified element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebElement element) {

		act.contextClick(element).perform();
	}


	/**
	 * This method is used to switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch the frame based on NAME or ID
	 * @param driver
	 * @param nameOrID
	 */
	public void switchFrame(String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}

	/**
	 * This method is used to switch the frame based on element
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebElement element) {
		driver.switchTo().frame(element);
	}


	/**
	 * This method is used to switch back parent frame of current frame (means just top of the current frame)
	 * @param driver
	 */
	public void switchPreviousFrame() {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method is used to switch back to webpage from frame(Take the controll back to home page)
	 * @param driver
	 * @param element
	 */
	public void switchBackFrame(WebElement element) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to close the browser
	 * @param driver
	 * @throws IOException 
	 */
	public void closeBrowser(ExcelUtility excelUtility, FileUtility fileUtility) throws IOException {
		excelUtility.closeExcel();
		fileUtility.closePropertyFile();
		driver.quit();
	}
	/**
	 * This method is used to close the browser
	 * @param driver
	 * @throws IOException 
	 */
	public void closeBrowser() {
		driver.quit();
	}
	/**
	 * This method is used to close the browser tab
	 */
	public void closeTab() {
		driver.close();
	}

	/**
	 * This method is used to accept alert popup
	 * @param driver
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to dissmiss alert popup
	 * @param driver
	 */
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to fetch data from alert popup
	 * @param driver
	 * @return
	 */
	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}

	/**
	 * This method is used to scrool till the end of webpage
	 */
	public void scrollTillEnd() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * This method is used to enter value using java script code
	 * @param element
	 * @param data
	 */
	public void enterValueUsingJs(WebElement element, String data) {
		js.executeScript("arguments[0].value=arguments[1]",element,data);
	}

	/**
	 * This method is used to click on the element
	 * @param element
	 */
	public void clickUsingJs(WebElement element) {
		js.executeScript("arguments[0].click()",element);
	}

	/**
	 * This method is used to scroll till element location
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()",element);
	}

	/**
	 * This method is used to take screen shot of webpage and stored in local system
	 * @param testCaseName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(String testCaseName) throws IOException {
		String fileName=testCaseName+"_"+new JavaUtiltiy().getDateTime();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./errorshots/"+fileName+".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}
	
	public String takeScreenShot() throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		 String src = ts.getScreenshotAs(OutputType.BASE64);
		return src;
	}



}
