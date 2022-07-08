package com.eisrem.pageFactory.People;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.SeleniumHelper;

public class ReferralsServicesPage extends PeopleNavigator{


	public ReferralsServicesPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@id='ReferralsServices-tab']//a")
	public WebElement ReferralsServicesLink;

	@FindBy(xpath="//input[@id='datepicker_startDate_referralServ']")
	public WebElement AdmitDate;

	@FindBy(xpath="//label[@for='datepicker_startDate_referralServ']")
	public WebElement AdmitDateTitle;

	@FindBy(xpath="//input[@id='datepicker_endDate_referralServ']")
	public WebElement DischargeDate;

	@FindBy(xpath="//label[@for='datepicker_endDate_referralServ']")
	public WebElement DischargeDateTitle;

	@FindBy(xpath="//select[@id='referralServType']")
	public WebElement TypeDropdown;

	@FindBy(xpath="//label[@for='referralServType']")
	public WebElement TypeDropdownTitle;

	@FindBy(xpath="//select[@id='referralServService']")
	public WebElement ServiceDropdown;

	@FindBy(xpath="//label[@for='referralServService']")
	public WebElement ServiceDropdownTitle;

	@FindBy(xpath="//input[@id='referralServCaseId']")
	public WebElement CaseIdInput;

	@FindBy(xpath="//label[@for='referralServCaseId']")
	public WebElement CaseIdTitle;
	
	@FindBy(xpath="//label[@for='serviceOrg-combobox']")
	public WebElement ServiceOrganizationTitle;
	
	@FindBy(xpath="//input[@id='serviceOrg-combobox']")
	public WebElement ServiceOrganizationTextBox;
	
	@FindBy(xpath="//label[@for='referralServComment']")
	public WebElement DescriptionTitle;
	
	@FindBy(xpath="//textarea[contains(@id,'referralServComment')]")
	public WebElement Description;

	@FindBy(xpath="//button[contains(text(),'Back To Referrals/Services')]")
	public WebElement BackToReferralsServicesBtn;

	public String readLinkTitle() {
		return Source.SeleniumHelper().readElement(ReferralsServicesLink);
	}

	public String readAdmitDateTitle() {
		return Source.SeleniumHelper().readElement(AdmitDateTitle);
	}

	public String readDischargeDateTitle() {
		return Source.SeleniumHelper().readElement(DischargeDateTitle);
	}

	public String readTypeDropdownTitle() {
		return Source.SeleniumHelper().readElement(TypeDropdownTitle);
	}

	public String readServiceDropdownTitle() {
		return Source.SeleniumHelper().readElement(ServiceDropdownTitle);
	}

	public String readCaseIdTitle() {
		return Source.SeleniumHelper().readElement(CaseIdTitle);
	}
	
	public String readReferralServicesDescriptionTitle() {
		return Source.SeleniumHelper().readElement(DescriptionTitle);
	}

	public ReferralsServicesPage setAdmitDate(String date,String... Clear) {
		Source.SeleniumHelper().setText(AdmitDate, date + Keys.TAB + Keys.TAB, Clear);	
		return this;
	}

	public ReferralsServicesPage setDischargeDate(String date,String... Clear) {
		Source.SeleniumHelper().setText(DischargeDate, date + Keys.TAB, Clear);	
		return this;
	}

	public ReferralsServicesPage selectType(int value) {
		Source.SeleniumHelper().select(TypeDropdown, value);
		return this;
	}

	public ReferralsServicesPage selectService(int value) {
		Source.SeleniumHelper().select(ServiceDropdown, value);
		return this;
	}

	public ReferralsServicesPage setCaseId(String value, String... Clear) {
		Source.SeleniumHelper().setText(CaseIdInput, value + Keys.TAB + Keys.TAB, Clear);
		return this;
	}
	
	public ReferralsServicesPage setReferralServicesDescription(String value, String... Clear) {
		Source.SeleniumHelper().setText(Description, value + Keys.TAB, Clear);
		return this;
	}

	public String readAdmitDateValue() {
		return Source.SeleniumHelper().readElement(AdmitDate);
	}	

	public String readDischargeDateValue() {
		return Source.SeleniumHelper().readElement(DischargeDate);
	}	

	public String readTypeDropdownValue() {
		return Source.SeleniumHelper().readAttribute(TypeDropdown, "value");
	}

	public String readServiceDropdownValue() {
		return Source.SeleniumHelper().readAttribute(ServiceDropdown, "value");
	}

	public String readCaseIdValue() {
		return Source.SeleniumHelper().readElement(CaseIdInput);
	}

	public String readBackToReferralsServicesBtn() {
		return Source.SeleniumHelper().readElement(BackToReferralsServicesBtn);
	}

	public ReferralsServicesPage clickBackToReferralsServicesBtn() {
		Source.SeleniumHelper().clickElement(BackToReferralsServicesBtn);
		return this;
	}
	
	public String readServiceOrganizationTitle() {
		return Source.SeleniumHelper().readElement(ServiceOrganizationTitle);
	}

	public ReferralsServicesPage setServiceOrganization(String organization, String... Clear) {
		Source.SeleniumHelper().setText(ServiceOrganizationTextBox, organization, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().clickElement(By.cssSelector("#serviceOrgDiv > div > div > ul > li > a"));
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}

	public ReferralsServicesPage createReferralsServicesIfNoData() {
		Actual = Source		.DataTable()
							.readDataTable(1, 1);

		if(Actual.equalsIgnoreCase("No data available")) {
			Source		.DataTable()
						.clickAdd()
						.ReferralsServicesPage()
						.setAdmitDate(Today, Clear)
						.selectType(ReferralsType.REFERRAL.getIndex())
						.selectService(ReferralsService.HCT.getIndex())
						.setCaseId(SeleniumHelper.generateRandomAlpha(10), Clear)
						.setServiceOrganization(OrgDHHS, Clear)
						.setReferralServicesDescription(SeleniumHelper.generateRandomAlpha(10), Clear)
						.clickSubmit()
						.clickPopupOk();
		}
		
		return this;
	}
	
	public ReferralsServicesPage createReferralsServicesIfNoData(String AdmitDate, ReferralsType type, ReferralsService Service, String CaseId, String organization,  String Description) {
		Actual = Source		.DataTable()
							.readDataTable(1, 1);

		if(Actual.equalsIgnoreCase("No data available")) {
			Source		.DataTable()
						.clickAdd()
						.ReferralsServicesPage()
						.setAdmitDate(AdmitDate, Clear)
						.selectType(type.getIndex())
						.selectService(Service.getIndex())
						.setCaseId(CaseId, Clear)
						.setServiceOrganization(organization, Clear)
						.setReferralServicesDescription(SeleniumHelper.generateRandomAlpha(10), Clear)
						.clickSubmit()
						.clickPopupOk();
		}
		
		return this;
	}
}
