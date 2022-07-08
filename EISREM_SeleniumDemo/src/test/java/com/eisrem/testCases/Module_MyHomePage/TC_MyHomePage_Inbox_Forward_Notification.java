package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_MyHomePage_Inbox_Forward_Notification extends BaseHook{

	@Test(priority=1,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void TC_MyHomePage_Inbox_Forward_Notification_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Forwarding Inbox Message and verifying Success message");
			
			String subject = Source		.MyHomePage()
										.clickMyInboxFirstResultID()
										.GetSource()
										.SeleniumHelper()
										.getAttribute(Source.MyInboxManagePage().SubjectTextBox, "value");
			
			Expected =	Success;						
			Actual = Source		.MyInboxManagePage()
								.clickForwardToAnotherRecipient()
								.setForwardMessage("Selenium Forward Message")
								.setAvailableSearch("571797")
								.selectAvailableClient(0)
								.clickAddName()
								.clickForward()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Logging out and logging back in as different user to confirm Inbox Message successfully received");
			Expected =	"FWD: " + subject;	
			Actual = Source		.Pagefactory()
								.clickGoBackToInbox()
								.MyInboxManagePage()
								.clickBackToMyInbox()
								.GetSource()
								.NavigationMenuBar()
								.clickMyHomePage()
//								.GetSource()
//								.NavigationMenuBar()
//								.clickWelcomeUser()
//								.clickLogOut()
//								.setUserName(Configuration.User.BusinessUser)
//								.setPassword(Configuration.Password.BusinessPass)
//								.clickSignIn()
//								.GetSource()
//								.MyHomePage()
								.clickMyInboxFirstResultID()
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.MyInboxManagePage().SubjectTextBox, "value");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Dismissing forwarded inbox message");
			Expected =	Success;	
			Actual = Source		.MyInboxManagePage()
								.clickDismiss()
								.GetSource()
								.Pagefactory()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}
