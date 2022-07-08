package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_12354_People_OtherNames_Suffix_List_Page extends BaseHook {

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_BHOPS_12354_People_OtherNames_Suffix_List_Page(String Module) {

		SoftAssert = new SoftAssert();

		String fName = FirstName + SeleniumHelper.generateRandomAlpha(3);
		String lName = LastName + SeleniumHelper.generateRandomAlpha(3);
		String sName = Suffix + SeleniumHelper.generateRandomAlpha(3);

		try{
			
			SeleniumHelper.log.info("Adding Suffix to Other Name to an existing person and confirming successful add");
			Expected =	lName.toUpperCase() + ", " + fName.toUpperCase() + ", " + sName.toUpperCase() + "/ FORMER NAME";
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphics(FirstName, LastName, Enumerations.Gender.MALE, "05/16/1976")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickOtherNamesTab()
									.clickAdd()
									.OtherNamesPage()
									.selectType(1)
									.GetSource()
									.DemographicsPage()
									.setFirstName(fName)
									.setLastName(lName)
									.setSuffix(sName)
									.setDescription(Description)
									.clickSubmit()
									.clickPopupOk()
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