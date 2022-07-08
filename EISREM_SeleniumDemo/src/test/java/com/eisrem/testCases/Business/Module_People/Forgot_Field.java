package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class Forgot_Field extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void People_Add_Forgot_DOB_001(String Module) {
		
		SoftAssert = new SoftAssert();
		
		try{
			
			SeleniumHelper.log.info("Verifying error message after leaving Date of birth blank");
			Expected =	"Please enter a Date Of Birth *";
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphics(FirstName, LastName, Gender.MALE, EmptyString)
									.clickSubmit()
									.readTopErrorMessage(1);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Entering valid Date of bith & verifying success message");
			Expected =	"Success!";
			Actual =	Source		.DemographicsPage()
									.setDateOfBirth(DateOfBirth)
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
	public void People_Add_Forgot_Gender_001(String Module) {
		
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verifying error message after leaving Gender blank");
			Expected =	"Please enter a Gender *";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.setFirstName(FirstName)
										.setMiddleName(MiddleName)
										.setLastName(LastName)
										.setDateOfBirth(DateOfBirth)
										.clickSubmit()
										.readTopErrorMessage(1);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Entering Gender & verifying success message");
			Expected =	"Success!";
			Actual =	Source			.DemographicsPage()
										.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
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
	public void People_Add_Forgot_First_Name_001(String Module) {
		
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verifying error message after leaving First Name blank");
			Expected =	"Please enter a First Name *";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.fillRequiredDemogrphics(EmptyString, LastName, Gender.MALE, DateOfBirth)
										.clickSubmit()
										.readTopErrorMessage(1);
										
			SoftAssert.assertEquals(Actual, Expected);		
			
			SeleniumHelper.log.info("Entering Fisrt Name & verifying success message");
			Expected =	"Success!";
			Actual =	Source			.DemographicsPage()
										.setFirstName(FirstName)
										.clickSubmit()
										.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);		
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=4,dataProvider = People, dataProviderClass = DataProviders.class)	
	public void People_Add_Forgot_Last_Name_001(String Module) {
		
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verifying error message after leaving Last Name blank");
			Expected =	"Please enter a Last Name *";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.fillRequiredDemogrphics(FirstName, EmptyString, Gender.MALE, DateOfBirth)
										.clickSubmit()
										.readTopErrorMessage(1);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Entering Last Name & verifying success message");
			Expected =	"Success!";
			Actual =	Source			.DemographicsPage()
										.setLastName(LastName)
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
	public void People_Add_Forgot_All_Fields_001(String Module) {
		
		SoftAssert = new SoftAssert();
		
		try{
			SeleniumHelper.log.info("Verifying all error message after leaving all required fields blank");
			Expected =	"Please enter a Start Date *";
			Actual =	Source			.DataTable()
										.clickAdd()
										.DemographicsPage()
										.setStartDate(EmptyString, "y")
										.GetSource()
										.DemographicsPage()
										.clickSubmit()
										.readTopErrorMessage(1);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	"Please enter a First Name *";
			Actual =	Source			.DataTable()
										.readTopErrorMessage(2);
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	"Please enter a Last Name *";
			Actual =	Source			.DataTable()
										.readTopErrorMessage(3);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	"Please enter a Gender *";
			Actual =	Source			.DataTable()
										.readTopErrorMessage(4);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	"Please enter a Date Of Birth *";
			Actual =	Source			.DataTable()
										.readTopErrorMessage(5);
			SoftAssert.assertEquals(Actual, Expected);
				
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
}