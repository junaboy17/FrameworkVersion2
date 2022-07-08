package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Pages_DataTable_Rows extends BaseHook{
	
	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Pages_DataTable_Rows_001(String Module) {		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying 'Show Entries' Drop Down");
			Expected = False;
			Actual = Source	.AdministratorNavigator()
							.clickPages()
							.GetSource()
							.DataTable()
							.validateRecordIds();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
	
}