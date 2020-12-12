package com.qa.pages;

import org.openqa.selenium.WebDriver;

public class PatientCheckInPage extends BasePage {

	public PatientCheckInPage(WebDriver driver) {
		super(driver);

	}
	
	public String verifyPatientCheckInPageTitle() {

		return driver.getTitle();

	}

}
