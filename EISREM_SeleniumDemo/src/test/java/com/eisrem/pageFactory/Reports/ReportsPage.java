package com.eisrem.pageFactory.Reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends ReportsNavigator{

	public ReportsPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	

	
}
