package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends BaseTest{

	LoginPage loginpage;
	HomePage homepage;
	
	@Test
	public void doLoginTest() {

		loginpage = new LoginPage(driver);

		homepage = loginpage.doLogin(prop.getProperty("uidd"), prop.getProperty("pwdd"));

	}
	
	@Test
	public void doNavigateToSelectHospitalLocationTest() {

		homepage.doNavigateToSelectHospitalLocation();
	}

}
