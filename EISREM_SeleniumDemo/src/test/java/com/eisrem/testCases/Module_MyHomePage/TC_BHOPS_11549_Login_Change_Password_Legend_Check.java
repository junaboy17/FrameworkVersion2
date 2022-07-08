package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11549_Login_Change_Password_Legend_Check extends BaseHook {
	
	@Test(priority=1,dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void TC_Change_Password_Legend_Check(String Module) {
	
		SoftAssert = new SoftAssert();
		try{
			SeleniumHelper.log.info("Confirming that 'Verification' legend is present on Change Password page");

			Expected= True;
			
			Actual=Source	.MyHomePage()
							.expandUserMenu()
							.selectChangePassword()
							.GetSource()
							.ChangePasswordPage()
							.checkLegendExists();
					
		 		
			SoftAssert.assertEquals(Actual, Expected);
		 
			SoftAssert.assertAll();	
			
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
		}
	
	}
	
}


