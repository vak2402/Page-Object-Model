package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	// class Objects
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {
		initization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String HomePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO", "Home Page Title Not Match");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactPage = homePage.clickonContactsLink();
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
