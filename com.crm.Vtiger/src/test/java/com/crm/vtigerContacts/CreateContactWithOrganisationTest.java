package com.crm.vtigerContacts;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtigerObjectRepository.ContactsInfoPage;
import com.crm.vtigerObjectRepository.ContactsPage;
import com.crm.vtigerObjectRepository.CreateContactPage;
import com.crm.vtigerObjectRepository.HomePage;

import vtigerGenericUtils.BaseClass;

public class CreateContactWithOrganisationTest extends BaseClass{
@Test
	public void createContactWithOrganisationTest() throws IOException{
	//welcome to createOrganisation	
	
	// to get random number
		int ranNo = jLib.getRandomNumber();

		// Fetch data from excel sheet
		String firstName = eLib.getExcelData("ContactsPage", 1, 0)+ranNo;
		String lastName = eLib.getExcelData("ContactsPage", 1, 1)+ranNo;
		String orgName = eLib.getExcelData("OrganisationsPage", 1, 0);

		//check whether the home page is displaying or not
		HomePage homePage = new HomePage(driver);
		String url = homePage.currentUrl(driver);

		SoftAssert sft = new SoftAssert();
		sft.assertTrue(url.contains("Home"),"home page is not displaying");

		//click on contacts link
		homePage.getContactsLink().click();

		//click on create contacts icon
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCnctLkpImg().click();

		//enter the first name ,last name and click on saveBtn
		CreateContactPage createContactPage = new CreateContactPage(driver);
		createContactPage.createContact(firstName, lastName);

		//click on select Organization lookUp image
		createContactPage.selectOrg(driver, orgName, wLib);

		//click on save button
		createContactPage.getSaveBtn().click();

		//verify whether the Contacts is created or not
		ContactsInfoPage contactsInfoPage = new ContactsInfoPage(driver);
		String presentContactName = contactsInfoPage.getContactname().getText();

		sft.assertTrue(presentContactName.contains(lastName),"contact is not created");
		
		Reporter.log("CreateContactWithOrganisationTest testcase is pass",true);
		
		sft.assertAll();
		//Thank you execution completed
	}
}