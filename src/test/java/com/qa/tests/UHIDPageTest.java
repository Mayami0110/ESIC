package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.pages.HISHomePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SelectHospitalLocationPage;
import com.qa.pages.UHIDPage;

public class UHIDPageTest extends BaseTest {

	public UHIDPageTest() {

	}

	LoginPage loginpage;
	HomePage homepage;
	SelectHospitalLocationPage selecthospitallocationpage;
	HISHomePage hishomepage;
	UHIDPage uhidpage;

	@Test(priority = 0)
	public void doLoginTest() {

		loginpage = new LoginPage(driver);

		homepage = loginpage.doLogin(prop.getProperty("uidd"), prop.getProperty("pwdd"));

	}

	@Test(priority = 1)
	public void doNavigateToSelectHospitalLocationTest() {

		selecthospitallocationpage = homepage.doNavigateToSelectHospitalLocation();
	}

	@Test(priority = 2)
	public void doNavigateToHISHomeTest() {

		hishomepage = selecthospitallocationpage.doNavigateToHISHome(prop.getProperty("locationName"),
				prop.getProperty("facilityName"));
	}

	@Test(priority = 3)
	public void doNavigateToUHIDcreationLinkTest() {

		uhidpage = hishomepage.doNavigateToUHIDcreationLink();
	}
	
	
	@Test(priority = 4)
	public void doUHIDCreationPageTest() {

		uhidpage.doUHIDCreationPage(prop.getProperty("Title"),prop.getProperty("FirstName"),prop.getProperty("LastName"),
				prop.getProperty("MaritalStatus"),prop.getProperty("Age"),prop.getProperty("Address"));
				
						
				
				
	}
	
}


