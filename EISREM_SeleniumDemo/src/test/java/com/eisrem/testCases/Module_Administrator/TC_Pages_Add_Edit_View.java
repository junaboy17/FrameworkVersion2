package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Pages_Add_Edit_View extends BaseHook{
	
	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
		public void TC_Pages_Add_001(String Module) {		
			SoftAssert = new SoftAssert();

			try{	
				SeleniumHelper.log.info("Add a new unlocked page");
				Expected = Success;
				Actual = Source   	.AdministratorNavigator()
									.clickPages()
									.clickAdd()
									.PagesPage()
									.setPageName(PageName)
									.setDescription(Description)
									.clickSubmit()
									.readPopUpTitle();
				
				SoftAssert.assertEquals(Actual, Expected);
				SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
				SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}