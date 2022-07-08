package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11609_Notifications_Criteria_Contains_Enabled_Disabled_Checks extends BaseHook {
	
	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Notifications_Criteria_Contains_Disabled(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Navigating to Notifications, checking to see if non-text field questions disable the CONTAINS format");
					Expected = False;
					Actual = Source	.AdministratorNavigator()
									.clickNotifications()
									.clickAdd()
									.SetConditionsAccord()
									.setType("1000074596")
									.setPage("1000005416")
									.setQuestion("1000023228")
									.clickFormatDropDown()
									.readContainsFormatEnabled();
					SoftAssert.assertEquals(Actual, Expected);


					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=2,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Notifications_Criteria_Contains_Enabled(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Navigating to Notifications, checking to see if text field questions enable the CONTAINS format");
					Expected = True;
					Actual = Source	.AdministratorNavigator()
									.clickNotifications()
									.clickAdd()
									.SetConditionsAccord()
									.setType("1000074596")
									.setPage("1000005416")
									.setQuestion("1000023170")
									.clickFormatDropDown()
									.readContainsFormatEnabled();
					SoftAssert.assertEquals(Actual, Expected);


					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}

}



