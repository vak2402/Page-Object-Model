package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

//PageFactory or OR

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name="client_lookup")
	WebElement companyName;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement savebtn;

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectSingleContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}

	public void selectMultipleContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}

	public void createNewContact(String title, String fn, String ln, String cmy) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		companyName.sendKeys(cmy);
		savebtn.click();
	}
}
