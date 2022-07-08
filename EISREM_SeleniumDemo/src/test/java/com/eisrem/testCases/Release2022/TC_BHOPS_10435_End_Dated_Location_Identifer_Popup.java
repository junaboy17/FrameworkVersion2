package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_10435_End_Dated_Location_Identifer_Popup extends BaseHook{


	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_BHOPS_10435_End_Dated_Location_Identifer_Popup_01(String Module) {
		SoftAssert = new SoftAssert();

		try{
			String baseLocation = LocationName + SeleniumHelper.generateRandomAlpha(6);
			String otherLocation = LocationName + SeleniumHelper.generateRandomAlpha(6);
			
			int nonEditedOtherId = SeleniumHelper.generateRandomNumber(8);
			int editedIdOther1 = SeleniumHelper.generateRandomNumber(8);
			int editedIdOther2 = SeleniumHelper.generateRandomNumber(8);
			
			int nonEditedBaseId = SeleniumHelper.generateRandomNumber(8);
			int editedIdBase1 = SeleniumHelper.generateRandomNumber(8);
			int editedIdBase2 = SeleniumHelper.generateRandomNumber(8);
			
			SeleniumHelper.log.info("Add new Organization to work with");
			String orgId =Source.OrganizationPage().addCompleteOrganizationPageSubmitAndReturnId();
			
			SeleniumHelper.log.info("Add new base location to organization: " + orgId);
			String baseId = Source			
								.OrganizationNavigator()
								.clickOrganizations()
								.DataTable()
								.setSearch(orgId)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setName(baseLocation)
								.GetSource()
								.LocationsPage()
								.selectType(LocationType.BASE.getName())
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle()
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
								.clickLocations()
								.DataTable()
								.setSearch(baseLocation, Clear)
								.readFirstResultID()
								.replaceAll("[^0-9]", EmptyString);
			
			SeleniumHelper.log.info("Add new other location to organization: " + orgId);
			String otherId = Source			
								.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setName(otherLocation)
								.selectType(LocationType.OTHER_LOCATION.getName())
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle()
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
								.clickLocations()
								.DataTable()
								.setSearch(otherLocation, Clear)
								.readFirstResultID()
								.replaceAll("[^0-9]", EmptyString);
			
			SeleniumHelper.log.info("Verifying no popup on other location in Edit");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickIdentifier()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(2)
								.setIdentifiersIdNumber(nonEditedOtherId, Clear)
								.clickSubmit()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickIdentifier()
								.clickFirstRow()
								.clickEdit()
								.IdentifiersPage()
								.setIdentifiersIdNumber(editedIdOther1, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			Source.DataTable().clickPopupOk().OrganizationNavigator().clickLocations();
			
			SeleniumHelper.log.info("End Date Other Location");
			Expected = Success;
			Actual = Source		.DataTable()
								.setSearch(otherId)
								.clickFirstRow()
								.clickEdit()
								.LocationsPage()
								.setEndDate(Today, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Close popup and navigate to Identifier");
			Source.DataTable().clickPopupOk().OrganizationNavigator().clickIdentifier();
								

			SeleniumHelper.log.info("Verifying popup Title on endated location - Edit");
			Expected = "Warning:";					
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickEdit()
								.IdentifiersPage()
								.setIdentifiersIdNumber(editedIdOther2, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying popup on Message on endated location - Edit");
			Expected = "You are attempting to edit an identifier on a location that is end dated.";
			Actual = Source		
								.DataTable()
								.readPopUpMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Cancel does not save edits");
			Expected = String.valueOf(editedIdOther1);
			Actual = Source		
								.DataTable()
								.clickPopUpCancel()
								.SeleniumHelper()
								.Wait(10)
								.GetSource()
								.IdentifiersPage()
								.clickBackToIdentifiers2()
								.clickDiscard()
								.DataTable()
								.readFirstResultNameType()
								.replaceAll("[^0-9]", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying popup continue saves changes");
			Expected = String.valueOf(editedIdOther2);					
			Actual = Source		
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.IdentifiersPage()
								.setIdentifiersIdNumber(editedIdOther2, Clear)
								.clickSubmit()
								.clickPopUpContinue()
								.DataTable()
								.clickPopupOk()
								.DataTable()
								.readFirstResultNameType()
								.replaceAll("[^0-9]", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying no popup on base location in Edit");
			Expected = Success;
			Actual = Source		.OrganizationNavigator()
								.clickLocations()
								.setSearch(baseId, Clear)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickIdentifier()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(2)
								.setIdentifiersIdNumber(nonEditedBaseId, Clear)
								.clickSubmit()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickIdentifier()
								.clickFirstRow()
								.clickEdit()
								.IdentifiersPage()
								.setIdentifiersIdNumber(editedIdBase1, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			Source.DataTable().clickPopupOk().OrganizationNavigator().clickLocations();
			
			SeleniumHelper.log.info("End date base location");
			Source				.OrganizationNavigator()
								.clickLocations()
								.setSearch(baseId, Clear)
								.clickFirstRow()
								.clickEdit()
								.DataTable()
								.setEndDate(Today, Clear)
								.clickSubmit();
			
			
			SeleniumHelper.log.info("Close popup and navigate to Identifier");
			Source.DataTable().clickPopupOk().OrganizationNavigator().clickIdentifier();
								

			SeleniumHelper.log.info("Verifying popup Title on endated base location - Edit");
			Expected = "Warning:";					
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickEdit()
								.IdentifiersPage()
								.setIdentifiersIdNumber(editedIdBase2, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying popup on Message on endated location - Edit");
			Expected = "You are attempting to edit an identifier on a location that is end dated.";
			Actual = Source		
								.DataTable()
								.readPopUpMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Cancel does not save edits");
			Expected = String.valueOf(editedIdBase1);
			Actual = Source		
								.DataTable()
								.clickPopUpCancel()
								.SeleniumHelper()
								.Wait(5)
								.GetSource()
								.IdentifiersPage()
								.clickBackToIdentifiers2()
								.clickDiscard()
								.DataTable()
								.readFirstResultNameType()
								.replaceAll("[^0-9]", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying popup continue saves changes");
			Expected = String.valueOf(editedIdBase2);					
			Actual = Source		
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.IdentifiersPage()
								.setIdentifiersIdNumber(editedIdBase2, Clear)
								.clickSubmit()
								.clickPopUpContinue()
								.DataTable()
								.clickPopupOk()
								.DataTable()
								.readFirstResultNameType()
								.replaceAll("[^0-9]", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}