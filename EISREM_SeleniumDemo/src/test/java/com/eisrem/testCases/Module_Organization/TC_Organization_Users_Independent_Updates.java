package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Organization_Users_Independent_Updates extends BaseHook{

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void Users_Independent_Updates(String Module) {
		SoftAssert = new SoftAssert();
		String randalph3 = SeleniumHelper.generateRandomAlpha(3);
		String fName = "First" + randalph3;
		String lName = "Last" + randalph3;
		String uName = fName + lName + SeleniumHelper.generateRandomNumber(3);
		
		try {
			SeleniumHelper.log.info("Creating a full User/Staff and verifying success");
			Expected = Success;
			Actual = Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(fName)
								.setLastName(lName)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Success;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.setSearch(fName)
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.clickUserActiveToggle(True)
								.setUserName(uName)
								.setPassword(TestPassword, Clear)
								.setPasswordConfirmation(TestPassword, Clear)
								.clickAdd()
								.UserHomeOfficeAccord()
								.setUserBaseLocation("a")
								.clickComplete()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.clickAdditionalOrgLocAdd()
								.GetSource()
								.SeleniumHelper()
								.Wait(2)
								.GetSource()
								.AdditionalOrgLocAccord()
								.setAdditionalOrgLocOrganizaiton(OrgDHHS)
								.chooseAdditionalOrgLocLocations("AUGUSTA")
								.clickComplete()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.selectRole(Enumerations.Roles.ALLAPPS.getName())
								.clickComplete()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation(Enumerations.ServicePopulations.CHILDRENS.getIndex())
								.clickComplete()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.GetSource()
								.IdentifiersPage()
								.addIdentifierandSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirming Modified Date is Today");
			Expected = Today;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Today;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.DataTable()
								.readDataTable("loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.DataTable()
								.readDataTable("addtnl-loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.DataTable()
								.readDataTable("role-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);		

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.DataTable()
								.readDataTable("sp-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);	

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickIdentifiersAccord()
								.DataTable()
								.readDataTable("idnt-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.UserInfoAccord()
								.clickBackTo()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Setting User End Date, adding a new Role and verifying Modified Date is Today");
			Expected = Today;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.GetSource()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.clickRolesFirstRow()
								.clickRolesEdit()
								.setEndDate(Today)
								.clickComplete()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(Enumerations.Roles.CS_STATE_PROVIDER.getIndex())
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.DataTable()
								.readDataTable("loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.DataTable()
								.readDataTable("addtnl-loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.DataTable()
								.readDataTable("role-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);		

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.DataTable()
								.readDataTable("sp-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);	

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickIdentifiersAccord()
								.DataTable()
								.readDataTable("idnt-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.DataTable()
								.clickBackTo()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
								
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Setting Identifier End Date, adding a new Identifier and verifying Modified Date is Today");
			Expected = Today;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.GetSource()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickIdentifiersAccord()
								.clickIdentifiersFirstRow()
								.clickIdentifiersEdit()
								.setEndDate(Today, Clear)
								.clickComplete()
								//.SeleniumHelper()
								//.scrollToBottom()
								.DemographicsPage()
								.clickIdentifiersAccord()
								.GetSource()
								.IdentifiersPage()
								.addIdentifierandSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readDataTable("loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);
										
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.DataTable()
								.readDataTable("addtnl-loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.DataTable()
								.readDataTable("role-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);		

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.DataTable()
								.readDataTable("sp-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);	

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickIdentifiersAccord()
								.DataTable()
								.readDataTable("idnt-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.Pagefactory()
								.clickBackTo()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Setting Users Access/Associations to Additional Organizations and Location Records End Date, adding another and verifying Modified Date is Today");
			Expected = Today;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.clickAdditionalOrgLocFirstRow()
								.clickAdditionalOrgLocEdit()
								.setAdditionalOrgLocEndDate(Today)
								.clickComplete()
								.AdditionalOrgLocAccord()
								.clickAdditionalOrgLocAdd()
								.GetSource()
								.SeleniumHelper()
								.Wait(2)
								.GetSource()
								.AdditionalOrgLocAccord()
								.setAdditionalOrgLocOrganizaiton(OrgDHHS)
								.chooseAdditionalOrgLocLocations("AUGUSTA")
								.GetSource()
								.SeleniumHelper()
								.Wait(5)
								.GetSource()
								.AdditionalOrgLocAccord()
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readDataTable("loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.DataTable()
								.readDataTable("addtnl-loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.DataTable()
								.readDataTable("role-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);		

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.DataTable()
								.readDataTable("sp-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);	

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickIdentifiersAccord()
								.DataTable()
								.readDataTable("idnt-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.Pagefactory()
								.clickBackTo()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.GetSource()
								.SeleniumHelper()
								.sleep(1)
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.clickSPFirstRow()
								.clickSpEdit()
								.setEndDate(Today)
								.clickComplete()
								.ServicePopulationsAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation(Enumerations.ServicePopulations.CHILDRENS.getIndex())
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readDataTable("loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.DataTable()
								.readDataTable("addtnl-loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.DataTable()
								.readDataTable("role-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);		

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.DataTable()
								.readDataTable("sp-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);	

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickIdentifiersAccord()
								.DataTable()
								.readDataTable("idnt-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.Pagefactory()
								.clickBackTo()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}