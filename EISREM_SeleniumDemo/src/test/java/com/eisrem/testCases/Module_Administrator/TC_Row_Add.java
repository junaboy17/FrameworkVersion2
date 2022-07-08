package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Row_Add extends BaseHook{
	
	@Test(priority=1, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Row_Add_001(String Module) {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Create a new page");
			String pageName = Source.PagesPage().addPageUnlockedGetNameAndSubmit();	
			
			SeleniumHelper.log.info("Create a new section");
			String sectionName = Source.SectionsAvailableAccord().addSectionGetNameAndSubmit(pageName);	
			
			SeleniumHelper.log.info("Add a Row");
			Expected = Success;
			Actual = Source   	.NavigationMenuBar()
								.GetSource()
								.DataTable()
								.setSearch(pageName)
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.GetSource()
								.DataTable()
								.setSearch(sectionName)
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.clickRowAdd()
								.setRowName(RowName)
								.setSortOrder(OneN)
								.clickRowSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("End Date the new page");
			Source.PagesPage().endDatePageAndSubmit(pageName, Today);
		
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}