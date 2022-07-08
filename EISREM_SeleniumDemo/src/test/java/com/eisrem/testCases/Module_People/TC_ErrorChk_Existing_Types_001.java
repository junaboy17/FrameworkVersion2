package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_ErrorChk_Existing_Types_001 extends BaseHook {

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_People_Associations_Existing_Assoc_ErrorChk_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding New Person To Work With");
			String PeopleId= Source.PeoplePage().addPersonReturnId();
			
			SeleniumHelper.log.info("Verifying Organization Combobox filter function is able to filter results");					
			Source				.AssociationsPage()
								.addCompleteAssociationAndSubmit(PeopleId, Today, Today, AssociationType.SERVICE_POPULATION, null, null, ServicePopulations.SUBSTANCE_USE, null, Description);

			SeleniumHelper.log.info("Reading Service Population ID Number");
				ID = Source		.Pagefactory()
								.DataTable()
								.readDataTable(5, 1)
								.replace("Select", EmptyString)
								.replace(" ", EmptyString);

			SeleniumHelper.log.info("Conflict with existing Association, 1435284, Start Date=12/21/2021, End Date=12/21/2021. If you cannot resolve the conflict, Please contact the appropriate Admin Staff:\n"
					+ "Children's: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n"
					+ "OBH: EIS.OBH@maine.gov");
			Expected = "Conflict with existing Association, " + ID + ", Start Date=" + Today + ", End Date=" + Today +". If you cannot resolve the conflict, Please contact the appropriate Admin Staff:\n"
					+ "Children's: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n"
					+ "OBH: EIS.OBH@maine.gov";
			Actual = Source		.DataTable()
								.clickAdd()
								.AssociationsPage()
								.addCompleteAssociation(PeopleId, Today, null, AssociationType.SERVICE_POPULATION, null, null, ServicePopulations.SUBSTANCE_USE, null, Description)
								.clickSubmit()
								.readTopErrorMessage(2);
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying Organization Combobox filter function is able to filter results");
			Expected = "Associations";
			Actual = Source		.AssociationsPage()
								.clickBackToAssociation()
								.clickDiscard()
								.PeopleNavigator()
								.readAssociationsTab();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}