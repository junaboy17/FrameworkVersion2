package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class People_Add_Edit_View_Test extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void People_Add_002(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying successful addition of an individual in People module");
			Expected =	"Success!";
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillAllDemogrphicsWithIdentifier()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void People_View_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Anchoring on to a person, clicking view, & verifying view functionality");
			Expected =	True;
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickView()
									.SeleniumHelper()
									.readAttribute(Source.DemographicsPage().FirstNameTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying if fields are disabled while in view mode");
			Expected =	True;
			Actual =	Source		.SeleniumHelper()
									.readAttribute(Source.DemographicsPage().LastNameTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	True;
			Actual =	Source		.SeleniumHelper()
									.readAttribute(Source.DemographicsPage().GenderDropDown, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	True;
			Actual =	Source		.SeleniumHelper()
									.readAttribute(Source.DemographicsPage().DateOfBirthTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	
}
