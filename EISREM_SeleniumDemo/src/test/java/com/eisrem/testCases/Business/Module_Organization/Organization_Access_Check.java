package com.eisrem.testCases.Business.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class Organization_Access_Check extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Organization_Access_Check_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying Organization Tab- Anchor Add Edit View Excel");
			Expected =	"Organizations";
			Actual =	Source		.DataTable()
									.setSearch(JeanneID)
									.clickFirstRow()
									.clickAnchor()
									.NavigationMenuBar()
									.clickOrganization()
									.setSearch(OrgDHHS)
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.readOrganizationsTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Anchor;
			Actual =	Source		.DataTable()
									.readAnchorBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Add;
			Actual =	Source		.DataTable()
									.readAddBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Edit;
			Actual =	Source		.DataTable()
									.readEditBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	View;
			Actual =	Source		.DataTable()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying UsersStaff tab - Add Edit View Excel");
			Expected =	"Users/Staff";
			Actual =	Source		.OrganizationNavigator()
									.clickUsersStaff()
									.readUsersStaffTab();
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	Add;
			Actual =	Source		.DataTable()
									.readAddBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Edit;
			Actual =	Source		.DataTable()
									.readEditBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	View;
			Actual =	Source		.DataTable()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Documents Tab - Add Edit View Excel");
			
			Expected =	"Documents";
			Actual =	Source		.OrganizationNavigator()
									.clickDocuments()
									.GetSource()
									.OrganizationNavigator()
									.readDocumentsTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Add;
			Actual =	Source		.DataTable()
									.readAddBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Edit;
			Actual =	Source		.DataTable()
									.readEditBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	View;
			Actual =	Source		.DataTable()
									.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	Excel;
			Actual =	Source		.DataTable()
									.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			
			SoftAssert.assertAll();		
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}

		
}
	
	

