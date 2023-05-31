package com.crm.vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement createdOrg;


	//initialization
	public OrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getCreatedOrg() {
		return createdOrg;
	}
	
	
	
	//utilization
	//verify the created organisation
}
