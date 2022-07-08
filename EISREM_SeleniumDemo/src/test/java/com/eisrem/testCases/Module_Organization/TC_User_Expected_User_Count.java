package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_User_Expected_User_Count extends BaseHook{

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_User_Expected_User_Count_001(String Module) {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Anchoring to DHHS and checking number of entries in Users/Staff");
			Expected = Source		.DataTable()
									.setSearch(OrgDHHS)
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.clickUsersStaff()
									.DataTable()
									.readShowNumOfEntries();

			SeleniumHelper.log.info("Anchoring any Location under DHHS and confirming number of entries has not changed in Users/Staff");
			Actual = 	Source		.OrganizationNavigator()
									.clickLocations()
									.DataTable()
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.clickUsersStaff()
									.DataTable()
									.readShowNumOfEntries();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}