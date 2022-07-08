package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class Enrollment_Add_Edit_End extends BaseHook {

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Add_Enrollment(String Module) {

		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Adding Enrollment Status and verifying success");
			Expected =	"OADS Eligible";
			Actual =	Source		.DataTable()			
									.setSearch(JeanneID)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickEnrollmentStatusTab()
									.clickAdd()
									.EnrollmentStatusPage()
									.setStartDate(PastDate7, Clear)
									.GetSource()
									.EnrollmentStatusPage()
									.selectStatus(2)
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
	
	@Test(priority=2,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Edit_Enrollment(String Module) {

		SoftAssert = new SoftAssert();
	
		try{
			
			SeleniumHelper.log.info("Adding Enrollment Status and verifying success");
			Expected =	"OADS Eligible";
			Actual =	Source		.DataTable()			
									.setSearch(JeanneID)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickEnrollmentStatusTab()
									.clickAdd()
									.EnrollmentStatusPage()
									.setStartDate(PastDate7, Clear)
									.GetSource()
									.EnrollmentStatusPage()
									.selectStatus(2)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Enrollment Status and verifying success");
			Expected =	"Test Data";
			Actual =	Source		.DataTable()			
									.clickFirstRow()
									.clickEdit()
									.EnrollmentStatusPage()
									.setDescription("Test Data")
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.EnrollmentStatusPage()
									.readDescriptionTextBoxValue();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}
	
	@Test(priority=3,dataProvider = People, dataProviderClass = DataProviders.class)
	public void End_Enrollment(String Module) {

		SoftAssert = new SoftAssert();
	
		try{
			
			SeleniumHelper.log.info("Adding Enrollment Status and verifying success");
			Expected =	"OADS Eligible";
			Actual =	Source		.DataTable()
									.setSearch(JeanneID)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickEnrollmentStatusTab()
									.clickAdd()
									.EnrollmentStatusPage()
									.setStartDate(PastDate7, Clear)
									.GetSource()
									.EnrollmentStatusPage()
									.selectStatus(2)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Enrollment Status and verifying success");
			Expected =	PastDate3;
			Actual =	Source		.DataTable()			
									.clickFirstRow()
									.clickEdit()
									.EnrollmentStatusPage()
									.setEndDate(PastDate3)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}
}
