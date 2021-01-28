package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class OPCaseSheetPage extends BasePage {
	
	public OPCaseSheetPage(WebDriver driver) {
		super(driver);
		
	}

	util utilobj = new util();

	String checkinNumber = null;
	String lblchkin1 = "//span[text()='";
	String lblchkin2 = "']";
//private By lblBillNo1 = By.linkText(checkinNumber);
	// private By lblBillNo1 = By.xpath(lblchkin1+ checkinNumber +lblchkin2);

	private By popok = By.id("popup_ok");

	private By lableprecripstionlink = By.id("ctl00_cphpage_trvSectionst11");

	private By txtOrdPackSearch = By.id("txtOrdPackSearch");
	private By orderpack = By.id("97701");

	private By clickorderpackbutton = By.id("btnOrdpack"); //97701

	private By orderpackselection = By.id("97701"); //

	private By btnISaveClose = By.id("btnISaveClose"); //
	
	

	public WebElement getorderpackselection() {
		return getElement(orderpackselection);

	}

	public WebElement getbtnISaveClose() {
		return getElement(btnISaveClose);

	}

	
	public WebElement getpopok() {
		return getElement(popok);

	}

	
	public WebElement getlableprecripstionlink() {
		return getElement(lableprecripstionlink);

	}

	public WebElement gettxtOrdPackSearch() {
		return getElement(txtOrdPackSearch);

	}

	public WebElement getorderpack() {
		return getElement(orderpack);

	}

	public WebElement getclickorderpackbutton() {
		return getElement(clickorderpackbutton);

	}

	public WebElement getlblBillNo1(String checkinNumber) {
		return getElement(By.xpath(lblchkin1 + checkinNumber + lblchkin2));
		//// span[text()='OPGENE012100026']
	}

	/*
	 * public WebElement getlblBillNo1(String checkinNumber) { return getElement(
	 * By.linkText(checkinNumber)); //// span[text()='OPGENE012100026'] }
	 */

	

	public String verifyDoctorWorklistPageTitle() {

		return driver.getTitle();

	}

	public void doOpenCaseSheet(String checkinNumber) {

		try

		{

			getlblBillNo1(checkinNumber).click();
			
			// Code for testing purpose Dr Worklist. - Direct Click
			
		//	driver.findElement(By.id("ctl00_cphpage_gdvSpecialization_ctl02_lblBillNo1")).click();
			

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
	public void doCasesheetprecripstion(String orderpackname) {

		try

		{
			getpopok().click();
			
			String parent3 = driver.getWindowHandle();
			
			utilobj.Window(driver);
			
			getlableprecripstionlink().click();
		
			Thread.sleep(2000);
						
			//utilobj.ChildWindowforPrescription(driver);
			utilobj.ChildWindow(driver);
			Thread.sleep(1000);
			
			//driver.switchTo().window("ClientSide_Prescriptions");
			System.out.println(driver.getTitle());	
			
			utilobj.JSEnterText(gettxtOrdPackSearch(), driver, orderpackname);
			
			utilobj.JSClick(getclickorderpackbutton(), driver);
			
			//gettxtOrdPackSearch().sendKeys(orderpackname);
			//getclickorderpackbutton().click();
			
			Thread.sleep(3000);

			utilobj.JSClick(getorderpackselection(), driver);
			
			Thread.sleep(5000);

			
			utilobj.JSClick(getbtnISaveClose(), driver);
			
			utilobj.waitForalert(driver);
			
			driver.switchTo().alert().accept();
			
			
			
			
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}
}
