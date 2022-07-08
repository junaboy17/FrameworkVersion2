package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;


public class TC_Organization_Documents_Add_Edit_View extends BaseHook{
	
	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Organization_Documents_Add_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding Documents");
			Expected ="Documents";

			Actual=	Source  	.OrganizationPage()
								.addOrganizationDocumentandSubmit()
								.readDocumentsTab();
				SoftAssert.assertEquals(Actual, Expected);
		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	 }

   }

	@Test(priority=2,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Organization_Documents_Edit_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Editing Documents");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
							    .clickDocuments()
							    .clickFirstRow()
			                    .clickEdit()
			                    .DocumentsPage()
			                    .setDescription(Description)
			                    .clickSubmit()
			                    .readPopUpMessage();
			
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	 }

   }
	
	@Test(priority=3,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Organization_Documents_View_001(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Viewing Documents");
			Expected =True;

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
							    .clickDocuments()
							    .clickFirstColumnLink()
							    .clickView()
							    .SeleniumHelper()
								.getAttribute(Source.DocumentsPage().TitleTextbox, "disabled");
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.DocumentsPage().DescriptionTextBox, "disabled");
			
			SoftAssert.assertEquals(Actual, Expected);
						
		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	 }

   }
}