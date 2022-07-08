package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class Duplicate_Entry extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Duplicate_Associations(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying error message for duplicate associations entry");
			Expected = "Conflict with existing Association";
			Actual = Source			.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillAllDemogrphicsWithIdentifier()
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickAssociationsTab()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.setOrganization("ACME BEHAVIORAL HEALTHCARE")
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.setOrganization("ACME BEHAVIORAL HEALTHCARE")
									.clickSubmit()
									.readTopErrorMessage(2);
			Source.SeleniumHelper().containsText(Actual, Expected);

			SoftAssert.assertAll();		
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		

	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Duplicate_Identifier_Accordion(String Module) {
		
		String IdentifierNumber = SeleniumHelper.generateRandomMedicaidIdentifier();
		String IdentifierNumber2 = SeleniumHelper.generateRandomMedicaidIdentifier();
		String OrgName = "ACME BEHAVIORAL HEALTHCARE";
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying error message for duplicate identifier entry");
			ID = 	Source			.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphicsWithIdentifier(FirstName, LastName, Gender.MALE, DateOfBirth, Identifier.MEDICAID, IdentifierNumber)
									.GetSource()
									.DemographicsPage()
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickAssociationsTab()
									.DataTable()
									.clickAdd()
									.AssociationsPage()
									.selectAssociationType(2)
									.setOrganization(OrgName)
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickPeopleTab()
									.readFirstResultID()
									.replace("Select", EmptyString)
									.replace(" ", EmptyString);
			
			Expected = "ERROR Message:\n"
					+ "Conflict with existing identifier:\n"
					+ "Client ID=" + ID + ", MEDICAID ID=" + IdentifierNumber + ", Start Date=" + Today + ", End Date=null";
			Actual = Source			.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphicsWithIdentifier(FirstName, LastName, Gender.MALE, DateOfBirth, Identifier.MEDICAID, IdentifierNumber)
									.GetSource()
									.DemographicsPage()
									.clickSubmit()
									.readTopErrorMessage(2);
			Source.SeleniumHelper().containsText(Actual, Expected);
			
			Expected =	Success;
			Actual = Source			.DataTable()
									.clickFirstRow()
									.clickEdit()
									.IdentifiersPage()
									.setIdentifiersIdNumber(IdentifierNumber2, "Y")
									.clickComplete()
									.DemographicsPage()
									.clickSubmit()
									.readPopUpTitle();
			Source.SeleniumHelper().containsText(Actual, Expected);
									
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
		
	}
	
	

