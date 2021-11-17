package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FindPatientsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.RegisterPatientPage;
import com.qa.utils.TestUtils;

public class RegisterPatientTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	FindPatientsPage findPatients;
	TestUtils testUtils;
	RegisterPatientPage registerPatientPage;
	
	String sheetNameString = "patients";
	
	public RegisterPatientTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
//		calling initialization method form testbases
		
		initialization();
		loginPage = new LoginPage();
		testUtils = new TestUtils();
		findPatients = new FindPatientsPage();
		registerPatientPage = new RegisterPatientPage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		homePage.clickOnRegisterPatientLink();
	}
	
	
	
	@Test
	public void verifyRegisterPatientLabel() {
		Assert.assertEquals(registerPatientPage.validateRegisterPatientPageTitle(), "OpenMRS Electronic Medical Record");
	}
	
	@DataProvider
	public Object[][] getMRSTestData() {
		Object data[][] = TestUtils.getTestData(sheetNameString);
		return data;
	}
	
	@Test(dataProvider = "getMRSTestData")
	public void registerpatient(String givenName, String familyName, String	gender, String dayOfBirth, String monthOfBirth, String yearofBirth, String address, String phoneNumber) throws InterruptedException {
//		registerPatientPage.registerPatient("X", "X", "Male", "01", "June", "2021", "xxxx", "123");
		registerPatientPage.registerPatient(givenName, familyName, gender, dayOfBirth, monthOfBirth, yearofBirth, address, phoneNumber);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
