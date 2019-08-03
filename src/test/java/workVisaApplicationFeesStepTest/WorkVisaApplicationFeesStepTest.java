package workVisaApplicationFeesStepTest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import workVisaApplicationFeesStep.WorkVisaApplicationFeesStep;

public class WorkVisaApplicationFeesStepTest {
	public static final Logger log = Logger.getLogger(WorkVisaApplicationFeesStepTest.class.getName());
	WorkVisaApplicationFeesStep workVisaApplicationFeesStep;
	
	@BeforeClass
	public void initWorkVisaApplicantInfoStep(){
		log.info("**********************Start Work Visa Application Fees Step Class*****************************");
		workVisaApplicationFeesStep = new WorkVisaApplicationFeesStep();
		//setPageWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 12, description = "Pay for the request")
	public void insertDataWorkVisaAddressesInfoStep(){
		workVisaApplicationFeesStep.clickOnAgreeCheckBox();
		workVisaApplicationFeesStep.clickOnAmwalWallet();
		workVisaApplicationFeesStep.clickOnPayButton();
		// waitUntilTheLoadingFlagGetHidden();
	}
}
