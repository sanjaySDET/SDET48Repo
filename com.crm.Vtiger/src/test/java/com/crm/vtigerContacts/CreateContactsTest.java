package com.crm.vtigerContacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtigerObjectRepository.ContactsInfoPage;
import com.crm.vtigerObjectRepository.ContactsPage;
import com.crm.vtigerObjectRepository.CreateContactPage;
import com.crm.vtigerObjectRepository.HomePage;

import vtigerGenericUtils.BaseClass;

@Listeners(vtigerGenericUtils.ListnerImpClass.class)	
public class CreateContactsTest extends BaseClass {
@Test(retryAnalyzer = vtigerGenericUtils.RetryAnalyser.class)
	 public void createContactsTest() throws EncryptedDocumentException, IOException{

		//welcome
		// to get random number
		int ranNo = jLib.getRandomNumber();

		// Fetch data from excel sheet
		String firstName = eLib.getExcelData("ContactsPage", 1, 0)+ranNo;
		String lastName = eLib.getExcelData("ContactsPage", 1, 1)+ranNo;

		//check whether the home page is displaying or not
		HomePage homePage = new HomePage(driver);
		String url = homePage.currentUrl(driver);

		Assert.assertTrue(url.contains("Home"));
		
		//click on contacts link
		homePage.getContactsLink().click();
		
		//click on create contacts icon
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCnctLkpImg().click();
		
		//enter the first name ,last name and click on saveBtn
		CreateContactPage createContactPage = new CreateContactPage(driver);
		createContactPage.createContact(firstName, lastName);
		createContactPage.getSaveBtn().click();
		
		//verify whether the Contacts is created or not
		ContactsInfoPage contactsInfoPage = new ContactsInfoPage(driver);
		String presentContactName = contactsInfoPage.getContactname().getText();
		
		Assert.assertTrue(presentContactName.contains(lastName),"contact is not created");
		
		Reporter.log("CreateContactsTest testcase is pass",true);
	}
}
