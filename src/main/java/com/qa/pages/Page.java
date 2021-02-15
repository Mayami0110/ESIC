package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
	
	WebDriver driver;
	
	public Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public abstract WebElement getElement(By locator);
	
	public abstract WebElement getElement(By locator, String elementdata);

	
	public abstract void waitForElement(By locator);
 
	

}
