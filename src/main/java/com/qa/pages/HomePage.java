package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ReadDataFile;
import com.qa.util.util;

public class HomePage extends BasePage {

	util utilobj = new util();
	ReadDataFile readdata = new ReadDataFile();
	
	public HomePage(WebDriver driver) {
		super(driver);

	}
	
	
	
	
	/* Applications menu link */
	private By ProdAppLink = By.linkText("Applications");
	
	/* HIS produciton link */
	private By ProdHISLink = By.linkText("Health Information System");

	
	public WebElement getProdAppLink() {
		
		return getElement(ProdAppLink);
	}

	public WebElement getProdHISLink() {
		
		return getElement(ProdHISLink);
	}
	
	//steps.ChildWindow(driver);
	
	public SelectHospitalLocationPage doNavigateToSelectHospitalLocation()
	{
		utilobj.MoveElement(getProdAppLink(), driver);
		
		getProdHISLink().click();
		
		utilobj.ChildWindow(driver);
		
		
		return new SelectHospitalLocationPage(driver);
		
	}

}
