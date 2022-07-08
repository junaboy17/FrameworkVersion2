package com.eisrem.testCases.Business.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class Admin_Notifications_Test extends BaseHook {

	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void Types(String Module) {
		
		SoftAssert = new SoftAssert();
		
		String title = "Data Fix " + RandNum4;
		String notificationName = "Business Selenium Data Fix Notification " + RandNum3;
		String message = "What needs to be fixed?";
		
		try{
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			Expected =	Success;
			Actual =	Source		.AdministratorNavigator()
									.clickNotifications()
									.clickAdd()
									.NotificationsPage()
									.setNotificationName(notificationName)
									.setDescription(Description)
									.setStartDate(PastDate5, Clear)
									.setEndDate(Tomorrow, Clear)
									.GetSource()
									.Pagefactory()
									.clickActiveToggle(True)
									.GetSource()
									.NotificationsPage()
									.clickSendEmailToggle(True)
									.GetSource()
									.SetConditionsAccord()
									.setType("1000075916")
									.setPage("1000007696")
									.setQuestion("1000032018")
									.selectAnswer("1000063309 Assessment/Forms")
									.selectFormat(NotificationFormat.ANSWER_IS_SELECTED.getName())
									.clickSetConditionsAdd()
									.GetSource()
									.NotificationsPage()
									.clickWhenAccord()
									.selectWhenFormat(NotificationWhenFormat.MINUTES.getIndex())
									.setWhenDaysTillExpiration("1")
									.selectWhenOccurance(NotificationWhenOccurance.UPON_SUBMISSION.getIndex())
									.setDaysAfterOccurance(NotificationWhenOccurance.SELECT.getIdAsString())
									.GetSource()
									.NotificationsPage()
									.clickWhoRecipientsAccord()
									.clickAdd()
									.WhoAccord()
									.setStartDate(PastDate5, Clear)
									.setEndDate(Tomorrow, Clear)
									.selectType(1)
									.setUser(SeleniumUserID)
									.clickComplete()
									.NotificationsPage()
									.clickMessageContent()
									.selectMessageContentType(1)
									.setMessageContentValue(message)
									.clickMessageContentAddCriteria()
									.GetSource()
									.MessageContentAccord()
									.selectMessageContentType(2,2)
									.selectMessageContentValue(2, 1)
									.clickMessageContentAddCriteria(2)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Adding an Assessment, filling Form and Starting Assessment");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickGoBackToList()
									.NavigationMenuBar()
									.clickPeople()
									.setSearch(JeanneID)
									.clickFirstRow()
									.clickAnchor()
									.NavigationMenuBar()
									.clickAssessmentForms()
									.clickAdd()
									.Assessment_FormsPage()
									.setStartDate(PastDate5, Clear)
									.setEndDate(Tomorrow, Clear)
									.GetSource()
									.Assessment_FormsPage()
									.selectAssessmentType("Data Fix Form (V2)/ Assessment")
									.setTitle(title)
									.clickStartAssessment()
									.GetSource()
									.FormPage()
									.selectValue(1, "Service", "Childrens")
									.setText(2, "Name", JeanneSignature)
									.setText(2, "Email", Email)
									.setText(2, "Agency", OrgDHHS)
									.setText(2, "Phone", PhoneNumber)
									.selectValue(3, "App", "Assessment/Forms")
									.clickSubmitAllPages()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Waiting for Notification and verifying Success");
			Expected =	message + JeanneID;
			Actual =	Source		.FormPage()
									.clickGoBackToPeople()
									.GetSource()
									.NavigationMenuBar()
									.clickMyHomePage()
									.GetSource()
									.SeleniumHelper()
									.sleep(300)
									.refreshPage()
									.GetSource()
									.MyHomePage()
									.readMyInboxFirstResultNameValue();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}



	@Test(priority=2,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void Forward_Notifications(String Module) {
	
	SoftAssert = new SoftAssert();
	
	String title = "Data Fix " + RandNum4;
	String notificationName = "Business Selenium Data Fix Notification " + RandNum3;
	String message = "What needs to be fixed?";
	
	
	try{
		SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
		Expected =	Success;
		Actual =	Source		.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.setNotificationName(notificationName)
								.setDescription(Description)
								.setStartDate(PastDate5, Clear)
								.setEndDate(Tomorrow, Clear)
								.GetSource()
								.Pagefactory()
								.clickActiveToggle(True)
								.GetSource()
								.NotificationsPage()
								.clickSendEmailToggle(True)
								.GetSource()
								.SetConditionsAccord()
								.setType("1000075916")
								.setPage("1000007696")
								.setQuestion("1000032018")
								.selectAnswer("1000063309 Assessment/Forms")
								.selectFormat(NotificationFormat.ANSWER_IS_SELECTED.getName())
								.clickSetConditionsAdd()
								.GetSource()
								.NotificationsPage()
								.clickWhenAccord()
								.selectWhenFormat(NotificationWhenFormat.MINUTES.getIndex())
								.setWhenDaysTillExpiration("1")
								.selectWhenOccurance(NotificationWhenOccurance.UPON_SUBMISSION.getIndex())
								.setDaysAfterOccurance(NotificationWhenOccurance.SELECT.getIdAsString())
								.GetSource()
								.NotificationsPage()
								.clickWhoRecipientsAccord()
								.clickAdd()
								.WhoAccord()
								.setStartDate(Today, Clear)
								.setEndDate(Tomorrow, Clear)
								.selectType(1)
								.setUser(SeleniumUserID)
								.clickComplete()
								.NotificationsPage()
								.clickMessageContent()
								.selectMessageContentType(1)
								.setMessageContentValue(message)
								.clickMessageContentAddCriteria()
								.GetSource()
								.MessageContentAccord()
								.selectMessageContentType(2,2)
								.selectMessageContentValue(2, 1)
								.clickMessageContentAddCriteria(2)
								.clickSubmit()
								.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);	
		
		SeleniumHelper.log.info("Adding an Assessment, filling Form and Starting Assessment");
		Expected =	Success;
		Actual =	Source		.Pagefactory()
								.clickGoBackToList()
								.NavigationMenuBar()
								.clickPeople()
								.setSearch(JeanneID)
								.clickFirstRow()
								.clickAnchor()
								.NavigationMenuBar()
								.clickAssessmentForms()
								.clickAdd()
								.Assessment_FormsPage()
								.setStartDate(PastDate5, Clear)
								.setEndDate(Tomorrow, Clear)
								.GetSource()
								.Assessment_FormsPage()
								.selectAssessmentType("Data Fix Form (V2)/ Assessment")
								.setTitle(title)
								.clickStartAssessment()
								.GetSource()
								.FormPage()
								.selectValue(1, "Service", "Childrens")
								.setText(2, "Name", JeanneSignature)
								.setText(2, "Email", Email)
								.setText(2, "Agency", OrgDHHS)
								.setText(2, "Phone", PhoneNumber)
								.selectValue(3, "App", "Assessment/Forms")
								.clickSubmitAllPages()
								.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);	
		
		SeleniumHelper.log.info("Waiting for Notification and verifying Success");
		Expected =	message + JeanneID;
		Actual =	Source		.FormPage()
								.clickGoBackToPeople()
								.GetSource()
								.NavigationMenuBar()
								.clickMyHomePage()
								.GetSource()
								.SeleniumHelper()
								.sleep(300)
								.refreshPage()
								.GetSource()
								.MyHomePage()
								.readMyInboxFirstResultNameValue();
		SoftAssert.assertEquals(Actual, Expected);	
		
		SeleniumHelper.log.info("Forwarding Notification and verifying Success");
		Expected =	Success;
		Actual = 	Source 		.MyHomePage()
								.clickMyInboxFirstResultID()
								.GetSource()
								.MyInboxManagePage()
								.clickForwardToAnotherRecipient()
								.setForwardMessage("Did you get this forwarded message? If so Clap twice", Clear)
								.setAvailableSearch("598532", Clear)
								.selectAvailableClient(0)
								.GetSource()
								.ForwardPage()
								.clickAddName()
								.clickForward()
								.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Going Back To Home Page and verifying Success");
		Expected =	message + JeanneID;
		Actual = 	Source 		.ForwardPage()
								.clickGoBackToInbox()
								.MyInboxManagePage()
								.clickBackToMyInbox()
								.GetSource()
								.MyHomePage()
								.readMyInboxFirstResultNameValue();			
				SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Logging Off");
		Expected =	"Login";
		Actual = 	Source 		.NavigationMenuBar()
								.LogOut()
								.GetSource()
								.LogInPage()
								.readLogInTitle();
				SoftAssert.assertEquals(Actual, Expected);	
				
		SeleniumHelper.log.info("Logging In as Admin to update user password");
		Expected ="";
			Actual = 	Source 	.LogInPage()
								.setUserName("GEORGEB_SELENIUM", Clear)
								.setPassword("Summer13#", Clear)
								.clickSignIn()
								.GetSource()
								.MyHomePage()
								.clickMyInboxFirstResultID()
								.GetSource()
								.MyInboxManagePage()
								.readSubject();
				SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Dismissing the Notification and Verifying Success");
		Expected =Success;
			Actual = Source 	.MyInboxManagePage()
								.clickDismiss()
								.readPopUpTitle();
				SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Reading My Home Page Title");
		Expected ="My Home Page";
			Actual = Source 	.MyInboxManagePage()
								.clickGoBackToList()
								.MyHomePage()
								.readMyHomePageTitle();
				SoftAssert.assertEquals(Actual, Expected);
				
		SoftAssert.assertAll();		
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

}
}