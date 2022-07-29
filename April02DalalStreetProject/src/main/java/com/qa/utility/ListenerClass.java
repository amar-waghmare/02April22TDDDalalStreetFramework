package com.qa.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.testBase.TestBase;

public class ListenerClass extends TestBase implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) 
	{
		 logger.info("Test Case execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		logger.info("Test Case execution completed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		logger.info("Test Case execution failed");
		 UtilClass.takeSS(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
	}

}
