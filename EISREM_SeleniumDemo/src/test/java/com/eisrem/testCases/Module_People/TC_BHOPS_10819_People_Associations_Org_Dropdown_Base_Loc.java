package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_10819_People_Associations_Org_Dropdown_Base_Loc extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void People_Add_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying if organization search list is sorted with base location first");
			ExpectedB =	true;
						Source		.PeoplePage()
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickAssociationsTab()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.OrganizationTextBox.sendKeys("ACME");
			ActualB = 	Source		.AssociationsPage()
									.checkIfBaseLocsIsFirst();
											
			SoftAssert.assertEquals(ActualB, ExpectedB);
			
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
}
