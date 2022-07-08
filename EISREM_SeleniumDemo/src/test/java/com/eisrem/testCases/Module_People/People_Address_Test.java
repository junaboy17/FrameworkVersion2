package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class People_Address_Test extends BaseHook {
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Address_Add_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying successful addition of an Address to an individual");
			Expected ="Success!";
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillAllDemogrphicsNoIdentifier()
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickAddressTab()
									.DataTable()
									.clickAdd()
									.AddressPage()
									.FillRequiredAddress()
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
	public void Address_Edit_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			
		SeleniumHelper.log.info("Verifying successful edit of an Address for an individual");	
		Expected =	"Success!";
		Actual=	Source			.DataTable()
								.setSearch(FirstName.replaceAll("[0-9]", EmptyString))
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickAddressTab()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.AddressPage()
								.setDescription(Description, "y")
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
	public void Address_View_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying successful edit of an Address for an individual");	
			Source					.DataTable()
									.setSearch(FirstName.replaceAll("[0-9]", EmptyString))
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickAddressTab()
									.DataTable()
									.clickFirstRow()
									.clickView()
									.AddressPage()
									.clickBackToAddress();
			SoftAssert.assertEquals(Actual, Expected);	
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	
}
