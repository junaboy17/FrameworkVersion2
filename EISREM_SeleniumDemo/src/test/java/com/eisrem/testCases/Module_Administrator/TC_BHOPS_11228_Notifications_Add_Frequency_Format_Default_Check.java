package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11228_Notifications_Add_Frequency_Format_Default_Check extends BaseHook {

	
	@Test(priority=1, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Notifications_Add_Frequency_Format_Default_Check(String Module) {
	
		SoftAssert = new SoftAssert();
		try{
			SeleniumHelper.log.info("Save/discard popup should not appear after clicking back to notifications");

			
			Source	.AdministratorNavigator()
					.clickNotifications()
					.clickAdd()
					.NotificationsPage()
					.clickWhenAccord()
					.confirmFrequencyValue("5")
					.selectWhenFormat(NotificationWhenFormat.MINUTES.getIndex());
		 
			SoftAssert.assertAll();	
			
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
}
}
