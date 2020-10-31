package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);

	}

	@Override
	public WebElement getElement(By locator) {
		
		WebElement element = null;
		try {
		element = driver.findElement(locator);
		
		}
		
		catch(Exception ex) {
			
		}
		return element;
	}
	public WebElement getElement(By locator, String elementdata) {
		
		WebElement element = null;
		try {
		element = driver.findElement(locator);
		}
		
		catch(Exception ex) {
			
		}
		return element;
	}

	@Override
	public void waitForElement(By locator) {
		// TODO Auto-generated method stub
		
	}

}
