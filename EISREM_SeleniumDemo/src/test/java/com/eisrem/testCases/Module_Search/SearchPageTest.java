package com.eisrem.testCases.Module_Search;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class SearchPageTest extends BaseHook{

	@Test(priority=1,dataProvider = Search, dataProviderClass = DataProviders.class)
	public void SearchTitleCheck(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying 'Search' Page title");
			Expected = "Search";
			Actual = Source   	.SearchPage()
								.readSearchPageTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Search' tab title");
			Expected = "Search";
			Actual = Source   	.SearchPage()
								.readSearchBtn();
								
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Search For' title");
			Expected = "Search For: *";
			Actual = Source   	.SearchPage()
								.readSearchForTitle();							
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Search By' title");
			Expected = "Search By: *";
			Actual = Source   	.SearchPage()
								.readSearchByTitle();							
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Condition' title");
			Expected = "Condition:";
			Actual = Source   	.SearchPage()
								.readSearchConditionTitle();							
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Add' button title");
			Expected = "Add";
			Actual = Source		.SearchPage()
								.readSearchAddBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Remove' button title");
			Expected = "Remove";
			Actual = Source		.SearchPage()
								.readSearchRemoveBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Search Criteria' title");
			Expected = "Search Criteria";
			Actual = Source		.SearchPage()
								.readSearchCritetria();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Search' button title");
			Expected = "Search";
			Actual = Source		.SearchPage()
								.readSearchBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Copyright' title");
			Expected = CopyRightInfo;
			Actual = Source		.DataTable()
								.readCopyright();
			SoftAssert.assertEquals(Actual, Expected);
	
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}