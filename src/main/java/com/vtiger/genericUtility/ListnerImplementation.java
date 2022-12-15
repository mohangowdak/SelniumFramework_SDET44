package com.vtiger.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener{
private	ExtentReports report;
private ExtentTest test;
// 7 methods
	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println(Thread.currentThread().getId()+"onFinish --> test");
		report.flush();
		
	}

	@Override //<test> //@BT
	public void onStart(ITestContext arg0) {
		System.out.println(Thread.currentThread().getId()+"onStart --> test");
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Report Name");
		spark.config().setTheme(Theme.DARK);
		 
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating System", "Windows 10");
		report.setSystemInfo("Browser name", "Chrome");
		report.setSystemInfo("Browser Version", "107");
		report.setSystemInfo("Reporter Name", "Mohan");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println(Thread.currentThread().getId()+"onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestFailure");
		ThreadSafe.getExtentTest().fail(result.getMethod().getMethodName()+" is Failed");
		ThreadSafe.getExtentTest().fail(result.getThrowable()); //get the exception infomation
		try {
			String screenshot = ThreadSafe.getWebdriverUtiliy().takeScreenShot();
			ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenshot, result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestSkipped");
		ThreadSafe.getExtentTest().skip(result.getMethod().getMethodName()+" is Skipped");
		ThreadSafe.getExtentTest().skip(result.getThrowable());
		try {
			String screenshot = ThreadSafe.getWebdriverUtiliy().takeScreenShot();
			ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenshot, result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestStart");
		 test = report.createTest(result.getMethod().getMethodName());
		 ThreadSafe.setExtentTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestSuccess");
		ThreadSafe.getExtentTest().pass(result.getMethod().getMethodName()+" is Passed");
	}
}
