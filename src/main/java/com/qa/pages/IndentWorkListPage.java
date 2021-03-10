package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class IndentWorkListPage extends BasePage {

	util utilobj = new util();

	public IndentWorkListPage(WebDriver driver) {
		super(driver);

	}

	String indentno = null;
	String grdIndtReceipts1 = "//span[contains(@id,'lblRecpIndentNo')][text()='";
	String grdIndtReceipts2 = "']/parent::td/preceding-sibling::td/input";
	
	private By ViewIndent = By.id("ctl00_cphpage_btnRecp_ViewIndent");
	private By btnApprove = By.id("ctl00_cphpage_btnApprove"); 
	private By popok = By.id("popup_ok");
		
	private By ButtonOK = By.id("ctl00_cphpage_MessageBoxInfo_ButtonOK");
	private By btnIssuesTab = By.id("ctl00_cphpage_btnIssuesTab");

	
	private By rdbIssueList = By.id("ctl00_cphpage_grdIndentIssues_ctl02_rdbIssueList");
	
	private By btnIssueViewIndent = By.id("ctl00_cphpage_btnIssue_ViewIndent");

	private By btnOk = By.id("ctl00_cphpage_btnOk");
	
	private By IssueIndent = By.id("ctl00_cphpage_btnIssue_IssueIndent"); 
	
	private By btnSaveDisplay = By.id("ctl00_cphpage_btnSaveDisplay"); 


	
	
	public WebElement getbtnSaveDisplay() {
		return getElement(btnSaveDisplay);

	}
	

	public WebElement getbtnOk() {
		return getElement(btnOk);

	}
		
	public WebElement getrdbReceiptsList(String indentno) {
		return getElement(By.xpath(grdIndtReceipts1 + indentno + grdIndtReceipts2));

	}
	public WebElement getViewIndent() {
		return getElement(ViewIndent);

	}
	public WebElement getbtnApprove() {
		return getElement(btnApprove);

	}
	public WebElement getpopok() {
		return getElement(popok);

	}
	
	public WebElement getButtonOK() {
		return getElement(ButtonOK);

	}
	public WebElement getbtnIssuesTab() {
		return getElement(btnIssuesTab);

	}
	
	public WebElement getrdbIssueList() {
		return getElement(rdbIssueList);

	}
	
	public WebElement getbtnIssueViewIndent() {
		return getElement(btnIssueViewIndent);

	}
	
	public WebElement getIssueIndent() {
		return getElement(IssueIndent);

	}
	
	
	
	

	
	public void doIndentWorklistViewIndentApproveFromStore(String indentno) {

		try

		{
			getrdbReceiptsList(indentno).click();
			
			//getrdbReceiptsList("INO.00179").click();
			
			String parentwidow = driver.getWindowHandle();
			utilobj.Window(driver);
			getViewIndent().click();
			Thread.sleep(3000);
			utilobj.ChildWindow(driver);
			//utilobj.ChildWindowSwitch(driver, btnApprove);
			getbtnApprove().click();
			
			getpopok().click();
			
			driver.close();
			driver.switchTo().window(parentwidow);
						
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
	public void doIndentWorklistViewIndentApproveToStore() {

		try

		{
			
			getButtonOK().click();
			Thread.sleep(1000);
			getbtnIssuesTab().click();
			getrdbIssueList().click();
			getbtnIssueViewIndent().click();
			String parentwidow1 = driver.getWindowHandle();
			utilobj.Window(driver);
			getViewIndent().click();
			Thread.sleep(3000);
			utilobj.ChildWindow(driver);
			getbtnApprove().click();
			getpopok().click();

			driver.close();
			driver.switchTo().window(parentwidow1);
			getbtnOk().click();
			
			
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
	public void doIndentWorklistIssueIndentToStore() {

		try

		{
			
			
			Thread.sleep(1000);
			getrdbIssueList().click();
			String parentwidow2 = driver.getWindowHandle();
			utilobj.Window(driver);
			getIssueIndent().click();
			Thread.sleep(3000);
			utilobj.ChildWindow(driver);
			getbtnSaveDisplay().click();
			Thread.sleep(3000);
			getpopok().click();
			driver.close();
			driver.switchTo().window(parentwidow2);
			getbtnOk().click();
			
			
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
	public void changeLocationFacility(WebDriver driver) {
		try {
			
			driver.findElement(By.id("ctl00_lnkbtnChangeHospital")).click();
			
		}

		catch (Exception e) {
			System.out.println("Not Able to click");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	}
