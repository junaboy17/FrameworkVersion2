package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Conducted_Types_Print_001 extends BaseHook {

//	1000072755, 1000072715, 1000075916, 1000072735
	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void Assessment_Add_Type1000072755(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			int typeId = 1000072755;
			String title = "PrinterFriendlyType_" + typeId;
			
			SeleniumHelper.log.info("Confirming printer friendly functionality for a printer friendly form. " 
					+ "Creating a conducted type for a printer friendly type " + typeId);
				
			Source		.DataTable()
						.clickFirstRow()
						.clickAnchor()			
						.NavigationMenuBar()
						.clickAssessmentForms()
						.DataTable()	
						.clickAdd()
						.Assessment_FormsPage()
						.selectAssessmentTypeById(String.valueOf(typeId))
						.setTitle(title)
						.setDescription(String.valueOf(typeId))
						.GetSource()
						.Assessment_FormsPage()
						.clickStartAssessment()
						.fillForm()
						.clickSubmitAllPages()
						.clickGoBackToList()
						
						// Select created type for viewing
						.NavigationMenuBar()
						.DataTable()
						.setSearch(title)
						.clickFirstRow()
						.clickView()
						.Assessment_FormsPage()
						// switching to the first tab and click Print
						.clickAssessmentsFormsTab()
						.clickPrint()
						;
			SeleniumHelper.log.warn("Type [" + String.valueOf(typeId)
					+ "] - The browser window will close within next 10 sec.Please verify the printing outcome.");
			Source		.SeleniumHelper()
						.sleep(10);
			
			SoftAssert.assertAll();
					
			}catch(Exception e) {
				Source	.SeleniumHelper()
						.assertFail();
			}
	}

	@Test(priority=2,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void Assessment_Add_Type1000072715(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			int typeId = 1000072715;
			String title = "PrinterFriendlyType_" + typeId;
			
			SeleniumHelper.log.info("Confirming printer friendly functionality for a printer friendly form. " 
					+ "Creating a conducted type for a printer friendly type " + typeId);
								
			Source		.DataTable()
						.clickFirstRow()
						.clickAnchor()			
						.NavigationMenuBar()
						.clickAssessmentForms()
						.DataTable()	
						.clickAdd()
						.Assessment_FormsPage()
						.selectAssessmentTypeById(String.valueOf(typeId))
						.setTitle(title)
						.setDescription(String.valueOf(typeId))
						.GetSource()
						.Assessment_FormsPage()
						.clickStartAssessment()
						.fillForm()
						.clickSubmitAllPages()
						.clickGoBackToList()
						
						// Select created type for viewing
						.NavigationMenuBar()
						.DataTable()
						.setSearch(title)
						.clickFirstRow()
						.clickView()
						.Assessment_FormsPage()
						// switching to the first tab and click Print
						.clickAssessmentsFormsTab()
						.clickPrint()
						;
			
			SeleniumHelper.log.warn("Type [" + String.valueOf(typeId)
					+ "] - The browser window will close within next 10 sec.Please verify the printing outcome.");
			Source		.SeleniumHelper()
						.sleep(10);
			SoftAssert.assertAll();
					
			}catch(Exception e) {
				Source	.SeleniumHelper()
						.assertFail();
			}
	}
	
	@Test(priority=3,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void Assessment_Add_Type1000075916(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			int typeId = 1000075916;
			String title = "PrinterFriendlyType_" + typeId;
			
			SeleniumHelper.log.info("Confirming printer friendly functionality for a printer friendly form. " 
					+ "Creating a conducted type for a printer friendly type " + typeId);
								
			Source		.DataTable()
						.clickFirstRow()
						.clickAnchor()			
						.NavigationMenuBar()
						.clickAssessmentForms()
						.DataTable()	
						.clickAdd()
						.Assessment_FormsPage()
						.selectAssessmentTypeById(String.valueOf(typeId))
						.setTitle(title)
						.setDescription(String.valueOf(typeId))
						.GetSource()
						.Assessment_FormsPage()
						.clickStartAssessment()
						.fillForm()
						.clickSubmitAllPages()
						.clickGoBackToList()
						
						// Select created type for viewing
						.NavigationMenuBar()
						.DataTable()
						.setSearch(title)
						.clickFirstRow()
						.clickView()
						.Assessment_FormsPage()
						// switching to the first tab and click Print
						.clickAssessmentsFormsTab()
						.clickPrint()
						;
			SeleniumHelper.log.warn("Type [" + String.valueOf(typeId)
					+ "] - The browser window will close within next 10 sec.Please verify the printing outcome.");
			Source		.SeleniumHelper()
						.sleep(10);
			SoftAssert.assertAll();
					
			}catch(Exception e) {
				Source	.SeleniumHelper()
						.assertFail();
			}
	}
	
	@Test(priority=4,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void Assessment_Add_Type1000072735(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			int typeId = 1000072735;
			String title = "PrinterFriendlyType_" + typeId;
			
			SeleniumHelper.log.info("Confirming printer friendly functionality for a printer friendly form. " 
					+ "Creating a conducted type for a printer friendly type " + typeId);
								
			Source		.DataTable()
						.clickFirstRow()
						.clickAnchor()			
						.NavigationMenuBar()
						.clickAssessmentForms()
						.DataTable()	
						.clickAdd()
						.Assessment_FormsPage()
						.selectAssessmentTypeById(String.valueOf(typeId))
						.setTitle(title)
						.setDescription(String.valueOf(typeId))
						.GetSource()
						.Assessment_FormsPage()
						.clickStartAssessment()
						.fillForm()
						.clickSubmitAllPages()
						.clickGoBackToList()
						
						// Select created type for viewing
						.NavigationMenuBar()
						.DataTable()
						.setSearch(title)
						.clickFirstRow()
						.clickView()
						.Assessment_FormsPage()
						// switching to the first tab and click Print
						.clickAssessmentsFormsTab()
						.clickPrint()
						;
			SeleniumHelper.log.warn("Type [" + String.valueOf(typeId)
					+ "] - The browser window will close within next 10 sec.Please verify the printing outcome.");
			Source		.SeleniumHelper()
						.sleep(10);
			SoftAssert.assertAll();
					
			}catch(Exception e) {
				Source	.SeleniumHelper()
						.assertFail();
			}
	}

}
