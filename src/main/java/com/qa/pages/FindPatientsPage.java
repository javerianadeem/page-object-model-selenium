package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FindPatientsPage extends TestBase{

	@FindBy(xpath = "//*[@id=\"content\"]/h2")
	WebElement findPatientsHeadingElement;
	
	public FindPatientsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyFindPatientLabel() {
		return findPatientsHeadingElement.isDisplayed();
	}
	
	public void selectPatient(int patientNumber) {
		driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr["+ patientNumber +"]/td[2]")).click();
		
		
	}
	
}
