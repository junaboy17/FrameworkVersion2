package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class ReferralsServicesPageTest extends BaseHook{

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void ReferralsServicesPageTitlesCheck(String Module) {
		SoftAssert = new SoftAssert();

		try{		
			SeleniumHelper.log.info("Verifying 'Referrals Services' link title");
			Expected ="Referrals/Services";
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickReferralsServicesTab()
								.readReferralsServicesTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Admit Date' title");
			Expected ="Admit/Referral Date *";
			Actual = Source		.DataTable()
								.clickAdd()
								.ReferralsServicesPage()
								.readAdmitDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Discharge Date' title");
			Expected ="Discharge Date";
			Actual = Source		.ReferralsServicesPage()
								.readDischargeDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Type' title");
			Expected ="Type *";
			Actual = Source		.ReferralsServicesPage()
								.readTypeDropdownTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Description' title");
			Expected ="Description";
			Actual = Source		.ReferralsServicesPage()
								.readDescriptionTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Case Id' title");
			Expected ="Case ID *";
			Actual = Source		.ReferralsServicesPage()
								.readCaseIdTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Service' title");
			Expected ="Service *";
			Actual = Source		.ReferralsServicesPage()
								.readServiceDropdownTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Submit' btn title");
			Expected ="Submit";
			Actual = Source		.ReferralsServicesPage()
								.readSubmitBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Print' btn title");
			Expected ="Print";
			Actual = Source		.ReferralsServicesPage()
								.readPrintBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Back To Referrals Services' btn title");
			Expected ="Back To Referrals/Services";
			Actual = Source		.ReferralsServicesPage()
								.readBackToReferralsServicesBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
		
	
	
}