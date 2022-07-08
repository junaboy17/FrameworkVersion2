package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_10742_Organization_ServicesSpecialties_View_001 extends BaseHook{

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
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


