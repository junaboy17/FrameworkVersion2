package com.eisrem.testCases.Module_Search;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;


public class TC_Search_MaxResults extends BaseHook{
	@Test(priority=1,dataProvider = Search, dataProviderClass = DataProviders.class)
	public void TC_Search_MaxResults_001(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verify Search generates results and user can click second pagination");
			Expected = EditUserHeader;
			Actual = Source   	.SearchPage()
								.setSearchFor(SearchFor.USER.getName())
								.setSearchBy(SearchBy.NAME.getName())
								.setValue("chris")
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.GetSource()
								.SeleniumHelper()
								.sleep(10)
								.GetSource()
								.SearchPage()	
								.clickPageTab2()
								.GetSource()
								.SearchPage()					
								.clickFirstRowIDLink()
								.GetSource()
								.SeleniumHelper()
								.sleep(5)
								.GetSource()
								.SearchPage()	
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