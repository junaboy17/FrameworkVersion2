package com.eisrem.pageFactory.ProcessWizard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProcessPage extends ProcessWizardNavigator{

	public ProcessPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	
}
