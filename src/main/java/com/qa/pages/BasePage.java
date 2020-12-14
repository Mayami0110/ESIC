package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);

	}

	@Override
	public WebElement getElement(By locator) {

		WebElement element = null;
		try {

			waitForElementExplicitClick(locator);

			element = driver.findElement(locator);

		}

		catch (Exception ex) {

		}
		return element;
	}

	public WebElement getElement(By locator, String elementdata) {

		WebElement element = null;
		try {
			waitForElementExplicitClick(locator);

			element = driver.findElement(locator);
		}

		catch (Exception ex) {
			System.err.println(ex);
		}
		return element;
	}

	@Override
	public void waitForElement(By locator) {
		try {
			// WebElement element = null;

			for (int i = 0; i < 120; i++) {
				driver.findElement(locator).isDisplayed();
				Thread.sleep(2000);
				break;
			}
		}

		catch (Exception e) {
			System.out.println("Not Able to Find Element" + locator);

			// logger("Steps","waitForElement", e);

		}

	}
	public void waitForElementExplicit(By locator) {
		try {
			// WebElement element = null;

			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}

		catch (Exception e) {
			System.out.println("Not Able to Find Element" + locator);

			// logger("Steps","waitForElement", e);

		}

	}
	public void waitForElementExplicitClick(By locator) {
		try {
			// WebElement element = null;

			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}

		catch (Exception e) {
			System.out.println("Not Able to Find Element" + locator);

			// logger("Steps","waitForElement", e);

		}

	}


}
