package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class ImagingWorkListIPPage extends BasePage {
	util utilobj = new util();

	public ImagingWorkListIPPage(WebDriver driver) {

		super(driver);

	}
	String parent10 = "";
	String parent12 = "";
	private By linkReqNo = By.xpath("//*[@id=\"ctl00_cphpage_gdvOPWorklist\"]/tbody/tr[5]/td[1]/a");
	private By linkReqNocount = By.xpath("//*[@id=\"ctl00_cphpage_gdvOPWorklist\"]/tbody/tr/td[1]/a");

	String linkreq = null;
	String linkreq1 = "//*[@id=\"ctl00_cphpage_gdvOPWorklist\"]//tbody/tr[";
	String linkreq2 = "]/td[1]/a";
	int recordcount = 0;

	private By chkPatientArrive = By.id("gdvTOItems_ctl02_chkPatientArrive");
	private By btnSave = By.id("btnSave"); // btnUpdate
	private By chkTestPerformed = By.id("gdvTOItems_ctl02_chkTestPerformed");
	private By imgReportEntry = By.id("gdvTOItems_ctl02_imgReportEntry");
	private By imgReportDispatch = By.id("gdvTOItems_ctl02_imgReportDispatch");
	//MyMessageBoxInfo_ButtonNo
	private By ButtonOK = By.id("MyMessageBoxInfo_ButtonOK");
	private By ButtonNo = By.id("MyMessageBoxInfo_ButtonNo");
	// gdvSearchResult_ctl02_chkDoctor
	private By txtResultentry = By.xpath("/html/body");
	private By chkDoctor = By.id("gdvSearchResult_ctl02_chkDoctor");
	private By ButtonOKpopup = By.id("popup_ok");

	private By chkVerify = By.id("chkVerify");
	private By btnUpdate = By.id("btnUpdate"); // txtDispatachedTo
	private By txtDispatachedTo = By.id("txtDispatachedTo"); // btnSaveDisplay
	private By btnSaveDisplay = By.id("btnSaveDisplay"); //

	private By imgInPatient = By.id("ctl00_cphpage_imgInPatient"); //

	
	
	
	/*
	 * public WebElement getlinkReqNocount() { return getElement(linkReqNocount); }
	 */
	public WebElement getimgInPatient() {
		return getElement(imgInPatient);
	}
	public WebElement getlinkReqNo() {
		return getElement(linkReqNo);
	}

	public WebElement getlinkReqNodynamic() {
		int noofrec = countOfRecords();
		int noofrecorg = noofrec + 1;
		return getElement(By.xpath(linkreq1 + noofrecorg + linkreq2));
	}

	public WebElement getButtonOKpopup() {
		return getElement(ButtonOKpopup);
	}

	public WebElement getchkPatientArrive() {
		return getElement(chkPatientArrive);
	}

	public WebElement getchkTestPerformed() {
		return getElement(chkTestPerformed);
	}

	public WebElement getimgReportEntry() {
		return getElement(imgReportEntry);
	}

	public WebElement getimgReportDispatch() {
		return getElement(imgReportDispatch);
	}

	public WebElement getbtnSave() {
		return getElement(btnSave);
	}

	public WebElement getButtonOK() {
		return getElement(ButtonOK);
	}

	public WebElement getButtonNo() {
		return getElement(ButtonNo);
	}

	public WebElement gettxtResultentry() {
		return getElement(txtResultentry);
	}

	public WebElement getchkDoctor() {
		return getElement(chkDoctor);
	}

	public WebElement getchkVerify() {
		return getElement(chkVerify);
	}

	public WebElement getbtnUpdate() {
		return getElement(btnUpdate);
	}

	public WebElement gettxtDispatachedTo() {
		return getElement(txtDispatachedTo);
	}

	public WebElement getbtnSaveDisplay() {
		return getElement(btnSaveDisplay);
	}

	public int countOfRecords() {

		recordcount = driver.findElements(linkReqNocount).size();

		return recordcount;

	}

		public void doImagingWorklistIPFlow(String reqPageTitle) {

		try {

			getimgInPatient().click();
			
			String parent4 = driver.getWindowHandle();

			utilobj.Window(driver);

			utilobj.JSClick(getlinkReqNodynamic(), driver);

			Thread.sleep(3000);

			utilobj.ChildWindow(driver);

			System.out.println(driver.getTitle());

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public void doImagingWorklistPA() {

		try {

			utilobj.JSClick(getchkPatientArrive(), driver);
			getbtnSave().click();
			getButtonOK().click();

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public void doImagingWorklistTestPerf() {

		try {

			utilobj.JSClick(getchkTestPerformed(), driver);
			getButtonNo().click();
			Thread.sleep(1000);

			getbtnSave().click();
			getButtonOK().click();
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public void doImagingWorklistResultEntry(String resultText) {

		try {

			parent10 = driver.getWindowHandle();

			utilobj.Window(driver);
			utilobj.JSClick(getimgReportEntry(), driver);

			Thread.sleep(3000);

			utilobj.ChildWindow(driver);

			driver.switchTo().frame("txtEditor_ctl02_ctl00");

			gettxtResultentry().sendKeys(resultText);
			driver.switchTo().defaultContent();

			getchkDoctor().click();
			getbtnSave().click();
			getButtonOKpopup().click();

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public void doImagingWorklistResultverify() {

		try {

			getchkVerify().click();
			getbtnUpdate().click();
			getButtonOKpopup().click();
			driver.close();

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public void doImagingWorklistDispatch(String dispatchname) {

		try {

			driver.switchTo().window(parent10);
			driver.switchTo().defaultContent();
			getbtnSave().click();
			// String parent12 = driver.getWindowHandle();
			utilobj.Window(driver);
			utilobj.JSClick(getimgReportDispatch(), driver);

			Thread.sleep(3000);

			utilobj.ChildWindow(driver);
			gettxtDispatachedTo().sendKeys(dispatchname);

			getbtnSaveDisplay().click();
			getButtonOKpopup().click();
			driver.close();
			driver.switchTo().window(parent10);
			driver.switchTo().defaultContent();

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

}
