package com.qa.util;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class util {

	
	//static WebDriver driver;
	//WebElement element;
	
	
	public void JSClick(WebElement element, WebDriver driver)
	{
		
		try {
		// element = driver.findElement(locator);
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", element);
		
		}
		catch(Exception ex) {
			System.out.println(ex);
			
		}
	}
	
	public void JSEnterText(WebElement element,WebDriver driver, String strData)
	{
		
		// element = driver.findElement(locator);
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].value = '" + strData + "'", element);	
	}
	
	
	public void ActionClick(WebElement element,WebDriver driver)
	{
		
		Actions act = new Actions(driver);
	
		//act.moveToElement(element).pause(1000).click().build().perform();

		//act.moveToElement(element).click().build().perform();
		
		act.click(element).perform();
	
	}
	
	public void rightClick(WebDriver driver, By locator,WebElement element) {

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
			
			System.out.println(handles.size());

			Iterator<String> iterator = handles.iterator();

			while (iterator.hasNext())
			{
				subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler);
			
			System.out.println(driver.getTitle());
		}
		catch(Exception e)
		{
			System.out.println("Winow not handled");
			
			//logger("Steps","Window", e);

		}
	}
	
	public void SwitchToChildWindow(WebDriver driver, String windowtitle)
	{
		try
		{
			String subWindowHandler = null;

			Set<String> handles = driver.getWindowHandles();
			
			System.out.println(handles.size());

			Iterator<String> iterator = handles.iterator();

			while (iterator.hasNext())
			{
				subWindowHandler = iterator.next();
				driver.switchTo().window(subWindowHandler);
				System.out.println(driver.getTitle());
				if(driver.getTitle().trim().equals(windowtitle))
					{
					break;
					};

			}
			
			System.out.println(driver.getTitle());
		}
		catch(Exception e)
		{
			System.out.println("Winow not handled");
			
			//logger("Steps","Window", e);

		}
	}
	public void Window(WebDriver driver)
	{
		try
		{
			((JavascriptExecutor)driver).executeScript("window.showModalDialog =window.open;");

			System.out.println("Modal pop window converted to Normal window");
		}
		catch(Exception e)
		{
			System.out.println("Modal pop window not converted to Normal window");
		}
	}


	

	public void ChildWindowforPrescription(WebDriver driver)
	{
		try
		{
			String subWindowHandler = null;

			Set<String> handles = driver.getWindowHandles();
			System.out.println(handles.size());

			Iterator<String> iterator = handles.iterator();

			while (iterator.hasNext())
			{
				subWindowHandler = iterator.next();
			
				driver.switchTo().window(subWindowHandler);
				System.out.println(driver.getTitle());

				if(driver.getTitle().contains("ClientSide_Prescriptions")) {
					
					break;				
					
				}
				
			}
			
			System.out.println(driver.getTitle());
		}
		catch(Exception e)
		{
			System.out.println("Winow not handled");
			
			//logger("Steps","Window", e);

		}
	}

	
	
	public String GetCheckinNumberText(WebElement strElement,WebDriver driver )
	{
		String strtext=(strElement.getText());
		String strtextcheckin[] = strtext.split(" ");
		
		String Checkinnumber =strtextcheckin[2];
		
		return Checkinnumber;

	
		
	
	}
	
	public void selectDropdown(WebElement strElement,  WebDriver driver , String strData)
	{
		try
		{
		//wait ForElement(strElement);

			Hashtable ht = new Hashtable();
			//System.out.println(strElement.getText());
			
			Select dropdownValue = new Select(strElement);
			
			dropdownValue.selectByVisibleText(strData);	

		}

		catch (Exception e)
		{
			System.out.println("Dropdown hasn't selected");
			
			// logger("Steps","selectDropdown", e);

		}

	}
	
	/*public void waitForElement(WebElement strElement)
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
	}*/
	
	public void waitForalert(WebDriver driver)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			wait.until(ExpectedConditions.alertIsPresent());
		}

		catch (Exception e)
		{
			System.out.println("Not Able to Find Element");
			
			//logger("Steps","waitForElement", e);

		}
	}
	
}

