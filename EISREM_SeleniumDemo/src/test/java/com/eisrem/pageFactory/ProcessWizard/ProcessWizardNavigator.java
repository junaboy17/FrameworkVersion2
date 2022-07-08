package com.eisrem.pageFactory.ProcessWizard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.pageFactory.CommonPage.DataTable;

public class ProcessWizardNavigator extends DataTable{

	public ProcessWizardNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Process')]")
	public WebElement ProcessTab;
	
	public String readReportsTab() {
		return Source.SeleniumHelper().readElement(ProcessTab);
	}
	
	public ProcessWizardNavigator clickReports() {
		Source.SeleniumHelper().clickElement(ProcessTab);
		return this;
	}
	
}
