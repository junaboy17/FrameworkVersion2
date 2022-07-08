package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_MyHomePage_Header_Functionality extends BaseHook{

	@Test(priority=1,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void TC_MyHomePage_Manage_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'My Home Page' Header Functionality");
		Expected = "Change Password";
		Actual = Source		.NavigationMenuBar()
							.clickWelcomeUser()
							.readChangePasswordLink();
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = "Logout";
		Actual = Source		.NavigationMenuBar()
							.readLogOutLink();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}
	

}
