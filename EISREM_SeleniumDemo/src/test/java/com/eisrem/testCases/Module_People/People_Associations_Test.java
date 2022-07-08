package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class People_Associations_Test extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Associations_Add_001(String Module) {
		SoftAssert = new SoftAssert();

		try{	
			
			SeleniumHelper.log.info("Verifying Successful add of an Association Type to an individual");
			Expected ="Success!";
			Actual = Source		.PeopleNavigator()
								.clickPeopleTab()
								.DataTable()
								.clickAdd()
								.DemographicsPage()
								.fillAllDemogrphicsNoIdentifier()
								.clickSubmit()
								.clickPopupOk()
								.PeopleNavigator()
								.clickAssociationsTab()
								.DataTable()
								.clickAdd()
								.AssociationsPage()
								.selectAssociationType(AssociationType.SERVICE_POPULATION.getIndex())
								.selectServicePopulation(ServicePopulations.SUBSTANCE_USE.getName())
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SoftAssert.assertAll();
			
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Association_Add_002(String Module) {
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying Successful add of an Association Type to an individual");
			Expected ="Success!";	
			Actual = Source		.PeopleNavigator()
								.clickPeopleTab()
								.DataTable()
								.clickAdd()
								.DemographicsPage()
								.fillAllDemogrphicsNoIdentifier()
								.clickSubmit()
								.clickPopupOk()
								.PeopleNavigator()
								.clickAssociationsTab()
								.DataTable()
								.clickAdd()
								.AssociationsPage()
								.selectAssociationType(2)
								.setOrganization(FullSearch)
								.clickSubmit()
								.readPopUpTitle();	
			SoftAssert.assertEquals(Actual, Expected);
			SoftAssert.assertAll();
				
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=3,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Associations_Check_Dup_Message(String Module) {
	SoftAssert = new SoftAssert();

	try{
		
		SeleniumHelper.log.info("Verifying Associations Check Dup error message");
		Actual =	 Source			.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillAllDemogrphicsNoIdentifier()
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickAssociationsTab()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(AssociationType.SERVICE_POPULATION.getIndex())
									.selectServicePopulation(ServicePopulations.SUBSTANCE_USE.getName())
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
	 								.clickPeopleTab()
	 								.DataTable()
	 								.setSearch(FirstName, "y")
	 								.clickFirstRow()
	 								.clickAnchor()
	 								.PeopleNavigator()
	 								.clickAssociationsTab()
	 								.DataTable()
	 								.clickAdd()
	 								.AssociationsPage()
	 								.selectAssociationType(AssociationType.SERVICE_POPULATION.getIndex())
	 								.selectServicePopulation(ServicePopulations.SUBSTANCE_USE.getName())
	 								.clickSubmit()
	 								.readTopErrorMessage(2);
	 
		String associationEntry = Actual.substring(36, 43);

		Expected = "Conflict with existing Association, " + associationEntry + ", Start Date=" + Today +", End Date=" + null + ". If you cannot resolve the conflict, Please contact the appropriate Admin Staff:\n"
				+ "Children's: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n"
				+ "OBH: EIS.OBH@maine.gov";

		SoftAssert.assertEquals(Actual, Expected);
		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
				
	}
	
	@Test(priority=4,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Associations_Edit_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying Successful edit of an Association Type for an individual");
			Expected ="Success!";

			Actual = Source			.PeopleNavigator()
									.clickPeopleTab()
									.DataTable()
									.setSearch(FirstName, "y")
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickAssociationsTab()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.AssociationsPage()
									.setDescription( " - UPDATED", "y")
									.setEndDateTTextBox(TodayDash, "y")
									.clickSubmit()
									.readPopUpTitle();	
			SoftAssert.assertEquals(Actual, Expected);
			SoftAssert.assertAll();
				
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=5,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Associations_Existing_Assoc_ErrorChk_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying Associations Existing Assoc error check");

			SoftAssert = new SoftAssert();
			Actual=		Source			.PeopleNavigator()
										.clickPeopleTab()
										//Adding new person
										.DataTable()
										.clickAdd()
										.DemographicsPage()
										.fillAllDemogrphicsNoIdentifier()
										.clickSubmit()
										.clickPopupOk()
										//Adding new association
										.PeopleNavigator()
										.clickAssociationsTab()
										.DataTable()
										.clickAdd()
										.AssociationsPage()
										.setEndDateTTextBox(TodayDash, "y")
										.selectAssociationType(AssociationType.SERVICE_POPULATION.getIndex())
										.selectServicePopulation(ServicePopulations.SUBSTANCE_USE.getName())
										.clickSubmit()
										.clickPopupOk()
										//Attempt to add same association
										.PeopleNavigator()
										.clickAssociationsTab()
										.DataTable()
										.clickAdd()
										.AssociationsPage()
										.selectAssociationType(AssociationType.SERVICE_POPULATION.getIndex())
										.selectServicePopulation(ServicePopulations.SUBSTANCE_USE.getName())
										.clickSubmit()
										//check error
										.readTopErrorMessage(2);
			String associationEntry = Actual.substring(36, 43);
			Expected=	"Conflict with existing Association, " + associationEntry + ", Start Date=" + Today +", End Date=" + Today +". If you cannot resolve the conflict, Please contact the appropriate Admin Staff:\n"
					+ "Children's: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n"
					+ "OBH: EIS.OBH@maine.gov";

			SoftAssert.assertEquals(Actual, Expected);
			SoftAssert.assertAll();	
	
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=6,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Associations_Existing_Identifier_ErrorChk_001(String Module) {
		SoftAssert = new SoftAssert();
		String IdentifierNumber = SeleniumHelper.generateRandomMedicaidIdentifier();

		try{
			
			SeleniumHelper.log.info("Verifying Associations Existing Identifier error check");
			Expected ="Success!";
		
			Actual = Source		.PeopleNavigator()
								.clickPeopleTab()
								.DataTable()
								.clickAdd()
								.DemographicsPage()
								.fillAllDemogrphicsNoIdentifier()
								.clickSubmit()
								.clickPopupOk()
								.PeopleNavigator()
								.clickPeopleTab()
								.DataTable()
								.setSearch(FirstName, "y")
								.clickFirstRow()
								.clickFirstRow()
								.clickEdit()
								.PeopleNavigator()
								.clickIdentifierTab()
								.DataTable()
								.clickAdd()
								.DataTable()
								.setEndDate(TodayDash, "y")
								.GetSource()
								.IdentifiersPage()
								.selectIdentifiersType(2)
								.setIdentifiersIdNumber(IdentifierNumber)
								.clickSubmit()
								.DataTable()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
													
	}
	
	@Test(priority=7,dataProvider = People, dataProviderClass = DataProviders.class)
	public void People_Association_View_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying Successful view of an Association Type for an individual");

			Source				.PeopleNavigator()
								.clickPeopleTab()
								.DataTable()
								.setSearch(FirstName, "y")
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickAssociationsTab()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.AssociationsPage()
								.clickBackToAssociation();
			
			SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
}
