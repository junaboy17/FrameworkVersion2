package com.eisrem.testCases.Module_Search;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Search_User extends BaseHook{
	@Test(priority=1,dataProvider = Search, dataProviderClass = DataProviders.class)
	public void TC_Search_User_001(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = UserId;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.USER.getName())
								.setSearchBy(SearchBy.NAME.getName())
								.setValue(UserFullName)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);

			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditUserHeader;					
			Actual = Source   	.SearchPage()					
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2,dataProvider = Search, dataProviderClass = DataProviders.class)
	public void TC_Search_User_002(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = UserId;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.USER.getName())
								.setSearchBy(SearchBy.USERNAME.getName())
								.setValue(User)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);

			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditUserHeader;					
			Actual = Source   	.SearchPage()					
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}