package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_12350_End_Dated_Document_Disabled_Link_Message extends BaseHook {
	
	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void End_Dated_Document_Disabled_Link_Message(String Module) {
		
		SoftAssert = new SoftAssert();
		
		SeleniumHelper.log.info("Creating new user to work with");
		String userName = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		String userPassword = "Spring12#";
		String newPassword = "Winter12#";
		
		try{
				
				//Cannot add documents in development
				if(!Source.SeleniumHelper().isDev())
				{
					SeleniumHelper.log.info("Creating test user");
					// create a test user to add a document on
					Source	
						.UserStaffPage()
						.addCompleteUserAndRemainOnUserPage(OrgDHHS, null, null, null, null, T, null, null, null
													, null, T, null, null, userName, userPassword, userPassword, null);
						// add Base Location
					String userId = Source
										.UserHomeOfficeAccord()
										.clickUserHomeOfficeAdd()
										.setUserBaseLocation(CentralOffice)
										.clickComplete()
						// add Service Population
										.UserInfoAccord()
										.clickServicePopulationAvailableAccord()
										.clickSpAdd()
										.selectServicePopulation(ServicePopulations.CHILDRENS.getName())
										.clickSpComplete()
						// add Role
										.UserInfoAccord()
										.clickRolesAvaiableAccord()
										.clickRolesAdd()
										.selectRole(Roles.ALLAPPS.getName())
										.clickRolesComplete()
										.UserStaffPage()
										.clickSubmit()
										.clickPopupOk()
										.DataTable()
										.readFirstResultID();
					
					SeleniumHelper.log.info("Adding Document and granting access to new user");
					String UserToAddDocumentOn = Source   	
										.NavigationMenuBar()
										.clickPeople()
										.DataTable()
										.readFirstResultID();
					
					Expected = Source	.DataTable()
										.clickFirstRow()
										.clickAnchor()
										.PeopleNavigator()
										.clickDocumentsTab()
										.clickAdd()
										.DocumentsPage()
										.setTitle(DocumentName)
										.setDocumentFile(DocumentPath, DocumentFile)
										.clickAdd()
										.DocumentsUserPage()
										.setUser(userId)
										.clickComplete()
										.DocumentsPage()
										.clickSubmit()
										.clickPopupOk()
										.DataTable()
										.readFirstResultID();
					
					SeleniumHelper.log.info("Log in as new user and check access");
					Source
									.LogInPage().LogOut();
				
					SeleniumHelper.log.info("Log in as the new user and change password");
					Source
										.LogInPage()
										.LogIn(userName, userPassword)
										.GetSource()
										.ChangePasswordPage()
										.setCurrentPassword(userPassword)
										.setNewPassword(newPassword)
										.setConfirmPassword(newPassword)
										.clickSubmit();
					
					SeleniumHelper.log.info("Log back in and confirm the user has access to the document");
					Actual = Source
										.LogInPage()
										.LogIn(userName, newPassword)
										.GetSource()
										.NavigationMenuBar()
										.clickPeople()
										.setSearch(UserToAddDocumentOn)
										.clickFirstRow()
										.clickAnchor()
										.PeopleNavigator()
										.clickDocumentsTab()
										.readFirstResultID();
					
					SoftAssert.assertEquals(Actual, Expected);
					SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
					
					SeleniumHelper.log.info("confirm link is active");
					ExpectedB = T;
					ActualB = Source
										.DataTable()
										.clickFirstRow()
										.clickEdit()
										.DocumentsPage()
										.isLinkEnabled();
					
					SoftAssert.assertEquals(ActualB, ExpectedB);
					SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
					
					SeleniumHelper.log.info("confirm message not present");
					ExpectedB = F;
					ActualB = Source	.DocumentsPage()
										.isLinkMessagePresent();
					
					SoftAssert.assertEquals(ActualB, ExpectedB);
					SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
					
					SeleniumHelper.log.info("end date document confirm link is inactive");
					ExpectedB = F;
					ActualB = Source	.DocumentsPage()
										.setEndDate(Today, Clear)
										.clickYes()
										.DocumentsPage()
										.isLinkEnabled();
					
					SoftAssert.assertEquals(ActualB, ExpectedB);
					SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
					
					SeleniumHelper.log.info("confirm message present");
					ExpectedB = T;
					ActualB = Source	.DocumentsPage()
										.isLinkMessagePresent();
					
					SoftAssert.assertEquals(ActualB, ExpectedB);
					SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
					
					SeleniumHelper.log.info("remove end date and confirm link is active");
					ExpectedB = T;
					ActualB = Source	.DocumentsPage()
										.setEndDate("", Clear)
										.GetSource()
										.DocumentsPage()
										.isLinkEnabled();
					
					SoftAssert.assertEquals(ActualB, ExpectedB);
					SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
					
					SeleniumHelper.log.info("confirm message not present");
					ExpectedB = F;
					ActualB = Source	.DocumentsPage()
										.isLinkMessagePresent();
					
					SoftAssert.assertEquals(ActualB, ExpectedB);
					SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
					
					SeleniumHelper.log.info("End date user access and confirm no longer have access");
					ExpectedB = T;
					ActualB = Source	.DataTable()
										.setSearch("Potatoes", Clear)
										.clickFirstRow()
										.clickEdit()
										.DocumentsUserPage()
										.setEndDate(Today, Clear)
										.GetSource()
										.DocumentsUserPage()
										.clickComplete()
										.DocumentsPage()
										.clickSubmit()
										.clickPopupOk()
										.DocumentsPage()
										.isEmpty();
										
					SoftAssert.assertEquals(ActualB, ExpectedB);
					SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
					
					SoftAssert.assertAll();
				}

				SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}