package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Organization_Identifiers_Add_Edit_View extends BaseHook{

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Organization_Identifiers_Add_001(String Module) {
		SoftAssert = new SoftAssert();
			
		try{
			SeleniumHelper.log.info("Adding Identifiers");
			Expected ="Operation completed successfully.";

			Actual=Source		.OrganizationPage()
								.addOrganizationIdentifierandSubmit()
			                    .readPopUpMessage();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

}
	
	@Test(priority=2,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Organization_Identifiers_Edit_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Editing Identifiers");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.clickFirstColumnLink()
				                .clickAnchor()
				                .LocationsPage()
				                .clickIdentifier()
								.clickFirstColumnLink()
				                .clickEdit()
				                .IdentifiersPage()
				                .setDescription("Updated")
				                .clickSubmit()
				                .readPopUpMessage();
	
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

}
	
	@Test(priority=3,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Organization_Identifiers_View_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Viewing Identifiers");
			ExpectedB =true;

			ActualB=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.clickFirstColumnLink()
				                .clickAnchor()
				                .LocationsPage()
				                .clickIdentifier()
								.clickFirstColumnLink()
				                .clickView()
				                .IdentifiersPage()
				                .clickBackToIdentifiersList()
				                .isActiveTab("Identifier");

		SoftAssert.assertEquals(ActualB, ExpectedB);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

}
	}

