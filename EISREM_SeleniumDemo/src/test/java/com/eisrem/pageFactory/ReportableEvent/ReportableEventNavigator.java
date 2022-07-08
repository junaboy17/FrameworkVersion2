package com.eisrem.pageFactory.ReportableEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.pageFactory.CommonPage.DataTable;

public class ReportableEventNavigator extends DataTable{

	public ReportableEventNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Reportable Event')]")
	public WebElement ReportableEventTab;
	
	public String readReportableEventTab() {
		return Source.SeleniumHelper().readElement(ReportableEventTab);
	}
	
	public ReportableEventNavigator clickReportableEventTab() {
		Source.SeleniumHelper().clickElement(ReportableEventTab);
		return this;
	}
	
}
