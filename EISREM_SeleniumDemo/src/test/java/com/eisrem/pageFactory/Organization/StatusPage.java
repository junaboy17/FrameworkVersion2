package com.eisrem.pageFactory.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class StatusPage extends OrganizationNavigator{


	public StatusPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath="//li[@id='36_Classes_tab']")
//	public WebElement ClassesTab;
//		
//	public String readClassesTab() {
//		return Source.SeleniumHelper().getWebElement(ClassesTab).getText();
//	}
//	
//	public ClassesPage clickClasses() {
//		Source.SeleniumHelper().getWebElement(ClassesTab).click();
//		return new ClassesPage(DriverFactory.getDriver());
//	}
	
	
}
