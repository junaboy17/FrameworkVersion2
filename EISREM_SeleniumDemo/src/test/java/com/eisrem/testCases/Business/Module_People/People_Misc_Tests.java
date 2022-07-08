package com.eisrem.testCases.Business.Module_People;

import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class People_Misc_Tests extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Clear_Anchor_Test(String Module) {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Anchoring onto a person and reading Anchored information");
			Expected =	"\n" +
					JeanneAnchoredData;
			Actual =	Source	.DataTable()
								.setSearch(JeanneID)
								.clickFirstRow()
								.clickAnchor()
								.Pagefactory()
								.readAnchoredInfo().replace("Anchored to:", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Clearing Anchor and reading Anchored information");
			Expected =	"Anchor cleared";
			Actual =	Source	.Pagefactory()
								.clickClearAnchor()
								.readAnchoredInfo();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();		
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Excel_Test(String Module) {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Downloading Excel from People and verifying all results");
			List<String> data;

					Source		.PeoplePage()
								.setSearch(JeanneID + Keys.TAB)
								.clickExcel();
								
			data = Source.SeleniumHelper().getTextFromWebElements(Source.DataTable().allDataResult);
			Source				.SeleniumHelper()
								.verifyExcelText(data, "download/People_export.xlsx", "Data");
			
			SoftAssert.assertAll();		
					
		}
		
		catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}

	@Test(priority=3,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Logout_Test(String Module) {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Anchoring onto a person and reading Anchored information");
			Expected =	"Login";
			Actual =	Source	.NavigationMenuBar()
								.LogOut()
								.readLogInTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}				
	}


}