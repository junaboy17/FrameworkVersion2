package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_People_Identifiers_Medicaid_Change_Without_Event_Listener extends BaseHook {
	
	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void People_Identifiers_Medicaid_Change_Without_Event_Listener_001(String Module) {
		
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Verifying if Identifier ID Number text box allows all different character entry");
			String IncorrectIdentNumber = RandNum4  + RandAlpha1 + RandNum4 + RandAlpha1 + RandNum2 + RandAlpha1;
			Expected =	IncorrectIdentNumber;
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickIdentifierTab()
									.clickAdd()
									.IdentifiersPage()
									.selectIdentifiersType(Identifier.MEDICAID.getIndex())
									.setIdentifiersIdNumber(IncorrectIdentNumber)
									.clickSubmit()
									.readIdentifiersIdNumber();
			SoftAssert.assertEquals(Actual, Expected);
			

			
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}	
	
	
	
}
