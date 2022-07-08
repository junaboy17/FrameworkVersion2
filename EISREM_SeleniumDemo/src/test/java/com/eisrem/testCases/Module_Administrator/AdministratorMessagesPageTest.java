package com.eisrem.testCases.Module_Administrator;

import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

import edu.emory.mathcs.backport.java.util.Arrays;

public class AdministratorMessagesPageTest extends BaseHook{


	@Test(priority=1, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void DataTableTitleCheck(String Module) {
		
		try{
			SeleniumHelper.log.info("Verifying 'Administrator Messages'tab title");
			Expected = "Administrator Messages";
			Actual = Source   	.AdministratorNavigator()
								.clickAdministratorMessages()
								.readAdministratorMessagesTab();
								
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Administrator Messages' tab is selected");
			Source		.AdministratorMessagesPage()
						.clickAdministratorMessages();
			Expected = "active";
			Actual = Source.SeleniumHelper().getAttribute(Source.AdministratorMessagesPage().AdministratorMessagesTab, "class");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Show entries' title");
			Expected ="Show\n"
					+ "10\n"
					+ "25\n"
					+ "50\n"
					+ "100\n"
					+ "entries";
			Actual = Source		.DataTable()
								.readShowEntriesTitle();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Add'  title");
			Expected = "Add";
			Actual = Source		.DataTable()
								.readAddBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'View'  title");
			Expected = "View";
			Actual = Source		.DataTable()
								.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Excel'  title");
			Expected = "Excel";
			Actual = Source		.DataTable()
								.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Id' list title");
			Expected = "Id";
			Actual = Source		.DataTable()
								.readIdList();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Name/Type' list title");
			Expected = "Name/Type";
			Actual = Source		.DataTable()
								.readNameList();
			SoftAssert.assertEquals(Actual, Expected);
	
	
			SeleniumHelper.log.info("Verifying 'Start Date' list title");
			Expected = "Start Date";
			Actual = Source		.DataTable()
								.readStartDateList();
			SoftAssert.assertEquals(Actual, Expected);
	
	
			SeleniumHelper.log.info("Verifying 'End Date' list title");
			Expected = "End Date";
			Actual = Source		.DataTable()
								.readEndDateList();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Modified Date' list title");
			Expected = "Modified Date";
			Actual = Source		.DataTable()
								.readModifiedDateList();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Previous'  title");
			Expected = "Previous";
			Actual = Source		.DataTable()
					 			.readPreviousBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Next'  title");
			Expected = "Next";
			Actual = Source		.DataTable()
					 			.readNextBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Copyright' title");
			Expected = CopyRightInfo;
			Actual = Source		.DataTable()
					 			.readCopyright();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}
		

	@Test(priority=2, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void DataTableFunctionsCheck(String Module) {		

		try{
			SeleniumHelper.log.info("Verifying 'Show Entries' Drop Down");
			String[] value =  {"10", "25", "50", "100"};
			List<String> values = Arrays.asList(value);
	
			Source		.AdministratorMessagesPage()
						.clickAdministratorMessages();
			
			Source		.SeleniumHelper()
						.verifyAndClickAllDropDown(Source.DataTable().ShowEntriesDropdown, values);
			
			Source		.DataTable()
						.selectShowEntries(0);
			
			Expected = "Showing 1 to";		
			Actual = Source.DataTable().readShowNumOfEntries();
			SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));
			
			Source		.DataTable()
						.selectShowEntries(1);
	
			Expected = "Showing 1 to";		
			Actual = Source.DataTable().readShowNumOfEntries();
			SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));
	
			Source		.DataTable()
						.selectShowEntries(2);
	
			Expected = "Showing 1 to";		
			Actual = Source.DataTable().readShowNumOfEntries();
			SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));
			
			Source		.DataTable()
						.selectShowEntries(3);
			
			Expected = "Showing 1 to";		
			Actual = Source.DataTable().readShowNumOfEntries();
			SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		
	
			SeleniumHelper.log.info("Verifying Add  function");
			Expected = "Add Administrator Message";
			Actual = Source		.DataTable()
								.clickAdd()
								.AdministratorMessagesPage()
								.readAddAdministratorMessagePageTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}	
	
	@Test(priority=3, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void SearchFunctionsCheck(String Module) {		
	
		try{
			Source		.AdministratorMessagesPage()
						.clickAdministratorMessages();
			
			SeleniumHelper.log.info("Verifying 'Search:' title");
			Expected = "Search:";
			Actual = Source		.DataTable()
								.readSearchTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Search Text Box' function with letters");
			Source.DataTable().setSearch("Test"+ Keys.TAB);
			Source.SeleniumHelper().verifyAllText(Source.DataTable().allDataResult, "TEST", "Test", "test");
			
			SeleniumHelper.log.info("Verifying 'Search Text Box' function with numbers");
			Source			.DataTable()
							.setSearch("10", Clear);		
			Source.SeleniumHelper().sleep(1).verifyAllText(Source.DataTable().allDataResult, "No data available", "10");
			
			SeleniumHelper.log.info("Verifying 'Search Text Box' function with special characters");
			Source			.DataTable()
							.setSearch("/", Clear);
			Source.SeleniumHelper().verifyAllText(Source.DataTable().allDataResult, "No data available", "/");
			
			SeleniumHelper.log.info("Verifying 'Search Text Box' function with no result");
			Source			.DataTable()
							.setSearch("****************", Clear);
			Source.SeleniumHelper().verifyAllText(Source.DataTable().allDataResult, "No data available");
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}

	@Test(priority=4, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void ListSortingCheck(String Module) {		

		try{	
			Source		.AdministratorMessagesPage()
						.clickAdministratorMessages();
			
			SeleniumHelper.log.info("Verifying 'Id' list function");
			Source		.DataTable()
						.clickIdSort();
			Expected = "Sorted Ascending";
			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().IdSort, "alt");
			SoftAssert.assertEquals(Actual, Expected);
	
			Source			.DataTable()
							.clickIdSort();
			Expected = "Sorted Descending";
			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().IdSort, "alt");
			SoftAssert.assertEquals(Actual, Expected);
	
	
			SeleniumHelper.log.info("Verifying 'Name/Type' list function");
			Source		.DataTable()
						.clickNameSort();
			Expected = "Sorted Ascending";
			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().NameSort, "alt");
			SoftAssert.assertEquals(Actual, Expected);
	
			Source			.DataTable()
							.clickNameSort();
			Expected = "Sorted Descending";
			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().NameSort, "alt");
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Start Date' list function");
			Source		.DataTable()
						.clickStartDateSort();
			Expected = "Sorted Ascending";
			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().StartDateSort, "alt");
			SoftAssert.assertEquals(Actual, Expected);
	
			Source		.DataTable()
						.clickStartDateSort();
			Expected = "Sorted Descending";
			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().StartDateSort, "alt");
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'End Date' list function");
			Source		.DataTable()
						.clickEndDateSort();
			Expected = "Sorted Ascending";
			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().EndDateSort, "alt");
			SoftAssert.assertEquals(Actual, Expected);
	
			Source		.DataTable()
						.clickEndDateSort();
			Expected = "Sorted Descending";
			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().EndDateSort, "alt");
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Modified Date' list function");
			Source		.DataTable()
						.clickModifiedDateSort();
			Expected = "Sorted Ascending";
			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().ModifiedDateSort, "alt");
			SoftAssert.assertEquals(Actual, Expected);
	
			Source		.DataTable()
						.clickModifiedDateSort();
			Expected = "Sorted Descending";
			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().ModifiedDateSort, "alt");
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}
	
	@Test(priority=5, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void DataTablePageTabCheck(String Module) {		

		try{
			Source		.NotificationsPage()
						.clickAdministratorMessages()
						.GetSource()
						.DataTableTabTest()
						.TabTest();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=6, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void ExcelDownloadCheck(String Module) {		
		
		try{	
			Source		.AdministratorMessagesPage()
						.clickAdministratorMessages();
	
			SeleniumHelper.log.info("Verifying 'Excel' btn title");
			Expected = "Excel";
			Actual = Source		.DataTable()
								.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying complete Excel download for all result");
			List <String> data = Source.SeleniumHelper().getTextFromWebElements(Source.DataTable().allDataResult);
			
			Source		.DataTable()
						.clickExcel();
					
			Source		.SeleniumHelper()
						.verifyExcelText(data, "download/AdministratorMessage_export.xlsx", "Data");
						
			SeleniumHelper.log.info("Verifying complete Excel download for search result");
			Source		.DataTable()
						.setSearch("Test" + Keys.TAB)
						.clickExcel();
			
			data = Source.SeleniumHelper().getTextFromWebElements(Source.DataTable().allDataResult);
			Source		.SeleniumHelper()
						.verifyExcelText(data, "download/AdministratorMessage_export (1).xlsx", "Data");
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}

}