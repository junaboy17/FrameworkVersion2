package com.eisrem.Hooks;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.Data;
import com.eisrem.AppUtils.SeleniumHelper;

public class BaseHook extends Data{

	@BeforeSuite
	public void testSuiteSetUp() {
		Source.SeleniumHelper().cleanScreenShotDirectory();
		Source.SeleniumHelper().cleanReportsDirectory();
		Source.SeleniumHelper().cleanDownloadDirectory();
	}

	@BeforeClass
	public void testClassSetUp() {
		SeleniumHelper.log.info("Begin Test Class: " + this.getClass().getSimpleName());
		SeleniumHelper.log.info(Source.SeleniumHelper().date());
		System.out.println(Data.EmptyString);
	}
	
	@BeforeMethod
	public void testSetUp1(ITestResult result, Object[] Module) {
		SeleniumHelper.log.info("Begin Test : " + result.getMethod().getMethodName());
		String module = Module[0].toString();
		SoftAssert = new SoftAssert();
		
		if(Configuration.Enviornment.baseEnviornment.equalsIgnoreCase("dev")) {
				Source	.DriverFactory().openBrowser(Browser);
				
				Source	.SeleniumHelper()
						.goToUrl(Configuration.Url.devPortal)
						.GetSource()
						.LogInPage()
						.setUserName(Configuration.User.devUser)
						.setPassword(Configuration.Password.devPassword)
						.clickSignIn();
		}
		
		else if (Configuration.Enviornment.baseEnviornment.equalsIgnoreCase("uat")) {
			
			Source	.DriverFactory().openBrowser(Browser);
			
			Source	.SeleniumHelper()
					.goToUrl(Configuration.Url.testPortal)
					.GetSource()
					.LogInPage()
					.setUserName(Configuration.User.testUser)
					.setPassword(Configuration.Password.testPassword)
					.clickSignIn();		
		}
		
		else if (Configuration.Enviornment.baseEnviornment.equalsIgnoreCase("local")) {
			Source	.DriverFactory().openBrowser(Browser);
			
			Source	.SeleniumHelper().goToUrl(Configuration.Url.localPortal)
					.GetSource()
					.LogInPage()
					.setUserName(Configuration.User.devUser)
					.setPassword(Configuration.Password.devPassword)
					.clickSignIn();
		}
		
		if(module.equalsIgnoreCase(MyHomePage)) {
			Source 	.NavigationMenuBar()
					.clickMyHomePage();
		}else if(module.equalsIgnoreCase(Reports)) {
			Source 	.NavigationMenuBar()
					.clickReports();
		}else if(module.equalsIgnoreCase(People)) {
			Source 	.NavigationMenuBar()
					.clickPeople();
		}else if(module.equalsIgnoreCase(Organization)) {
			Source 	.NavigationMenuBar()
					.clickOrganization();
		}else if(module.equalsIgnoreCase(AssessmentForms)) {
			Source 	.NavigationMenuBar()
					.clickAssessmentForms();
		}else if(module.equalsIgnoreCase(Authorization)) {
			Source 	.NavigationMenuBar()
					.clickAuthorization();
		}else if(module.equalsIgnoreCase(Notes)) {
			Source 	.NavigationMenuBar()
					.clickNotes();
		}else if(module.equalsIgnoreCase(Planning)) {
			Source 	.NavigationMenuBar()
					.clickPlanning();
		}else if(module.equalsIgnoreCase(ReportableEvent)) {
			Source 	.NavigationMenuBar()
					.clickReportableEvent();
		}else if(module.equalsIgnoreCase(Search)) {
			Source 	.NavigationMenuBar()
					.clickSearch();
		}else if(module.equalsIgnoreCase(Agreement)) {
			Source 	.NavigationMenuBar()
					.clickAgreement();
		}else if(module.equalsIgnoreCase(Classes)) {
			Source 	.NavigationMenuBar()
					.clickClasses();
		}else if(module.equalsIgnoreCase(QuickLinks)) {
			Source 	.NavigationMenuBar()
					.clickQuickLinks();
		}else if(module.equalsIgnoreCase(Administrator)) {
			Source 	.NavigationMenuBar()
					.clickAdministrator();
		}else {
			Log.error(module + ": Module chosen does not exist");
		}

	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		String MethodName = result.getName();
		
		if(ITestResult.FAILURE == result.getStatus()) {
			Source.SeleniumHelper().takeScreenShot(MethodName);
		}
		System.out.println(Data.EmptyString);
		Source.SeleniumHelper().sleep(2);
		Source.SeleniumHelper().quitBrowser();
		
	}
	
}
