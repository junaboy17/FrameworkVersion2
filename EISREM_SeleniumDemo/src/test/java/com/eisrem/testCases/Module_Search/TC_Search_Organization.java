package com.eisrem.testCases.Module_Search;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;


public class TC_Search_Organization extends BaseHook{
	@Test(priority=1,dataProvider = Search, dataProviderClass = DataProviders.class)
	public void TC_Search_Organization_002(String Module) {
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = OneN;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.ORGANIZATION.getName())
								.setSearchBy(SearchBy.NAME.getName())
								.setValue(OrgDHHS)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);

			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditOrganizationHeader;					
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