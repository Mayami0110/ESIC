package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ReadDataFile;
import com.qa.util.util;

public class LoginPage extends BasePage {

	util utilobj = new util();
	ReadDataFile readdata = new ReadDataFile();
	private By emailid = By.id("username");
	private By password = By.id("password");
	private By loginbtn = By.id("loginBtn");

	
	public LoginPage(WebDriver driver) {
		super(driver);
	
	}

	/**
	 * @return the emailid
	 */
	public WebElement getEmailid() {
		
		String ui = readdata.readDataFile("LoginPage", 1, "uidd", "LoginPage");
		//String pw = readdata.readDataFile("LoginPageTest", 1, "pwdd", "doLoginTest");
		
		return getElement(emailid);
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
		getEmailid().sendKeys(uid);
		getPassword().sendKeys(pwd);
		
		utilobj.JSClick(loginbtn, driver);
		
		//getLoginbtn().click();
		
		return new HomePage();
		
	}
	
	
	
}
