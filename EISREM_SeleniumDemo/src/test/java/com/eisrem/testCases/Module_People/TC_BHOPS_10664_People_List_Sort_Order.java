package com.eisrem.testCases.Module_People;

import java.util.List;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_10664_People_List_Sort_Order extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void Types_Add_PopupCheck(String Module) {
		
		SoftAssert = new SoftAssert();
		int sec = 2;

		try{
					SeleniumHelper.log.info("Validating if list in people module are sorted with active User on top");
					SeleniumHelper.log.info("Verifying Actual end dates mataches sorted end dates in Identifiers Accordian");
					List<String> actuals;
					List<String> expecteds;
					actuals = Source	.DataTable()
										.setSearch("388939")
										.clickFirstRow()
										.clickAnchor()
										.DemographicsPage()
										.clickIdentifiersAccord()
										.GetSource()
										.SeleniumHelper()
										.getTextFromWebElements(Source.DataTable().AllEndDate);
					
					expecteds = Source	.SeleniumHelper()
										.sortDateElementsDesc(Source.DataTable().AllEndDate);
					SoftAssert.assertEquals(actuals, expecteds);
					
					SeleniumHelper.log.info("Verifying Actual end dates mataches sorted end dates in Identifiers Tab");
					actuals = Source	.PeopleNavigator()
										.clickIdentifierTab()
										.GetSource()
										.SeleniumHelper()
										.sleep(sec)
										.getTextFromWebElements(Source.DataTable().AllEndDate);
		
					expecteds = Source	.SeleniumHelper()
										.sortDateElementsDesc(Source.DataTable().AllEndDate);
					SoftAssert.assertEquals(actuals, expecteds);
					
					SeleniumHelper.log.info("Verifying Actual end dates mataches sorted end dates in Address Tab");
					actuals = Source	.PeopleNavigator()
										.clickAddressTab()
										.GetSource()
										.SeleniumHelper()
										.sleep(sec)
										.getTextFromWebElements(Source.DataTable().AllEndDate);
			
					expecteds = Source	.SeleniumHelper()
										.sortDateElementsDesc(Source.DataTable().AllEndDate);
					SoftAssert.assertEquals(actuals, expecteds);
					
					SeleniumHelper.log.info("Verifying Actual end dates mataches sorted end dates in Associations Tab");
					actuals = Source	.PeopleNavigator()
										.clickAssociationsTab()
										.GetSource()
										.SeleniumHelper()
										.sleep(sec)
										.getTextFromWebElements(Source.DataTable().AllEndDate);
			
					expecteds = Source	.SeleniumHelper()
										.sortDateElementsDesc(Source.DataTable().AllEndDate);
					SoftAssert.assertEquals(actuals, expecteds);
					

					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
		
	}
	
	

