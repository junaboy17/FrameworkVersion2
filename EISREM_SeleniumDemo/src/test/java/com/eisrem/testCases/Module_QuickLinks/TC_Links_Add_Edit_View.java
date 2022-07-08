package com.eisrem.testCases.Module_QuickLinks;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Links_Add_Edit_View extends BaseHook{


	@Test(priority=1,dataProvider = QuickLinks, dataProviderClass = DataProviders.class)
	public void TC_Links_Add_001(String Module) {
		SoftAssert = new SoftAssert();

		String DisplayedName = "SELENIUM TEST LINK" + RandNum2;
		
		try{
		SeleniumHelper.log.info("Adding Quick Links and verifying successful add");
		Expected =Success;
		Actual = Source		.DataTable()
							.clickAdd()
							.QuickLinksPage()
							.setDisplayedName(DisplayedName)
							.setLinkURL(Configuration.Url.basePortal)
							.clickActiveToggle(True)
							.setDescription("Selenium Description" + RandNum4)
							.DataTable()
							.clickAdd()
							.ServicePopulationsAvailableAccord()
							.selectServicePopulation(1)
							.clickComplete()
							.DataTable()
							.readPopUpTitle();																
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Link was added successfully");
		Expected = DisplayedName;
		Actual = Source		.DataTable()
							.clickPopupOk()
							.DataTable()
							.clickBackToList()
							.DataTable()
							.readFirstResultNameType();											
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Clicking Link and verifying if Link is functional");
		Expected = "Login";
		Actual = Source		.DataTable()
							.clickFirstRowNameLink()
							.GetSource()
							.SeleniumHelper()
							.switchWindow()
							.GetSource()
							.LogInPage()
							.readLogInTitle();											
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	}
	
	@Test(priority=2,dataProvider = QuickLinks, dataProviderClass = DataProviders.class)
	public void TC_Links_Edit_001(String Module) {
		SoftAssert = new SoftAssert();

		String Description = "UPDATED SELENIUM TEST LINK" + RandNum2;
		String NewName = "SELENIUMTEST" + RandNum4;
		
		try{
		SeleniumHelper.log.info("Verifying successful Quick Links Add");
		Expected =Success;
		Actual = Source		.DataTable()
							.clickFirstRow()
							.clickEdit()
							.QuickLinksPage()
							.setDisplayedName(NewName, Clear)
							.setLinkURL(Configuration.Url.devPortal, Clear)
							.setDescription(Description, Clear)
							.DataTable()
							.clickSubmit()
							.readPopUpTitle();																		
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Quick Link Displayed Name, Link URL, and Description was changed");
		Expected = NewName;
		Actual = Source		.DataTable()
							.clickPopupOk()
							.DataTable()
							.clickFirstRow()
							.clickEdit()
							.SeleniumHelper()
							.readAttribute(Source.QuickLinksPage().DisplayedNameTextBox, "value");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = Configuration.Url.devPortal;
		Actual = Source		.SeleniumHelper()
							.readAttribute(Source.QuickLinksPage().LinkURLTextBox, "value");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = Description;
		Actual = Source		.SeleniumHelper()
							.readAttribute(Source.QuickLinksPage().DescriptionTextBox, "value");
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Quick Link name was changed in the DataTable");
		Expected = NewName;
		Actual = Source		.DataTable()
							.clickBackToList()
							.DataTable()
							.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Quick Link URL has been changed");
		Expected = "Login";
		Actual = Source		.DataTable()
							.clickFirstRowNameLink()
							.GetSource()
							.SeleniumHelper()
							.switchWindow()
							.GetSource()
							.LogInPage()
							.readLogInTitle();
																					
		SoftAssert.assertEquals(Actual, Expected);
				
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=3,dataProvider = QuickLinks, dataProviderClass = DataProviders.class)
	public void TC_Links_View_001(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Verifying Quick Links View Functionality");
		Expected = True;
		Actual = Source		.DataTable()
							.clickFirstRow()
							.clickView()
							.SeleniumHelper()
							.readAttribute(Source.QuickLinksPage().DisplayedNameTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying text fields cannot be changed");
		Expected = True;
		Actual = Source		.SeleniumHelper()
							.readAttribute(Source.QuickLinksPage().LinkURLTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source		.SeleniumHelper()
							.readAttribute(Source.QuickLinksPage().DescriptionTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
				
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	
}