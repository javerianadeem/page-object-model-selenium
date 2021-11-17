package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

import io.netty.channel.VoidChannelPromise;

public class HomePage extends TestBase {

	@FindBy(id="coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
	WebElement findPatientLinkElement;
	
	@FindBy(id="org-openmrs-module-coreapps-activeVisitsHomepageLink-org-openmrs-module-coreapps-activeVisitsHomepageLink-extension")
	WebElement activeVisitsElement;
	
	@FindBy(id="referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
	WebElement registerPatient;
	
	@FindBy(id="referenceapplication-vitals-referenceapplication-vitals-extension")
	WebElement captureVitalsElement;
	
//	@FindBy(id="appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")
//	WebElement appointmentScheduling;
//	
//	@FindBy(id="registrationapp-basicRegisterPatient-homepageLink-registrationapp-basicRegisterPatient-homepageLink-extension")
//	WebElement registerPatientElement;
	
	public HomePage() {
	PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public FindPatientsPage clickOnFindPatientsLink() {
		findPatientLinkElement.click();
		return new FindPatientsPage();
	}
	
	public ActiveVisitsPage clickOnActiveVisitsLink() {
		activeVisitsElement.click();
		return new ActiveVisitsPage();
	}
	
	public CaptureVitalsPage clickOnCaptureVitalsLink() {
		captureVitalsElement.click();
		return new CaptureVitalsPage();
	}
	
	public RegisterPatientPage clickOnRegisterPatientLink() {
		registerPatient.click();
		return new RegisterPatientPage();
	}
	
}
