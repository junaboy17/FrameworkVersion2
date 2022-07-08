package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Organization_Location_Anchor_Filter extends BaseHook{
	
	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Location_AddEdit_TTY(String Module) {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Comparing Location count before and after anchoring on Location. ");

			String numbEntriesString;
			String count1 = "0";
			String count2 = "0";
			
			Source	// Anchoring on Organization
					.OrganizationPage().setSearch(OrgDHHS)
					.clickFirstRow()
					.clickAnchor();
					// Reading Number of Entries label
			numbEntriesString = Source
					.OrganizationNavigator()
					.clickLocations()	
					.readShowNumOfEntries()
					.replace(" entries", EmptyString);
					// Retrieving Number of Locations
			count1 = numbEntriesString.substring(numbEntriesString.lastIndexOf(" ") + 1);
					// Anchoring on Location
			Source
					.OrganizationPage()
					.clickFirstRow()
					.clickAnchor();
					// Reading Number of Entries label
			numbEntriesString = Source
					.OrganizationNavigator()
					.clickLocations()	
					.readShowNumOfEntries()
					.replace(" entries", EmptyString);
					// Retrieving Number of Locations
			count2 = numbEntriesString.substring(numbEntriesString.lastIndexOf(" ") + 1);
	
			SoftAssert.assertEquals(count1, count2);
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}
