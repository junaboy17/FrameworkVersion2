package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Organization_Identifiers_Edit_With_Service_Pop_001 extends BaseHook{

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Organization_Identifiers_Add_001(String Module) {
		SoftAssert = new SoftAssert();
		String ident1 = "Test Ident" + RandNum3;
		try{
			SeleniumHelper.log.info("Editing Identifiers with service pop");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
			                    .clickLocations()
			                    .clickAdd()
			                    .LocationsPage()
			                    .setName("BHOPS-10749")
			                   	.selectType(LocationType.OTHER_LOCATION.getName())
								.toggleActive(T)
								.DataTable()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(ServicePopulations.ADULT_MH.getName())
								.setDescription(Description)
								.clickComplete()
								.DataTable()
								.clickSubmit()
								.clickPopupOk()
								.OrganizationNavigator()
			                    .clickLocations()
			                    .clickFirstRow()
			                    .clickAnchor()
			                    .OrganizationNavigator()
			                    .clickIdentifier()
			                    .clickAdd()
			                    .IdentifiersPage()
			                    .selectIdentifiersType(1)
			                    .setIdentifiersIdNumber(ident1)
			                    .clickSubmit()
			                    .clickPopupOkIfExist()
			                    .OrganizationNavigator()
			                    .clickIdentifier()
			                    .clickFirstRow()
			                    .clickEdit()
			                    .IdentifiersPage()
			                    .setEndDate(Tomorrow, true, Clear)
			                    .clickSubmit()
			                    .readPopUpMessage();
								
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

}
	}
