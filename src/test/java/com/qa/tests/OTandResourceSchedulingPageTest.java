package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.qa.pages.HISHomePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.OPCaseSheetPage;
import com.qa.pages.OTandResourceSchedulingPage;
import com.qa.pages.PatientCheckInPage;
import com.qa.pages.SelectHospitalLocationPage;

public class OTandResourceSchedulingPageTest extends BaseTest {

	public OTandResourceSchedulingPageTest () {

	}

	LoginPage loginpage;
	HomePage homepage;
	SelectHospitalLocationPage selecthospitallocationpage;
	HISHomePage hishomepage;
	OTandResourceSchedulingPage otandResourceSchedulingpage;
	OPCaseSheetPage opCaseSheetPage;
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
				prop.getProperty("OtFacilityname"));
	}
	@Test(priority = 3)
	public void doNavigateToOTandResourceSchedulingTest() {

		otandResourceSchedulingpage = hishomepage.doNavigateToOTandResourceSchedulingLink();
	}
	
	@Test(priority = 4)
	public void verifyOTSurgeryPageTitleTest() {

	
		String OTTitle= otandResourceSchedulingpage.verifyOTSurgeryPageTitle();
		Assert.assertEquals(OTTitle, prop.getProperty("commonpagetitle"),"OTTitle is Not matching");
	
	}
	
	
	@Test(priority = 5)
	public void doOTandResourceSchedulingnTest() {

		otandResourceSchedulingpage.dosurgeryRecord(prop.getProperty("SurgeryRecord"),prop.getProperty("otname"),
				prop.getProperty("OtPriority"),prop.getProperty("Anesthesianame"),prop.getProperty("otlSurgeryType"),
				prop.getProperty("ddlHour"),
				prop.getProperty("StartdatetimeddlHour"),
				prop.getProperty("enddatetimeddlHour"),
				prop.getProperty("TSPtOutTimeddlHour"));
	}
	
}
