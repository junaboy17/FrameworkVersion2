package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_MyHomePage_No_Custom_Error_Msg extends BaseHook{

	@Test(priority = 1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_MyHomePage_No_Custom_Error_Msg_001(String Module) {
		
		SoftAssert = new SoftAssert();
		
		String OrgName = "Selenium Org" + SeleniumHelper.generateRandomNumber(5);

		try{
			SeleniumHelper.log.info("Adding an Organization and verifying Success Message");
			Expected =	Success;						
			Actual = Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrgName)
								.selectOrganizationType(1)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding an Organization with the same name and verifying Error Message");
			Expected =	"An Organization with same name already exists.";						
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickOrganizations()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrgName)
								.selectOrganizationType(1)
								.clickSubmit()
								.readTopErrorMessage(2);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Navigating to My Homepage and verifying Error Message does not appear after leaving the Add Organization page");
			ExpectedB =	F;						
			ActualB = Source	.NavigationMenuBar()
								.clickMyHomePage()
								.clickDiscard()
								.SeleniumHelper()
								.ifWebElementExists(Source.Pagefactory().ErrorMessage);
			SoftAssert.assertEquals(ActualB, ExpectedB);
			
			SeleniumHelper.log.info("Adding an Organization with the same name and verifying Error Message");
			Expected =	"An Organization with same name already exists.";					
			Actual = Source		.NavigationMenuBar()
								.clickOrganization()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrgName)
								.selectOrganizationType(1)
								.clickSubmit()
								.readTopErrorMessage(2);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Navigating to Search page and verifying Error Message does not appear after leaving the Add Organization page");
			ExpectedB =	F;						
			ActualB = Source	.NavigationMenuBar()
								.clickSearch()
								.clickDiscard()
								.SeleniumHelper()
								.ifWebElementExists(Source.Pagefactory().ErrorMessage);
			SoftAssert.assertEquals(ActualB, ExpectedB);
			
			SoftAssert.assertAll();
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}
