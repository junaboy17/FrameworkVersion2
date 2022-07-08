package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_12479_Admin_Edit_Start_Dates_Association extends BaseHook{

	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_BHOPS_12479_Admin_Edit_Start_Dates_Association(String Module) {
		SoftAssert = new SoftAssert();
		
		try {
			String adminUser = "OIT" + SeleniumHelper.generateRandomAlpha(10);
			String nonAdminUser = "OIT" + SeleniumHelper.generateRandomAlpha(10);
			String role = "BHOPS 12479 Role" + SeleniumHelper.generateRandomAlpha(10);
			
			SeleniumHelper.log.info("Adding a new Role");
			Source   	.AdministratorNavigator()
								.clickRoles()
								.clickAdd()
								.RolesPage()
								.setRoleName(role)
								.setDescription(Description)
								.GetSource()
								.RolesPage()
								.clickAppAreaAccord()
								.clickAppToggle(PeopleApp, True)
								.clickAppAreaModulesAccord()
								.setSearchAppAreaModules("Associations")
								.clickModuleToggle("Associations", Active, True)
								.clickModuleToggle("Associations", Add, True)
								.clickModuleToggle("Associations", View, True)
								.clickModuleToggle("Associations", Edit, True)
								.setSearchAppAreaModules("Demographics", Clear)
								.clickModuleToggle("Demographics", Active, True)
								.clickModuleToggle("Demographics", Add, True)
								.clickModuleToggle("Demographics", View, True)
								.clickModuleToggle("Demographics", Edit, True)
								.clickSubmit()
								.clickPopupOk();
			
			Source.UserStaffPage().addCompleteUserAndRemainOnUserPage(OrgDHHS, adminUser, adminUser, UserEmail, PhoneNumber,
					true, null, null, Today, null, true, 
					Today, null, adminUser, "Spring17#",  "Spring17#", Description)
								.GetSource()
								.UserHomeOfficeAccord()
								.setUserHomeOfficeBaseLocationAndSubmit()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.addRole(Today, null, Roles.CS_ADMIN_ROLE.getName(), Description)
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.addServicePopulation(Today, null, ServicePopulations.CHILDRENS.getName(), Description)
								.clickSubmit()
								.clickPopupOk();
								
			SeleniumHelper.log.info("Create an non admin user to work with");
			Source.UserStaffPage().addCompleteUserAndRemainOnUserPage(OrgDHHS, nonAdminUser, nonAdminUser, UserEmail, PhoneNumber,
					true, null, null, Today, null, true, 
					Today, null, nonAdminUser, "Spring17#",  "Spring17#", Description)
								.GetSource()
								.UserHomeOfficeAccord()
								.setUserHomeOfficeBaseLocationAndSubmit()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.addRole(Today, null, role.toUpperCase(), Description)
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.addServicePopulation(Today, null, ServicePopulations.CHILDRENS.getName(), Description)
								.clickSubmit()
								.clickPopupOk();
								
			SeleniumHelper.log.info("Login as admin user and create person to work with");
			Source				.LogInPage()
								.LogOut()
								.GetSource()
								.LogInPage()
								.setUserName(adminUser)
								.setPassword("Spring17#")
								.clickSignIn()
								.GetSource()
								.ChangePasswordPage()
								.setCurrentPassword("Spring17#", Clear)
								.setNewPassword(UserPassword, Clear)
								.setConfirmNewPassword(UserPassword, Clear)
								.clickSubmit();
			
			String peoId =		Source.LogInPage()
								.LogIn(adminUser, UserPassword, Clear)
								.GetSource()
								.NavigationMenuBar()
								.clickPeople()
								.addPersonReturnId();
			
			SeleniumHelper.log.info("Verifying Admin User can edit start date");
			ExpectedB = T;
			ActualB = Source	.PeoplePage()
								.setSearch(peoId, Clear)
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickAssociationsTab()
								.clickFirstRow()
								.clickEdit()
								.AssociationsPage()
								.isStartDateEnabledAssociation();
			
			SoftAssert.assertEquals(ActualB, ExpectedB);
			
			SeleniumHelper.log.info("Verifying Admin User can save edited start date");
			Expected = Tomorrow;
			Actual = Source		.AssociationsPage()
								.setStartDateTextBox(Tomorrow, Clear)
								.GetSource()
								.AssociationsPage()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.AssociationsPage()
								.readStartDate();
			
			SeleniumHelper.log.info("Login as non admin user and create person to work with");
			Source				.LogInPage()
								.LogOut()
								.GetSource()
								.LogInPage()
								.setUserName(nonAdminUser)
								.setPassword("Spring17#")
								.clickSignIn()
								.GetSource()
								.ChangePasswordPage()
								.setCurrentPassword("Spring17#", Clear)
								.setNewPassword(UserPassword, Clear)
								.setConfirmNewPassword(UserPassword, Clear)
								.clickSubmit();
			
			SeleniumHelper.log.info("Verifying non Admin User cannot edit start date");
			ExpectedB = F;
			ActualB = Source	.LogInPage()
								.LogIn(nonAdminUser, UserPassword, Clear)
								.GetSource()
								.NavigationMenuBar()
								.clickPeople()
								.setSearch(peoId, Clear)
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickAssociationsTab()
								.clickFirstRow()
								.clickEdit()
								.AssociationsPage()
								.isStartDateEnabledAssociation();
			
			SoftAssert.assertEquals(ActualB, ExpectedB);
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
