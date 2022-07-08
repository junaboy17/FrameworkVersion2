package com.eisrem.testCases.Module_Administrator;

import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

import edu.emory.mathcs.backport.java.util.Arrays;

public class TypesPageTest extends BaseHook{


	@Test(priority=1, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void DataTableTitleCheck(String Module) {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'Types'tab title");
		Expected = "Types";
		Actual = Source   	.AdministratorNavigator()
							.readTypesTab();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Types' tab is selected");
		Source		.TypesPage()
					.clickTypes();
		Expected = "active";
		Actual = Source.SeleniumHelper().getAttribute(Source.TypesPage().typesTab, "class");
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

		SeleniumHelper.log.info("Verifying 'Edit'  title");
		Expected = "Edit";
		Actual = Source		.DataTable()
							.readEditBtn();
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

	@SuppressWarnings("unchecked")
	@Test(priority=2, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void DataTableFunctionsCheck(String Module) {		
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'Show Entries' Drop Down");
		String[] value =  {"10", "25", "50", "100"};
		List<String> values = Arrays.asList(value);

		Source		.SeleniumHelper()
					.verifyAndClickAllDropDown(Source.DataTable().ShowEntriesDropdown, values);
		
		Source		.DataTable()
					.selectShowEntries(0);
		
		Expected = "Showing 1 to 10 of";		
		Actual = Source.DataTable().readShowNumOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		
		
		Source		.DataTable()
					.selectShowEntries(1);

		Expected = "Showing 1 to 25 of";		
		Actual = Source.DataTable().readShowNumOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		
		
		Source		.DataTable()
					.selectShowEntries(2);

		Expected = "Showing 1 to 50 of";		
		Actual = Source.DataTable().readShowNumOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		
		
		Source		.DataTable()
					.selectShowEntries(3);
		
		Expected = "Showing 1 to 100 of";		
		Actual = Source.DataTable().readShowNumOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));				

		SeleniumHelper.log.info("Verifying Add  function");
		Expected = "Add Types";
		Actual = Source		.DataTable()
							.clickAdd()
							.TypesPage()
							.readAddTypesPageTitle();
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}	
	
	@Test(priority=3,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void SearchFunctionsCheck(String Module) {		
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'Search:' title");
		Expected = "Search:";
		Actual = Source		.DataTable()
							.readSearchTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with letters");
		Source.DataTable().setSearch("notes"+ Keys.TAB);
		Source.SeleniumHelper().verifyAllText(Source.DataTable().allDataResult, "Notes");
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with numbers");
		Source			.DataTable()
						.setSearch("12", "y");		
		Source.SeleniumHelper().verifyAllText(Source.DataTable().allDataResult, "12","No data available");
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with special characters");
		Source			.DataTable()
						.setSearch("/", "y");
		Source.SeleniumHelper().verifyAllText(Source.DataTable().allDataResult, "/");
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with no result");
		Source			.DataTable()
						.setSearch("****************", "y");
		Source.SeleniumHelper().verifyAllText(Source.DataTable().allDataResult, "No data available");
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}

	@Test(priority=4,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void ListSortingCheck(String Module) {		
		SoftAssert = new SoftAssert();

		try{
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
		SoftAssert = new SoftAssert();
		
		try{
			Source		.NotificationsPage()
						.clickTypes()
						.GetSource()
						.DataTableTabTest()
						.TabTest();
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	//@Test(priority=6,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void ExcelDownloadCheck(String Module) {		
		SoftAssert = new SoftAssert();

		try{
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
					.verifyExcelText(data, "download/Types_export.xlsx", "Data");
					
		SeleniumHelper.log.info("Verifying complete Excel download for search result");
		Source		.DataTable()
					.setSearch("Notes" + Keys.TAB)
					.clickExcel();
		
		data = Source.SeleniumHelper().getTextFromWebElements(Source.DataTable().allDataResult);
		Source		.SeleniumHelper()
					.verifyExcelText(data, "download/Types_export (1).xlsx", "Data");
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}

}