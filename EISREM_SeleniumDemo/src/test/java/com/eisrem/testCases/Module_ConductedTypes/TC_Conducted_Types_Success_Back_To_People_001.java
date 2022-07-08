package com.eisrem.testCases.Module_ConductedTypes;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Conducted_Types_Success_Back_To_People_001 extends BaseHook  {

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void confirmBackToPeople(String Module) {
		
		SoftAssert = new SoftAssert();	
		String ctTitle = "Conducted Type "  + RandNum4;
		String ctType = "Data Fix Form (V2)/ Assessment";
		By PeopleLink = By.xpath("//a[@id='4']");
		try {
			SeleniumHelper.log.info("Anchoring on a client, conducting an assessment and " + 
					"confirming Back To People functionality.");
						
			Source	
					.DataTable()
					.setSearch(TestClient2)
					.clickFirstRow()
					.clickAnchor()
					.NavigationMenuBar()
					.clickAssessmentForms()
					.DataTable()
					.clickAdd()
					.Assessment_FormsPage()
					.setTitle(ctTitle)
					.selectAssessmentType(ctType)
					.setDescription("Selenium Description")
					.GetSource()
					.Assessment_FormsPage()
					.clickStartAssessment()
					.fillForm()
					.clickSubmitAllPages()
					.clickGoBackToPeople()
					;
			
			Expected = "active";
			Actual = 	Source	
						.SeleniumHelper()
						.getWebElement(PeopleLink)
						.getAttribute("class")						
						;
			
			SoftAssert.assertEquals(Actual, Expected);
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}

