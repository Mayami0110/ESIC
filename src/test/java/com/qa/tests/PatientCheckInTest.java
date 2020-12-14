package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HISHomePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.PatientCheckInPage;
import com.qa.pages.SelectHospitalLocationPage;

public class PatientCheckInTest  extends BaseTest{

	
	LoginPage loginpage;
	HomePage homepage;
	SelectHospitalLocationPage selecthospitallocationpage;
	HISHomePage hishomepage;
	PatientCheckInPage patientcheckInpage;
	
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
	public void doNavigateToPatientCheckInTest() {

		patientcheckInpage = hishomepage.doNavigateToPatientCheckIn();
	}
	
	@Test(priority =4)
	public void verifyPatientCheckInPageTitleTest() {

		String PatientCheckInTitle= patientcheckInpage.verifyPatientCheckInPageTitle();
		Assert.assertEquals(PatientCheckInTitle, prop.getProperty("patientcheckintitle"),"PatientCheckInTitle is Not matching");
	}
	
	@Test(priority =5)
	public void doPatientCheckINTest() {

		patientcheckInpage.doPatientCheckIN(prop.getProperty("IPNumber"),prop.getProperty("specialisationName"));
		
	}
	
	
	
}
