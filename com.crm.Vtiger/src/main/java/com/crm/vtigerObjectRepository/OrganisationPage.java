package com.crm.vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

	@FindBy(xpath = "//img[@title='Create Organization...']")private WebElement createOrgLookUpImg;
	
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
}
