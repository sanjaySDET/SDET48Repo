package com.crm.vtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// declaretion
	@FindBy(name = "user_name")
	private WebElement usernameTxtEdt;

	@FindBy(name = "user_password")
	private WebElement passwordTxtEdt;

	@FindBy(id = "submitButton")
	private WebElement submitBtnClk;

	// initialization

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization provide getters and setters and business libraries
	public WebElement getUsernameTxtEdt() {
		return usernameTxtEdt;
	}

	public WebElement getPasswordTxtEdt() {
		return passwordTxtEdt;
	}

	public WebElement getSubmitBtnClk() {
		return submitBtnClk;
	}

	// create a method for login
	public void loginToApp(String username, String password) {
		usernameTxtEdt.sendKeys(username);
		passwordTxtEdt.sendKeys(password);
		submitBtnClk.click();
	}

}
