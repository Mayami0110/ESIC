package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.AdjustmentLBStoreConsumptionPage;
import com.qa.pages.HISHomePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SelectHospitalLocationPage;
import com.qa.pages.PhysicalStockEntryPage;

public class StoreConsumptionTest  extends BaseTest {

	
	LoginPage loginpage;
	HomePage homepage;
	SelectHospitalLocationPage selecthospitallocationpage;
	HISHomePage hishomepage;
	AdjustmentLBStoreConsumptionPage storeconsumptions;
	
	
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
	public void doNavigateAdjustmentTest() {

		storeconsumptions = hishomepage.doNavigategetStoreConsumptionLink();
	}

			
	@Test(priority =4)
	public void doAdjustmentTest() {

		storeconsumptions.doAdjustmentLBStoreConsumption();
		
	}
	
	
	
}
