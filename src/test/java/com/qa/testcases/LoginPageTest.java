package com.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.extentReportListener.TestAllureReportListener;
import com.qa.base.BasePageAllure;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({TestAllureReportListener.class})
public class LoginPageTest extends BasePageAllure {
//	extends TestBase for pom and BasePageALlure for allure report listener
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
//		 using super keyword because before initializing method, we need to init properties as well in test base class 
//		super class constructor will be called from here
		super(); 
		
	}
	@BeforeMethod
	public void setUp() {
//		calling initialization method form testbases
		
		initialization();
		loginPage = new LoginPage();
	}

	
	@Test(priority = 1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify login page title test for login page")
	@Story("Story Name: To check login page title")
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login123");
	}
	
	@Test(priority = 2)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify image for login page")
	@Story("Story Name: To check login image")
	public void mrsImageLogoTest() {
		boolean flag  = loginPage.validateMRSImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: Verify user is able to login")
	@Story("Story Name: To check user is logging in")
	public void loginTest() {
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
