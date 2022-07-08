package com.eisrem.testCases.Release2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_10820_Types_Planning_Option_Gone extends BaseHook{

	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
		public void TC_Types_Planning_Option_Gone(String Module) {		
			SoftAssert = new SoftAssert();
	
			try{
			SeleniumHelper.log.info("Check that 'Planning' is no longer an option for App Module when adding a Type.");
			SizeExpected = 0;
			SizeActual = Source		.NavigationMenuBar()
								.GetSource()
								.DataTable()
								.clickAdd()
								.TypesPage()
								.clickAppModule()
								.GetSource()
								.SeleniumHelper()
								.Wait(10)
								.GetSource()
								.TypesPage()
								.clickAppModule()
								.GetSource()
								.SeleniumHelper()
								.getWebElementList(By.xpath("//select[@id='module']/option[text()='Planning']"))
								.size();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
}