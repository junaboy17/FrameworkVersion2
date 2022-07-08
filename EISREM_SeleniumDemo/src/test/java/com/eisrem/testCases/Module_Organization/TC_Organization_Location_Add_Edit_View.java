package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Organization_Location_Add_Edit_View extends BaseHook{
	
	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Location_Add_001(String Module) {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Add Organization to work with");
			String orgId = Source.OrganizationPage().addCompleteOrganizationPageSubmitAndReturnId();
			
			SeleniumHelper.log.info("Verifying Successful Adding Location");
			Expected = Success;
			Actual = Source		.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.clickSubmit()
								.GetSource()
								.SeleniumHelper()
								.continueIfErrors()
								.GetSource()
								.LocationsPage()
								.setName(LocationName)
								.selectType(LocationType.OTHER_LOCATION.getName())
								.toggleActive(T)
								.DataTable()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(ServicePopulations.ADULT_MH.getName())
								.setDescription(Description)
								.clickComplete()
								.DataTable()
								.clickSubmit()
								.readPopUpTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			Source.DataTable().clickPopupOk();
			
			Source.LocationsPage().endDateLocation(orgId, LocationName);
			Source.OrganizationPage().endDateOrganization(orgId);
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Location_Edit_001(String Module) {
		SoftAssert = new SoftAssert();

		try {
			
			SeleniumHelper.log.info("Verifying Successful Editing Location");
			Expected = Success;
			Actual = Source	.DataTable()
							.clickFirstRow()
							.clickAnchor()
							.OrganizationNavigator()
							.clickLocations()
							.clickFirstRow()
							.clickEdit()
							.LocationsPage()
							.setDescription(UpdateDescription, Clear)
							.GetSource()
							.ServicePopulationsAvailableAccord()
							.clickFirstRow()
							.clickEdit()
							.ServicePopulationsAvailableAccord()
							.setDescription(UpdateDescription, Clear)
							.clickComplete()
							.LocationsPage()
							.clickSubmit()
							.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			
			SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
		
	@Test(priority=3,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Location_View_001(String Module) {
		SoftAssert = new SoftAssert();

		try {
			
			SeleniumHelper.log.info("Verifying Successful Viewing Location");
			Expected = "Locations";
			Actual = Source	.DataTable()
							.clickFirstRow()
							.clickAnchor()
							.OrganizationNavigator()
							.clickLocations()
							.clickFirstRow()
							.clickView()
							.LocationsPage()
							.clickBack()
							.OrganizationNavigator()
							.readLocationsTab();	
			SoftAssert.assertEquals(Actual, Expected);	
			
			
			SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}
