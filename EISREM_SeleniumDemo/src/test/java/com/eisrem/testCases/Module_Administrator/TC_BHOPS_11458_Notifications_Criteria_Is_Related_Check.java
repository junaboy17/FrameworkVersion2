package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11458_Notifications_Criteria_Is_Related_Check extends BaseHook {
	
	@Test(priority=1, dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Notifications_Criteria_Is_Related_Check_001(String Module) {
	
		SoftAssert = new SoftAssert();
		try{
			SeleniumHelper.log.info("Adding condition with format IS RELATED TO ANOTHER CONDUCTED TYPE ID & verifying successful addition of criteria");
			Expected = "When Type: 1000075916 Data Fix Form (V2)/ Assessment Page: 1000007696 DATA FIX FORM (V2) Question: 1000032010 Agency Name/ TEXT FIELD (80 VARCHARACTERS) IS RELATED TO ANOTHER CONDUCTED TYPE ID 1000075916 Data Fix Form (V2)/ Assessment AND Page: 1000007696 DATA FIX FORM (V2) AND Question: 1000032010 Agency Name/ TEXT FIELD (80 VARCHARACTERS) Answer: TYPE/ANSWER IS ENTERED";
			Actual = Source	.AdministratorNavigator()
							.clickNotifications()
							.clickAdd()
							.SetConditionsAccord()
							.setType(DataFixForm)
							.setPage(DataFixForm)
							.setQuestion("Agency Name")
							.selectFormat(NotificationFormat.IS_RELATED.getName())
					        .setType2(DataFixFormV2)
					        .setPage2(DataFixFormV2)
					        .setQuestion2("Agency Name")
					        .selectFormat2(NotificationFormat.IS_ENTERED.getName())
					        .clickSetConditionsAdd()
					        .readSearchCriteria(1);
	        
			SoftAssert.assertEquals(Actual, Expected);
						
			SoftAssert.assertAll();
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

	}

}