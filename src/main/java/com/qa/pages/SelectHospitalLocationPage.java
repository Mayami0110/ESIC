package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ReadDataFile;
import com.qa.util.util;

public class SelectHospitalLocationPage extends BasePage {
	
	util utilobj = new util();
	ReadDataFile readdata = new ReadDataFile();
	
	public SelectHospitalLocationPage(WebDriver driver) {
		super(driver);

	
	}
	
	/* Location */
	private By Location = By.id("ctl00_cphpage_ddlHospital");
	
	/* Facility */
	private By facility = By.id("ctl00_cphpage_ddlFacility");
	
	/* Submit */
	private By submit = By.id("ctl00_cphpage_btnSubmit");

	
	public WebElement getLocation() {
		return getElement(Location);
	}

	
	public WebElement getFacility() {
		return getElement(facility);
	}

	
	public WebElement getSubmit() {
		return getElement(submit);
	}
	
	public HISHomePage doNavigateToHISHome(String LocationName, String FacilityName)
	{
		
		utilobj.selectDropdown(getLocation(), driver, LocationName);
		
		driver.manage().window().maximize();
		
		utilobj.selectDropdown(getFacility(), driver, FacilityName);
		
		getSubmit().click();
		
		return new HISHomePage(driver);
		
	}
	

}
