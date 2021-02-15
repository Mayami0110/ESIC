package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class OTandResourceSchedulingPage extends BasePage {
	util utilobj = new util();

	public OTandResourceSchedulingPage(WebDriver driver) {
		super(driver);

	}

	private By OTviewList = By.id(
			"/html/body/div[1]/form/div[3]/div[2]/table/tbody/tr/td[2]/div/div[3]/table/tbody/tr[2]/td/table/tbody/tr/td/div/ul/li[1]/a[2]/a");

	private By AcupressureTherapy = By
			.xpath("/html/body/div[1]/form/div[4]/div[2]/div/div/div[1]/div/table/tbody/tr[2]/td[7]/a");

	// private By ScheduleDropdown =
	// By.xpath("/html/body/div[1]/form/div[4]/div[2]/div/div/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/select/option[2]");
	private By btnNextTask = By.id("ctl00_cphpage_btnNextTask");

	private By NextTaskSurgeryRecord = By.xpath(
			"/html/body/div[1]/form/div[4]/div[2]/div/div/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/select/option[3]");

	private By popupok = By.id("popup_ok");

	private By ddlNextTask = By.id("ctl00_cphpage_ddlNextTask");

//	private By HealthInterventionSurgery = By.xpath("/html/body/div[1]/form/div[4]/div[2]/div/div/div[1]/div/table/tbody/tr[2]/td[7]"); 
	private By ddlOt = By.id("ctl00_cphpage_ddlOt");

	private By ddlPriority = By.id("ctl00_cphpage_ddlPriority");

	private By ddlAnesthesia = By.id("ctl00_cphpage_ddlAnesthesia");

	private By ddlSurgeryType = By.id("ctl00_cphpage_ddlSurgeryType");

	private By ddlHour = By.id("ctl00_cphpage_TSPtInTime_ddlHour");

	//private By TSSurgeryStartdatetimeddlMinute = By.id("ctl00_cphpage_TSSurgeryStartdatetime_ddlMinute");

	private By TSSurgeryStartdatetimeddlHour = By.id("ctl00_cphpage_TSSurgeryStartdatetime_ddlHour");
	
	private By TSSurgeryenddatetimeddlHour = By.id("ctl00_cphpage_TSSurgeryenddatetime_ddlHour");
	
	private By TSPtOutTimeddlHour = By.id("ctl00_cphpage_TSPtOutTime_ddlHour");
	
	
	
	

	//private By TSPtOutTimeddlMinute = By.id("ctl00_cphpage_TSPtOutTime_ddlMinute");

	private By btnSaveDisplay = By.id("ctl00_cphpage_btnSaveDisplay");

	public WebElement getOTviewList() {
		return getElement(OTviewList);
	}

	public WebElement getAcupressureTherapy() {
		return getElement(AcupressureTherapy);
	}

	/*
	 * public WebElement getScheduleDropdown() { return
	 * getElement(ScheduleDropdown); }
	 */

	public WebElement getbtnNextTask() {
		return getElement(btnNextTask);
	}

	public WebElement getpopupok() {
		return getElement(popupok);
	}

	public WebElement getddlNextTask() {
		return getElement(ddlNextTask);
	}

	public WebElement getddlOt() {
		return getElement(ddlOt);
	}

	public WebElement getddlPriority() {
		return getElement(ddlPriority);
	}

	public WebElement getddlAnesthesia() {
		return getElement(ddlAnesthesia);
	}

	public WebElement getddlSurgeryType() {
		return getElement(ddlSurgeryType);
	}

	public WebElement getddlHourr() {
		return getElement(ddlHour);
	}

	

	public WebElement getTSSurgeryStartdatetimeddlHour() {
		return getElement(TSSurgeryStartdatetimeddlHour);
	}
	
	public WebElement getTSSurgeryenddatetimeddlHour() {
		return getElement(TSSurgeryenddatetimeddlHour);
	}
	public WebElement getTSPtOutTimeddlHour() {
		return getElement(TSPtOutTimeddlHour);
	}

	public WebElement getbtnSaveDisplay() {
		return getElement(btnSaveDisplay);
	}

	public String verifyOTSurgeryPageTitle() {

		return driver.getTitle();

	}

	public void dosurgeryRecord(String SurgeryRecord,String otname,String OtPriority,String Anesthesianame,
			String otSurgeryType,String ddlHour,
			String StartdatetimeddlHour,String enddatetimeddlHour,String TSPtOutTimeddlHour)

	{

		try {
			Thread.sleep(2000);
			// getOTviewList().click();

			getAcupressureTherapy().click();
			// getScheduleDropdown().click();
		//	getddlNextTask().sendKeys(SurgeryRecord);
			utilobj.selectDropdown(getddlNextTask(), driver, SurgeryRecord);

			getbtnNextTask().click();
			getpopupok().click();
			
			utilobj.selectDropdown(getddlOt(), driver, otname);
			
			utilobj.selectDropdown(getddlPriority(), driver, OtPriority);
			utilobj.selectDropdown(getddlAnesthesia(), driver, Anesthesianame);
			utilobj.selectDropdown(getddlSurgeryType(), driver, otSurgeryType);
			
		
			
			utilobj.selectDropdown(getddlHourr(), driver, ddlHour);
			
			utilobj.selectDropdown(getTSSurgeryStartdatetimeddlHour(), driver, StartdatetimeddlHour);
			utilobj.selectDropdown(getTSSurgeryenddatetimeddlHour(), driver, enddatetimeddlHour);
			
			utilobj.selectDropdown(getTSPtOutTimeddlHour(), driver, TSPtOutTimeddlHour);
			
			getbtnSaveDisplay().click();
			
			
			
			//getddlOt().click();
			//getddlPriority().click();
			//getddlAnesthesia().click();
			//getddlSurgeryType().click();
		

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}
}
