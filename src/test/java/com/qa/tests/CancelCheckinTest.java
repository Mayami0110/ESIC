package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.pages.CancelCheckinPage;
import com.qa.pages.HISHomePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.PatientAdmissionPage;
import com.qa.pages.SelectHospitalLocationPage;

public class CancelCheckinTest extends BaseTest{

	public CancelCheckinTest() {
		// TODO Auto-generated constructor stub
	}
	LoginPage loginpage;
	HomePage homepage;
	SelectHospitalLocationPage selecthospitallocationpage;
	HISHomePage hishomepage;
	CancelCheckinPage cancelCheckinpage;
	
	@Test(priority =0)
	public void doLoginTest() {

		loginpage = new LoginPage(driver);

		homepage = loginpage.doLogin(prop.getProperty("uidd"), prop.getProperty("pwdd"));

	}
	
	
	@Test(priority =1)
	public void doNavigateToSelectHospitalLocationTest() {

		selecthospitallocationpage = homepage.doNavigateToSelectHospitalLocation();
	}
	
	@Test(priority =2)
	public void doNavigateToHISHomeTest() {

		hishomepage = selecthospitallocationpage.doNavigateToHISHome(prop.getProperty("locationName"), prop.getProperty("facilityName"));
	}
	
	@Test(priority =3)
	public void doNavigateToCancelCheckinTest() {

		cancelCheckinpage = hishomepage.doNavigateToCancelCheckinLink();
	}


@Test(priority =5)
public void doPatientAdmissionTest() {

	cancelCheckinpage.doCancelCheckin(prop.getProperty("UHIDNumber"));
	
}
}
