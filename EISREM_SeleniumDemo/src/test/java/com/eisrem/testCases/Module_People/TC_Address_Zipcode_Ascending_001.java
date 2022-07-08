package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Address_Zipcode_Ascending_001 extends BaseHook {

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_Address_Zipcode_Asc_People(String Module) {
		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Adding a new person and verifying zipcodes are in Ascending order");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickAdd()
								.DemographicsPage()
								.fillRequiredDemogrphics(FirstName, LastName, Enumerations.Gender.MALE, Today)
								.clickSubmit()
								.clickPopupOk()
								.PeopleNavigator()
								.clickAddressTab()
								.clickAdd()
								.AddressPage()
								.selectAddressType(1)
								.setAddress1TextBox(Address)
								.selectCity("AUGUSTA")
								.GetSource()
								.SeleniumHelper()
								.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
								.GetSource()
								.AddressPage()
								.selectZipcode(5)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.SeleniumHelper()
								.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
								.GetSource()
								.Pagefactory()
								.clickBackTo()
								.PeopleNavigator()
								.clickRelationshipsTab()
								.clickAdd()
								.RelationshipsPage()
								.selectType(1)
								.setFirstName(FirstName)
								.setLastName(LastName)
								.clickAdd()
								.AddressPage()
								.selectAddressType(1)
								.setAddress1TextBox(Address)
								.selectCity("AUGUSTA")
								.GetSource()
								.SeleniumHelper()
								.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
								.GetSource()
								.AddressPage()
								.selectZipcode(5)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.SeleniumHelper()
								.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
								.GetSource()
								.Pagefactory()
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
		public void TC_Address_Zipcode_Asc_Organization(String Module) {
			SoftAssert = new SoftAssert();

			try{

				SeleniumHelper.log.info("Adding organization and verifying zipcodes are in Ascending order");
				Expected = Success;
				Actual = Source		.OrganizationPage()
									.addCompleteOrganizationPageAndSubmit()
									.DataTable()
									.clickAdd()
									.LocationsPage()
									.setName(LocationName)
									.selectType(2)
									.clickSubmit()
									.clickPopupOk()
									.OrganizationNavigator()
									.clickAddress()
									.clickAdd()
									.AddressPage()
									.selectAddressType(1)
									.setAddress1TextBox(Address)
									.selectCity("AUGUSTA")
									.GetSource()
									.SeleniumHelper()
									.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
									.GetSource()
									.AddressPage()
									.selectZipcode(5)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.SeleniumHelper()
									.verifyDropDownIsInOrderAlpha(Source.AddressPage().ZipcodeDropDown)
									.GetSource()
									.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
				SoftAssert.assertEquals(Actual, Expected);
				
				SoftAssert.assertAll();

			}catch(Exception e) {
				Source	.SeleniumHelper()
						.assertFail();
			}
		
}
}


