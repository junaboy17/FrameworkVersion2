package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11671_Conducted_Types_UserLocation_Check extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Conducted_Types_UserLocation_Check(String Module){
		
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Filling out an assessment for a person with Orgnaization other then base "
					+ "& Verifying if the organization is not changed to users default base location");
			Expected ="1";
			Actual =	Source		.DataTable()
									.setSearch("Chris")
									.isEmptyThrowError()
									.clickFirstRow()
									.clickAnchor()
									.NavigationMenuBar()
									.clickAssessmentForms()
									.clickAdd()
									.Assessment_FormsPage()
									.selectAssessmentType(DataFixFormV2Assessment)
									.selectOrganization(SeleniumHelper.generateRandomNumber(2, 24))
									.setTitle("Selenium Test")
									.setDescription(Description)
									.GetSource()
									.Assessment_FormsPage()
									.clickStartAssessment()
									.fillForm()
									.clickSubmitAllPages()
									.clickGoBackToList()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.Assessment_FormsPage()
									.clickAssessmentsFormsTab()
									.GetSource()
									.SeleniumHelper()
									.readAttribute(Source.Assessment_FormsPage().OrganizationDropDown, "value");
			SoftAssert.assertNotEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying if Organization field is disabled in edit mode");
			Expected = True;
			Actual =	Source		.SeleniumHelper()
									.readAttribute(Source.Assessment_FormsPage().OrganizationDropDown, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}	

}
