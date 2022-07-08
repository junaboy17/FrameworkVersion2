package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Combobox extends BaseHook {

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_Combobox_TypeAmpersand_001(String Module) {
		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Verifying Organization Combobox filter function is able to filter results");
			Expected = "Associations";
			Actual = Source		.DataTable()
								.setSearch(LastName)
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickAssociationsTab()
								.clickAdd()
								.AssociationsPage()
								.selectAssociationType(2)
								.setOrganizationAssociation("R&K", 1, Clear)
								.clickBackToAssociation()
								.clickDiscard()
								.PeopleNavigator()
								.readAssociationsTab();
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_Combobox_Row_Count_001(String Module) {
		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Verifying Organization Combobox filter function is able to filter results");
			Expected = "";
			Actual = Source		.NavigationMenuBar()
								.clickAdministrator()
								.GetSource()
								.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.setNotificationName("Test Notification")
								.setDescription(Description)
								.GetSource()
								.SetConditionsAccord()
								.setType("Initial Contact")
								.setPage("Beyond")
								.readQuestionXbtn();
								
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}


}


