package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11433_Conducted_Types_Error_Message extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_Conducted_Types_Error_Check_People(String Module) {
		
		SoftAssert = new SoftAssert();
		
		Source.NavigationMenuBar().clickPeople().AddPeople();

		try{
					SeleniumHelper.log.info("Entering start date before client's start date on conducted type; ensuring error message is client-specific");
					Expected =	"Start Date should not be before client's Start Date. ("+ Today + ")";
					Actual = 	Source		.NavigationMenuBar()
											.clickPeople()
											.setSearch(FirstName, Clear)
											.clickFirstColumnLink()
											.clickAnchor()
											.NavigationMenuBar()
											.clickAssessmentForms()
											.clickAdd()
											.Assessment_FormsPage()
											.selectAssessmentType(DataFixFormV2Assessment)
											.setTitle("SELENIUM TEST")
											.setDescription(Description)
											.setStartDate("01/01/1900", Clear)
											.GetSource()
											.Assessment_FormsPage()
											.clickStartAssessment()
											.GetSource()
											.SeleniumHelper()
											.sleep(10)
											.GetSource()
											.FormPage()
											.fillForm()
											.clickSubmitAllPages()
											.readTopErrorMessage(2);
											
					SoftAssert.assertEquals(Actual, Expected);
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=2,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Conducted_Types_Error_Check_Location(String Module) {
		
		SoftAssert = new SoftAssert();
		
		Source.LocationsPage().addCompleteLocationAndSubmit("DHHS");

		try{
					SeleniumHelper.log.info("Entering start date before client's start date on conducted type; ensuring error message is location-specific");
					Expected =	"Start Date should not be before location's Start Date. (" + Today + ")";
					Actual = 	Source		.NavigationMenuBar()
											.clickOrganization()
											.setSearch("DHHS", Clear)
											.clickFirstRow()
											.clickAnchor()
											.OrganizationNavigator()
											.clickLocations()
											.DataTable()
											.clickFirstRow()
											.clickAnchor()
											.NavigationMenuBar()
											.clickAssessmentForms()
											.clickAdd()
											.Assessment_FormsPage()
											.selectAssessmentType(DataFixFormV2Assessment)
											.setTitle("SELENIUM TEST")
											.setDescription(Description)
											.setStartDate("01/01/1900", Clear)
											.GetSource()
											.Assessment_FormsPage()
											.clickStartAssessment()
											.GetSource()
											.SeleniumHelper()
											.sleep(10)
											.GetSource()
											.FormPage()
											.fillForm()
											.clickSubmitAllPages()
											.readTopErrorMessage(2);
											
					SoftAssert.assertEquals(Actual, Expected);
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
		
}
	
	

