package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Organization_Users_Verify_Locations_001 extends BaseHook{

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Organization_Users_Verify_Locations(String Module) {
		SoftAssert = new SoftAssert();
		String fName = FirstName + SeleniumHelper.generateRandomAlpha(3);
		String lName = LastName + SeleniumHelper.generateRandomAlpha(3);

		try {
			SeleniumHelper.log.info("test");
			ExpectedB = F;
			ActualB =   Source	.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(fName)
								.setLastName(lName)
								.clickUserInfoAccord()
								.setUserName(UserName)
								.setPassword(TestPassword)
								.setPasswordConfirmation(TestPassword)
								.GetSource()
								.UserHomeOfficeAccord()
								.setUserHomeOfficeBaseLocationAndSubmit()
								.GetSource()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.clickAdditionalOrgLocAdd()
								.setAdditionalOrgLocOrganizaiton(OrganizationPrefix2)
								.verifyLocations();

			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}