package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ReadDataFile;
import com.qa.util.util;

public class LoginPage extends BasePage {

	util utilobj = new util();
	ReadDataFile readdata = new ReadDataFile();
	private By username = By.id("IDToken1");
	private By password = By.id("IDToken2");
	private By loginbtn = By.xpath("//*[@id=\"wraper\"]/table/tbody/tr/td[2]/table[1]/tbody/tr[4]/td/table/tbody/tr/td[1]/div/input");

	
	public LoginPage(WebDriver driver) {
		super(driver);
	
	}

	/**
	 * @return the username
	 */
	public WebElement getUsername() {
		
		//String ui = readdata.readDataFile("LoginPage", 1, "uidd", "LoginPage");
		//String pw = readdata.readDataFile("LoginPageTest", 1, "pwdd", "doLoginTest");
		
		return getElement(username);
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		
		
		return getElement(password);	}

	/**
	 * @return the loginbtn
	 */
	public WebElement getLoginbtn() {
		return getElement(loginbtn);	

	}

	public HomePage doLogin(String uid, String pwd)
	{
		getUsername().sendKeys(uid);
		getPassword().sendKeys(pwd);
		
		utilobj.JSClick(getLoginbtn(), driver);
		
		//getLoginbtn().click();
		
		return new HomePage(driver);
		
	}
	
	
	
}
