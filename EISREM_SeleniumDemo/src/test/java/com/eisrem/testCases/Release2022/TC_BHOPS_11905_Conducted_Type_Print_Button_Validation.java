package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11905_Conducted_Type_Print_Button_Validation extends BaseHook {

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Conducted_Type_Print_AfterCheck(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Conducting a type, printing it, verifying buttons.");

			int typeId = 1000075416;	// CS INDIVIDUAL PLANNING FUNDS FORM V2
	
			Source		.DataTable()
						.setSearch(TestClient2)
						.clickFirstRow()
						.clickAnchor()
						.NavigationMenuBar()
						.clickAssessmentForms()
						.DataTable()	
						.clickAdd()
						.Assessment_FormsPage()
						.selectAssessmentTypeById(String.valueOf(typeId))
						.setTitle("Conducted_Type_Test")
						.setDescription(String.valueOf(typeId))
						.GetSource()
						.Assessment_FormsPage()
						.clickStartAssessment()
						.GetSource()
						.SeleniumHelper()
						.sleep(10)
						.GetSource()
						.FormPage()
						.fillForm()
						.clickSubmitAllPages()
						.clickGoBackToList()
						
						// Select created type for viewing
						.NavigationMenuBar()
						.DataTable()
						.clickFirstRow()
						.clickView()
						.Assessment_FormsPage()
						// switching to the first tab and click Print
						.clickAssessmentsFormsTab()
						.clickPrint();
			
			SeleniumHelper.log.warn("Type [" + String.valueOf(typeId)
			+ "] - The browser window will close within next 10 sec.");
			Source.SeleniumHelper()
			.sleep(10);
			
			SeleniumHelper.log.info("Confirming Back to Assement button works");
			Source.FormPage()
						.clickClosePrint()
						.clickBackToAssessment();

			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
}