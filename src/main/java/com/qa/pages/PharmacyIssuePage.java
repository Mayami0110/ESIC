package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

import org.openqa.selenium.WebDriver;

public class PharmacyIssuePage extends BasePage {

	util utilobj = new util();

	public PharmacyIssuePage(WebDriver driver) {

		super(driver);
	}

	private By txtIPNO = By.id("ctl00_cphpage_txtIPNO");

	// Livelist Control 

	private By lnkbtnIPNo = By.id("ctl00_cphpage_lnkbtnIPNo");

	private By hisLiveListControlchkUHID = By.id("ctl00_cphpage_hisLiveListControl_gdvInsurance_ctl02_chkUHID");

	private By hisLiveListControlbtnSelect = By.id("ctl00_cphpage_hisLiveListControl_btnSelect");

	private By txtIssueQty = By.id("ctl00_cphpage_grdIssueDetails_ctl02_txtIssueQty");

	private By btnSave = By.id("ctl00_cphpage_btnSave");
	
	private By popupok = By.id("popup_ok");


	public WebElement gettxtIssueQty() {
		return getElement(txtIssueQty);
	}

	public WebElement getpopupok() {
		return getElement(popupok);
	}

	
	public WebElement getbtnSave() {
		return getElement(btnSave);
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

	public void doPharmacyIssue(String IPNumber) {

		try {

			getTxtIPNO().sendKeys(IPNumber);
			getLnkbtnIPNo().click();
			Thread.sleep(2000);
			getHisLiveListControlchkUHID().click();
			getHisLiveListControlbtnSelect().click();
			Thread.sleep(3000);
			gettxtIssueQty().clear();
			gettxtIssueQty().sendKeys("1");
			getbtnSave().click();
			//utilobj.waitForalert(driver);
			//System.out.println(driver.switchTo().alert().getText());
			//driver.switchTo().alert().accept();
			Thread.sleep(2000);
			getpopupok().click();
			
			

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}
}
