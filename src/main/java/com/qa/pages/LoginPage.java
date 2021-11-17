package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

//	page Factory - Object repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="Inpatient Ward")
	WebElement locationCategory;
	
	@FindBy(id="loginButton")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/header/div/a/img")
	WebElement openmrsLogo;
	
//	initializing page objects 
	public LoginPage() {
//		all variables will be assigned using driver, "this" is pointing to the current class object. "driver" is comign from base class
		PageFactory.initElements(driver, this); 
	}
	
//	actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateMRSImage() {
		return openmrsLogo.isDisplayed();
		
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		locationCategory.click();
		loginButton.click();
		
		return new HomePage();
		
	}
}
