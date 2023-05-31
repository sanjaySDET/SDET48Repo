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

public class CreateOrganisationWithIndusAndTypeTest extends BaseClass{
//Welcome to my project
	@Test
	public void createOrganisationWithIndusAndTypeTest() throws EncryptedDocumentException, IOException
	{
		//to get random number
				int ranNo = jLib.getRandomNumber();

				// Fetch data from excel sheet
				String orgName = eLib.getExcelData("OrganisationsPage", 1, 0)+ranNo;
				
				// select industry
				String industry = eLib.getExcelData("OrganisationsPage", 3, 1);
				
				// select type
				String type = eLib.getExcelData("OrganisationsPage", 4, 2);
				
				// check whether the home page is displaying or not
				HomePage homePage = new HomePage(driver);
				String url = homePage.currentUrl(driver);
				
				//verify whether the homePage is displaying or not
				Assert.assertTrue(url.contains("Home"),"home page is not displaying");

				// click on organization module in home page
				homePage.getOrganisationLink().click();
				
				// click on create organization lookUp Image
				OrganisationPage organisationPage = new OrganisationPage(driver);
				organisationPage.getCreateOrgLookUpImg().click();

				// enter the organisationName in the OrganisationName textFiled
				CreateOrganisationPage createOrganisationPage = new CreateOrganisationPage(driver);
				createOrganisationPage.createOrg(orgName);

				// select industry from industry dropdown
				createOrganisationPage.selectIndustry(industry, wLib);

				// select type from type dropdown
				createOrganisationPage.selectType(type, wLib);

				// click on saveBtn
				createOrganisationPage.getSaveBtnClk().click();

				// verify whether the organisation is created or not
				OrganisationInfoPage organisationInfoPage = new OrganisationInfoPage(driver);
				String organisationName = organisationInfoPage.getCreatedOrg().getText();
				
				//verify whether the organisation is created or not
		        Assert.assertTrue(organisationName.contains(orgName),"Organisation is not created");
				
				Reporter.log("CreateOrganisationWithIndustryAndType testcase is pass",true);
	}
}
