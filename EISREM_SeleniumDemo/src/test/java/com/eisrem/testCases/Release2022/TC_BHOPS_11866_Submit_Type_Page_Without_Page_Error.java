package com.eisrem.testCases.Release2022;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11866_Submit_Type_Page_Without_Page_Error extends BaseHook{

	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
		public void Test_Triggered_Pages_With_Popup(String Module) {		
			SoftAssert = new SoftAssert();
			String TypeName = "TC_Types_Selenium " + SeleniumHelper.generateRandomNumber(8);
	
			try{
			SeleniumHelper.log.info("Attempting to submit a Type Page without a Page.");
			Expected = "Please select a valid page from the page dropdown";
			Actual = Source		.NavigationMenuBar()
								.GetSource()
								.DataTable()
								.clickAdd()
								.TypesPage()
								.selectAppModule(AppModule.NOTES.getIndex())
								.setName(TypeName)
								.setDescription(Description)
								.selectLockTime(LockTime.NEVER.getIndex())
								.selectAppAreaToConductType(AppAreaConductType.BOTH.getIndex())
								.clickAdd()
								.PagesAvailableAccord()
								.setPage("-1000")
								.setSortOrder(OneN)
								.clickComplete()
								.SeleniumHelper()
								.readElement(By.xpath("//ul[@id='errorMessages']/li[2]"))
									.replace("\"", "")
									.trim();
			
			SoftAssert.assertEquals(Actual, Expected, "The error message does not match.");
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
}