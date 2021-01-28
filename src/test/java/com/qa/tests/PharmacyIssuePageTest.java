package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.qa.pages.HISHomePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.OPCaseSheetPage;
import com.qa.pages.PatientCheckInPage;
import com.qa.pages.SelectHospitalLocationPage;
import com.qa.pages.PharmacyIssuePage;

public class PharmacyIssuePageTest  extends BaseTest {

	
	LoginPage loginpage;
	HomePage homepage;
	SelectHospitalLocationPage selecthospitallocationpage;
	HISHomePage hishomepage;
	PharmacyIssuePage pharmacyissuepage;
	OPCaseSheetPage opCaseSheetPage;
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

		hishomepage = selecthospitallocationpage.doNavigateToHISHome(prop.getProperty("locationName"), prop.getProperty("storefacility"));
	}
	
	
	@Test(priority = 3)
	public void doNavigateToPatientCheckInTest() {

		patientcheckInpage = hishomepage.doNavigateToPatientCheckIn();
	}

	@Test(priority = 4)
	public void doPatientCheckINTest() {

		patientcheckInpage.doPatientCheckIN(prop.getProperty("IPNumber"), prop.getProperty("specialisationName"));

	}

	@Test(priority = 5)
	public void doNavigateToDoctorWorklistTest() {

		String txtcheckInNumber = patientcheckInpage.getPatientCheckinNumber();
		opCaseSheetPage = hishomepage.doNavigateToDoctorWorklistLink();
		// String txtcheckInNumber = "";
		opCaseSheetPage.doOpenCaseSheet(txtcheckInNumber);
		// doctorWorklistpage.doOpenCaseSheet(txtcheckInNumber);

	}

	@Test(priority = 6)
	public void doCasesheetprecripstionTest() {

		opCaseSheetPage.doCasesheetprecripstion(prop.getProperty("orderpackname"));

	}

	
	@Test(priority =7)
	public void doNavigateToPharmacyIssueTest() {

		pharmacyissuepage = hishomepage.doNavigateToPharmacyIssueLink();
	}
	
		
	@Test(priority =8)
	public void doPharmacyIssueTest() {

		pharmacyissuepage.doPharmacyIssue(prop.getProperty("IPNumber"));
		
	}
	
	
	
}
