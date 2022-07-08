package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_Organization_Location_Add_003 extends BaseHook{
	
	@Test(priority=1,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Location_Add_StateUser_002(String Module) {

			try {
				SeleniumHelper.log.info("Using the new toggle on the add location screen, "
					+ "a newly created location can be automatically added to any active user in that loc's org who share a service pop " 
					+ "with the new location");

				String baseLoc = "1";
				String lastName = "TestUser" + SeleniumHelper.generateRandomAlpha(4);
				String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
				
				Source		.OrganizationPage().setSearch(OrgDHHS).clickFirstRow().clickAnchor();
							// Creating a User
				Source		.OrganizationNavigator().clickUsersStaff().clickAdd()
							.UserStaffPage()
							.setFirstName(UserFirstName)
							.setLastName(lastName)
							.setEmail(UserEmail)
							.toggleStaffActive(T)
							.clickUserInfoAccord()			
							.toggleUserActive(F)
							.setUserName(username)
							.setPassword(UserPassword)
							.setPasswordConfirmation(UserPassword);
							// Adding Base Location and Service Population - Childrens
				Source
							.UserHomeOfficeAccord()
							.clickUserHomeOfficeAdd()
							.setUserBaseLocation(baseLoc)
							.clickComplete()
							.UserInfoAccord()		
							.clickServicePopulationAvailableAccord()
							.addServicePopulation()
							.clickSubmit()
							.clickPopupOk()
							// Adding a location 
							.OrganizationNavigator()
							.clickLocations()					
							.clickAdd()
							.LocationsPage()
							.setName(LocationName)
							.selectType(LocationType.OTHER_LOCATION.getName())
							.toggleActive(T)
							// and setting Add to State users flag
							.toggleStateUser(T)
							// setting Service Population same as for the user
							.DataTable()
							.clickAdd()
							.ServicePopulationsAvailableAccord()					
							.selectServicePopulation(ServicePopulations.ADULT_MH.getName())
							.setDescription(Description)
							.clickComplete()
							.LocationsPage()
							.clickSubmit()
							.clickPopupOk();
				Actual = Source
							.OrganizationNavigator()
							.clickUsersStaff()
							.clickFirstRow()
							.clickView()
							.UserStaffPage()
							.clickUserInfoAccord()
							.clickAdditionalOrgLocationAccord()
							.readAdditionalOrgLocFirstRowLocation();
									
				Expected = "DHHS/ " + LocationName;
				Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
				SoftAssert.assertEquals(Actual, Expected);
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
			
			
			
			
	
	@Test(priority=2,dataProvider = Organization, dataProviderClass = DataProviders.class)
	public void TC_Location_Add_StateUser_003(String Module) {

		try {
			SeleniumHelper.log.info("Using the new toggle on the add location screen, "
				+ "a newly created location can be automatically added to any active user in that loc's org who share a service pop " 
				+ "with the new location");

			String baseLoc = "1";
			String lastName = "TestUser" + SeleniumHelper.generateRandomAlpha(4);
			String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
			
			Source		.OrganizationPage().setSearch(OrgDHHS).clickFirstRow().clickAnchor();
						// Creating a User
			Source		.OrganizationNavigator().clickUsersStaff().clickAdd()
						.UserStaffPage()
						.setFirstName(UserFirstName)
						.setLastName(lastName)
						.setEmail(UserEmail)
						.toggleStaffActive(T)
						.clickUserInfoAccord()			
						.toggleUserActive(T)
						.setUserName(username)
						.setPassword(UserPassword)
						.setPasswordConfirmation(UserPassword);
						// Adding Base Location and Service Population - Childrens
			Source
						.UserHomeOfficeAccord()
						.clickUserHomeOfficeAdd()
						.setUserBaseLocation(baseLoc)
						.clickComplete()
						.UserInfoAccord()		
						.clickServicePopulationAvailableAccord()
						.addServicePopulation()
						.clickSubmit()
						.clickPopupOk()
						// Adding a location 
						.OrganizationNavigator()
						.clickLocations()					
						.clickAdd()
						.LocationsPage()
						.setName(LocationName)
						.selectType(LocationType.OTHER_LOCATION.getName())
						.toggleActive(T)
						// and setting Add to State users flag
						.toggleStateUser(T)
						// setting Service Population same as for the user
						.DataTable()
						.clickAdd()
						.ServicePopulationsAvailableAccord()					
						.selectServicePopulation(ServicePopulations.CHILDRENS.getName())
						.setDescription(Description)
						.clickComplete()
						.LocationsPage()
						.clickSubmit()
						.clickPopupOk();
			Actual = Source
						.OrganizationNavigator()
						.clickUsersStaff()
						.clickFirstRow()
						.clickView()
						.UserStaffPage()
						.clickUserInfoAccord()
						.clickAdditionalOrgLocationAccord()
						.readAdditionalOrgLocFirstRowLocation();
								
			Expected = "DHHS/ " + LocationName;
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}
