package com.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
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
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login");
	}
	
	@Test(priority = 2)
	public void mrsImageLogoTest() {
		boolean flag  = loginPage.validateMRSImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
