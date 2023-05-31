package com.crm.vtigerOrganisation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtigerObjectRepository.CreateOrganisationPage;
import com.crm.vtigerObjectRepository.HomePage;
import com.crm.vtigerObjectRepository.OrganisationInfoPage;
import com.crm.vtigerObjectRepository.OrganisationPage;

import vtigerGenericUtils.BaseClass;

public class CreateOrganisationTest extends BaseClass{
@Test
	public void createOrganisationTest() throws EncryptedDocumentException, IOException
	{
	//welcome
		//to get random number
		int ranNo = jLib.getRandomNumber();
		
		//Fetch data from excel sheet
		String orgName =eLib.getExcelData("OrganisationsPage", 1, 0)+ranNo;
		
		//check whether the home page is displaying or not
		HomePage homePage = new HomePage(driver);
		String url = homePage.currentUrl(driver);
		
		Assert.assertTrue(url.contains("Home"),"home page is not displaying");
		
		//click on organisation module in home page
		homePage.getOrganisationLink().click();
		
		//click on create organisation lookUp Image
		OrganisationPage organisationPage = new OrganisationPage(driver);
		organisationPage.getCreateOrgLookUpImg().click();

		//enter the organisationName in the OrganisationName textFiled
		//click on saveBtn
		CreateOrganisationPage createOrganisationPage = new CreateOrganisationPage(driver);
		createOrganisationPage.createOrg(orgName);
		createOrganisationPage.getSaveBtnClk().click();
		
		//verify whether the organisation is created or not
		OrganisationInfoPage organisationInfoPage = new OrganisationInfoPage(driver);
		String organisationName = organisationInfoPage.getCreatedOrg().getText();
		
		Assert.assertTrue(organisationName.contains(orgName),"Organisation is not created");
		
		Reporter.log("CreateOrganisationTest testcase is pass",true);
		
		
	}
}
