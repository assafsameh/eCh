package workVisaAttachmentsStepTest;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import workVisaAttachmentsStep.WorkVisaAttachmentsStep;

public class WorkVisaAttachmentsStepTest extends BaseClass{
	public static final Logger log = Logger.getLogger(WorkVisaAttachmentsStepTest.class.getName());
	WorkVisaAttachmentsStep WorkVisaAttachmentsStep;

	@BeforeClass
	public void initWorkVisaAttachmentsStepTest(){
		log.info("**********************Start Work Visa Attachments Step Class*****************************");
		WorkVisaAttachmentsStep = new WorkVisaAttachmentsStep();
		waitUntilTheLoadingFlagGetHidden();
	}
	
	@Test(priority = 10, description = "fill Out Attachments Info Step of Work Visa")
	public void insertAttachmentsStep(){
		WorkVisaAttachmentsStep.uploadAttachments();
		WorkVisaAttachmentsStep.clickNextButton();
	}
	
	@AfterClass
	public void tearDownWorkVisaAttachmentsStepTest(){
		log.info("**********************Tear Down Work Visa Attachments Step Class*****************************");
	}	
}