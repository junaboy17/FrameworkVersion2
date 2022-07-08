package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class People_LivingArangement_Test extends BaseHook {
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void LivingArangement_Add_001(String Module) {

		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Adding Living Arrangement to an existing person and verifying success message");
			Expected = Success;
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickLivingArrangementTab()
									.clickAdd()
									.LivingArrangementPage()
									.selectType(1)
									.setDescription(Description)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Living Arrangement was added successfully");
			Expected = "In Service- CSR";
			Actual =	Source		.Pagefactory()
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
	public void LivingArangement_Edit_001(String Module) {

		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Adding Living Arrangement to an existing person and verifying success message");
			Expected = Success;
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickLivingArrangementTab()
									.clickAdd()
									.LivingArrangementPage()
									.selectType(1)
									.setDescription(Description)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Living Arrangement was added successfully");
			Expected = "In Service- CSR";
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			String ID = Source 		.DataTable()
									.readFirstResultID().replace("Select", "");
			
			SeleniumHelper.log.info("Verifying Living Arrangement was added successfully");
			Expected = Success;
			Actual =	Source		.Pagefactory()
									.DataTable()
									.setSearch(ID)
									.clickFirstRow()
									.clickEdit()
									.Pagefactory()
									.setEndDate(Tomorrow)
									.GetSource()
									.LivingArrangementPage()
									.setDescription(UpdateDescription, Clear)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Living Arrangement was added successfully");
			Expected = Tomorrow;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.setSearch(ID)
									.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);
						
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3,dataProvider = People, dataProviderClass = DataProviders.class)
	public void LivingArangement_View_001(String Module) {

		SoftAssert = new SoftAssert();

		try{
				
			SeleniumHelper.log.info("Adding Living Arrangement to an existing person and verifying success message");
			Expected = Success;
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickLivingArrangementTab()
									.clickAdd()
									.LivingArrangementPage()
									.selectType(1)
									.setDescription(Description)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding Living Arrangement to an existing person and verifying success message");
			Expected = True;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickView()
									.SeleniumHelper().readAttribute(Source.Pagefactory().StartDateTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);

			Expected = True;
			Actual =	Source		.SeleniumHelper().readAttribute(Source.LivingArrangementPage().DescriptionTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = True;
			Actual =	Source		.SeleniumHelper().readAttribute(Source.LivingArrangementPage().DescriptionTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
						
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}