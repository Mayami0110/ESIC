package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class CaseSheetPage extends BasePage {

	util utilobj = new util();
  
		public CaseSheetPage(WebDriver driver) 
		{
			super(driver);
		}

		public String verifyDoctorWorklistPageTitle() {

			return driver.getTitle();

		}
		private By Linkprescripstion = By.id("ctl00_cphpage_trvSectionst11");

		public WebElement Linkprescripstion() 
		{
			return getElement(Linkprescripstion);
		}
		/*public WebElement getGetCheckinNumberText() {
			return getElement(GetCheckinNumberText);
		}*/

		

	}

