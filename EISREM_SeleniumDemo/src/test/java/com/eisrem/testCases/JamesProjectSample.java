package com.eisrem.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.Data;
import com.eisrem.AppUtils.DriverFactory;

public class JamesProjectSample extends Data{

	String url = "https://som01--mecnvtst.lightning.force.com/lightning/page/home";
	String user = "case_worker_01@maine.gov.cnvtst";
	String pass = "MaineTest@22";
	
	@Test
	public void scrollTest() {
		
		Source.DriverFactory().openBrowser(Browser);
		Source	.SeleniumHelper()
				.goToUrl(url)
				.setText(By.xpath("//input[@id='username']"), user)
				.setText(By.xpath("//input[@id='password']"), pass)
				.clickElement(By.xpath("//input[@id='Login']"))
				.clickElement(By.xpath("//header/div[2]/div[2]/div[1]/button[1]"))
				.setText(By.xpath("//input[@class='slds-input']"), "I-0001036810 ", Clear)
				.clickElement(By.xpath("//mark[contains(text(),'I-0001036810')]"))
				.sleep(3)
//				.clickElement(By.xpath("//body/div[4]/div[1]/section[1]/div[1]/div[1]/one-appnav[1]/div[1]/one-app-nav-bar[1]/nav[1]/div[1]/one-app-nav-bar-item-root[2]/a[1]/span[1]"))
//				.clickElement(By.xpath("//a[contains(text(),'I-0001036810')]"))
				.scrollToSpecificPoint(0, 500)
				.sleep(5);
		
		//WebElement element = Source.SeleniumHelper().getWebElement(By.xpath("//body//div[1]/div[1]/div[1]/div[3]/div[2]/section[1]/div[2]/div[2]/div[2]/div[6]/section[1]/div[1]/div[2]"));
		WebElement element2 = Source.SeleniumHelper().getWebElement(By.xpath("//tbody/tr[@id='Intake PersonssfRecord0']/td[1]"));
		Source	.SeleniumHelper()		
				//.runJavascriptWithElement("arguments[0].scrollBottom += 200;", element)
				.runJavascriptWithElement("arguments[0].scrollIntoView(true);", element2)
				.sleep(5);
		
	}
	
	
}
