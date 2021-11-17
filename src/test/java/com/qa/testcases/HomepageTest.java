package com.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FindPatientsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;

public class HomepageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	FindPatientsPage findPatients;
	TestUtils testUtils;
	public HomepageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
//		calling initialization method form testbases
		
		initialization();
		loginPage = new LoginPage();
		testUtils = new TestUtils();
		findPatients = new FindPatientsPage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
//		Thread.sleep(1000);
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		String homePageTitletring = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitletring, "Home", "Homepage title did not match");
	}
	
	@Test
	public void findPatientsTest() {
		findPatients = homePage.clickOnFindPatientsLink();
		testUtils.navigateBack();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
