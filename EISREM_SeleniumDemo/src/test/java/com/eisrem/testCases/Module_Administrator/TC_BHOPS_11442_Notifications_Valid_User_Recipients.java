package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11442_Notifications_Valid_User_Recipients extends BaseHook {
	
	@Test(priority=1, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Notifications_Valid_User_Recipients(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
				SeleniumHelper.log.info("Adding a Notification, confirming that User recipients MUST be valid/selected before clicking 'Complete'.");
				Expected = "Please enter a User";
				Actual = Source	.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.clickActiveToggle()
								.setNotificationName("SELENIUM NOTIFICATION")
								.setNotificationsCriteria(DataFixForm)
								.GetSource()
								.SetConditionsAccord()
								.setType(DataFixForm)
								.setPage(DataFixForm)
								.setQuestion("Agency Name")
								.selectFormat("TYPE/ANSWER IS EDITED")
								.clickSetConditionsAdd()
								.GetSource()
								.WhenAccord()
								.clickWhenAccord()
								.setNotifyIn("15")
								.selectWhenFormat(1)
								.setWhenDaysTillExpiration("1")
								.clickWhoRecipientsAccord()
								.clickAdd()
								.WhoAccord()
								.selectType(1)
								.searchForUser("taran")
								.clickComplete()
								.Pagefactory()
								.readTopErrorMessage(1);
				SoftAssert.assertEquals(Actual, Expected);
				
				Expected = "WILSON, TARAN, COMPUTER PROGRAMMER/ USER";
				Actual = Source	.WhoAccord()
								.setUser("taran")
								.clickComplete()
								.NotificationsPage()
								.clickSubmitExit()
								.GetSource()
								.Pagefactory()
								.clickGoBackToList()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.NotificationsPage()
								.clickWhoRecipientsAccord()
								.readFirstResultNameType();
				SoftAssert.assertEquals(Actual, Expected);
				
					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}

}



