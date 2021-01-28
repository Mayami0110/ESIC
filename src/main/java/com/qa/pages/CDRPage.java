package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class CDRPage extends BasePage {
	util utilobj = new util();

	public CDRPage(WebDriver driver) {
		super(driver);

	}

	private By txtIPNumber = By.id("ctl00_cphpage_SearchUserControl1_txtIPNumber");

	private By SearchBtnUhid = By.id("ctl00_cphpage_SearchUserControl1_imgBtnUhid");
	
	private By SelectBtn = By.xpath("/html/body/div[1]/form/div[4]/div[2]/div/div[1]/div[2]/table[2]/tbody/tr[1]/td/div/div/table[2]/tbody/tr[2]/td[5]/a");
	
	private By mgBtnDetails = By.id("ctl00_cphpage_imgBtnDetails");
	private By tvCompleteDetailst2 = By.id("ctl00_cphpage_tvCompleteDetailst2");
	
	public WebElement gettxtIPNumber() {
		return getElement(txtIPNumber);
	}

	public WebElement getSearchBtnUhid() {
		return getElement(SearchBtnUhid);
	}

	public WebElement getSelectBtn() {
		return getElement(SelectBtn);
	}
	public WebElement getmgBtnDetails() {
		return getElement(mgBtnDetails);
	}
	public WebElement gettvCompleteDetailst2() {
		return getElement(tvCompleteDetailst2);
	}
	
	
	
	
	public void doSearchCDR(String IPnumber) {
		
			try {	
				
				gettxtIPNumber().sendKeys(IPnumber);
				getSearchBtnUhid().click();
				Thread.sleep(2000);
				getSelectBtn().click();
				getmgBtnDetails().click();
				gettvCompleteDetailst2().click();
			
				
			}
				
			catch(Exception ex) {
				System.err.println(ex);
			}	
	}
				
				
			
			
	
	
			
	
	
	
	
	
	
	
	
}
