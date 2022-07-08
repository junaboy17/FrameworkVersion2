package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class People_Ending_Address extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Related_Person_Autoending_Address(String Module) {
		
		String FirstName = "Chris" + SeleniumHelper.generateRandomAlpha(3);
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding Related Person Address and Verifying Success");
			Expected =	Success;
			Actual = Source		.DataTable()
								.setSearch(JeanneID)
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickRelationshipsTab()
								.clickAdd()
								.RelationshipsPage()
								.selectType(1)
								.setFirstName(FirstName)
								.setLastName(LastName)
								.setStartDate(PastDate30, Clear)
								.clickAdd()
								.AddressPage()
							    .selectAddressType(1)
							    .setAddress1TextBox(Address, Clear)
								.selectCity(City)
								.selectZipcode(Zip)
								.setStartDate(PastDate30, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Relationships was successfully added");
			Expected =	LastName.toUpperCase() + ", " + FirstName.toUpperCase() + "/ BHPC";;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.PeopleNavigator()
								.clickRelationshipsTab()
								.DataTable()
								.readFirstResultNameType();
			
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding End Date and Verifying Success");
			Expected =	Success;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickEdit()	
								.Pagefactory()
								.setEndDate(Today, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Reading End Date and Verifying Success");
			Expected =	Today;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.PeopleNavigator()
								.clickRelationshipsTab()
								.DataTable()
								.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);
						
			SoftAssert.assertAll();		
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	
	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_People_Autoending_Address(String Module) {
		
			String Description1 = "SELENIUM TEST Auto End Dating RECORD";
			String fname = "Chris" + SeleniumHelper.generateRandomAlpha(3);
			String lname = "Bacon" + SeleniumHelper.generateRandomAlpha(3);
			
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding Persons Details and Verifying Success");
			Expected =	Success;
				Actual = Source	.PeoplePage()
								.DataTable()
								.clickAdd()
								.DemographicsPage()
								.fillRequiredDemogrphics(fname, lname, Gender.MALE, DateOfBirth)
								.clickSubmit()
								.readPopUpTitle();
							
					SoftAssert.assertEquals(Actual, Expected);
					
				SeleniumHelper.log.info("Adding Persons Address Details and Verifying Success");
				Expected =	Success;
				Actual = Source	.Pagefactory()
								.clickPopupOk()
								.PeopleNavigator()
								.clickPeopleTab()
								.DataTable()
								.setSearch(fname)
								.clickFirstRow()
								.clickAnchor()
								.DemographicsPage()
								.clickAddressTab()
								.clickAdd()
								.AddressPage()
								.FillRequiredAddress(Address, LegalAddressType, State, City, Zip, PhoneNumber, Description)
								.clickSubmit()
								.readPopUpTitle();
				SoftAssert.assertEquals(Actual, Expected);
				
				SeleniumHelper.log.info("Adding Persons New Address Details and Verifying Success");
				Expected =	Success;
				Actual = Source	.Pagefactory()
								.clickPopupOk()
								.AddressPage()
								.GetSource()
								.PeoplePage()
								.clickPeopleTab()
								.DataTable()
								.setSearch(fname, Clear)
								.clickFirstRow()
								.clickAnchor()
								.DemographicsPage()
								.clickAddressTab()
								.clickAdd()
								.AddressPage()
								.setStartDate(FutureDate30, Clear)
								.FillRequiredAddress(RandNum3+LocationAddress, 1, State, City, Zip, PhoneNumber, Description1)
								.clickSubmit()
								.readPopUpTitle();
				
				SoftAssert.assertEquals(Actual, Expected);
				
				SeleniumHelper.log.info("Reading End Date and Verifying Success");
				Expected =	FutureDate29;
				Actual = Source	.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.readDataTable(2, 4);
				SoftAssert.assertEquals(Actual, Expected);
			SoftAssert.assertAll();		
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}