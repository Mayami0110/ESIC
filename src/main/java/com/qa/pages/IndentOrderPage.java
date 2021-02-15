package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndentOrderPage extends BasePage {

	public IndentOrderPage(WebDriver driver) {
		super(driver);
	}
	
	private By imgSearch= By.id("ctl00_cphpage_imgSearch");

	private By txtCriteria= By.id("ctl00_cphpage_HISDataSearchCtrl_hisSearchCriteria_dlData_ctl00_txtCriteria");

	private By btnSearch= By.id("ctl00_cphpage_HISDataSearchCtrl_hisSearchCriteria_btnSearch");
	
	private By rdbTemp= By.xpath("//*[text()='Store D']//preceding-sibling::td/input");

	private By btnSelect= By.id("ctl00_cphpage_HISDataSearchCtrl_btnSelect");
	
	private By imgbtnSearchItem1= By.id("ctl00_cphpage_grdIndentIssues_ctl01_imgbtnSearchItem1");
	
	private By txtName= By.id("txtName");
	
	private By itembtnSearch= By.id("btnSearch");

	
	

	public WebElement getimgSearch() {
		return getElement(imgSearch);

	}
	public WebElement gettxtCriteria() {
		return getElement(txtCriteria);

	}
	public WebElement getbtnSearch() {
		return getElement(btnSearch);

	}
	public WebElement getrdbTemp() {
		return getElement(rdbTemp);

	}
	public WebElement getbtnSelect() {
		return getElement(btnSelect);

	}

	public void doIndentOrder() {

		try {
			
			getimgSearch().click();
			gettxtCriteria().sendKeys("Store D");
			getbtnSearch().click();
			Thread.sleep(2000);
			getrdbTemp().click();
			getbtnSelect().click();

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	
	
}
