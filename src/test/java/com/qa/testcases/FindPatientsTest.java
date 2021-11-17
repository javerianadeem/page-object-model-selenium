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

public class FindPatientsTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	FindPatientsPage findPatients;
	TestUtils testUtils;
	
	public FindPatientsTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
//		calling initialization method form testbases
		
		initialization();
		loginPage = new LoginPage();
		testUtils = new TestUtils();
		findPatients = new FindPatientsPage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		homePage.clickOnFindPatientsLink();
	}
	
	@Test
	public void verifyFindPatientLabel() {
		Assert.assertTrue(findPatients.verifyFindPatientLabel(), "Find Patient Label is missing on the page");
	}
	
	@Test
	public void findPatient() {
		findPatients.selectPatient(1);
		testUtils.navigateBack();
		findPatients.selectPatient(3);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
