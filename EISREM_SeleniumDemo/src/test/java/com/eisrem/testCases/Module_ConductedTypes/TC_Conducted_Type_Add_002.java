package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Conducted_Type_Add_002 extends BaseHook {

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void Assessment_Add(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Anchoring an organization & verifying Add Assessment functionality");
					Expected =	"TC_Conducted_Types_Add_002/ Data Fix Form (V2)";
					Actual = 	Source		.DataTable()
											.setSearch(OrgDHHS)
											.clickFirstRow()
											.clickAnchor()
											.NavigationMenuBar()
											.clickAssessmentForms()
											.clickAdd()
											.Assessment_FormsPage()
											.selectAssessmentType("Data Fix Form (V2)/ Assessment")
											.setTitle("TC_Conducted_Types_Add_002")
											.setDescription("Type Data Fix Form (V2)/ Assessment")
											.GetSource()
											.Assessment_FormsPage()
											.clickStartAssessment()
											.fillForm()
											.clickSubmitAllPages()
											.clickGoBackToList()
											.DataTable()
											.readFirstResultNameType();
					SoftAssert.assertEquals(Actual, Expected);

					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
}