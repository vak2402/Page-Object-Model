package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil testUtil;
	String sheetName= "contact";

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactPage = new ContactPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage = homePage.clickonContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsLabel() {
		Assert.assertTrue(contactPage.verifyContactsLabel(), "Contact Label is missing on the Page");
	}

	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactPage.selectSingleContactsByName("Ravi Sharma");
	}

	@Test(priority = 3)
	public void selecMultipletContactsTest() {
		contactPage.selectMultipleContactsByName("Ravi Sharma");
		contactPage.selectMultipleContactsByName("test1 test");
	}
	
	@DataProvider
	public Object getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=4,dataProvider="getCRMTestData")
	public void createNewContact(String Title, String FirstName, String LastName, String CompanyName) {
		homePage.clickOnNewContact();
		contactPage.createNewContact(Title,FirstName,LastName,CompanyName);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
