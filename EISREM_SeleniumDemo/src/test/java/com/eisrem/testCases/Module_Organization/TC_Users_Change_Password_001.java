package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Users_Change_Password_001 extends BaseHook{

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_User_Change_Password_001(String Module) {
		SoftAssert = new SoftAssert();

		String UserName = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		String fName = "Second" + RandNum3;
		String lName = "User" + RandNum3;
		String fullName = lName + ", " + fName;
		
		try {
			SeleniumHelper.log.info("Adding a New User with password and confirming successful creation of New User");
			ExpectedB = T;	
			ActualB = Source	.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.DataTable()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(fName)
								.setLastName(lName)
								.clickUserInfoAccord()
								.clickUserActiveToggle(True)
								.setUserName(UserName)
								.setPassword(UserPassword, Clear)
								.setPasswordConfirmation(UserPassword, Clear)
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.selectRole(Enumerations.Roles.CS_ADMIN_ROLE.getName())
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(fullName)
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.GetSource()
								.SeleniumHelper().checkWebElementExists(Source.UserInfoAccord().DateofLastPWResetTextBox);
			SoftAssert.assertEquals(ActualB, ExpectedB);	
			
			Expected = Today;
			Actual = Source		.UserInfoAccord()
								.readDateofLastPasswordReset().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);	
			
			ExpectedB = T;
			ActualB = Source	.SeleniumHelper().checkWebElementExists(Source.UserInfoAccord().DaysSinceLastLoginTextBox);
			SoftAssert.assertEquals(ActualB, ExpectedB);	
			
			Expected = "";
			Actual = Source		.UserInfoAccord()
								.readDaysSinceLastLogin().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Signing out, signing in as New User, changing password and verifying password change was successful");
			Expected = Today;
			Actual = Source		.UserInfoAccord()
								.clickSubmit()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickWelcomeUser()
								.clickLogOut()
								.GetSource()
								.LogInPage()
								.setUserName(UserName)
								.setPassword(UserPassword)
								.clickSignIn()
								.GetSource()
								.PasswordChangePage()
								.setCurrentPassword(UserPassword)
								.setNewPassword(userPassword2)
								.setConfirmNewPassword(userPassword2)
								.clickSubmit()
								.GetSource()
								.LogInPage()
								.setUserName(UserName)
								.setPassword(userPassword2)
								.clickSignIn()
								.clickOrganization()
								.setSearch(OrgDHHS)
								.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.setSearch(fullName)
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readDateofLastPasswordReset().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = "0";
			Actual = Source		.UserInfoAccord()
								.readDaysSinceLastLogin().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}