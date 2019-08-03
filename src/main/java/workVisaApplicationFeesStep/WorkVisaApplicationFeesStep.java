package workVisaApplicationFeesStep;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import helper.ExtendedWebElement;

public class WorkVisaApplicationFeesStep extends BaseClass{
	public static final Logger log = Logger.getLogger(WorkVisaApplicationFeesStep.class.getName());
	ExtendedWebElement extendedWebElement;
	
	public WorkVisaApplicationFeesStep(){
		log.info("**********************Start Work Visa Addresses Info Step Class*****************************");
		extendedWebElement = new ExtendedWebElement(driver);
	}
	
	public void clickOnAgreeCheckBox(){
		WebElement checkBoxAgree = extendedWebElement.elementLocator(By.xpath("//input[@Type='checkbox' and @ng-model='termsAccepted']"),"CheckBoxAgree");
		extendedWebElement.clickOnElement(checkBoxAgree, "checkBoxAgree");
	}
	
	public void clickOnAmwalWallet(){
		WebElement buttonAmwalWallet = extendedWebElement.elementLocator(By.xpath("//button[@title='eWALLET']"),"buttonAmwalWallet");
		extendedWebElement.clickOnElement(buttonAmwalWallet, "buttonAmwalWallet");
	}
	
	public void checkAccountNameDropDownListAmount(){
		// extendedWebElement.tahalufDropDownListSelect(byListElement, byFilteredElement, elementVariableName);
	}
	
	public void clickOnPayButton(){
		WebElement buttonPay = extendedWebElement.elementLocator(By.xpath("//button[@title='Pay']"),"buttonPay");
		extendedWebElement.clickOnElement(buttonPay, "buttonPay");
	}
}
