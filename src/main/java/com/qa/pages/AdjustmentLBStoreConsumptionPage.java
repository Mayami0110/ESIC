package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class AdjustmentLBStoreConsumptionPage extends BasePage {
	
	public AdjustmentLBStoreConsumptionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	util utilobj = new util();

	

	private By imgbtnMultiItemSearch = By.id("ctl00_cphpage_grdItemgrid_ctl01_imgbtnMultiItemSearch");
	private By txtCriteria = By.id("ctl00_cphpage_hisDataSearchCtrl_hisSearchCriteria_dlData_ctl00_txtCriteria");
	private By btnSearch = By.id("ctl00_cphpage_hisDataSearchCtrl_hisSearchCriteria_btnSearch");
	private By btnSelect = By.id("ctl00_cphpage_hisDataSearchCtrl_btnSelect");
	private By chkTemp = By.id("ctl00_cphpage_hisDataSearchCtrl_hisSearchResultGrid_gdvList_ctl02_chkTemp");
	private By imgSearchBatchNo = By.id("ctl00_cphpage_grdItemgrid_ctl02_imgSearchBatchNo");
	private By chkBSSelect = By.id("ctl00_cphpage_grdIssueSearchResult_ctl03_chkBSSelect");
	private By btnBSSelect = By.id("ctl00_cphpage_btnBSSelect");

	private By txtQTY = By.id("ctl00_cphpage_grdItemgrid_ctl02_txtQTY");
	private By txtRemarks = By.id("ctl00_cphpage_grdItemgrid_ctl02_txtRemarks");
	private By txtRefNo = By.id("ctl00_cphpage_txtRefNo");
	private By btnSave = By.id("ctl00_cphpage_btnSave");
	private By ButtonOK = By.id("ctl00_cphpage_MessageBoxInfo_ButtonOK");

	public WebElement getbtnSave() {
		return getElement(btnSave);
	}
	
	public WebElement getimgbtnMultiItemSearch() {
		return getElement(imgbtnMultiItemSearch);
	}
	public WebElement gettxtCriteria() {
		return getElement(txtCriteria);
	}
	public WebElement getbtnSearch() {
		return getElement(btnSearch);
	}
	public WebElement getbtnSelect() {
		return getElement(btnSelect);
	}
	public WebElement getchkTemp() {
		return getElement(chkTemp);
	}
	
	public WebElement gettxtRefNo() {
		return getElement(txtRefNo);
	}
	public WebElement getimgSearchBatchNo() {
		return getElement(imgSearchBatchNo);
	}
	public WebElement getchkBSSelect() {
		return getElement(chkBSSelect);
	}
	public WebElement getbtnBSSelect() {
		return getElement(btnBSSelect);
	}
	public WebElement gettxtQTY() {
		return getElement(txtQTY);
	}
	public WebElement gettxtRemarks() {
		return getElement(txtRemarks);
	}
	
	public WebElement getButtonOK() {
		return getElement(ButtonOK);
	}
	
	public void doAdjustmentLBStoreConsumption() {

		try {
			
			gettxtRefNo().sendKeys("Test Ref");
			
			getimgbtnMultiItemSearch().click();
			Thread.sleep(2000);
			gettxtCriteria().sendKeys("12016014015005");
			
			getbtnSearch().click();
			getchkTemp().click();
			getbtnSelect().click();
			Thread.sleep(2000);
			
			getimgSearchBatchNo().click();
			
			getchkBSSelect().click();
			getbtnBSSelect().click();
			
			Thread.sleep(2000);

			gettxtQTY().sendKeys("1");
			gettxtRemarks().sendKeys("Test Remarks");
			
			getbtnSave().click();
			getButtonOK().click();
			
			
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}




}
