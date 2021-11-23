
package com.mindtree.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listeners implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	    
		String path = TakeSS.getScreenShot(result.getName());
		System.out.println("ScreenShot takken");
		
		
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String path = TakeSS.getScreenShot(result.getName());
		System.out.println("ScreenShot takken");
		
		/*
		 * ExtentReports reports = new ExtentReports(".//report//extent report.html");
		 * 
		 * reports.startTest(result.getName());
		 */
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
