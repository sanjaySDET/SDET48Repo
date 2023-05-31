package com.crm.vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author SanjayBabu
 *
 */
public class ContactsInfoPage {
	//initialisation

	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaretion
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement contactname;

	//utilization
	public WebElement getContactname() {
		return contactname;
	}

}
