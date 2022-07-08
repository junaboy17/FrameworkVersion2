package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class People_Add extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Add_With_Identifier_Accordian_001(String Module) {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying people add with Identifier accordion");
			Expected =	"Success!";
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphicsWithIdentifier()
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
	public void Add_With_Association_Tab_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying People add with Association tab");
			Expected =	"Success!";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.fillRequiredDemogrphicsWithIdentifier()
										.clickSubmit()
										.clickPopupOk()
										.PeopleNavigator()
										.clickAssociationsTab()
										.DataTable()
										.clickAdd()
										.AssociationsPage()
										.selectAssociationType(2)
										.setOrganization("ACME BEHAVIORAL HEALTHCARE")
										.clickSubmit()
										.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);		
					
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		

	@Test(priority=3,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Add_Client_With_Address_Tab(String Module) {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying Add client with Address tab");
			Expected =	"Success!";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.fillRequiredDemogrphicsWithIdentifier()
										.clickSubmit()
										.clickPopupOk()
										.PeopleNavigator()
										.clickAssociationsTab()
										.DataTable()
										.clickAdd()
										.AssociationsPage()
										.selectAssociationType(2)
										.setOrganization("ACME BEHAVIORAL HEALTHCARE")
										.clickSubmit()
										.clickPopupOk()
										.PeopleNavigator()
										.clickAddressTab()
										.DataTable()
										.clickAdd()
										.AddressPage()
										.FillRequiredAddress(Address, LegalAddressType, State, City, Zip, PhoneNumber, Description)
										.clickSubmit()
										.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);		
					
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=4,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Add_With_Identifier_Tab_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying People add with Identifier tab");
			Expected =	"Success!";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.fillRequiredDemogrphicsWithIdentifier()
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