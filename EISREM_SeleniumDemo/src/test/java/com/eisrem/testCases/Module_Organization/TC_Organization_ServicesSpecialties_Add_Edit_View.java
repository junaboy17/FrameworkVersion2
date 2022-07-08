package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Organization_ServicesSpecialties_Add_Edit_View extends BaseHook{

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Organization_ServicesSpecialties_Add_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding ServicesSpecialties");
			Expected ="Operation completed successfully.";
			
			String orgId = Source.OrganizationPage().addCompleteOrganizationPageSubmitAndReturnId();

			Actual=Source		.DataTable()
								.setSearch(orgId)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
			                    .clickServicesSpecialties()
			                    .ServicesSpecialtiesPage()
			                    .clickAdd()
			                    .ServicesSpecialtiesPage()
			                    .selectServices("CRISIS")
			                    .selectSpecialties("CRISIS RESOLUTION-CHILDREN")
			                    .chooseCovergeArea("STATEWIDE")
			                    .clickSubmit()
			                    .readPopUpMessage();
	
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

}

	@Test(priority=2,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Organization_ServicesSpecialties_Edit_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Editing ServicesSpecialties");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
			                    .clickServicesSpecialties()
			                    .ServicesSpecialtiesPage()
								.clickFirstColumnLink()
			                    .clickEdit()
			                    .ServicesSpecialtiesPage()
			                    .setDescription(UpdateDescription, Clear)		                    
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
	public void TC_Organization_ServicesSpecialties_View_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying coverage button is disabled while in view mode");
			Expected =True;
			Actual =Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickServicesSpecialties()
								.ServicesSpecialtiesPage()
								.clickFirstRow()
								.clickView()
								.SeleniumHelper()
								.getAttribute(Source.ServicesSpecialtiesPage().CoverageButton, "disabled");
			SoftAssert.assertEquals(Actual, Expected);

					Source		.ServicesSpecialtiesPage()
								.clickBackToServices();
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}
}

