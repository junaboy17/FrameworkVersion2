package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Conducted_Type_AddEditView_001 extends BaseHook {

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Assessment_Add() {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Anchoring a person & verifying Add Assessment functionality");
					Expected =	"TC_Conducted_Types_AddEditView_001/ CS INDIVIDUAL PLANNING FUNDS FORM V2";
					Actual = 	Source		.DataTable()
											.setSearch(TestClient2, Clear)
											.clickFirstRow()
											.clickAnchor()
											.NavigationMenuBar()
											.clickAssessmentForms()
											.clickAdd()
											.Assessment_FormsPage()
											.selectAssessmentType("CS INDIVIDUAL PLANNING FUNDS FORM V2/ Assessment")
											.setTitle("TC_Conducted_Types_AddEditView_001")
											.setDescription("Type CS INDIVIDUAL PLANNING FUNDS FORM V2")
											.GetSource()
											.Assessment_FormsPage()
											.clickStartAssessment()
											.fillForm()
											.clickSubmitAllPages()
											.clickGoBackToList()
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
	public void Assessment_Edit_Header(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Anchoring a person & verifying Edit Assessment Header functionality");
					Expected =	"TC_Conducted_Types_AddEditView_001/ CS INDIVIDUAL PLANNING FUNDS FORM V2";
					Actual = 	Source		.DataTable()
											.setSearch(TestClient2, Clear)
											.clickFirstRow()
											.clickAnchor()
											.NavigationMenuBar()						
											.clickAssessmentForms()
											.setSearch("TC_Conducted_Types_AddEditView_001", Clear)
											.isEmptyThrowError()
											.clickFirstRow()
											.clickEdit()
											.Assessment_FormsPage() 
											.clickAssessmentsFormsTab()
											.setDescription(" - Updated")
											.clickSubmit()
											.clickPopupOk()
											.DataTable()
											.readFirstResultNameType();						
					SoftAssert.assertEquals(Actual, Expected);
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			if(e.getMessage().equalsIgnoreCase("No Records")) 
				SeleniumHelper.log.info("No Records Found in Datatable.");
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}
	
	@Test(priority=3,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Assessment_Edit_Page(String Module) {
		
		SoftAssert = new SoftAssert();
		//String ClientID = "597570";
		try{
					SeleniumHelper.log.info("Anchoring a person & verifying Edit Assessment functionality");
					Expected =	"TC_Conducted_Types_AddEditView_001/ CS INDIVIDUAL PLANNING FUNDS FORM V2";
					Actual = 	Source		.DataTable()
											//.setSearch(ClientID, Clear)
											.setSearch(LastName, Clear)
											.clickFirstRow()
											.clickAnchor()
											.NavigationMenuBar()
											.clickAssessmentForms()
											.setSearch("TC_Conducted_Types_AddEditView_001", Clear)
											.isEmptyThrowError()
											.clickFirstRow()
											.clickEdit()
											.Assessment_FormsPage() 
											.GetSource()
											.FormPage()					
											.fillForm()
											.clickSubmitAllPages()
											.clickGoBackToList()
											.DataTable()
											.readFirstResultNameType();			
					SoftAssert.assertEquals(Actual, Expected);
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			if(e.getMessage().equalsIgnoreCase("No Records")) 
				SeleniumHelper.log.info("No Records Found in Datatable.");
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}
	
	@Test(priority=4,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Assessment_View(String Module) {
		
		SoftAssert = new SoftAssert();
		//String ClientID = "597570";
		try{
					SeleniumHelper.log.info("Anchoring a person & verifying View Assessment functionality");

									Source	.DataTable()
											//.setSearch(ClientID)
											.setSearch(FirstName, Clear)
											.clickFirstRow()
											.clickAnchor()
											.NavigationMenuBar()
											.clickAssessmentForms()
											.setSearch("TC_Conducted_Types_AddEditView_001", Clear)
											.isEmptyThrowError()
											.clickFirstRow()
											.clickView()
											.FormPage()
											.checkAllWebElementsDisabled()
											.checkSubmitAllPagesBtnInvisible()
											.GetSource()
											.Assessment_FormsPage() 
											.clickAssessmentsFormsTab()
											.GetSource()
											.FormPage()
											.checkAllWebElementsDisabled()
											.checkSubmitBtnInvisible()
											.clickBackToAssessment();
							SoftAssert.assertAll();
							
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}

}
	
	

