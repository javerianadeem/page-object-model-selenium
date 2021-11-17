package com.qa.pages;


import java.sql.Time;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class RegisterPatientPage extends TestBase {
	
	@FindBy(name="givenName")
	WebElement givenNameElement;
	
	@FindBy(name="familyName")
	WebElement familyNameElement;
	
	@FindBy(name="gender")
	WebElement genderDropdownElement;

	
//	selectGender.selectByValue("Male");
	
	@FindBy(name="birthdateDay")
	WebElement dayOfBirthElement;
	
	@FindBy(name="birthdateMonth")
	WebElement monthOfElement;
//	Select monthOfBirthday = new Select(monthOfElement);
	
	@FindBy(name="birthdateYear")
	WebElement yearOfBirthElement;
	
	@FindBy(id="address1")
	WebElement addressElement;
	
	@FindBy(name="phoneNumber")
	WebElement phoneNumberElement;
	
	@FindBy(id="next-button")
	WebElement nextButtonElement; 
	
	@FindBy(id="submit")
	WebElement confirmButtonElement;
	
	public RegisterPatientPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateRegisterPatientPageTitle() {
		return driver.getTitle();
	}
	
	public void registerPatient(String givenName, String familyName, String gender, String dayOfBirth, String month, String yearOfBirth, String address, String phoneNumber) throws InterruptedException {
		givenNameElement.sendKeys(givenName);
		familyNameElement.sendKeys(familyName);
		nextButtonElement.click();
		Select selectGender = new Select(genderDropdownElement);
		selectGender.selectByVisibleText(gender);
		nextButtonElement.click();
		dayOfBirthElement.sendKeys(dayOfBirth);
		Select monthOfBirthday = new Select(monthOfElement);
		monthOfBirthday.selectByVisibleText(month);
		yearOfBirthElement.sendKeys(yearOfBirth);
		nextButtonElement.click();
		Thread.sleep(1000);
		addressElement.sendKeys(address);
		nextButtonElement.click();
		phoneNumberElement.sendKeys(phoneNumber);
		nextButtonElement.click();
		nextButtonElement.click();
		confirmButtonElement.click();
	}
}
