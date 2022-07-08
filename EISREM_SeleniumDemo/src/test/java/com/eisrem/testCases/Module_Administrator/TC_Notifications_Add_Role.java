package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Notifications_Add_Role extends BaseHook{
	
	@Test(priority=1, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Notification_Add_Role_001(String Module) {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Adding a new Recipient to an existing notification and verifying success message");
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickNotifications()
								.DataTable()
								.setSearch("selenium")
								.clickFirstRow()
								.clickEdit()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.NotificationsPage()
								.clickWhoRecipientsAccord()
								.clickAdd()
								.WhoAccord()
								.selectType(2)
								.selectRole(10)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}