package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class UHIDPage extends BasePage {

	util utilobj = new util();

	public UHIDPage(WebDriver driver) {
		super(driver);
	}

	private By Title = By.id("ctl00_cphpage_ddlTitle");
	private By FirstName = By.id("ctl00_cphpage_txtFirstName");
	private By LastName = By.id("ctl00_cphpage_txtLastName");
	private By MarriageStatus = By.xpath("//*[@id='ctl00_cphpage_ddlMarriage']");
	private By Age = By.id("ctl00_cphpage_txtAge");
	private By PresentAddres = By.id("ctl00_cphpage_txtPresentAddress1");
	private By Savebutton = By.id("ctl00_cphpage_btnSaveDisplay");
	private By btnYes = By.id("ctl00_cphpage_btnYes1");
	private By InformationPopUp = By.id("ctl00_cphpage_btnYes");
	
	
	public WebElement getTitle() {
		return getElement(Title);
	}

	public WebElement getFirstName() {
		return getElement(FirstName);
	}

	public WebElement getLastName() {
		return getElement(LastName);
	}

	public WebElement getMarriageStatus() {
		return getElement(MarriageStatus);
	}

	public WebElement getAge() {
		return getElement(Age);
	}

	public WebElement getPresentAddres() {
		return getElement(PresentAddres);
	}

	public WebElement getSavebutton() {
		return getElement(Savebutton);
	}
	
	public WebElement getbtnYes() {
		return getElement(btnYes);
	}
	
	public WebElement getInformationPopUp() {
		return getElement(InformationPopUp);
	}
	
	

	public String verifyUHIDPageTitle() {

		return driver.getTitle();

	}
	
	

	public void doUHIDCreationPage(String Title, String FirstName, String LastName, String MaritalStatus1, String Age,
			String Address) {

		try {
			
			utilobj.selectDropdown(getTitle(), driver, Title);
			getFirstName().sendKeys(FirstName);
			getLastName().sendKeys(LastName);
			
			Thread.sleep(2000);
			
			System.out.println(MaritalStatus1 + getMarriageStatus());
			//utilobj.selectDropdown(getMarriageStatus(), driver, MaritalStatus1);
			
			getAge().sendKeys(Age);
			getPresentAddres().sendKeys(Address);
			getSavebutton().click();
			getbtnYes().click();
			getInformationPopUp().click();
		

			

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}
}
