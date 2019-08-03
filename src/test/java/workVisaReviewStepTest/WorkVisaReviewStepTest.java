package workVisaReviewStepTest;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import workVisaReviewStep.WorkVisaReviewStep;

public class WorkVisaReviewStepTest extends BaseClass{
	
	public static final Logger log = Logger.getLogger(WorkVisaReviewStepTest.class.getName());
	WorkVisaReviewStep workVisaReviewStep;

	@BeforeClass
	public void initWorkVisaReviewStepTest(){
		log.info("**********************Start Work Visa Review Step Class*****************************");
		workVisaReviewStep = new WorkVisaReviewStep();
		waitUntilTheLoadingFlagGetHidden();
	}
	
	@Test(priority = 11, description = "Click on the next Button in the Work Visa in the Review Stept")
	public void clickNextButtonWorkVisaReviewStepTest(){
		workVisaReviewStep.clickOnNexuButton();
		log.info("Clicked on the next Button in the Work Visa in the Review Stept");
	}
	
	@AfterClass
	public void workVisaReviewStepTestTearDown(){
		log.info("**********************Tear Down Work Visa Review Step Class*****************************");
	}
}
