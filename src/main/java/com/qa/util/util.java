package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class util {

	
	//static WebDriver driver;
	WebElement element;
	
	
	public void JSClick(By locator,WebDriver driver)
	{
		
		 element = driver.findElement(locator);
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", element);
	
	}
	
	public void rightClick(WebDriver driver, By locator) {

		element = driver.findElement(locator);

		Actions act = new Actions(driver);

		act.contextClick(element).build().perform();

	}
	
	
}
