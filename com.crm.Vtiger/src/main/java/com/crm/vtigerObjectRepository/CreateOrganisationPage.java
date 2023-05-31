package com.crm.vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtils.WebdriverUtility;

public class CreateOrganisationPage{

	//declaretion
	@FindBy(name = "accountname") private WebElement orgNameTxtEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")private WebElement saveBtnClk;
	
	@FindBy(name = "industry") private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")private WebElement typeDropDown;
	
	//initialization
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	//utilization
	public WebElement getOrgNameTxtEdt() {
		return orgNameTxtEdt;
	}


	public WebElement getSaveBtnClk() {
		return saveBtnClk;
	}
	
	
	//enter organisationName and click on save btn
	public void createOrg(String orgName)
	{
		orgNameTxtEdt.sendKeys(orgName);
	}
	
	//select industry from dropdown
	public void selectIndustry(String industry,WebdriverUtility wLib)
	{
		wLib.selectElementInDropdown(industryDropDown, industry);
	}
	
	//select type from dropdown
	public void selectType(String type,WebdriverUtility wLib)
	{
		wLib.selectElementInDropdown(typeDropDown, type);
	}
}
