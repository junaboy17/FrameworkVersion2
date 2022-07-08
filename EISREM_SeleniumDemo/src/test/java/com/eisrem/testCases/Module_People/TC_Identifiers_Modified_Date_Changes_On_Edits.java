package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Identifiers_Modified_Date_Changes_On_Edits extends BaseHook{

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_Identifiers_Modified_Date_Changes_On_Edits_1(String Module) {
		SoftAssert = new SoftAssert();
		
		String NotesDes = "SELENIUM TEST EDIT" + RandNum3;
		String fname = "Chris" + SeleniumHelper.generateRandomAlpha(3);
		String lname = "Bacon" + SeleniumHelper.generateRandomAlpha(3);
		String IdentNumber = SeleniumHelper.generateRandomMedicaidIdentifier();
		String IdentNumber2 = "Test Ident" + RandNum3;
		
		try{
			SeleniumHelper.log.info("Adding Persons Details and Verifying Success");
			Expected =	Success;
			Actual = Source	.PeoplePage()
							.DataTable()
							.clickAdd()
							.DemographicsPage()
							.setFirstName(fname)
							.setMiddleName(MiddleName)
							.setLastName(lname)
							.selectDemographicsGender(2)
							.setDateOfBirth(DateOfBirth)
							.clickSubmit()
							.readPopUpTitle();
							
					SoftAssert.assertEquals(Actual, Expected);
					
			SeleniumHelper.log.info("Adding Identifiers and Verifying Success");
			Expected = Success;
			Actual = Source	.Pagefactory()
							.clickPopupOk()
							.AssociationsPage()
							.clickPeopleTab()
							.DataTable()
							.setSearch(fname, Clear)
							.clickModifiedDateSort()
							.clickFirstRow()
							.clickEdit()
							.DemographicsPage()
							.clickIdentifierTab()
							.DataTable()
							.clickAdd()
							.IdentifiersPage()
							.selectIdentifiersType(1)
							.setIdentifiersIdNumber(IdentNumber)
							.clickSubmit()
							.readPopUpTitle();
														
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Identifiers Description and Verifying Success");
			Expected = Success;
			Actual = Source	.Pagefactory()
							.clickPopupOk()
							.DataTable()
							.clickModifiedDateSort()
							.clickFirstRow()
							.clickEdit()
							.IdentifiersPage()
							.setDescription(NotesDes, Clear)
							.clickSubmit()
							.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			
			SeleniumHelper.log.info("Editing and Verifying Identifier Notes");
			Expected =Success;
			Actual = 
					Source .Pagefactory()
							.clickPopupOk()
							.PeoplePage()
							.clickPeopleTab()
							.DataTable()
							.setSearch(fname, Clear)
							.clickModifiedDateSort()
							.clickFirstRow()
							.clickEdit()
							.DemographicsPage()
							.clickIdentifierTab()
							.clickModifiedDateSort()
							.clickFirstRow()
							.clickEdit()
							.IdentifiersPage()
							.setDescription(NotesDes, Clear)
							.clickSubmit()
							.readPopUpTitle();	
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Modifying and Verifying Identifier Notes 2");
			Expected = Success;
			Actual = Source .Pagefactory()
							.clickPopupOk()
							.PeoplePage()
							.clickPeopleTab()
							.DataTable()
							.setSearch(fname, Clear)
							.clickModifiedDateSort()
							.clickFirstRow()
							.clickAnchor()
							.DemographicsPage()
							.clickIdentifierTab()
							.clickFirstRow()
							.clickEdit()
							.IdentifiersPage()
							.setDescription(NotesDes, Clear)
							.clickSubmit()
							.readPopUpTitle();
												
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Identifier and verifying success");
			Expected =Today;
			Actual = Source .Pagefactory()
							.clickPopupOk()
							.PeoplePage()
							.clickPeopleTab()
							.DataTable()
							.setSearch(fname, Clear)
							.clickModifiedDateSort()
							.clickFirstRow()
							.clickEdit()
							.DemographicsPage()
							.clickSubmit()
							.clickPopupOk()
							.DemographicsPage()
							.clickPeopleTab()
							.DataTable()
							.readDataTable(1, 5);		
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Ogranizations Identifier and verifying success");
			Expected =Success;
			Actual = Source .PeoplePage()
							.GetSource()
							.LocationsPage()
							.addCompleteLocationAndSubmit(OrgDHHS)
							.DataTable()
							.clickFirstRow()
							.clickAnchor()
							.OrganizationPage()
							.clickIdentifier()
							.clickAdd()
							.IdentifiersPage()
							.selectIdentifiersType(1)
							.setIdentifiersIdNumber(IdentNumber2, Clear)
							.clickSubmit()
							.clickPopupOk()
							.IdentifiersPage()
							.clickIdentifier()
							.DataTable()
							.clickFirstRow()
							.clickEdit()
							.IdentifiersPage()
							.setDescription(NotesDes, Clear)
							.clickSubmit()
							.readPopUpTitle();	
						SoftAssert.assertEquals(Actual, Expected);
						
						
			SeleniumHelper.log.info("Editing Ogranizations Identifier and verifying success");
			Expected =Success;
			Actual = Source .Pagefactory()
							.clickPopupOk()
							.IdentifiersPage()
							.GetSource()
							.LocationsPage()
							.clickLocations()
							.DataTable()
							.clickModifiedDateSort()
							.clickModifiedDateSort()
							.clickFirstRow()
							.clickEdit()
							.LocationsPage()
							.setEndDate(Today, Clear)
							.clickSubmit()
							.readPopUpTitle();
						SoftAssert.assertEquals(Actual, Expected);
						
			SeleniumHelper.log.info("Reading Modified Info and verifying success");
			Expected =Today;
			Actual = Source .Pagefactory()
								.clickPopupOk()
								.DataTable()
								.readDataTable(1, 5);
						SoftAssert.assertEquals(Actual, Expected);
						
						SoftAssert.assertAll();
				
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
}
}
}