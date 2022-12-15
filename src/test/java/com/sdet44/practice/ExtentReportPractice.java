package com.sdet44.practice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportPractice {
	
	public static void main(String[] args) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Report Name");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating System", "Windows 10");
		report.setSystemInfo("Browser name", "Chrome");
		report.setSystemInfo("Browser Version", "107");
		report.setSystemInfo("Reporter Name", "Mohan");
		
		ExtentTest test1 = report.createTest("test1");	
		test1.info("This information comming from script");
		test1.warning("Warning message");
		test1.fail("test1 fail");
		
		ExtentTest test2 = report.createTest("test2");
		test2.info("This information comming from script");
		test2.info("This information comming from script");
		test2.info("This information comming from script");
		test2.pass("test1 pass");
		
		ExtentTest test3 = report.createTest("test3");
		test3.info("This information comming from script");
		test3.info("This information comming from script");
		test3.warning("Warning message");
		test3.info("This information comming from script");
		test3.info("This information comming from script");
		test3.info("This information comming from script");
		test3.info("This information comming from script");
		
		
		report.flush();
		
	}

}
