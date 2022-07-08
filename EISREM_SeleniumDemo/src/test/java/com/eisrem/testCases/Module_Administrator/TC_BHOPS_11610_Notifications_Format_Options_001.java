package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11610_Notifications_Format_Options_001 extends BaseHook {
	
	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Notifications_Format_Options_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Confirm dropdown values for Format");
					Source	.AdministratorNavigator()
							.clickNotifications()
							.clickAdd()
							.SetConditionsAccord()
							.setType(DataFixForm)
							.setPage(DataFixForm)
							.setQuestion("Agency Name")
							.confirmFormatValues() //Soft Asserts run in this method call
							.GetSource()
							.NotificationsPage()
							.clickBackToNotifications()
							.clickDiscard();
					SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
	
	

