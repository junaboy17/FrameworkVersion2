package com.eisrem.testCases.Release2022;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_10723_Test_Triggered_Pages_With_Popup extends BaseHook{

	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
		public void Test_Triggered_Pages_With_Popup(String Module) {		
			SoftAssert = new SoftAssert();
			String TypeName = "TC_Types_Selenium " + SeleniumHelper.generateRandomNumber(8);
	
			try{
			SeleniumHelper.log.info("Create Type with two pages (one page being triggered by the other).");
			ExpectedB = true;
			ActualB = Source		.NavigationMenuBar()
								.GetSource()
								.DataTable()
								.clickAdd()
								.TypesPage()
								.selectAppModule(AppModule.NOTES.getIndex())
								.setName(TypeName)
								.setDescription(Description)
								.selectLockTime(LockTime.NEVER.getIndex())
								.selectAppAreaToConductType(AppAreaConductType.BOTH.getIndex())
								.clickAdd()
								.PagesAvailableAccord()
								.setPage(DataFixForm)
								.setSortOrder(OneN)
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(Roles.ALLAPPS.getIndex())
								.setDescription(Description)
								.clickRolesComplete()
								.PagesAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation(ServicePopulations.CHILDRENS.getIndex())
								.setDescription(Description)
								.clickSpComplete()
								.PagesAvailableAccord()
								.clickComplete()
								.DataTable()
								.clickPopupOk()
								.TypesPage()
								.clickAdd()
								.PagesAvailableAccord()
								.setPage("Children's Client Access form")
								.setSortOrder(TwoN)
								.selectTriggeredByPage(1)
								.clickPopupOk()
								.PagesAvailableAccord()
								.selectTriggeredByQuestion("Service Population")
								.selectTriggeredByAnswer_MultiSelect("Childrens")
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(Roles.ALLAPPS.getIndex())
								.setDescription(Description)
								.clickRolesComplete()
								.PagesAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation(ServicePopulations.CHILDRENS.getIndex())
								.setDescription(Description)
								.clickSpComplete()
								.PagesAvailableAccord()
								.clickComplete()
								.SeleniumHelper()
								.sleep(5)
								.GetSource()
								.TypesPage()
								.clickTestForm()
								.GetSource()
								.SeleniumHelper()
								//.checkWebElementExists(By.id("renderTypePageTab-1000005416"), 5);
								.checkWebElementExists(By.xpath("//li[@id='renderTypePageTab-1000005416' and contains(@style,'display: none')]"), 5);
			
			SoftAssert.assertEquals(ActualB, ExpectedB, "Triggered Page Tab didn't render as display: none!");
			
			ExpectedB = true;
			ActualB   = Source   .TypesPage()
								.clickTestFormFirstPage()
								.GetSource()
								.FormPage()
								.selectTestValue("//select[@id='renderTypeQuestion-1000032015']", "Childrens")
								.GetSource()
								.SeleniumHelper()
								//.checkWebElementExists(By.id("renderTypePageTab-1000005416"), 5);
								.checkWebElementExists(By.xpath("//li[@id='renderTypePageTab-1000005416' and not(contains(@style,'display:'))]"), 5);
			
			SoftAssert.assertEquals(ActualB, ExpectedB, "Render Page Tab isn't showing!");
			
			ExpectedB = true;
			ActualB = Source    .SeleniumHelper()
								.checkWebElementExists(By.xpath("//div[text()='This page was triggered.']"), 5);
			
			SoftAssert.assertEquals(ActualB, ExpectedB, "The popover didn't appear!");
			
			ExpectedB = true;
			ActualB   = Source  .FormPage()
								.selectTestValue("//select[@id='renderTypeQuestion-1000032015']", "Adults")
								.GetSource()
								.SeleniumHelper()
								//.checkWebElementExists(By.id("renderTypePageTab-1000005416"), 5);
								.checkWebElementExists(By.xpath("//li[@id='renderTypePageTab-1000005416' and contains(@style,'display: none')]"), 5);
			
			SoftAssert.assertEquals(ActualB, ExpectedB, "Triggered Page Tab wasn't hidden after un-triggering!");
			
			ExpectedB = false;
			ActualB = Source    .SeleniumHelper()
								.Wait(3)
								.checkWebElementExists(By.xpath("//div[text()='This page was triggered.']"), 5);
			
			SoftAssert.assertEquals(ActualB, ExpectedB, "The popover didn't disappear after un-triggering!");
			
			Source.TypesPage()
								.clickTestBackBtn()
								.clickLockForUseToggle()
								.clickYes()
								.TypesPage()
								.clickSubmitExit()
								.readDataTable(1, 1)
								.replace("Select", EmptyString)
								.replace(" ", EmptyString);
								
			ExpectedB = true;
			ActualB = Source	.NavigationMenuBar()
								.clickPeople()
								.clickPeopleTab()
								.clickAdd()
								.DemographicsPage()
								.setFirstName("INIGO")
								.setLastName("MONTOYA")
								.selectDemographicsGender(1)
								.setDateOfBirth(PastDate30)
								.clickSubmit()
								.clickPopupOk()
								
								.NavigationMenuBar()
								.clickNotes()
								.clickAdd()
								.NotesPage()
								.setTitle("Selenium Conducted Type")
								.selectNotesType(TypeName + "/ Notes")
								.clickStartNotes()
								.selectTestValue("//select[@id='renderTypeQuestion-1000032015']", "Childrens")
								.GetSource()
								.SeleniumHelper()
								//.checkWebElementExists(By.id("renderTypePageTab-1000005416"), 5);
								.checkWebElementExists(By.xpath("//li[@id='renderTypePageTab-1000005416' and not(contains(@style,'display:'))]"), 5);
			
			SoftAssert.assertEquals(ActualB, ExpectedB, "Triggered Page Tab didn't render as display: none!");
			
			ExpectedB = true;
			ActualB   = Source   .NotesPage()
								.clickFormFirstPage()
								.GetSource()
								.FormPage()
								.selectTestValue("//select[@id='renderTypeQuestion-1000032015']", "Childrens")
								.GetSource()
								.SeleniumHelper()
								//.checkWebElementExists(By.id("renderTypePageTab-1000005416"), 5);
								.checkWebElementExists(By.xpath("//li[@id='renderTypePageTab-1000005416' and not(contains(@style,'display:'))]"), 5);
			
			SoftAssert.assertEquals(ActualB, ExpectedB, "Render Page Tab isn't showing!");
			
			ExpectedB = false;
			ActualB = Source    .SeleniumHelper()
								.checkWebElementExists(By.xpath("//div[text()='This page was triggered.']"), 5);
			
			SoftAssert.assertEquals(ActualB, ExpectedB, "The popover appeared when it shouldn't have!");
			
			ExpectedB = true;
			ActualB   = Source  .FormPage()
								.selectTestValue("//select[@id='renderTypeQuestion-1000032015']", "Adults")
								.GetSource()
								.SeleniumHelper()
								//.checkWebElementExists(By.id("renderTypePageTab-1000005416"), 5);
								.checkWebElementExists(By.xpath("//li[@id='renderTypePageTab-1000005416' and contains(@style,'display: none')]"), 5);
			
			SoftAssert.assertEquals(ActualB, ExpectedB, "Triggered Page Tab wasn't hidden after un-triggering!");
			
			ExpectedB = false;
			ActualB = Source    .SeleniumHelper()
								.Wait(3)
								.checkWebElementExists(By.xpath("//div[text()='This page was triggered.']"), 5);
			
			SoftAssert.assertEquals(ActualB, ExpectedB, "The popover didn't disappear after un-triggering!");
			
			
			
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
}