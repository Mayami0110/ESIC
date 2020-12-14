package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class PatientCheckInPage extends BasePage {
	util utilobj = new util();

	public PatientCheckInPage(WebDriver driver) {
		super(driver);

	}
	
	private By txtIPNO = By.id("ctl00_cphpage_txtIPNO");

	//Livelist Control
	
	private By lnkbtnIPNo = By.id("ctl00_cphpage_lnkbtnIPNo");
	
	private By hisLiveListControlchkUHID = By.id("ctl00_cphpage_hisLiveListControl_gdvInsurance_ctl02_chkUHID");
	
	private By hisLiveListControlbtnSelect = By.id("ctl00_cphpage_hisLiveListControl_btnSelect");
	
	//Checkin page
	
	private By btnOK = By.id("ctl00_cphpage_btnOK");

	private By btnSaveDisplay = By.id("ctl00_cphpage_btnSaveDisplay");

	private By btncancel = By.id("popup_cancel");

	private By popupmessage = By.id("popup_message");
	
	private By ddlSpecialisation = By.id("ctl00_cphpage_ddlSpecialisation");


	
	/**
	 * @return the ddlSpecialisation
	 */
	public WebElement getDdlSpecialisation() {
		return getElement(ddlSpecialisation);
	}


	public WebElement getTxtIPNO() {
		return getElement(txtIPNO);
	}

	public WebElement getLnkbtnIPNo() {
		return getElement(lnkbtnIPNo);
	}

	public WebElement getHisLiveListControlchkUHID() {
		return getElement(hisLiveListControlchkUHID);
	}

	public WebElement getHisLiveListControlbtnSelect() {
		return getElement(hisLiveListControlbtnSelect);
	}

	public WebElement getBtnOK() {
		return getElement(btnOK);
	}

	public WebElement getBtnSaveDisplay() {
		return getElement(btnSaveDisplay);
	}

	public WebElement getBtncancel() {
		return getElement(btncancel);
	}

	public WebElement getPopupmessage() {
		return getElement(popupmessage);

	}

	public String verifyPatientCheckInPageTitle() {

		return driver.getTitle();

	}
	
	public void doPatientCheckIN(String IPNumber , String SpecialisationName) {

		try {
			
			getTxtIPNO().sendKeys(IPNumber);
			getLnkbtnIPNo().click();
			//Thread.sleep(2000);
			getHisLiveListControlchkUHID().click();
			getHisLiveListControlbtnSelect().click();
			Thread.sleep(3000);
			
			getBtnSaveDisplay().isEnabled();	
				
			utilobj.selectDropdown(getDdlSpecialisation(), driver, SpecialisationName);
			
		//	driver.switchTo().defaultContent();

			//utilobj.JSClick(getBtnOK(), driver);
			
			utilobj.ActionClick(getBtnOK(), driver);
			
			getBtnSaveDisplay().isEnabled();	
			Thread.sleep(2000);

			//getBtnOK().click();
			utilobj.ActionClick(getBtnSaveDisplay(), driver);
			//utilobj.JSClick(getBtnSaveDisplay(), driver);

		//	getBtnSaveDisplay().click();
			Thread.sleep(2000);
			System.out.println(getPopupmessage().getText());
			getBtncancel().click();
	
					
			
	}
		
		catch(Exception ex) {
			System.err.println(ex);
		}

	}
	

}
