package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class IPCaseSheetPrescriptionPage extends BasePage {

	public IPCaseSheetPrescriptionPage(WebDriver driver) {
		super(driver);

	}

	util utilobj = new util();

	private By imgexpand = By.xpath(
			"//*[@id=\"ctl00_cphpage_lstViewUnit_ctrl2_row\"]/th[contains(text(),'Dummyunit')]//preceding-sibling::th/img");
	private By imgadmissionno = By.xpath(
			"//span[contains(@id,\"lblAdmissionNumberDetail\")][(text()='IP012100011')]//parent::td//preceding-sibling::td[3]//input");

	private By popok = By.id("popup_ok");

	private By lableprecripstionlink = By.id("ctl00_cphpage_trvSectionst11");

	private By txtOrdPackSearch = By.id("txtOrdPackSearch");
	private By orderpack = By.id("97701");

	private By clickorderpackbutton = By.id("btnOrdpack"); // 97701

	private By orderpackselection = By.id("97701"); //

	private By btnISaveClose = By.id("btnISaveClose"); //

	public WebElement getimgexpand() {
		return getElement(imgexpand);

	}

	public WebElement getimgadmissionno() {
		return getElement(imgadmissionno);

	}

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

	public String verifyDoctorWorklistPageTitle() {

		return driver.getTitle();

	}

	public void doOpenIPCaseSheet() {

		try

		{
			// ().click();
			utilobj.JSClick(getimgexpand(), driver);
			utilobj.JSView(getimgadmissionno(), driver);
			utilobj.JSClick(getimgadmissionno(), driver);

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public void doIPCasesheetprecripstion(String orderpackname) {

		try

		{
			Thread.sleep(5000);

			getpopok().click();

			String parent3 = driver.getWindowHandle();

			utilobj.Window(driver);

			getlableprecripstionlink().click();

			Thread.sleep(2000);

			// utilobj.ChildWindowforPrescription(driver);
			utilobj.ChildWindow(driver);
			Thread.sleep(1000);

			// driver.switchTo().window("ClientSide_Prescriptions");
			System.out.println(driver.getTitle());

			utilobj.JSEnterText(gettxtOrdPackSearch(), driver, orderpackname);

			utilobj.JSClick(getclickorderpackbutton(), driver);

			// gettxtOrdPackSearch().sendKeys(orderpackname);
			// getclickorderpackbutton().click();

			Thread.sleep(3000);

			utilobj.JSClick(getorderpackselection(), driver);

			Thread.sleep(5000);

			utilobj.JSClick(getbtnISaveClose(), driver);

			utilobj.waitForalert(driver);

			driver.switchTo().alert().accept();

			driver.switchTo().window(parent3);

			driver.switchTo().defaultContent();

			getpopok().click();

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}
}
