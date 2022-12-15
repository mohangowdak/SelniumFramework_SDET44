package com.vtiger.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementaion implements IRetryAnalyzer{
	int count=0;
	int retrycount=1;
	@Override
	public boolean retry(ITestResult arg0) {
		if(count<retrycount) {
			count++;
			return true;
		}
		return false;
	}

}
