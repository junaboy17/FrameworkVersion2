package com.eisrem.pageFactory.Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class AttendancePage extends ClassesNavigator{


	public AttendancePage(WebDriver driver) {
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
