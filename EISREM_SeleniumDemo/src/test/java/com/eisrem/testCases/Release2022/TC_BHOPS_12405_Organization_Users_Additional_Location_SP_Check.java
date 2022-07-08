package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_12405_Organization_Users_Additional_Location_SP_Check extends BaseHook{

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Additional_Location_SP_Check(String Module) {
		SoftAssert = new SoftAssert();
		String fName = FirstName + SeleniumHelper.generateRandomAlpha(3);
		String lName = LastName + SeleniumHelper.generateRandomAlpha(3);

		try {
			SeleniumHelper.log.info("Creating user to verify Additional Location service population");
			Expected = "577310";
			Actual =   Source		.DataTable()
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
						.clickAdd()
						.UserHomeOfficeAccord()
						.setUserBaseLocation("base")
						.clickComplete()
						.UserInfoAccord()
						.clickAdditionalOrgLocationAccord()
						.clickAdditionalOrgLocAdd()
						.selectAdditionalOrgLocServicePopulation(3)
						.setAdditionalOrgLocOrganizaiton(OrganizationPrefix2)
						.chooseFirstAdditionalOrgLocLocations()
						.clickComplete()
						.UserStaffPage()
						.clickSubmit()
						.clickPopupOk()
						.DataTable()
						.clickFirstRow()
						.clickEdit()
						.UserStaffPage()
						.clickUserInfoAccord()
						.clickAdditionalOrgLocationAccord()
						.clickAdditionalOrgLocFirstRow()
						.clickEdit()
						.AdditionalOrgLocAccord()
						.getAdditionalOrgLocServicePopulation();

			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}