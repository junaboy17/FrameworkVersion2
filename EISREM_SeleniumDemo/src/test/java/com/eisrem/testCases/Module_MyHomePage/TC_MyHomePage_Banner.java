package com.eisrem.testCases.Module_MyHomePage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_MyHomePage_Banner extends BaseHook{

	@Test(priority=1, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_MyHomePage_Banner_001(String Module) {
		SoftAssert = new SoftAssert();

		String Notification = "Test Notification " + SeleniumHelper.generateRandomNumber(4);
		
		try{
		
		SeleniumHelper.log.info("Creating a Notification for testing");
		Expected = Success;
		Actual = Source		.AdministratorNavigator()
							.clickAdministratorMessages()
							.clickAdd()
							.AdministratorMessagesPage()
							.selectMessagesType(2)
							.setDescription(Notification)
							.GetSource()
							.AdministratorMessagesPage()
							.clickInternalToggle(False)
							.clickActiveToggle(True)
							.clickSubmit()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);	
		
		SeleniumHelper.log.info("Verifying Warning Banner Font Size");
		Expected = "14px";
		Actual = Source		.Pagefactory()
							.clickPopupOk()
							.NavigationMenuBar()
							.clickWelcomeUser()
							.clickLogOut()
							.GetSource()
							.LogInPage()
							.GetSource()
							.SeleniumHelper()
							.getWebElement(By.xpath("//div[@id='msgwarningdiv']")).getCssValue("font-size");
		SoftAssert.assertEquals(Actual, Expected);	
			
		SeleniumHelper.log.info("Verifying Warning Banner Background Color");
		Expected = "rgba(252, 248, 227, 1)";
		Actual = Source		.SeleniumHelper()
							.getWebElement(By.xpath("//div[@id='msgwarningdiv']")).getCssValue("background-color");
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Notification Banner Font Size");
		Expected = "14px";
		Actual = Source		.SeleniumHelper()
							.getWebElement(By.xpath("//div[@id='msgdiv']")).getCssValue("font-size");
		SoftAssert.assertEquals(Actual, Expected);	
			
		SeleniumHelper.log.info("Verifying Notification Banner Background Color");
		Expected = "rgba(217, 237, 247, 1)";
		Actual = Source		.SeleniumHelper()
							.getWebElement(By.xpath("//div[@id='msgdiv']")).getCssValue("background-color");
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Disabling created Notifcation");
		Expected = Success;
		Actual = Source		.LogInPage()
							.LogInSeleniumUser()
							.GetSource()
							.NavigationMenuBar()
							.clickAdministrator()
							.clickAdministratorMessages()
							.DataTable()
							.setSearch(Notification)
							.clickFirstRow()
							.clickEdit()
							.AdministratorMessagesPage()
							.clickActiveToggle(False)
							.clickSubmit()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}
	

}
