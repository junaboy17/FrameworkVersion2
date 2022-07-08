package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_6269_Organization_Add_ServicesSpecialties_Duplicate_Error_Msg extends BaseHook{

	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void Add_ServicesSpecialties_Duplicate_Error_Message(String Module) {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying Error message after adding duplicate Organization ServicesSpecialties");
			Expected ="Please correct the following errors:";
			
			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
			                    .clickServicesSpecialties()
			                    .ServicesSpecialtiesPage()
			                    .clickAdd()
			                    .ServicesSpecialtiesPage()
			                    .selectServices(Enumerations.OrgServices.PNMI.getName())
			                    .selectSpecialties("CHILDRENS RESIDENTIAL CARE FACILITY - OUT OF STATE")
			                    .chooseCovergeArea("CUMBERLAND")		                    
			                    .clickSubmit()
			                    .readTopErrorMessage(1);
			                 			                    
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected ="ERROR Message:\n"
				+ "Conflict with existing Services/Specialties:\n"
				+ "Service = PNMI Specialty= CHILDRENS RESIDENTIAL CARE FACILITY - OUT OF STATE County = CUMBERLAND";
		Actual = Source		.DataTable()
							.readTopErrorMessage(2);
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	   }catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	   }
    }						
}
							    
								
								
	