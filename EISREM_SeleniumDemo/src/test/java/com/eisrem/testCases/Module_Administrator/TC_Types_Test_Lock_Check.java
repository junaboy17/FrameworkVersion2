package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Types_Test_Lock_Check extends BaseHook{
	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Types_Test_Lock_Check_001(String Module) {		
		SoftAssert = new SoftAssert();
		try{
			
			
			SeleniumHelper.log.info("Search for and test Initial Contact Type");
			Expected = False;
			Actual = Source		.TypesPage()
								.setSearch("INITIAL CONTACT")
								.clickFirstRow()
								.clickEdit()
								.TypesPage()
								.isTestFormEnabled();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}