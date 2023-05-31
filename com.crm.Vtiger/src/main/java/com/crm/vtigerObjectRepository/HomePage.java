package com.crm.vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtils.WebdriverUtility;

public class HomePage{

	//declaration
	@FindBy(xpath = "//a[.='Organizations']")private WebElement organisationLink;
	
	@FindBy(xpath = "//a[.='Contacts']")private WebElement contactsLink;
	
	@FindBy(linkText = "Products")private WebElement productsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")private WebElement adminstratorIcon;
	
	@FindBy(xpath = "//a[.='Sign Out']")private WebElement signOutLnk;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//utization
	public WebElement getOrganisationLink() {
		return organisationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdminstratorIcon() {
		return adminstratorIcon;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	//logout from application
	public void logoutFromApp(WebDriver driver,WebdriverUtility wLib)
	{
		wLib.mouseOverOnElement(driver, adminstratorIcon);
		signOutLnk.click();
	}
	
	//get url of application
	public String currentUrl(WebDriver driver)
	{
		String url = driver.getCurrentUrl();
		return url;
	}
}
