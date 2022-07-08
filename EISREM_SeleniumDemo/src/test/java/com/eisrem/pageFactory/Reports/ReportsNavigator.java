package com.eisrem.pageFactory.Reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.pageFactory.CommonPage.ConductedTypes;

public class ReportsNavigator extends ConductedTypes{

	public ReportsNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@id='24_Report_tab']")
	public WebElement ReportsTab;
	
	public String readReportsTab() {
		return Source.SeleniumHelper().readElement(ReportsTab);
	}
	
	public ReportsNavigator clickReports() {
		Source.SeleniumHelper().clickElement(ReportsTab);
		return this;
	}
	
}
