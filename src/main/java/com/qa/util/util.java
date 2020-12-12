package com.qa.util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class util {

	
	//static WebDriver driver;
	WebElement element;
	
	
	public void JSClick(WebElement element,WebDriver driver)
	{
		
		// element = driver.findElement(locator);
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", element);
	
	}
	
	public void rightClick(WebDriver driver, By locator) {

		element = driver.findElement(locator);

		Actions act = new Actions(driver);

		act.contextClick(element).build().perform();

	}
	
	public void MoveElement(WebElement element ,WebDriver driver)
	{

		try
		{
			Actions mov = new Actions(driver);
			
			//waitForElement(locator, driver);

			mov.moveToElement(element);

			mov.build().perform();

		}
		catch (Exception e)
		{
			System.out.println("Not Able to Move");
			
		//	logger("Steps","MoveElement",  e);

		}
	}

	public void ChildWindow(WebDriver driver)
	{
		try
		{
			String subWindowHandler = null;

			Set<String> handles = driver.getWindowHandles();

			Iterator<String> iterator = handles.iterator();

			while (iterator.hasNext())
			{
				subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler);
		}
		catch(Exception e)
		{
			System.out.println("Winow not handled");
			
			//logger("Steps","Window", e);

		}
	}
	
	
	public void selectDropdown(WebElement strElement,  WebDriver driver , String strData)
	{
		try
		{
			waitForElement(strElement);
			
			System.out.println(strElement.getText());
			
			Select dropdownValue = new Select(strElement);
			
			dropdownValue.selectByVisibleText(strData);	

		}

		catch (Exception e)
		{
			System.out.println("Dropdown hasn't selected");
			
			// logger("Steps","selectDropdown", e);

		}

	}
	
	public void waitForElement(WebElement strElement)
	{
		try
		{
			for (int i=0; i<120; i++)
			{
				strElement.isDisplayed();
				Thread.sleep(2000);
				break;
			}                      
		}

		catch (Exception e)
		{
			System.out.println("Not Able to Find Element");
			
			//logger("Steps","waitForElement", e);

		}
	}
	
}
