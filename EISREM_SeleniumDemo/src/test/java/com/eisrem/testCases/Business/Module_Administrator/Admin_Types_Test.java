package com.eisrem.testCases.Business.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class Admin_Types_Test extends BaseHook {

	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void Types(String Module) {
		
		SoftAssert = new SoftAssert();

		int randNum = SeleniumHelper.generateRandomNumber(3);
		int randNum4 = SeleniumHelper.generateRandomNumber(4);
		String pageName = "ACME SURVEY PAGE " + randNum;
		String pageName2 = "ACME SURVEY PAGE " + (randNum + 1);
		String survName = "ACME Survey Tool " + randNum4;
		String survNameSelect = survName + "/ Assessment";
		String title = "Survey Tool Test " + randNum4;
		
		try{
			SeleniumHelper.log.info("Adding Pages and verifying success");
			Expected =	"Lock Page!";
			Actual =	Source		.AdministratorNavigator()
									.clickPages()
									.clickAdd()
									.PagesPage()
									.setPageName(pageName)
									.setStartDate(PastDate5, Clear)
									.setDescription(Description)
									.GetSource()
									.DataTable()
									.clickAdd()
									.SectionsAvailableAccord()
									.setSectionName("Section 1")
									.setSortOrder("1")
									.clickShowDescriptionToggle(False)
									.setDescription(Description)
									.GetSource()
									.RowsAvailableAccord()
									.clickRowAdd()
									.setRowName("Row 1")
									.setSortOrder("1")
									.clickShowDescriptionToggle(False)
									.setDescription("Selenium Row")
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(3)
									.setQuestionLabel("TODAY'S DATE")
									.setSortOrder("1")
									.clickRequiredToggle()
									.clickQASave()
									.clickPopupOkIfExist()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(1)
									.setQuestionLabel("WHICH COLOR?")
									.setSortOrder("2")
									.setAnswerValue(1, "Red")
									.clickAddValueAnswer()
									.setAnswerValue(2, "Blue")
									.clickAddValueAnswer()
									.setAnswerValue(3, "Green")
									.clickAddValueAnswer()
									.setAnswerValue(4, "Purple")
									.clickQASave()
									.clickPopupOkIfExist()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(2)
									.setQuestionLabel("WHO TO CHOOSE?")
									.setSortOrder("3")
									.setAnswerValue(1, "1000000622  CBH_Staff")
									.clickQASave()
									.clickPopupOkIfExist()
									.RowsAvailableAccord()
									.clickRowSubmit()
									.clickPopupOkIfExist()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.PagesPage()
									.clickLockForUseToggle(True)
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Locking for Use, Copying Page and verifying Copied Page was created successfully");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickYes()
									.PagesPage()
									.clickSubmitExit()
									.clickPopupOkIfExist()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.PagesPage()
									.clickCopyPage()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected =	"Lock Page!";
			Actual =	Source		.Pagefactory()
									.clickPopupOkIfExist()
									.PagesPage()
									.setPageName(pageName2, Clear)
									.clickLockForUseToggle("true")
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected =	pageName2;
			Actual =	Source		.Pagefactory()
									.clickYes()
									.Pagefactory()
									.clickSubmit()
									.DataTable()
									.clickPopupOkIfExist()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Adding Pages with Roles, Service Populations and Locking for Use");
			Expected =	"Lock Type!";
			Actual =	Source		.AdministratorNavigator()
									.clickTypes()
									.clickAdd()
									.TypesPage()
									.setStartDate(PastDate5, Clear)
									//.setEndDate(Tomorrow, Clear)
									.GetSource()
									.TypesPage()
									.selectAppModule(1)
									.setName(survName)
									.selectLockTime(1)
									.selectAppAreaToConductType(2)
									.clickMultipleAllowed()
									.clickAdd()
									.PagesAvailableAccord()
									.setPage(pageName)
									.setSortOrder("1")
									.GetSource()
									.RolesAvailableAccord()
									.clickRolesAdd()
									//only can select todays date
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.ALLAPPS.getName())	
									.clickEditToggle(False)
									.clickRolesComplete()
									.RolesAvailableAccord()
									.clickRolesAdd()
									//today
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.CS_ADMIN_ROLE.getName())
									.clickRolesComplete()
									.RolesAvailableAccord()
									.clickRolesAdd()
									//today
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.SYSTEM_ADMIN.getName())
									.clickRolesComplete()
									.ServicePopulationsAvailableAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									.clickStartDateIcon()
									//today
									.setStartDate(Today, Clear)
									.selectServicePopulation(Enumerations.ServicePopulations.CHILDRENS.getIndex())
									.clickSpComplete()
									.PagesPage()
									.clickComplete()
									.Pagefactory()
									.clickPopupOkIfExist()
									.PagesAvailableAccord()
									.clickAdd()
									.PagesAvailableAccord()
									.setPage(pageName2)
									.setSortOrder(TwoN)
									.GetSource()
									.RolesAvailableAccord()
									.clickRolesAdd()
									//today
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.ALLAPPS.getName())
									.clickEditToggle(False)
									.clickRolesComplete()
									.RolesAvailableAccord()
									.clickRolesAdd()
									//today
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.CS_ADMIN_ROLE.getName())
									.clickRolesComplete()
									.RolesAvailableAccord()
									.clickRolesAdd()
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.SYSTEM_ADMIN.getName())
									.clickRolesComplete()
									.ServicePopulationsAvailableAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									//today
									.setStartDate(Today, Clear)
									.selectServicePopulation(Enumerations.ServicePopulations.CHILDRENS.getIndex())
									.clickSpComplete()
									.PagesPage()
									.clickComplete()
									.Pagefactory()
									.clickPopupOkIfExist()
									.TypesPage()
									.clickPreview()
									.clickTestBackBtn()
									.clickSubmitExit()
									.clickPopupOkIfExist()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.TypesPage()
									.clickLockForUseToggle(True)
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying Survey functions working properly");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickYes()
									.TypesPage()
									.clickSubmitExit()
									.clickPopupOkIfExist()
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
									.GetSource()
									.Assessment_FormsPage()
									.selectAssessmentType(survNameSelect)
									.setTitle(title)
									.clickStartAssessment()
									.setText2(1, "DATE", Today, Clear)
									.clickCheckBox(1, "WHICH", 2)
									.clickCheckBox(1, "WHICH", 3)
									.selectValue(1, "WHO", 1)
									.clickTopTab(3)
									.setText2(1, "DATE", Today, Clear)
									.clickSubmitAllPages()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("End Dating Types");
					Source			.Assessment_FormsPage()
									.clickBackToList()
									.NavigationMenuBar()
									.clickAdministrator()
									.GetSource()
									.TypesPage()
									.endDateType(survName);	
			
			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}
	
	@Test(priority=2,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void Types_Required_Page(String Module) {
		
		SoftAssert = new SoftAssert();

		int randNum = SeleniumHelper.generateRandomNumber(3);
		int randNum4 = SeleniumHelper.generateRandomNumber(4);
		String pageName = "ACME SURVEY PAGE " + randNum;
		String pageName2 = "ACME SURVEY PAGE " + (randNum + 1);
		String survName = "ACME Survey Tool " + randNum4;
		String survNameSelect = survName + "/ Assessment";
		String title = "Survey Tool Test " + randNum4;
		
		try{
			SeleniumHelper.log.info("Adding Pages and verifying success");
			Expected =	"Lock Page!";
			Actual =	Source		.AdministratorNavigator()
									.clickPages()
									.clickAdd()
									.PagesPage()
									.setPageName(pageName)
									.setStartDate(PastDate5, Clear)
									.setDescription(Description)
									.GetSource()
									.DataTable()
									.clickAdd()
									.SectionsAvailableAccord()
									.setSectionName("Section 1")
									.setSortOrder("1")
									.clickShowDescriptionToggle(False)
									.setDescription(Description)
									.GetSource()
									.RowsAvailableAccord()
									.clickRowAdd()
									.setRowName("Row 1")
									.setSortOrder("1")
									.clickShowDescriptionToggle(False)
									.setDescription("Selenium Row")
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(3)
									.setQuestionLabel("Today's Date")
									.setSortOrder("1")
									.clickRequiredToggle()
									.clickQASave()
									.clickPopupOkIfExist()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(1)
									.setQuestionLabel("WHICH COLOR?")
									.setSortOrder("2")
									.setAnswerValue(1, "Red")
									.clickAddValueAnswer()
									.setAnswerValue(2, "Blue")
									.clickAddValueAnswer()
									.setAnswerValue(3, "Green")
									.clickAddValueAnswer()
									.setAnswerValue(4, "Purple")
									.clickQASave()
									.clickPopupOkIfExist()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(2)
									.setQuestionLabel("WHO TO CHOOSE?")
									.setSortOrder("3")
									.setAnswerValue(1, "1000000622  CBH_Staff")
									.clickQASave()
									.clickPopupOkIfExist()
									.RowsAvailableAccord()
									.clickRowSubmit()
									.clickPopupOkIfExist()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.PagesPage()
									.clickLockForUseToggle(True)
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Locking for Use, Copying Page and verifying Copied Page was created successfully");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickYes()
									.PagesPage()
									.clickSubmitExit()
									.clickPopupOkIfExist()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.PagesPage()
									.clickCopyPage()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected =	"Lock Page!";
			Actual =	Source		.Pagefactory()
									.clickPopupOkIfExist()
									.PagesPage()
									.setPageName(pageName2, Clear)
									.clickLockForUseToggle(True)
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected =	pageName2;
			Actual =	Source		.Pagefactory()
									.clickYes()
									.Pagefactory()
									.clickSubmit()
									.DataTable()
									.clickPopupOkIfExist()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Adding Pages with Roles, Service Populations and Locking for Use");
			Expected =	"Lock Type!";
			Actual =	Source		.AdministratorNavigator()
									.clickTypes()
									.clickAdd()
									.TypesPage()
									.setStartDate(PastDate5, Clear)
									.GetSource()
									.TypesPage()
									.selectAppModule(1)
									.setName(survName)
									.selectLockTime(1)
									.selectAppAreaToConductType(2)
									.clickMultipleAllowed()
									.clickAdd()
									.PagesAvailableAccord()
									.setPage(pageName)
									.setSortOrder("1")
									.GetSource()
									.RolesAvailableAccord()
									.clickRolesAdd()
									//only can select todays date
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.ALLAPPS.getName())	
									.clickEditToggle(False)
									.clickRolesComplete()
									.RolesAvailableAccord()
									.clickRolesAdd()
									//today
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.CS_ADMIN_ROLE.getName())
									.clickRolesComplete()
									.RolesAvailableAccord()
									.clickRolesAdd()
									//today
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.SYSTEM_ADMIN.getName())
									.clickRolesComplete()
									.ServicePopulationsAvailableAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									//today
									.setStartDate(Today, Clear)
									.selectServicePopulation(Enumerations.ServicePopulations.CHILDRENS.getIndex())
									.clickSpComplete()
									.PagesPage()
									.clickComplete()
									.Pagefactory()
									.clickPopupOkIfExist()
									.PagesAvailableAccord()
									.clickAdd()
									.PagesAvailableAccord()
									.setPage(pageName2)
									.setSortOrder("2")
									.GetSource()
									.RolesAvailableAccord()
									.clickRolesAdd()
									//today
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.ALLAPPS.getName())
									.clickEditToggle(False)
									.clickRolesComplete()
									.RolesAvailableAccord()
									.clickRolesAdd()
									//today
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.CS_ADMIN_ROLE.getName())
									.clickRolesComplete()
									.RolesAvailableAccord()
									.clickRolesAdd()
									.setStartDate(Today, Clear)
									.GetSource()
									.RolesAvailableAccord()
									.selectRole(Enumerations.Roles.SYSTEM_ADMIN.getName())
									.clickRolesComplete()
									.ServicePopulationsAvailableAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									//today
									.setStartDate(Today, Clear)
									.selectServicePopulation(Enumerations.ServicePopulations.CHILDRENS.getIndex())
									.clickSpComplete()
									.PagesPage()
									.clickComplete()
									.Pagefactory()
									.clickPopupOkIfExist()
									.TypesPage()
									.clickPreview()
									.clickTestBackBtn()
									.clickSubmitExit()
									.clickPopupOkIfExist()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.TypesPage()
									.clickLockForUseToggle(True)
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying Survey Page 2 required data needs to be filled in");
			Expected =	"On " + pageName2 + ", Please enter a Today's Date *";
			Actual =	Source		.Pagefactory()
									.clickYes()
									.TypesPage()
									.clickSubmitExit()
									.clickPopupOkIfExist()
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
									.GetSource()
									.Assessment_FormsPage()
									.selectAssessmentType(survNameSelect)
									.setTitle(title)
									.clickStartAssessment()
									.setText2(1, "Date", Today, Clear)
									.clickCheckBox(1, "WHICH", 2)
									.clickCheckBox(1, "WHICH", 3)
									.selectValue(1, "WHO", 1)
									.clickTopTab(3)
									.clickFormContinue()
									.readTopErrorMessage(1);
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected =	Success;
			Actual =	Source		.FormPage()
									.setText2(1, "Date", Today, Clear)
									.clickSubmitAllPages()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("End Dating Types");
			Expected =	"Operation completed successfully.";
			Actual = Source			.Assessment_FormsPage()
									.clickBackToList()
									.NavigationMenuBar()
									.clickAdministrator()
									.GetSource()
									.TypesPage()
									.endDateType(survName)
									.readPopUpMessage();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}
}