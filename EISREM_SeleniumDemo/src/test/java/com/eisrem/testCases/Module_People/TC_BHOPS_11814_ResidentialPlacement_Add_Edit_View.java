package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11814_ResidentialPlacement_Add_Edit_View extends BaseHook{

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_ResidentialPlacement_Add_001(String Module) {
		SoftAssert = new SoftAssert();

		try {
			Source.PeoplePage().AddPeople();
			
			SeleniumHelper.log.info("Verifying Successful Adding of Residential Placement record");
			Expected = "Residential Placement";
			Actual = Source		.PeopleNavigator()
								
								.clickResidentialPlacementTab()
								.GetSource()
								.ResidentialPlacementPage()
								.createResidentialPlacementIfNoData()
								.readResidentialPlacementTab();
			SoftAssert.assertEquals(Actual, Expected);
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	
	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_ResidentialPlacement_Edit_001(String Module) {
		SoftAssert = new SoftAssert();

		try {						
			SeleniumHelper.log.info("Verifying Successful Editing of Residential Placement record");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
							    .clickResidentialPlacementTab()
							    .createResidentialPlacementIfNoData()
							    .DataTable()					    
							    .clickFirstRow()
							    .clickEdit()
								.ResidentialPlacementPage()
								.setDischargeDate(Today)
								.setDescription(UpdateDescription)
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
	public void TC_ResidentialPlacement_View_001(String Module) {
		SoftAssert = new SoftAssert();

		try {		
			SeleniumHelper.log.info("Verifying Successful Viewing of Residential Placement record");
			Expected = View;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
							    .clickResidentialPlacementTab()
							    .createResidentialPlacementIfNoData()
							    .DataTable()
							    .clickFirstRow()
							    .clickView()
								.ResidentialPlacementPage()
								.clickBackToResidentialPlacementBtn()
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
