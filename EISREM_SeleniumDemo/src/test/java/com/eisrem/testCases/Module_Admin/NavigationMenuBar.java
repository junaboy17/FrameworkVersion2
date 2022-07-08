package com.eisrem.testCases.Module_Admin;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;


public class NavigationMenuBar extends BaseHook{

	@Test(priority=1,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void AppAreasTitle(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying App Areas title text");
		Expected = "App Areas";
		Actual = Source .NavigationMenuBar()
						.readAppAreasTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=2,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void MyHomePageLink(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Verifying My Home Page link text");
		Expected = "MY HOMEPAGE";
		Actual = Source .NavigationMenuBar()
						.readMyHomePageTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying My Home Page link function");
		Source			.NavigationMenuBar()
						.clickMyHomePage();

		Expected = "My Home Page";
		Actual = Source	.MyHomePage()
						.readMyHomePageTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=3,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void ReportsLink(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Verifying Reports link text");
		Expected = "REPORTS";
		Actual = Source .NavigationMenuBar()
						.readReports();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Reports link function");
	     Source			.NavigationMenuBar()
						.clickReports();

		Expected = "Reports";
		Actual = Source .ReportsPage()
						.readReportsTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}

	@Test(priority=4,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void ProcessWizardLink(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Verifying Process Wizard link text");
		Expected = "PROCESS WIZARD";
		Actual = Source .NavigationMenuBar()
						.readProcessWizardTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=5,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void PeopleLink(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying People link text");
		Expected = "PEOPLE";
		Actual = Source .NavigationMenuBar()
						.readPeopleTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying People link function");
	    Source			.NavigationMenuBar()
						.clickPeople();

		Expected = "People";
		Actual = Source .PeopleNavigator()
						.readPeopleTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=6,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void OrganizationLink(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Organization link text");
		Expected = "ORGANIZATION";
		Actual = Source .NavigationMenuBar()
						.readOrganizationTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Organization link function");
	    Source			.NavigationMenuBar()
						.clickOrganization();

		Expected = "Organizations";
		Actual = Source .OrganizationPage()
						.readOrganizationsTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=7,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void AssessmentFormsLink(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Assessment/Forms link text");
		Expected = "ASSESSMENT/FORMS";
		Actual = Source .NavigationMenuBar()
						.readAssessmentFormsLink();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=8,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void AuthorizationLink(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Authorization link text");
		Expected = "AUTHORIZATION";
		Actual = Source .NavigationMenuBar()
						.readAuthorization();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	

	@Test(priority=9,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void NotesLink(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Notes link text");
		Expected = "NOTES";
		Actual = Source .NavigationMenuBar()
						.readNotesLink();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=10,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void PlanningLink(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Planning link text");
		Expected = "PLANNING";
		Actual = Source .NavigationMenuBar()
						.readPlanningLink();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=11,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void ReportableEventLink(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Reportable event link text");
		Expected = "REPORTABLE EVENT";
		Actual = Source .NavigationMenuBar()
						.readReportableEventLink();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	

	@Test(priority=12,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void SearchLink(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Search link text");
		Expected = "SEARCH";
		Actual = Source .NavigationMenuBar()
						.readSearchLink();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Search link function");
	     		Source  .NavigationMenuBar()
						.clickSearch();

		Expected = "Search";
		Actual = Source .SearchPage()
						.readSearchBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=13,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void AgreementLink(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Verifying Agreement link text");
		Expected = "AGREEMENT";
		Actual = Source .NavigationMenuBar()
						.readAgreementLink();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Agreement link function");
	    Source			.NavigationMenuBar()
						.clickAgreement();

		Expected = "Agreement";
		Actual = Source .AgreementPage()
						.readAgreementTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=14,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void ClassesLink(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Classes link text");
		Expected = "CLASSES";
		Actual = Source .NavigationMenuBar()
						.readClassesLink();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Classes link function");
		Source			.NavigationMenuBar()
						.clickClasses();

		Expected = "Classes";
		Actual = Source .ClassesPage()
						.readClassesTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=15,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void QuickLink(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Quick Links link text");
		Expected = "QUICK LINKS";
		Actual = Source .NavigationMenuBar()
						.readQuickLinksLink();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Quick Links function");
		Source			.NavigationMenuBar()
						.clickQuickLinks();

		Expected = "Quick Links";
		Actual = Source .QuickLinksNavigator()
						.readQuickLinksTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=16,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void AdministratorLink(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Administrator Links link text");
		Expected = "ADMINISTRATOR";
		Actual = Source .NavigationMenuBar()
						.readAdministratorLink();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Administrator function");
		Source			.NavigationMenuBar()
						.clickAdministrator();

		Expected = "Types";
		Actual = Source .TypesPage()
						.readTypesTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
}
