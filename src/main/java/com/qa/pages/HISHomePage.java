package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class HISHomePage extends BasePage {

	util utilobj = new util();

	public HISHomePage(WebDriver driver) {
		super(driver);

	
	}
	
	/* Registration module */
	private By RegistrationLink = By.linkText("Registration");
	
	/* Patient CheckIn */
	private By PatientCheckInLink = By.linkText("Patient Check-In /Registration");

	
	public WebElement getRegistrationLink() {
		return getElement(RegistrationLink);

	}
	
	public WebElement getPatientCheckInLink() {
		return getElement(PatientCheckInLink);

	}

	public PatientCheckInPage doNavigateToPatientCheckIn()
	{
		utilobj.MoveElement(getRegistrationLink(), driver);
		
		getPatientCheckInLink().click();
		
		return new PatientCheckInPage(driver);
		
	}
	
}
