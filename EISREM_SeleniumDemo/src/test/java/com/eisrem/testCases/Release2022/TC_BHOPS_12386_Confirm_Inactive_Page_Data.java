package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_12386_Confirm_Inactive_Page_Data extends BaseHook{

	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Related_Question_Restriction(String Module) {		
		SoftAssert = new SoftAssert();
		String actual1;
		String actual2;
		String actual3;
		try{
			SeleniumHelper.log.info("Create a new page with disabled section, row, and question to ensure they are not copied over");
			Expected = "Showing 1 to 1 of 1 entries";
			Expected2 = "None";
			actual1 = Source   	.PagesPage()
								.addPageUnlocked()
								.GetSource()
								.SectionsAvailableAccord()
								.clickAdd()
								.SectionsAvailableAccord()
								.setSectionName("DISABLED SECTION")
								.setSortOrder(OneN)
								.clickActiveToggle()
								.clickSave()
								.SectionsAvailableAccord()
								.clickPopupOk()
								.SectionsAvailableAccord()
								.clickSectionsBack()
								.clickAdd()
								.SectionsAvailableAccord()
								.setSectionName(SectionName)
								.setSortOrder(OneN)
								.GetSource()
								.RowsAvailableAccord()
								.clickRowAdd()
								.setRowName("DISABLED ROW")
								.setSortOrder("1")
								.clickActiveToggle()
								.clickSubmitExit()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.SectionsAvailableAccord()
								.setSearch("TC")
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.addRow()
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(1)
								.setQuestionLabel(SectionName, Clear)
								.setSortOrder(OneN, Clear)
								.setAnswerValue(1, One, Clear)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(1)
								.setQuestionLabel("test123")
								.setSortOrder(OneN, Clear)
								.setAnswerValue(1, One, Clear)
								.selectRelateToQuestionDropDown(1)
								.selectRelateToAnswer(new String[] {"One"})
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowSubmit()
								.clickPopupOk()
								//remove the related question
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.GetSource()
								.SectionsAvailableAccord()
								.setSearch("TC")
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.setSearch("TC")
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.setSearch("test")
								.clickQAFirstRow()
								.clickQAEdit()
								.selectRelateToQuestionDropDown(0)
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowSubmit()
								.clickPopupOk()
								//copy page and confirm the related question is not present
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.clickCopyPage()
								.clickPopupOk()
								.PagesPage()
								.clickBackTo()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.GetSource()
								.DataTable()
								.readShowNumOfEntries();
			
			SoftAssert.assertEquals(actual1, Expected);
			SeleniumHelper.log.info("Actual: " + actual1 + "   Expected: " + Expected);
			
			actual2 = Source.SectionsAvailableAccord()
			
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.readShowNumOfEntries("row_table");
			
			SoftAssert.assertEquals(actual2, Expected);
			SeleniumHelper.log.info("Actual: " + actual2 + "   Expected: " + Expected);
			
			actual3 = Source.RowsAvailableAccord()
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.setSearch("test123")
								.clickQAFirstRow()
								.clickQAEdit()
								.readFirstRelateToQuestionDropDown();
			
			SoftAssert.assertEquals(actual3, Expected2);
			SeleniumHelper.log.info("Actual: " + actual3 + "   Expected: " + Expected2);
					
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}
