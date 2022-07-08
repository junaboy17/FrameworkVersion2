package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_12478_Admin_Edit_Start_Dates_CNDCTD_Type extends BaseHook{

	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_BHOPS_12478_Admin_Edit_Start_Dates_CNDCTD_Type(String Module) {
		SoftAssert = new SoftAssert();
		
		try {
			String adminUser = "OIT" + SeleniumHelper.generateRandomAlpha(10);
			String nonAdminUser = "OIT" + SeleniumHelper.generateRandomAlpha(10);
			String role = "BHOPS 12478 Role" + SeleniumHelper.generateRandomAlpha(10);
			int typeId = 1000075416;	// CS INDIVIDUAL PLANNING FUNDS FORM V2
			
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
								.clickAppToggle(Assessment_FormsApp, True)
								.clickAppAreaModulesAccord()
								.setSearchAppAreaModules("ASSESSMENT/FORMS")
								.clickModuleToggle("ASSESSMENT/FORMS", Active, True)
								.clickModuleToggle("ASSESSMENT/FORMS", Add, True)
								.clickModuleToggle("ASSESSMENT/FORMS", View, True)
								.clickModuleToggle("ASSESSMENT/FORMS", Edit, True)
								.setSearchAppAreaModules("Demographics", Clear)
								.clickModuleToggle("Demographics", Active, True)
								.clickModuleToggle("Demographics", Add, True)
								.clickModuleToggle("Demographics", View, True)
								.clickModuleToggle("Demographics", Edit, True)
								.clickSubmit()
								.clickPopupOk();
			
			Source.NavigationMenuBar().clickAdministrator()
								.setSearch(String.valueOf(typeId), Clear)
								.clickFirstRow()
								.clickEdit()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.DataTable()
								.clickAdd()
								.RolesAvailableAccord()
								.selectRole(role.toUpperCase())
								.clickRolesComplete()
								.PagesAvailableAccord()
								.clickComplete()
								.TypesPage()
								.clickSubmitExit()
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
								.NavigationMenuBar()
								.clickAssessmentForms()
								.clickAdd()
								.Assessment_FormsPage()
								.selectAssessmentTypeById(String.valueOf(typeId))
								.setTitle(ConductedTypePrefix)
								.setDescription(String.valueOf(typeId))
								.GetSource()
								.Assessment_FormsPage()
								.clickStartAssessment()
								.GetSource()
								.SeleniumHelper()
								.sleep(10)
								.GetSource()
								.FormPage()
								.fillForm()
								.clickSubmitAllPages()
								.clickGoBackToList()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.Assessment_FormsPage()
								.clickAssessmentsFormsTab()
								.isStartDateEnabled();
			
			SoftAssert.assertEquals(ActualB, ExpectedB);
			
			SeleniumHelper.log.info("Verifying Admin User can save edited start date");
			Expected = Tomorrow;
			Actual = Source		.DataTable()
								.setStartDate(Tomorrow, Clear)
								.GetSource()
								.Assessment_FormsPage()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.Assessment_FormsPage()
								.clickAssessmentsFormsTab()
								.readStartDateValue();
			
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
								.NavigationMenuBar()
								.clickAssessmentForms()
								.clickFirstRow()
								.clickEdit()
								.Assessment_FormsPage()
								.clickAssessmentsFormsTab()
								.isStartDateEnabled();
			
			SoftAssert.assertEquals(ActualB, ExpectedB);
			
			Expected =	"Login";
			Actual =	Source		.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.readLogInTitle();
			SoftAssert.assertEquals(Actual, Expected);

						Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.clickAdministrator();

			Expected =	Today;
			Actual =	Source		.AdministratorNavigator()
									.clickRoles()
									.setSearch("BHOPS 12478 Role")
									.clickFirstRow()
									.clickEdit()
									.Pagefactory()
									.setEndDate(Today)
									.clickActiveToggle(False)
									.clickSubmit()
									.DataTable()
									.readFirstResultEndDate();				
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
