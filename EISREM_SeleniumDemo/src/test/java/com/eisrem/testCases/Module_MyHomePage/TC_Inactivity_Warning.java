package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Inactivity_Warning extends BaseHook{

	@Test(priority=1,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void TC_Login_Legend_Check_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Logging in & triggering session time out");
			
			Expected =	"Session TimeOut Warning!";
						Source	.SeleniumHelper()
								.endCurrentUserSession();
									
			SeleniumHelper.log.info("Verifying session timeout title");			
			Actual = Source		.DataTable()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
		
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
