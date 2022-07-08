package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;
public class TC_BHOPS_11401_Documents_End_Date_Message extends BaseHook {   
	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Documents_End_Date_Message_Confirm_Message_Text(String Module) {
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Navigating to Organization, using DHHS to add a document and ensure that the end-date message appears when filled out.");
					Expected = "End Dating this document will make it no longer available for viewing. Continue?";
					Actual = Source	.OrganizationNavigator()
									.setSearch(OrgDHHS)
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.clickDocuments()
									.clickAdd()
									.DocumentsPage()
									.setEndDate(Today)
									.readPopUpMessage();
					SoftAssert.assertEquals(Actual, Expected);


					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=2,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Documents_End_Date_Message_Confirm_Cleared_Field(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Navigating to Organization, using DHHS to add a document and ensure that the end-date field is cleared out when the user selects the No option on the popup.");
					Expected = "\"\"";
					Actual = Source	.OrganizationNavigator()
									.setSearch(OrgDHHS)
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.clickDocuments()
									.clickAdd()
									.DocumentsPage()
									.setEndDate(Today)
									.clickNo()
									.DocumentsPage()
									.readOriginalEndDateValue();
					SoftAssert.assertEquals(Actual, Expected);
		
		
					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=3,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Documents_End_Date_Message_Confirm_End_Date_Field(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Navigating to Organization, using DHHS to add a document and ensure that the end-date field remains when the user selects the Yes option on the popup.");
					Expected = "\"" + Today + "\"";
					Actual = Source	.OrganizationNavigator()
									.setSearch(OrgDHHS)
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.clickDocuments()
									.clickAdd()
									.DocumentsPage()
									.setEndDate(Today)
									.clickYes()
									.DocumentsPage()
									.readEndDateValue();
					SoftAssert.assertEquals(Actual, Expected);
		
		
					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
}
	
	

