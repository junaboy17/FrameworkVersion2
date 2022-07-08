package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class People_Name_Caps extends BaseHook {

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_People_Name_Caps(String Module) {

		SoftAssert = new SoftAssert();
		
		String FName = FirstName + SeleniumHelper.generateRandomAlpha(3);
		String people = LastName + ", " + FName +  " (" + DateOfBirth + ")";
		String IdentifierNumber = SeleniumHelper.generateRandomMedicaidIdentifier();

		try{
			SeleniumHelper.log.info("Adding a Person with Identifier and verifying successful add");
			Expected =	people.toUpperCase();
			Actual =	Source			.PeoplePage()
										.AddPeopleWith_Identifier(FName, LastName, Enumerations.Gender.MALE, DateOfBirth, Enumerations.Identifier.MEDICAID, IdentifierNumber)
										.GetSource()
										.PeopleNavigator()
										.clickPeopleTab()
										.DataTable()
										.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}

}