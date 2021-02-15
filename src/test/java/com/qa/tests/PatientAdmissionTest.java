package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HISHomePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.PatientAdmissionPage;
import com.qa.pages.PatientCheckInPage;
import com.qa.pages.SelectHospitalLocationPage;

public class PatientAdmissionTest extends BaseTest {

	public PatientAdmissionTest() {
}
	
	LoginPage loginpage;
	HomePage homepage;
	SelectHospitalLocationPage selecthospitallocationpage;
	HISHomePage hishomepage;
	PatientAdmissionPage patientAdmissionpage;
	
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
	public void doNavigateToPatientAdmissionTest() {

		patientAdmissionpage = hishomepage.doNavigateToPatientAdmission();
	}
	
	@Test(priority =4)
	public void verifyPatientAdmissionPageTitleTest() {

		String PatientAdmissionTitle= patientAdmissionpage.verifyPatientAdmissionPageTitle();
		Assert.assertEquals(PatientAdmissionTitle, prop.getProperty("commonpagetitle"),"patientadmissiontittle is Not matching");
	}
	
	@Test(priority =5)
	public void doPatientAdmissionTest() {

		patientAdmissionpage.doPatientAdmission(prop.getProperty("IPNumber"),prop.getProperty("specialisationName"),prop.getProperty("AdmissionType"),prop.getProperty("ReferralsourceofAdmission"), prop.getProperty("UnitName"));
		
		
	}
	
	
	
}


