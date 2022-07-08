package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11836_Conducted_Types_Clear_Anchor_Check extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_Conducted_Types_Clear_Anchor_Check(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Clicking save and verifying form was saved without a peo_id after clicking clear anchor in Conducted types");
					Expected =	"Do you want to save your changes?";
					Actual = 	Source		.DataTable()
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
											.GetSource()
											.Assessment_FormsPage()
											.clickStartAssessment()
											.fillForm()
											.clickClearAnchor()
								            .readPopUpTitle();
											
					SoftAssert.assertEquals(Actual, Expected);
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}

}

	

