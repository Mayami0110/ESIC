package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class PatientAdmissionPage extends BasePage{
	util utilobj = new util();
	
	public PatientAdmissionPage(WebDriver driver) {
		super(driver);

	}
private By txtIPNO = By.id("ctl00_cphpage_txtInsuranceNo");

//Livelist Control

private By lnkbtnIPNo = By.id("ctl00_cphpage_lnkbtnIPNo");

private By hisLiveListControlchkUHID = By.id("ctl00_cphpage_hisLiveListControl_gdvInsurance_ctl02_chkUHID");

private By hisLiveListControlbtnSelect = By.id("ctl00_cphpage_hisLiveListControl_btnSelect");
//Patient admission Screen
private By ddlAdmissionType =By.id("ctl00_cphpage_ddlAdmissionType");

private By ddlAdmissionSrc =By.id("ctl00_cphpage_ddlAdmissionSrc");

private By btnSave =By.id("ctl00_cphpage_btnSave");

private By ddlSpecialisation =By.id("ctl00_cphpage_ddlSpecialisation");

private By ddlUnit =By.id("ctl00_cphpage_ddlUnit");

private By PermanentSameAsPresentRadiobutton =By.id("ctl00_cphpage_PermanentSameAsPresent");

private By MyMessageBoxInfoButtonYes =By.id("ctl00_cphpage_MyMessageBoxInfo_ButtonYes");



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

public WebElement getDdlAdmissionType() {
	return getElement(ddlAdmissionType);
}

public WebElement getDdlAdmissionSrc() {
	return getElement(ddlAdmissionSrc);
}

public List<WebElement> getDdlUnit() {
	return getElements(ddlUnit);
}



public WebElement getddlSpecialisation() {
	return getElement( ddlSpecialisation);}

public WebElement getBtnSave() {
	return getElement(btnSave);
}

public WebElement getPermanentSameAsPresentRadiobutton() {
	return getElement(PermanentSameAsPresentRadiobutton);
}


public WebElement getMyMessageBoxInfoButtonYes() {
	return getElement(MyMessageBoxInfoButtonYes);
}







public String verifyPatientAdmissionPageTitle() {

	return driver.getTitle();

}
public void doPatientAdmission(String IPnumber,String SpecialisationName,String AdmissionType,String AdmissionSrc,String DdlUnitName) {

	try {
		
		getTxtIPNO().sendKeys(IPnumber);
		getLnkbtnIPNo().click();
		getHisLiveListControlchkUHID().click();
		getHisLiveListControlbtnSelect().click();
		Thread.sleep(3000);
		getPermanentSameAsPresentRadiobutton().click();
		

		utilobj.selectDropdown(getddlSpecialisation(), driver, SpecialisationName);
		Thread.sleep(2000);
		utilobj.selectDropdown(getDdlAdmissionType(), driver, AdmissionType);
		utilobj.selectDropdown(getDdlAdmissionSrc(), driver, AdmissionSrc);
		//utilobj.selectDropdownValue(getDdlUnit(), driver, DdlUnitName);
		utilobj.selectDropdownValue(getDdlUnit(), driver, DdlUnitName);
		
		//utilobj.JSEnterText(getDdlUnit(), driver, DdlUnitName);
		
		Thread.sleep(3000);
		getBtnSave().click();
		getMyMessageBoxInfoButtonYes().click();
		
		driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div[2]/div/div[3]/div[1]/div[2]/p")).getText();
	System.out.println(driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div[2]/div/div[3]/div[1]/div[2]/p")).getText());
	
	}

	catch(Exception ex) {
		System.err.println(ex);
	}

}















}
