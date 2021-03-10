package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.AdjustmentLBStoreConsumptionPage;
import com.qa.pages.HISHomePage;
import com.qa.pages.HomePage;
import com.qa.pages.IndentOrderPage;
import com.qa.pages.IndentWorkListPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SelectHospitalLocationPage;
import com.qa.pages.PhysicalStockEntryPage;

public class IndentWorklistPageTest  extends BaseTest {

	
	LoginPage loginpage;
	HomePage homepage;
	SelectHospitalLocationPage selecthospitallocationpage;
	HISHomePage hishomepage;
	IndentOrderPage indentorderPage;
	IndentWorkListPage indentworkListPage;
	String indentnumber;
	
	
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
	public void doNavigateIndentOrderLinkTest() {

		indentorderPage = hishomepage.doNavigateIndentOrderLink();
			}

			
	@Test(priority =4)
	public void doIndentOrderTest() {

		indentorderPage.doIndentOrderLast5Indent();
		
	}
	
	@Test(priority =5)
	public void doIndentWorklistViewIndentApproveFromStoreTest() {

		indentnumber = indentorderPage.getIndentNumber();
		indentworkListPage = hishomepage.doNavigateIndentWorkListLink();
		indentworkListPage.doIndentWorklistViewIndentApproveFromStore(indentnumber);
		indentworkListPage.changeLocationFacility(driver);
		//indentworkListPage.doIndentWorklistViewIndent("");

	}
	
	@Test(priority =6)
	public void doIndentWorklistViewIndentApproveToStoreTest() {

		selecthospitallocationpage.doNavigateToHISHome(prop.getProperty("locationName"), prop.getProperty("storefacilitytostore"));
		hishomepage.doNavigateIndentWorkListLink();
		indentworkListPage.doIndentWorklistViewIndentApproveToStore();


	}
	@Test(priority =7)
	public void doIndentWorklistIssueIndentToStoreTest() {

		indentworkListPage.doIndentWorklistIssueIndentToStore();


	}

	
	
}
