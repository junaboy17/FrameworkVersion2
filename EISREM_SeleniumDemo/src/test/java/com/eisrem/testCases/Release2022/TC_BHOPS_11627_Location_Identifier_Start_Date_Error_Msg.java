package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11627_Location_Identifier_Start_Date_Error_Msg extends BaseHook{


	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_BHOPS_11627_Location_Identifier_Start_Date_Error_Msg_001(String Module) {
		SoftAssert = new SoftAssert();
		String OrganizationName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(8);
		String LocationName = "AUGUSTA/3 Group Home "+ SeleniumHelper.generateRandomNumber(4);
		try{
			SeleniumHelper.log.info("Creating Organization, Location with out end date, & Associtated identifier within date range");
			Expected = Success;
			Actual =		Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrganizationName)
								.selectOrganizationType(OrganizationType.OTHER.getName())
								.setStartDate(SeleniumHelper.dateOnlyPast(28), Clear)
								.clickActiveToggle(True)
								.GetSource()
								.OrganizationPage()
								.clickSubmit()
								.clickPopupOk()
								.LocationsPage()
								.clickAdd()
								.LocationsPage()
								.setName(LocationName)
								.selectType(2)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle()
								.setStartDate(SeleniumHelper.dateOnlyPast(28), Clear)
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(3)
								.clickComplete()
								.LocationsPage()
								.clickSubmit()
								.clickPopupOk()		
								.OrganizationNavigator()
								.clickIdentifier()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(1)
								.setIdentifiersIdNumber(SeleniumHelper.generateRandomNumber(8), Clear)
								.setStartDate(Today, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Error Message");
			Expected = "Start Date should not be before location's Start Date. (" + SeleniumHelper.dateOnlyPast(28) +")";
			Actual = 	Source	.DataTable()
								.clickPopupOk()
								.DataTable()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(1)
								.setIdentifiersIdNumber(SeleniumHelper.generateRandomNumber(8), Clear)
								.setStartDate(SeleniumHelper.dateOnlyPast(30), Clear)
								.clickSubmit()
								.readTopErrorMessage(2);
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}