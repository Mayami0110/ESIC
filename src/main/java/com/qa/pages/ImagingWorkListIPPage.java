package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.qa.util.util;

public class ImagingWorkListIPPage extends BasePage
{
    util utilobj;
    String parent10;
    String parent12;
    private By linkReqNo;
    private By linkReqNocount;
    String linkreq;
    String linkreq1;
    String linkreq2;
    int recordcount;
    private By chkPatientArrive;
    private By btnSave;
    private By chkTestPerformed;
    private By imgReportEntry;
    private By imgReportDispatch;
    private By ButtonOK;
    private By ButtonNo;
    private By txtResultentry;
    private By chkDoctor;
    private By ButtonOKpopup;
    private By chkVerify;
    private By btnUpdate;
    private By txtDispatachedTo;
    private By btnSaveDisplay;
    private By imgInPatient;
    
    public ImagingWorkListIPPage(final WebDriver driver) {
        super(driver);
        utilobj = new util();
        parent10 = "";
        parent12 = "";
        linkReqNo = By.xpath("//*[@id=\"ctl00_cphpage_gdvIPWorklist\"]/tbody/tr[5]/td[1]/a");
        linkReqNocount = By.xpath("//*[@id=\"ctl00_cphpage_gdvIPWorklist\"]/tbody/tr/td[1]/a");
        linkreq = null;
        linkreq1 = "//*[@id=\"ctl00_cphpage_gdvIPWorklist\"]//tbody/tr[";
        linkreq2 = "]/td[1]/a";
        recordcount = 0;
        chkPatientArrive = By.id("gdvTOItems_ctl02_chkPatientArrive");
        btnSave = By.id("btnSave");
        chkTestPerformed = By.id("gdvTOItems_ctl02_chkTestPerformed");
        imgReportEntry = By.id("gdvTOItems_ctl02_imgReportEntry");
        imgReportDispatch = By.id("gdvTOItems_ctl02_imgReportDispatch");
        ButtonOK = By.id("MyMessageBoxInfo_ButtonOK");
        ButtonNo = By.id("MyMessageBoxInfo_ButtonNo");
        txtResultentry = By.xpath("/html/body");
        chkDoctor = By.id("gdvSearchResult_ctl02_chkDoctor");
        ButtonOKpopup = By.id("popup_ok");
        chkVerify = By.id("chkVerify");
        btnUpdate = By.id("btnUpdate");
        txtDispatachedTo = By.id("txtDispatachedTo");
        btnSaveDisplay = By.id("btnSaveDisplay");
        imgInPatient = By.id("ctl00_cphpage_imgInPatient");
    }
    
    public WebElement getimgInPatient() {
        return getElement(imgInPatient);
    }
    
    public WebElement getlinkReqNo() {
        return getElement(linkReqNo);
    }
    
    public WebElement getlinkReqNodynamic() {
        final int noofrec = countOfRecords();
        final int noofrecorg = noofrec + 1;
        System.out.println(String.valueOf(linkreq1) + noofrecorg + linkreq2);
        return getElement(By.xpath(String.valueOf(linkreq1) + noofrecorg + linkreq2));
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
        return recordcount = driver.findElements(linkReqNocount).size();
    }
    
    public void doImagingWorklistIPFlow(final String reqPageTitle) {
        try {
            getimgInPatient().click();
            Thread.sleep(3000);
            final String parent4 = driver.getWindowHandle();
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
            
            utilobj.JSClick(getbtnSave(), driver);

           // getbtnSave().click();
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
            utilobj.JSClick(getbtnSave(), driver);
            getButtonOK().click();
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    public void doImagingWorklistResultEntry(final String resultText) {
        try {
            parent10 = driver.getWindowHandle();
            utilobj.Window(driver);
            utilobj.JSClick(getimgReportEntry(), driver);
            Thread.sleep(3000);
            utilobj.ChildWindow(driver);
            driver.switchTo().frame("txtEditor_ctl02_ctl00");
            gettxtResultentry().sendKeys(new CharSequence[] { resultText });
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
    
    public void doImagingWorklistDispatch(final String dispatchname) {
        try {
            driver.switchTo().window(parent10);
            driver.switchTo().defaultContent();
            getbtnSave().click();
            utilobj.Window(driver);
            utilobj.JSClick(getimgReportDispatch(), driver);
            Thread.sleep(3000);
            utilobj.ChildWindow(driver);
            gettxtDispatachedTo().sendKeys(new CharSequence[] { dispatchname });
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