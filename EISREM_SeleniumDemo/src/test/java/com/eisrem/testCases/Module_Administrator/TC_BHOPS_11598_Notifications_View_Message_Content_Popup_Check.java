package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11598_Notifications_View_Message_Content_Popup_Check extends BaseHook {

	
	@Test(priority=1, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Notifications_View_Message_Content_Popup_Check(String Module) {
	
		SoftAssert = new SoftAssert();
		try{
			SeleniumHelper.log.info("Save/discard popup should not appear after clicking back to notifications");

			Expected="false";
			Actual=Source	.AdministratorNavigator()
							.clickNotifications()
							.clickFirstRow()
							.clickView()
							.NotificationsPage()
							.clickMessageContent()
							.clickBackToNotifications()
							.isSaveDiscardPopupPresent(10);
		 		
			SoftAssert.assertEquals(Actual, Expected);
		 
			SoftAssert.assertAll();	
			
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

	}

}


