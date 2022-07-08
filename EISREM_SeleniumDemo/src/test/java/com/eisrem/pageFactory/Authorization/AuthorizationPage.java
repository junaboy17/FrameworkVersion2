package com.eisrem.pageFactory.Authorization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class AuthorizationPage extends AuthorizationNavigator{

	public AuthorizationPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	
	
}
