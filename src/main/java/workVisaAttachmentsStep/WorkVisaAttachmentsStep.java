package workVisaAttachmentsStep;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import helper.ExtendedWebElement;

public class WorkVisaAttachmentsStep extends BaseClass{
	public static final Logger log = Logger.getLogger(WorkVisaAttachmentsStep.class.getName());
	ExtendedWebElement extendedWebElement ;
	
	public WorkVisaAttachmentsStep(){
		log.info("**********************Start Work Visa Attachments Step Class*****************************");
		extendedWebElement = new ExtendedWebElement(driver);
	}
	
	public void uploadAttachments() {
		List<WebElement> attachmentsList = extendedWebElement.elementsLocator(By.xpath("//tahaluf-attachments-viewer[@class='ng-scope ng-isolate-scope']/ol/li"), "Upload Attachments");
		log.info("List<WebElement> attachmentsList size "+attachmentsList.size());
		for(int i=0; i<attachmentsList.size(); i++){
			int x = i+1;
			//WebElement lnkattachment = extendedWebElement.elementLocator("/html/body/div[4]/div[4]/div/ui-view/div/div[2]/div[4]/div[2]/div/div[1]/tahaluf-attachments-viewer/ol/li["+x+"]/span[4]","xpath", "Upload Attachment");
			WebElement lnkattachment = extendedWebElement.elementLocator(By.xpath("/html/body/div[4]/div[4]/div/ui-view/div/div[2]/div[4]/div[2]/div/div[1]/tahaluf-attachments-viewer/ol/li["+x+"]/span[4]"), "Upload Attachment");
			extendedWebElement.clickOnElement(lnkattachment, "Attachment # "+i);
			// lnkattachment.click();
			uploadAttachmentRobot();
			log.info("Attachment Number("+x+")has been uploaded");
		}
	}
	
	public void clickNextButton() {
		WebElement btnNextInAttachmentsStep = extendedWebElement.elementLocator(By.xpath("//button[@type='button' and @ng-click='next()' and @name='btnNext']"), "btnNext");
		// btnNext.click();
		extendedWebElement.clickOnElement(btnNextInAttachmentsStep, "btnNextInAttachmentsStep");
		log.info("Click on next button in the attachment step");
	}
}