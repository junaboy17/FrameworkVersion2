package com.eisrem.testCases.Module_MyHomePage;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Datepicker_Icon extends BaseHook{

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_Datepicker_Icon_001(String Module) {
		SoftAssert = new SoftAssert();

		try{			
			SeleniumHelper.log.info("Verifying Start Date Icon is disabled");
			Expected = True;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickEdit()
								.SeleniumHelper()
								.getAttribute(Source.Pagefactory().StartDateTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Clicking End Date Icon and verifying DatePicker Table does popup");
			ExpectedB = T;
			ActualB = Source	.DataTable()
								.clickEndDateIcon()
								.GetSource()
								.SeleniumHelper()
								.ifWebElementExists(Source.Pagefactory().DatePickerTable);
			SoftAssert.assertEquals(ActualB, ExpectedB);
			
			Expected = Success;
			Actual = Source		.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
					
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_Datepicker_Select_Date_001(String Module) {
		SoftAssert = new SoftAssert();

		try{			
			SeleniumHelper.log.info("Verifying Keyboard key 'UP' and 'ENTER' can be used to select");
			Expected = PastDate7;			
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickEdit()
								.DemographicsPage()
								.clickDemographicsParentAccord()
								.clickDemographicsParentAccord()
								.GetSource()
								.SeleniumHelper()
								.Wait(2)
								.pressTab(3)
								.PressKeys(Keys.UP, Keys.ENTER)
								.GetSource()			
								.Pagefactory()
								.readEndDateValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Keyboard key 'DOWN' and 'ENTER' can be used to select");
			Expected = Today;			
			Actual = Source		.SeleniumHelper()
								.PressKeys(Keys.DOWN, Keys.ENTER)
								.GetSource()
								.Pagefactory()
								.readEndDateValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Keyboard key 'LEFT' and 'ENTER' can be used to select");
			Expected = Yesterday;			
			Actual = Source		.SeleniumHelper()
								.PressKeys(Keys.LEFT, Keys.ENTER)
								.GetSource()
								.Pagefactory()
								.readEndDateValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Keyboard key 'RIGHT' and 'ENTER' can be used to select");
			Expected = Today;			
			Actual = Source		.SeleniumHelper()
								.PressKeys(Keys.RIGHT, Keys.ENTER)
								.GetSource()
								.Pagefactory()
								.readEndDateValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
					
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Datepicker_Question_Role_Functionality(String Module) {
		SoftAssert = new SoftAssert();

		try{			
			SeleniumHelper.log.info("Adding Questions, Role in Administrator Pages and verifying Success");
			Expected = Enumerations.Roles.CBH_PROVIDER_APPLICATION_ROLE.getId().toString();			
			Actual = Source		.AdministratorNavigator()
								.clickPages()
								.GetSource()
								.PagesPage()
								.addCompletePage(false)
								.setSearch("Pages_Selenium")
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(12)
								.setQuestionLabel("Selenium Question")
								.setSortOrder("1")
								.clickQASave()
								.GetSource()
								.SeleniumHelper()
								.Wait(5)
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(17)
								.setQuestionLabel("Cndctd type Search")
								.setSortOrder("2")
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(Enumerations.Roles.CBH_PROVIDER_APPLICATION_ROLE.getName())
								.clickRolesComplete()
								.RolesAvailableAccord()
								.clickQuestionRolesFirstRow()							
								.clickRolesEdit()
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.RolesAvailableAccord().RoleDropDown, "value");
			SoftAssert.assertEquals(Actual, Expected);
					
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=4,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Datepicker_Admin_Messages_Role_Functionality(String Module) {
		SoftAssert = new SoftAssert();

		try{			
			SeleniumHelper.log.info("Adding Role in Administrator Message");
			Expected = Success;			
			Actual = Source		.AdministratorNavigator()
								.clickAdministratorMessages()
								.setSearch("SELENIUM")
								.clickFirstRow()
								.clickEdit()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(Enumerations.Roles.CBH_PROVIDER_APPLICATION_ROLE.getName())
								.clickRolesComplete()
								.Pagefactory()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Role has been correctly selected");
			Expected = Enumerations.Roles.CBH_PROVIDER_APPLICATION_ROLE.getId().toString();		
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.RolesAvailableAccord()
								.clickEndDateSort()
								.clickRolesFirstRow()
								.clickRolesEdit()
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.RolesAvailableAccord().RoleDropDown, "value");
			SoftAssert.assertEquals(Actual, Expected);
					
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}
