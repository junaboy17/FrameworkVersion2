package com.eisrem.AppUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	/* Extent HTML Reporter */
	
	public ExtentHtmlReporter htmlReporter; 
	public ExtentReports extent;
	
	public String getReportName() {
		String date = SeleniumHelper.dateTimeFileNameFormat();
		String fileName = "Test-Report- " + date + ".html";
		return fileName;
	}
	
	/*    Extent Reports Create Instance     */
	
	public ExtentReports createInstance() {
		String fileName = getReportName();
		htmlReporter = new ExtentHtmlReporter("reports/" + fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("EISREM Test Project");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "Maine");
		extent.setSystemInfo("Browser", Configuration.Browser.baseBrowser);
		extent.attachReporter(htmlReporter);
		return extent;
	}
	
}
