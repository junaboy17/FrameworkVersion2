package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_12461_Referrals_Services_Add_Edit_View extends BaseHook{

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_ReferralsServices_Add_001(String Module) {
		SoftAssert = new SoftAssert();

		try {
			Source.PeoplePage().AddPeople();
			
			SeleniumHelper.log.info("Verifying Successful Adding of Referrals Services record");
			Expected = Success;
			Actual = Source		.PeopleNavigator()
								.clickReferralsServicesTab()
							    .DataTable()
							    .clickAdd()
								.ReferralsServicesPage()
								.setAdmitDate(Today, Clear)
								.selectType(ReferralsType.IN_SERVICE_CSR.getIndex())
								.selectService(ReferralsService.HCT.getIndex())
								.setCaseId(String.valueOf(SeleniumHelper.generateRandomNumber(10)), Clear)
								.setServiceOrganization(OrgDHHS, Clear)
								.setReferralServicesDescription(Description)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			Source.DataTable().clickPopupOk();
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	
	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_ReferralsServices_Edit_001(String Module) {
		SoftAssert = new SoftAssert();

		try {						
			SeleniumHelper.log.info("Verifying Successful Editing of Residential Placement record");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
							    .clickReferralsServicesTab()
							    .createReferralsServicesIfNoData()
							    .DataTable()					    
							    .clickFirstRow()
							    .clickEdit()
								.ReferralsServicesPage()
								.setDischargeDate(Today)
								.setReferralServicesDescription(UpdateDescription)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			Source.DataTable().clickPopupOk();
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_ReferralsServices_View_001(String Module) {
		SoftAssert = new SoftAssert();

		try {		
			SeleniumHelper.log.info("Verifying Successful Viewing of Residential Placement record");
			Expected = View;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
							    .clickReferralsServicesTab()
							    .createReferralsServicesIfNoData()
							    .DataTable()
							    .clickFirstRow()
							    .clickView()
								.ReferralsServicesPage()
								.clickBackToReferralsServicesBtn()
								.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
