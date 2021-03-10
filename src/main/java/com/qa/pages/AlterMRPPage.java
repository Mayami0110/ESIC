package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlterMRPPage extends BasePage {

	public AlterMRPPage(WebDriver driver) {
		super(driver);

	}

	private By imgBtnItemSearch = By.id("ctl00_cphpage_gdvAlterItemMRP_ctl02_imgBtnItemSearch");

	private By txtCriteria = By.id("ctl00_cphpage_hisDataSearchCtrl_hisSearchCriteria_dlData_ctl00_txtCriteria");

	private By btnSearch = By.id("ctl00_cphpage_hisDataSearchCtrl_btnSearch");

	private By rdbTemp = By.id("ctl00_cphpage_hisDataSearchCtrl_hisSearchResultGrid_gdvList_ctl02_rdbTemp");

	private By btnSelect = By.id("ctl00_cphpage_hisDataSearchCtrl_btnSelect");

	private By imgBtnBatchSearch = By.id("ctl00_cphpage_gdvAlterItemMRP_ctl02_imgBtnBatchSearch");

	private By chkSelect = By.id("ctl00_cphpage_grdBatchPopGrid_ctl02_chkSelect");

	private By btnSelectBatch = By.id("ctl00_cphpage_btnSelect");

	private By txtNewMRP = By.id("ctl00_cphpage_gdvAlterItemMRP_ctl02_txtNewMRP");

	private By btnSave = By.id("ctl00_cphpage_btnSave");

	
	private By ButtonOK = By.id("ctl00_cphpage_MessageBoxInfo_ButtonOK");

	private By popuptxt = By.id("/html/body/div[1]/form/div[4]/div[2]/div[3]/div[1]/div[2]/p");

	public WebElement getimgBtnItemSearch() {
		return getElement(imgBtnItemSearch);

	}

	public WebElement gettxtCriteria() {
		return getElement(txtCriteria);

	}

	public WebElement getrdbTemp() {
		return getElement(rdbTemp);

	}

	public WebElement getbtnSearch() {
		return getElement(btnSearch);

	}

	public WebElement getbtnSelect() {
		
		
		return getElement(btnSelect);

	}

	public WebElement getimgBtnBatchSearch() {
		return getElement(imgBtnBatchSearch);

	}

	public WebElement getchkSelect() {
		return getElement(chkSelect);

	}

	public WebElement getbtnSelectBatch() {
		return getElement(btnSelectBatch);

	}

	public WebElement gettxtNewMRP() {
		return getElement(txtNewMRP);

	}

	public WebElement getButtonOK() {
		return getElement(ButtonOK);

	}

	public WebElement getpopuptxt() {
		return getElement(popuptxt);

	}
	
	public WebElement getbtnSave() {
		return getElement(btnSave);

	}

	
	public void doAlterMRP() {
		
		try {
			
			getimgBtnItemSearch().click();
			gettxtCriteria().sendKeys("Paracetamol Tab");
			getbtnSearch().click();
			getrdbTemp().click();
			getbtnSelect().click();
			
			Thread.sleep(3000);
			
			getimgBtnBatchSearch().click();
			getchkSelect().click();
			getbtnSelectBatch().click();
			Thread.sleep(3000);

			gettxtNewMRP().sendKeys("1");
			getbtnSave().click();
		//System.out.println(getpopuptxt().getText());
			getButtonOK().click();
			
			
			
		}
		
		catch (Exception ex) {
			System.err.println(ex);
		}
	}

}
