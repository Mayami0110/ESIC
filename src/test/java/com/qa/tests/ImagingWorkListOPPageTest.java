package com.qa.tests;

import org.testng.annotations.Test;


import com.qa.pages.HISHomePage;
import com.qa.pages.HomePage;
import com.qa.pages.ImagingWorkListOPPage;
import com.qa.pages.LoginPage;
import com.qa.pages.OPCaseSheetPage;
import com.qa.pages.PatientCheckInPage;
import com.qa.pages.SelectHospitalLocationPage;

public class ImagingWorkListOPPageTest extends BaseTest {

	LoginPage loginpage;
	HomePage homepage;
	SelectHospitalLocationPage selecthospitallocationpage;
	HISHomePage hishomepage;
	ImagingWorkListOPPage imagingWorkListOPPage;

	OPCaseSheetPage opCaseSheetPage;
	PatientCheckInPage patientcheckInpage;

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
				prop.getProperty("imagingfacilityname"));
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

	@Test(priority = 7)
	public void doNavigateToImagingWorklistLinkTest() {

		imagingWorkListOPPage = hishomepage.doNavigateToImagingWorklistLink();
	}

	@Test(priority = 8)
	public void doImagingWorklistOPFlowTest() {

		imagingWorkListOPPage.doImagingWorklistOPFlow(prop.getProperty("reqPageTitle"));

	}

	@Test(priority = 9)
	public void doImagingWorklistOPFlowPATest() {

		imagingWorkListOPPage.doImagingWorklistPA();

	}

	@Test(priority = 10)
	public void doImagingWorklistOPFlowTestPerfTest() {

		imagingWorkListOPPage.doImagingWorklistTestPerf();

	}

	@Test(priority = 11)
	public void doImagingWorklistOPFlowResultEntryTest() {

		imagingWorkListOPPage.doImagingWorklistResultEntry(prop.getProperty("resultText"));

	}

	@Test(priority = 12)
	public void doImagingWorklistOPFlowResultverifyTest() {

		imagingWorkListOPPage.doImagingWorklistResultverify();

	}

	@Test(priority = 13)
	public void doImagingWorklistOPFlowDispatchTest() {

		imagingWorkListOPPage.doImagingWorklistDispatch(prop.getProperty("dispatchname"));

	}

}
