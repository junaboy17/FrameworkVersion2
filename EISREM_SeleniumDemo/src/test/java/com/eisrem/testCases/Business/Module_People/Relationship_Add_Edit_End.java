package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class Relationship_Add_Edit_End extends BaseHook {
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Add_Relationship(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding Relationships to an existing person and verifying success message");
			Expected = Success;
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickFirstRow()
									.clickAnchor()
									.RelationshipsPage()
									.addRelationship()
//									.PeopleNavigator()
//									.clickRelationshipsTab()
//									.clickAdd()
//									.RelationshipsPage()
//									.selectType(1)
//									.setFirstName(BusinessFirstName)
//									.setLastName(BusinessLastName)
									.DataTable()
									.clickAdd()
									.AddressPage()
									.FillRequiredAddress()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Edit_Relationship(String Module) {
			SoftAssert = new SoftAssert();
			
			try{

				SeleniumHelper.log.info("Adding Relationships to an existing person and verifying success message");
				Expected = Success;
				Actual =	Source		.DataTable()
										.setSearch(LastName)
										.clickFirstRow()
										.clickAnchor()
										.RelationshipsPage()
										.addRelationship(1, BusinessFirstName, BusinessLastName, DescriptionUpdated)
//										.PeopleNavigator()
//										.clickRelationshipsTab()
//										.clickAdd()
//										.RelationshipsPage()
//										.selectType(1)
//										.setFirstName(BusinessFirstName)
//										.setLastName(BusinessLastName)
//										.setDescription(Description)
										.DataTable()
										.clickAdd()
										.AddressPage()
										.FillRequiredAddress()
										.clickSubmit()
										.readPopUpTitle();
				SoftAssert.assertEquals(Actual, Expected);	
				
				SeleniumHelper.log.info("Editing Relationships and verifying success message");
				Expected = Success;
				Actual =	Source		.Pagefactory()
										.clickPopupOk()
										.DataTable()
										.setSearch(BusinessFirstName)
										.clickFirstRow()
										.clickEdit()
										.RelationshipsPage()
										.setDescription(UpdateDescription, Clear)
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
	public void End_Relationship(String Module) {

		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Adding Relationships to an existing person and verifying success message");
			Expected = Success;
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickFirstRow()
									.clickAnchor()
									.RelationshipsPage()
									.addRelationship()
//									.PeopleNavigator()
//									.clickRelationshipsTab()
//									.clickAdd()
//									.RelationshipsPage()
//									.selectType(1)
//									.setFirstName(BusinessFirstName)
//									.setLastName(BusinessLastName)
//									.setDescription(Description)
									.DataTable()
									.clickAdd()
									.AddressPage()
									.FillRequiredAddress()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("End Dating Relationships and verifying success message");
			Expected = Success;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.setSearch(BusinessFirstName)
									.clickFirstRow()
									.clickEdit()
									.RelationshipsPage()
									.setEndDate(FutureDate7, Clear)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Relationships was successfully End Dated");
			Expected = FutureDate7;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.setSearch(BusinessFirstName, Clear)
									.readDataTable(1, 4);
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying Related Persons Address was successfully End Dated");
			Expected = FutureDate7;
			Actual =	Source		.DataTable()	
									.clickFirstRow()
									.clickView()
									.DataTable()
									.readDataTable("RelAddrTbl-picker-table", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);	
					
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
			
}