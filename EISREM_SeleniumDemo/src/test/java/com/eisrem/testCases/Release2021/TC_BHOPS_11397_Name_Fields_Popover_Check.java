package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11397_Name_Fields_Popover_Check extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Popover_Check(String Module) {

		SoftAssert = new SoftAssert();
		String Actual2;
		String Actual3;

		try{
			SeleniumHelper.log.info("Verifying popovers exist for First Name, Middle Name, and Last Name fields.");
			Expected =	"Incorrect formatting of field - (\"A-Z\", ' and \"-\")";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.setFirstName("Test123")
										.setMiddleName("")
										.readPopover();
			Actual2 =	Source.SeleniumHelper()
                    					.clearElement(Source.DemographicsPage().FirstNameTextBox)
                    					.GetSource()
                    					.DemographicsPage()
					
										.setFirstName("Test")
										.setMiddleName("Test!")
										.setLastName("")
										.readPopover();
			Actual3 =	Source.SeleniumHelper()
										.clearElement(Source.DemographicsPage().MiddleNameTextBox)
										.clearElement(Source.DemographicsPage().FirstNameTextBox)
										.GetSource()
										.DemographicsPage()
										.setLastName("Test123")
										.setMiddleName("T")
										.setFirstName("Test")
										.readPopover();
			
			SoftAssert.assertEquals(Actual, Expected);
			SoftAssert.assertEquals(Actual2, Expected);
			SoftAssert.assertEquals(Actual3, Expected);
			
			SoftAssert.assertAll();		
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
}
