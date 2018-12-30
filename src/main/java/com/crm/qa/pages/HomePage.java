package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Vaibhav Khandekar')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

//Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

//Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactPage clickonContactsLink() {
		contactsLink.click();
		return new ContactPage();
	}

	public void clickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();

	}

	public DealPage clickonDealsLink() {
		dealsLink.click();
		return new DealPage();
	}

	public TaskPage clickonTasksLink() {
		tasksLink.click();
		return new TaskPage();
	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
}
