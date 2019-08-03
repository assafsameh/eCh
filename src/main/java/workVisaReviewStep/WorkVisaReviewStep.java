package workVisaReviewStep;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import helper.ExtendedWebElement;

public class WorkVisaReviewStep extends BaseClass {
	final Logger log = Logger.getLogger(WorkVisaReviewStep.class.getName());
	ExtendedWebElement extendedWebElement;

	public WorkVisaReviewStep() {
		log.info("**********************Start Work Visa Review Step Class*****************************");
		extendedWebElement = new ExtendedWebElement(driver);
	}

	public void clickOnNexuButton() {
		WebElement buttonNextInReviewStep = extendedWebElement.elementLocator(By.xpath("//button[@type='button' and @ng-click='goToNextStep()']"), "Next Button");
		extendedWebElement.clickOnElement(buttonNextInReviewStep, "buttonNextInReviewStep");
		// buttonNextInReviewStep.click();
	}
}