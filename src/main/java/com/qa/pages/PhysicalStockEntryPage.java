package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class PhysicalStockEntryPage extends BasePage {

	util utilobj = new util();

	public PhysicalStockEntryPage(WebDriver driver) {
		super(driver);

	}

	private By btnSearch = By.id("btnSearch");

	private By txtName = By.id("txtName");
	private By btnSearchpopup = By.xpath("//*[@id='ctl00_cphpage_td1']/input[@id='btnSearch']");
	private By btnSelect = By.id("btnSelect");
	private By gridrecord = By
			.xpath("//*[@id=\"grdsearch\"]/tbody/tr/td[text()='112016014015005']/preceding-sibling::td/input");

	private By txtQty = By.id("ctl00_cphpage_gdvPhysicalStock_ctl02_txtQty");
	private By txtPRate = By.id("ctl00_cphpage_gdvPhysicalStock_ctl02_txtPRate");
	private By txtMRP = By.id("ctl00_cphpage_gdvPhysicalStock_ctl02_txtMRP");
	private By txtExpiryDate = By.id("ctl00_cphpage_gdvPhysicalStock_ctl02_txtExpiryDate");
	private By txtMFDDate = By.id("ctl00_cphpage_gdvPhysicalStock_ctl02_txtMFDDate");
	private By txtRemarks1 = By.id("ctl00_cphpage_gdvPhysicalStock_ctl02_txtRemarks1");
	private By txtBatch = By.id("ctl00_cphpage_gdvPhysicalStock_ctl02_txtBatch");
	private By btnSave = By.id("ctl00_cphpage_btnSave");
	private By popupok = By.id("popup_ok");

	public WebElement getpopupok() {
		return getElement(popupok);
	}

	public WebElement getbtnSave() {
		return getElement(btnSave);
	}

	public WebElement getbtnSearch() {
		return getElement(btnSearch);
	}

	public WebElement gettxtName() {
		return getElement(txtName);
	}

	public WebElement getbtnSearchpopup() {
		return getElement(btnSearchpopup);
	}

	public WebElement getbtnSelect() {
		return getElement(btnSelect);
	}

	public WebElement getgridrecord() {
		return getElement(gridrecord);
	}

	public WebElement gettxtQty() {
		return getElement(txtQty);
	}

	public WebElement gettxtPRate() {
		return getElement(txtPRate);
	}

	public WebElement gettxtMRP() {
		return getElement(txtMRP);
	}

	public WebElement gettxtBatch() {
		return getElement(txtBatch);
	}

	public WebElement gettxtExpiryDate() {
		return getElement(txtExpiryDate);
	}

	public WebElement gettxtMFDDate() {
		return getElement(txtMFDDate);
	}

	public WebElement gettxtRemarks1() {
		return getElement(txtRemarks1);
	}

	public void doPhysicalStockEntry(String itemnames) {

		try {
			getbtnSearch().click();
			gettxtName().sendKeys(itemnames);

			getbtnSearchpopup().click();
			Thread.sleep(2000);
			getgridrecord().click();

			getbtnSelect().click();
			
			Thread.sleep(2000);

			//utilobj.JSEnterText(gettxtQty(), driver, "100");
			
			gettxtQty().sendKeys("100");
			gettxtPRate().sendKeys("1");
			gettxtMRP().sendKeys("1");
			gettxtBatch().sendKeys("ABC");
			gettxtExpiryDate().sendKeys("01-Feb-2030");
			gettxtMFDDate().sendKeys("01-Feb-2020");
			gettxtRemarks1().sendKeys("Remarks");
			getbtnSave().click();
			getpopupok().click();
			
			
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

}
