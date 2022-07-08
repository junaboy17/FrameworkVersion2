package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_11321_People_Classes_Special_Accommodations extends BaseHook{

	@Test(priority=1,dataProvider = People, dataProviderClass = DataProviders.class)
	public void TC_BHOPS_11321_People_Classes_Special_Accommodations_1(String Module) {
		SoftAssert = new SoftAssert();

		try{
			//SeleniumHelper.log.info("Verifying Error message after adding duplicate People Associations");
			
			SeleniumHelper.log.info("Creating new person to work with");
			String peoId = Source.PeoplePage().addPersonReturnId();
			
			String ClassName = "Selenium Test Class " + SeleniumHelper.generateRandomNumber(4);
			
			SeleniumHelper.log.info("Creating Class, Roster, Adding Person and selecting a specialty");
			Expected = Success;
			Actual = Source	.NavigationMenuBar()
							.clickClasses()
							.DataTable()
							.clickAdd()
							.ClassesPage()
							.setClassName(ClassName)
							.setSeatsAvailable(String.valueOf(RandNum3))
							.selectServicePopulation(ServicePopulations.CHILDRENS.getName())
							.selectProgramType(ProgramType.UNKNOWN.getName())
							.selectOrganizationLocation(1)
							.setDescription(Description)
							.setEndDate(FutureDate7)
							.clickSubmit()
							.clickGoBackToList()
							.DataTable()
							.clickFirstRow()
							.clickAnchor()
							.ClassesNavigator()
							.clickRoster()
							.clickAdd()
							.RosterPage()
							.selectTypeOfMemberDropDown(TypeOfMember.PERSON.getName())
							.setPerson(peoId, Clear)
							.setPaymentProcessedDate(Today)
							.setPaymentConfirmationNum(String.valueOf(RandNum8))
							.setSpecialties("BRAIN INJURY", Clear)
							.setSpecialties("DEAF", Clear)
							.setNotes("Selenium Test" + RandNum3)
							.clickSubmit()
							.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Specialty loads on Edit in People - Classes");
			ExpectedB = T;
			ActualB = Source.DataTable()
							.clickGoBackToList()
							.NavigationMenuBar()
							.clickPeople()
							.setSearch(peoId, Clear)
							.clickFirstRow()
							.clickAnchor()
							.SeleniumHelper()
							.Wait(5)
							.GetSource()
							.PeopleNavigator()
							.clickClassesTab()
							.clickFirstRow()
							.clickEdit()
							.PeopleClassesPage()
							.confirmSpeciality("BRAIN INJURY, DEAF");
							
			SoftAssert.assertEquals(ActualB, ExpectedB);
							
			SeleniumHelper.log.info("Verifying Specialty loads on View in People - Classes");
			ExpectedB = T;
			ActualB = Source.ClassesPage()
							.clickBackTo()
							.DataTable()
							.clickFirstRow()
							.clickView()
							.PeopleClassesPage()
							.confirmSpeciality("BRAIN INJURY, DEAF");
							
			SoftAssert.assertEquals(ActualB, ExpectedB);
		
		SeleniumHelper.log.info("End Date the Client");
		Source.DataTable().clickBackTo().NavigationMenuBar().clickPeople().GetSource().PeoplePage().endDateAndSubmit(peoId);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
}						
}
							    
								
								
	