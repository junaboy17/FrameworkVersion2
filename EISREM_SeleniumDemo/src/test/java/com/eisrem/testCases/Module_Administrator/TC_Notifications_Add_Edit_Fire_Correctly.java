package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;


public class TC_Notifications_Add_Edit_Fire_Correctly extends BaseHook {
	
	@Test(priority=1, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Notifications_Add_Edit_Fire_Correctly_001(String Module) {
		
		SoftAssert = new SoftAssert();
		String notification1Name = "BHOPS-11130 Tickler 1: Edited." + SeleniumHelper.generateRandomNumber(6);
		String notification1Created = "BHOPS-11130 Tickler 1: Edited." + SeleniumHelper.generateRandomNumber(6);
		
		String notification2Name = "BHOPS-11130 Tickler 2: Entered." + SeleniumHelper.generateRandomNumber(6);
		String notification2Created = "BHOPS-11130 Tickler 2: Entered." + SeleniumHelper.generateRandomNumber(6);

		try{
			
				SeleniumHelper.log.info("Creating new person to work with");
				String peoId = Source.PeoplePage().addPersonReturnId();
								
				SeleniumHelper.log.info("Creating notification for edited");				
				
							Source	.NavigationMenuBar()
									.clickAdministrator()
									.clickNotifications()
									.DataTable()
									.clickAdd()
									.NotificationsPage()
									.setNotificationName(notification1Name)
									.setNotificationsCriteria("TC_Notifications_Add_Edit_Fire_Correctly")
									.setEndDate(Tomorrow, "Y")
									.GetSource()
									.SetConditionsAccord()
									.setType("1000075916")
									.selectFormat(NotificationFormat.IS_EDITED.getName())
									.clickSetConditionsAdd()
									.clickWhenAccord()
									.setWhenDaysTillExpiration(OneN)
									.clickWhoRecipientsAccord()
									.DataTable()
									.clickAdd()
									.WhoAccord()
									.selectType(1)
									.setUser("USER, SELENIUM")
									.clickComplete()
									.NotificationsPage()
									.clickMessageContent()
									.selectMessageContentType(1)
									.setMessageContentValue(notification1Created)
									.clickSubmitExit()
									.clickGoBackToList();
									
							
				SeleniumHelper.log.info("Trigger First Notification modified");
				ExpectedB = true;
				ActualB = Source	.NavigationMenuBar()
									.clickPeople()
									.setSearch(peoId, Clear)
									.clickFirstRow()
									.clickAnchor()
									.NavigationMenuBar()
									.clickAssessmentForms()
									.clickAdd()
									.Assessment_FormsPage()
									.selectAssessmentTypeById("1000075916")
									.setTitle(notification1Name, Clear)
									.clickStartAssessment()
									.fillForm()
									.clickSubmitAllPages()
									.clickGoBackToList()
									.NavigationMenuBar()
									.clickMyHomePage()
									.GetSource()
									.SeleniumHelper()
									.sleep(400)
									.refreshPage()
									.Wait(10)
									.GetSource()
									.MyHomePage()
									.setSearchMyInbox(notification1Created)
									.GetSource()
									.SeleniumHelper()
									.ifWebElementExists(Source.MyHomePage().MyInboxFirstResultNameValue);
				SeleniumHelper.log.info(notification1Created);	
				SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB );		
				SoftAssert.assertEquals(ActualB, ExpectedB);
					
				
				SeleniumHelper.log.info("Edit First Notification");				
							Source	.NavigationMenuBar()
									.clickAdministrator()
									.clickNotifications()
									.DataTable()
									.setSearch(notification1Name, Clear)
									.clickFirstRow()
									.clickEdit()
									.NotificationsPage()
									.clickMessageContent()
									.selectMessageContentType(1)
									.setMessageContentValue(notification1Created.replace("Edited", "Modified"), Clear)
									.clickSubmitExit()
									.clickGoBackToList();
				
				SeleniumHelper.log.info("Test Trigger First Notification modified false");
				ExpectedB = false;
				ActualB = Source	.NavigationMenuBar()
									.clickMyHomePage()
									.GetSource()
									.SeleniumHelper()
									.sleep(400)
									.refreshPage()
									.Wait(10)
									.GetSource()
									.MyHomePage()
									.setSearchMyInbox(notification1Created.replace("Edited", "Modified"))
									.GetSource()
									.SeleniumHelper()
									.ifWebElementExists(Source.MyHomePage().MyInboxFirstResultNameValue);
				SeleniumHelper.log.info(notification1Created);	
				SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB );	
				SoftAssert.assertEquals(ActualB, ExpectedB);
				
				
SeleniumHelper.log.info("Creating notification for entered");				
				
							Source	.NavigationMenuBar()
									.clickAdministrator()
									.clickNotifications()
									.DataTable()
									.clickAdd()
									.NotificationsPage()
									.setNotificationName(notification2Name)
									.setNotificationsCriteria("TC_Notifications_Add_Edit_Fire_Correctly")
									.setEndDate(Tomorrow, "Y")
									.GetSource()
									.SetConditionsAccord()
									.setType("1000075916")
									.selectFormat(NotificationFormat.IS_ENTERED.getName())
									.clickSetConditionsAdd()
									.GetSource()
									.SeleniumHelper()
									.sleep(30)
									.GetSource()
									.NotificationsPage()
									.clickWhenAccord()
									.setWhenDaysTillExpiration(OneN)
									.clickWhoRecipientsAccord()
									.DataTable()
									.clickAdd()
									.WhoAccord()
									.selectType(1)
									.setUser("USER, SELENIUM")
									.clickComplete()
									.NotificationsPage()
									.clickMessageContent()
									.selectMessageContentType(1)
									.setMessageContentValue(notification2Created)
									.clickSubmitExit()
									.clickGoBackToList();
												
										
				SeleniumHelper.log.info("Trigger Second Notification modified");
				ExpectedB = true;
				ActualB = Source	.NavigationMenuBar()
									.clickPeople()
									.setSearch(peoId, Clear)
									.clickFirstRow()
									.clickAnchor()
									.NavigationMenuBar()
									.clickAssessmentForms()
									.clickAdd()
									.Assessment_FormsPage()
									.selectAssessmentTypeById("1000075916")
									.setTitle(notification2Name, Clear)
									.clickStartAssessment()
									.fillForm()
									.clickSubmitAllPages()
									.clickGoBackToList()
									.NavigationMenuBar()
									.clickMyHomePage()
									.GetSource()
									.SeleniumHelper()
									.sleep(400)
									.refreshPage()
									.Wait(10)
									.GetSource()
									.MyHomePage()
									.setSearchMyInbox(notification2Created)
									.GetSource()
									.SeleniumHelper()
									.ifWebElementExists(Source.MyHomePage().MyInboxFirstResultNameValue);
				SeleniumHelper.log.info(notification2Created);	
				SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB );	
				SoftAssert.assertEquals(ActualB, ExpectedB);
					
				
				SeleniumHelper.log.info("Edit Second Notification");				
							Source	.NavigationMenuBar()
									.clickAdministrator()
									.clickNotifications()
									.DataTable()
									.setSearch(notification2Name, Clear)
									.clickFirstRow()
									.clickEdit()
									.NotificationsPage()
									.clickMessageContent()
									.selectMessageContentType(1)
									.setMessageContentValue(notification2Created.replace("Entered", "Modified"), Clear)
									.clickSubmitExit()
									.clickGoBackToList();
							
				SeleniumHelper.log.info("Test Trigger Second Notification modified false");
				ExpectedB = false;
				ActualB = Source	.NavigationMenuBar()
									.clickMyHomePage()
									.GetSource()
									.SeleniumHelper()
									.sleep(400)
									.refreshPage()
									.Wait(10)
									.GetSource()
									.MyHomePage()
									.setSearchMyInbox(notification2Created.replace("Entered", "Modified"))
									.GetSource()
									.SeleniumHelper()
									.ifWebElementExists(Source.MyHomePage().MyInboxFirstResultNameValue);
				SeleniumHelper.log.info(notification2Created);	
				SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB );	
				SoftAssert.assertEquals(ActualB, ExpectedB);
				
				Source.NotificationsPage().DisableNotification(notification1Name);
				Source.NotificationsPage().DisableNotification(notification2Name);
				SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
}
	
	

