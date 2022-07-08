package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_People_Identifiers_Add_Edit_View extends BaseHook{

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_People_Identifiers_Add_001(String Module) {
		SoftAssert = new SoftAssert();
		String IdentifierNumber = SeleniumHelper.generateRandomMedicaidIdentifier();
		
		try{
			SeleniumHelper.log.info("Adding New Person To Work With");
			String PeopleId= Source.PeoplePage().addPersonReturnId();
			
			SeleniumHelper.log.info("Adding Identifiers and verifying successful message");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(PeopleId, Clear)
								.clickFirstColumnLink()
								.clickEdit()
								.DemographicsPage()
								.GetSource()
								.IdentifiersPage()
								.addPeopleIdentifierAndSubmit(Identifier.MEDICAID, IdentifierNumber, Description)
			                    .readPopUpMessage();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

}
	
	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_People_Identifiers_Edit_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			
			
			SeleniumHelper.log.info("Editing Identifiers");
			Expected ="Operation completed successfully.";
			
			Actual=Source		.DataTable()
								.setSearch(LastName)
								.clickFirstColumnLink()
								.clickEdit()
								.DemographicsPage()
								.clickIdentifierTab()
								.clickFirstRow()
			                    .clickEdit()
			                    .IdentifiersPage()
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
	
	@Test(priority=3,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_People_Identifiers_View_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Viewing Identifiers");
			Expected =Today;

			Actual=Source		.DataTable()
//								.setSearch(LastName)
								.clickFirstColumnLink()
								.clickAnchor()
								.DemographicsPage()
								.clickIdentifierTab()
			                    .clickFirstRow()
			                    .clickView()
			                    .IdentifiersPage()
			                    .clickBackToIdentifiersList()
			                    .readFirstResultModifiedDate();

		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

}
	
	
	@Test(priority=4,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_People_Identifiers_DuplicateMEcare_001(String Module) {
		SoftAssert = new SoftAssert();
		
		String IdentNum = SeleniumHelper.generateRandomMedicaidIdentifier();

		try{
			SeleniumHelper.log.info("Adding New Person To Work With");
			String PeopleId= Source.PeoplePage().addPersonReturnId();
			
			SeleniumHelper.log.info("Adding Identifier");
			Expected = Success;

		Actual = 	Source 	.NavigationMenuBar()
							.clickPeople()
							.DataTable()
							.setSearch(PeopleId, Clear)
							.clickFirstRow()
							.clickEdit()
							.DemographicsPage()
							.clickIdentifiersAccord()
							.clickIdentifiersAdd()
							.selectIdentifiersType(1)
							.setIdentifiersIdNumber(IdentNum, Clear)
							.clickComplete()
							.DemographicsPage()
							.clickSubmit()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
							
		SeleniumHelper.log.info("Adding Identifier and Verifying Error Message");
		Expected = "ERROR Message:\n"
				+ "Conflict with existing identifier:\n"
				+ "Client ID="+ PeopleId +", MEDICAID ID="+IdentNum+", Start Date="+ Today +", End Date=null";

		Actual = 	Source 	.Pagefactory()
							.clickPopupOk()
							.PeoplePage()
							.clickPeopleTab()
							.clickFirstRow()
							.clickEdit()
							.DemographicsPage()
							.clickIdentifiersAccord()
							.clickIdentifiersAdd()
							.selectIdentifiersType(1)
							.setIdentifiersIdNumber(IdentNum, Clear)
							.clickComplete()
							.DemographicsPage()
							.clickSubmit()
							.readTopErrorMessage(2);

		SoftAssert.assertEquals(Actual, Expected);
		SoftAssert.assertAll();				
		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}		
	}
	
	@Test(priority=5,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_People_Identifiers_Add_002(String Module) {
		SoftAssert = new SoftAssert();
		
		String IdentifierNumber1 = SeleniumHelper.generateRandomMedicaidIdentifier();

		try{
			SeleniumHelper.log.info("Adding New Person To Work With");
			String PeopleId2= Source.PeoplePage().addPersonReturnId();
			
			SeleniumHelper.log.info("Adding Identifiers and verifying successful message");
			Expected ="Operation completed successfully.";

			Actual=Source		.NavigationMenuBar()
								.clickPeople()
								.DataTable()
								.setSearch(PeopleId2)
								.clickFirstColumnLink()
								.clickEdit()
								.DemographicsPage()
								.GetSource()
								.IdentifiersPage()
								.addPeopleIdentifierAndSubmit(Identifier.MEDICAID, IdentifierNumber1, Description)
			                    .readPopUpMessage();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
}
}
	
	@Test(priority=6,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_People_Identifiers_Edit_002(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Editing Identifiers and verifying successful message");
			Expected ="Operation completed successfully.";

			Actual=Source		.NavigationMenuBar()
								.clickPeople()
								.DataTable()
								.setSearch(LastName)
								.clickFirstColumnLink()
								.clickEdit()
								.DemographicsPage()
								.clickIdentifierTab()
								.clickFirstRow()
			                    .clickEdit()
			                    .IdentifiersPage()
			                    .setDescription(DescriptionUpdated, Clear)
			                    .clickSubmit()
			                    .readPopUpMessage();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
}
}
	@Test(priority=7,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_People_Identifiers_View_002(String Module) {
		SoftAssert = new SoftAssert();
		

		try{
			SeleniumHelper.log.info("Viewing Identifiers");
			Expected =Today;

			Actual=Source		.NavigationMenuBar()
								.clickPeople()
								.DataTable()
								.setSearch(LastName)
								.clickFirstColumnLink()
								.clickAnchor()
								.DemographicsPage()
								.clickIdentifierTab()
			                    .clickFirstRow()
			                    .clickView()
			                    .IdentifiersPage()
			                    .clickBackToIdentifiersList()
			                    .readFirstResultModifiedDate();   
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
}
}
}