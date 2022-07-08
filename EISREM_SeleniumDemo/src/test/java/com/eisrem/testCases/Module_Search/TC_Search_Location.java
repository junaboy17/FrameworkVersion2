package com.eisrem.testCases.Module_Search;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Search_Location extends BaseHook{
	@Test(priority=1,dataProvider = Search, dataProviderClass = DataProviders.class)
	public void TC_Search_Location_001(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = OneN;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.LOCATION.getName())
								.setSearchBy(SearchBy.IDENTIFIER.getName())
								.setValue(LocationIdentifier)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);

			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditLocationHeader;					
			Actual = Source   	.SearchPage()					
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

	@Test(priority=2,dataProvider = Search, dataProviderClass = DataProviders.class)
	public void TC_Search_Location_002(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = OneN;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.LOCATION.getName())
								.setSearchBy(SearchBy.ID.getName())
								.setValue(OneN)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);

			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditLocationHeader;					
			Actual = Source   	.SearchPage()					
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3,dataProvider = Search, dataProviderClass = DataProviders.class)
	public void TC_Search_Location_003(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = OneN;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.LOCATION.getName())
								.setSearchBy(SearchBy.ADDRESS.getName())
								.setAddress(LocationAddress)
								.setCity(LocationCity)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultNameType().replaceAll("[^0-9]", EmptyString);

			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditLocationHeader;					
			Actual = Source   	.SearchPage()					
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=4,dataProvider = Search, dataProviderClass = DataProviders.class)
	public void TC_Search_Location_004(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = OneN;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.LOCATION.getName())
								.setSearchBy(SearchBy.NAME.getName())
								.setValue(CentralOffice)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);

			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditLocationHeader;					
			Actual = Source   	.SearchPage()					
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=5,dataProvider = Search, dataProviderClass = DataProviders.class)
	public void TC_Search_Location_005(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = OneN;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.LOCATION.getName())
								.setSearchBy(SearchBy.BASE_LOCATION.getName())
								.setValue(OrgDHHS)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);

			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditLocationHeader;					
			Actual = Source   	.SearchPage()					
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}