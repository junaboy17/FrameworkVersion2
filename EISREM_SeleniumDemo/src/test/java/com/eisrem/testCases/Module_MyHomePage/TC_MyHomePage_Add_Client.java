package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_MyHomePage_Add_Client extends BaseHook{

	@Test(priority=1, dataProvider = MyHomePage, dataProviderClass = DataProviders.class)
	public void TC_MyHomePage_Add_Client_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding a Client to My Client section in My HomePage DashBoard");
			Expected = "ID";
			Actual = Source	.MyHomePage()
							.clickMyClientsManage()
							.setAvailableFilter(JeanneClient, Clear)
							.selectAvailableClient(1)
							.clickAdd()
							.clickSaveMyClients()
							.clickGoBackToList()
							.MyHomePage()
							.setSearchMyClients(JeanneClient, Clear)
							.readMyClientsId();
	
			SoftAssert.assertEquals(Actual, Expected);
				
			SoftAssert.assertAll();
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();

		}
	}
}
