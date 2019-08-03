package workVisaAddressesInfoStepTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import workVisaAddressesInfoStep.WorkVisaAddressesInfoStep;

public class WorkVisaAddressesInfoStepTest extends BaseClass {
	public static final Logger log = Logger.getLogger(WorkVisaAddressesInfoStepTest.class.getName());
	WorkVisaAddressesInfoStep workVisaAddressesInfoStep ;
	
	@BeforeClass
	public void initWorkVisaAddressesInfoStep(){	
		log.info("**********************Start Work Visa Addresses Info Step Class*****************************");
		setPageWait(10, TimeUnit.SECONDS);
		workVisaAddressesInfoStep = new WorkVisaAddressesInfoStep() ;
		// waitUntilTheLoadingFlagGetHidden();
	}
	
	@Test(priority = 9, description = "fill Out Address Step of Work Visa")
	public void insertDataWorkVisaAddressesInfoStep(){
		workVisaAddressesInfoStep.insertLocationinsideUAE();
		workVisaAddressesInfoStep.insertEmirateDropDownList();
		workVisaAddressesInfoStep.insertCityDropDownList();
		workVisaAddressesInfoStep.insertLocalBuilding();
		workVisaAddressesInfoStep.insertLocalFlatNumber();
		workVisaAddressesInfoStep.insertUAEPhoneNumber();
		workVisaAddressesInfoStep.insertPermanentMobileNumber();
		workVisaAddressesInfoStep.insertPermanentCountryDropDownList();
		workVisaAddressesInfoStep.insertEmail();
		workVisaAddressesInfoStep.insertApplicantlocationoutsideUAE();
		workVisaAddressesInfoStep.clickNextButton();
		
		// waitUntilTheLoadingFlagGetHidden();
	}
	
	@AfterClass
	public void tearDownWorkVisaAddressesInfoStep(){	
		log.info("**********************Tear Down Work Visa Addresses Info Step Class*****************************");
	}
}
