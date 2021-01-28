package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.util;

public class HISHomePage extends BasePage {

	util utilobj = new util();

	public HISHomePage(WebDriver driver) {
		super(driver);

	}

	/* Registration module */
	private By RegistrationLink = By.linkText("Registration");

	/* Patient CheckIn */
	private By PatientCheckInLink = By.linkText("Patient Check-In /Registration");

	private By PatientAdmissionLink = By.linkText("Patient Admission");

	private By CancelCheckinLink = By.linkText("Cancel Check-in");

	private By ClinicalRecordsLink = By.linkText("Clinical Records");

	private By DoctorWorklistLink = By.linkText("Doctor Worklist");
	
	private By InpatientsEmergencyLink = By.linkText("Inpatients/Emergency Patients");
	private By UHIDcreationLink = By.linkText("UHID Creation");
	
	private By BedstatusLink = By.linkText("Bed Status");



	private By CDRLink = By.linkText("CDR");

	private By PatientFolderLink = By.linkText("Patient Folder");

	/* OT module */

	private By OTandResourceSchedulingLink = By.linkText("OT and Resource Scheduling");

	private By ViewOTListLink = By.linkText("View OT List");
	
	/* Imaging module */

	private By ImagingServicesLink = By.linkText("IMAGING SERVICES");

	private By ImagingWorklistLink = By.linkText("Worklist");
		
	// Store
	
	private By StoreLinks = By.linkText("Stores");

	private By PharmacyIssueLink = By.linkText("Pharmacy Issues");
	
	
	

	public WebElement getRegistrationLink() {
		return getElement(RegistrationLink);

	}

	public WebElement getPatientCheckInLink() {
		return getElement(PatientCheckInLink);

	}

	public WebElement getPatientAdmissionLink() {
		return getElement(PatientAdmissionLink);

	}

	public WebElement getCancelCheckinLink() {
		return getElement(CancelCheckinLink);

	}

	public WebElement getClinicalRecordsLink() {
		return getElement(ClinicalRecordsLink);

	}

	public WebElement getDoctorWorklistLink() {
		return getElement(DoctorWorklistLink);

	}
	public WebElement getInpatientsEmergencyLink() {
		return getElement(InpatientsEmergencyLink);

	}

	public WebElement getCDRLink() {
		return getElement(CDRLink);

	}

	public WebElement getPatientFolderLink() {
		return getElement(PatientFolderLink);

	}

	public WebElement getOTandResourceSchedulingLink() {
		return getElement(OTandResourceSchedulingLink);

	}

	public WebElement getViewOTListLink() {
		return getElement(ViewOTListLink);

	}
	
	
	public WebElement getBedstatusLink() {
		return getElement(BedstatusLink);

	}
	
	public WebElement getUHIDcreationLink() {
		return getElement(UHIDcreationLink);

	}
	public WebElement getImagingServicesLink() {
		return getElement(ImagingServicesLink);

	}
	public WebElement getImagingWorklistLink() {
		return getElement(ImagingWorklistLink);

	}

	public WebElement getStoreLinks() {
		return getElement(StoreLinks);

	}
	public WebElement getPharmacyIssueLink() {
		return getElement(PharmacyIssueLink);

	}

	
	public PatientCheckInPage doNavigateToPatientCheckIn() {
		utilobj.MoveElement(getRegistrationLink(), driver);

		getPatientCheckInLink().click();

		return new PatientCheckInPage(driver);

	}

	public PatientAdmissionPage doNavigateToPatientAdmission() {
		utilobj.MoveElement(getRegistrationLink(), driver);

		getPatientAdmissionLink().click();

		return new PatientAdmissionPage(driver);
	}

	public CancelCheckinPage doNavigateToCancelCheckinLink() {
		utilobj.MoveElement(getRegistrationLink(), driver);

		getCancelCheckinLink().click();

		return new CancelCheckinPage(driver);
	}

	public OPCaseSheetPage doNavigateToDoctorWorklistLink() {
		utilobj.MoveElement(getClinicalRecordsLink(), driver);

		getDoctorWorklistLink().click();

		return new OPCaseSheetPage(driver);
	}
	
	public IPCaseSheetPage doNavigateToInpatientEmergencyLink() {
		utilobj.MoveElement(getClinicalRecordsLink(), driver);

		getInpatientsEmergencyLink().click();

		return new IPCaseSheetPage(driver);
	}

	public CDRPage doNavigateToCDRLink() {
		utilobj.MoveElement(getCDRLink(), driver);

		getPatientFolderLink().click();

		return new CDRPage(driver);
	}

	public OTandResourceSchedulingPage doNavigateToOTandResourceSchedulingLink() {
		
		utilobj.MoveElement(getOTandResourceSchedulingLink(), driver);

		getViewOTListLink().click();

		return new OTandResourceSchedulingPage(driver);
		
		
	}
		
		
		public BedStatusPage doNavigateToBedStatusLink() {
			utilobj.MoveElement(getRegistrationLink(), driver);

			getBedstatusLink().click();

			return new BedStatusPage(driver);

		}
		
		public UHIDPage doNavigateToUHIDcreationLink() {
			utilobj.MoveElement(getRegistrationLink(), driver);

			getUHIDcreationLink().click();

			return new UHIDPage(driver);

		}

		public ImagingWorkListOPPage doNavigateToImagingWorklistLink() {
			utilobj.MoveElement(getImagingServicesLink(), driver);

			getImagingWorklistLink().click();

			return new ImagingWorkListOPPage(driver);

		}


		public PharmacyIssuePage doNavigateToPharmacyIssueLink() {
		
			utilobj.MoveElement(getStoreLinks(), driver);

			getPharmacyIssueLink().click();

			return new PharmacyIssuePage(driver);

		}

}


