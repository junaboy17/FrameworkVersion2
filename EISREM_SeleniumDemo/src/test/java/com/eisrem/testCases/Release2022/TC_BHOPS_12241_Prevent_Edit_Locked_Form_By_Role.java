package com.eisrem.testCases.Release2022;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.DataProviders;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BaseHook;

public class TC_BHOPS_12241_Prevent_Edit_Locked_Form_By_Role extends BaseHook {


	@Test(priority=1,dataProvider = Administrator, dataProviderClass = DataProviders.class)
	public void TC_Disabled_Locked_Form_By_Role(String Module) {
		
		SoftAssert = new SoftAssert();
		
		String PageName = "LOCK FORM TEST PAGE " + SeleniumHelper.generateRandomNumber(4);
		String TypeName = "LOCK FORM TEST TYPE " + SeleniumHelper.generateRandomNumber(4);
		String ConductedTypeName = "Selenium Test Locked Form " + SeleniumHelper.generateRandomNumber(4);
		String Question1 = "QUESTION 1 THAT LOCKS FORM IF ANSWERED";
		String testClientID = "";
		By NotesLink = By.xpath("//a[@id='7']");
		
		try{
			SeleniumHelper.log.info("Verifying lock form functionality based on Admin/Non-Admin user role.");

							//Add page with required question	
					Source  .PagesPage()
							.addPage(PageName,null ,null , F,"SELENIUM DESCRIPTION")
							.GetSource()
							.SectionsAvailableAccord()
							.addSection("LOCK TEST SECTION", 1, "SELENIUM DESCRIPTION", F, F, T)
							.GetSource()
							.RowsAvailableAccord()
							.addRow("LOCK TEST ROW", 1, null, F, F, T)
							.GetSource()
							.QuestionsAvailableAccord()
							.clickQAAdd()
					    	.selectQuestionType(QuestionType.TEXT_FIELD.getIndex())
							.setQuestionLabel(Question1)
							.setSortOrder("1")
							.clickLockFormToggle()
							.clickQASave()
							.clickPopupOkIfExist()
							
							.QuestionsAvailableAccord()							
							.clickQAAdd()
					    	.selectQuestionType(QuestionType.TEXT_FIELD.getIndex())
							.setQuestionLabel("QUESTION 2")
							.setSortOrder("2")
							.clickQASave()
							.clickPopupOkIfExist()
							
							.RowsAvailableAccord()
							.clickRowsBack()
							.GetSource()
							.SectionsAvailableAccord()
							.clickSectionsBack()
							.GetSource()
							.PagesPage()
							.clickLockForUseToggle()
							.clickYes()
							.PagesPage()	
							.clickSubmitExit()
							.GetSource()
							.SeleniumHelper()
							.sleep(5)
														
							// add a new type with page created above
							.GetSource()
							.TypesPage()
							.addType(TypeName, 
									null, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), 
									"SELENIUM DESCRIPTION", F, F, AppAreaConductType.PEOPLE.getIndex())
							
							//Add Page
							.GetSource()
							.PagesAvailableAccord()
							.addPage(PageName, 1, null, null, null, T, T)
							.addRoleToPage(Roles.ALLAPPS.getIndex())
							.addRoleToPage(Roles.CS_ADMIN_ROLE.getIndex())
				 			.clickServicePopulationAvailableAccord()
							.GetSource()
							.PagesAvailableAccord()
							.addServicePopulationToPage(ServicePopulations.CHILDRENS.getIndex())
							.clickCompleteAndOk()
							
							//Lock type for use
							.TypesPage() 
							.clickLockForUseToggle()
							.clickYes()
							.TypesPage()
							.clickSubmitExit()
							.GetSource()
							.SeleniumHelper()
							.sleep(5)

							// add and anchor client and conduct the type
							.GetSource()
							.NavigationMenuBar()
							.clickPeople()
							.clickAdd()
							.DemographicsPage()
							.fillRequiredDemogrphics()
							.clickSubmit()
							.clickPopupOk()
							.PeopleNavigator()
							.clickPeopleTab();

				testClientID = Source
							.DataTable()
							.clickFirstRow()
							.readFirstResultID().replaceAll("[^0-9]", EmptyString);
				
				Source		.PeoplePage()
							.clickAnchor()
							.NavigationMenuBar()
							.clickNotes()
							.clickAdd()
							.NotesPage()
							.selectType(TypeName + "/ Notes")
							.setTitle(ConductedTypeName)
							.clickStartAssessment()
							.setText(1, Question1, "ABC")
							.clickSubmitAllPages()
							.clickGoBackToList()
							.NotesNavigator()
							.clickFirstRow()
							.clickEdit()
							.FormPage()
							.checkAllWebElementsEnabled(); 	// if the user has one of Admin roles 
															//a form should be enabled for Edit even if it is locked by answer on a question
					
				Source
						.LogInPage()
						.LogOut()
						.LogIn(userName2, userPassword2)
						.GetSource()
						.NavigationMenuBar()
						.clickPeople()
						.GetSource()
						.SeleniumHelper()
						.sleep(10)
						.GetSource()
						.DataTable()
						.setSearch(testClientID, No)
						.clickFirstRow()
						.clickAnchor()
						.NavigationMenuBar()
						.GetSource()
						.SeleniumHelper()
						.sleep(10);
						
				Source	.SeleniumHelper().clickElement(NotesLink)
						.GetSource()
						.DataTable()
						.setSearch(ConductedTypeName, No)
						.clickFirstRow()
						.clickEdit()
						.FormPage()
				        .checkAllWebElementsDisabled();	// form is locked for non-admin user ;
					
				Source  .LogInPage()
						.LogOut()
						.LogInSeleniumUser();
				
				Source	.NavigationMenuBar()
						.clickAdministrator()
						.GetSource()
						.TypesPage()
						.endDateType(TypeName);
				SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
			
		}
	
	}

}