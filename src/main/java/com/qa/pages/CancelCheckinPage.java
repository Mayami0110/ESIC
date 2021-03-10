package com.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.pages.BasePage;
import com.qa.util.util;

public class CancelCheckinPage extends BasePage {

	util utilobj = new util();

	public CancelCheckinPage(WebDriver driver) {
		super(driver);

	}

	private By ImgUhidSearch = By.id("ctl00_cphpage_ImgUhid");

	private By UhidSearchTextBox = By.id("ctl00_cphpage_hisDataSearchCtrl_hisSearchCriteria_dlData_ctl00_txtCriteria");

	private By btnSearch = By.id("ctl00_cphpage_hisDataSearchCtrl_hisSearchCriteria_btnSearch");

	private By btnSelect = By.id("ctl00_cphpage_hisDataSearchCtrl_btnSelect");

	private By rdbUhid = By.id("ctl00_cphpage_hisDataSearchCtrl_hisSearchResultGrid_gdvList_ctl02_rdbTemp");

	// private By SelectBtn = By.id("ctl00_cphpage_hisDataSearchCtrl_btnSelect");

	private By chkCancel = By.id("ctl00_cphpage_gdvCancelCheckin_ctl02_chkCancel");

	private By btnCancel = By.id("ctl00_cphpage_btnCancel");

	public WebElement getImgUhidSearch() {
		return getElement(ImgUhidSearch);
	}

	public WebElement getUhidSearchTextBox() {
		return getElement(UhidSearchTextBox);
	}

	public WebElement getbtnSearch() {
		return getElement(btnSearch);
	}

	public WebElement getbtnSelect() {
		return getElement(btnSelect);
	}

	public WebElement getrdbUhid() {
		return getElement(rdbUhid);
	}

	/*
	 * public WebElement getSelectBtnc() { return getElement(SelectBtn); }
	 */

	public WebElement getchkCancel() {
		return getElement(chkCancel);
	}

	public WebElement getbtnCancel() {
		return getElement(btnCancel);
	}

	/*
	 * public String verifyCancelCheckinPageTitle() {
	 * 
	 * return driver.getTitle();
	 * 
	 * }
	 */
	


	public void doCancelCheckin(String UHDNo) {

		try {

			getImgUhidSearch().click();
			getUhidSearchTextBox().sendKeys(UHDNo);
			getbtnSearch().click();
			getrdbUhid().click();
			getbtnSelect().click();
			Thread.sleep(2000);
			getchkCancel().click();
			getbtnCancel().click();

			driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div[2]/div/div/div[3]/div[1]/div[2]/p"))
					.getText();
			System.out.println(
					driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div[2]/div/div/div[3]/div[1]/div[2]/p"))
							.getText());

		}

		catch (ArithmeticException | NoSuchElementException fno) {
			System.err.println(fno);
		}
		
		catch (Exception ex) {
			System.err.println(ex);
		}

	}
}
