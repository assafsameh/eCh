package workVisaAddressesInfoStep;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import helper.ExtendedWebElement;
import workVisaApplicantInfoStep.WorkVisaApplicantInfoStep;

public class WorkVisaAddressesInfoStep extends BaseClass{
	public static final Logger log = Logger.getLogger(WorkVisaApplicantInfoStep.class.getName());
	ExtendedWebElement extendedWebElement;
	
	public WorkVisaAddressesInfoStep(){
		log.info("**********************Start Work Visa Addresses Info Step Class*****************************");
		extendedWebElement = new ExtendedWebElement(driver);
	}
	
	public void insertLocationinsideUAE() {
		WebElement txtlocationinsideUAE = extendedWebElement.elementLocator(By.xpath("//input[@name='localDetailedAddress' and @ng-model='detailedAddress']"),"txtlocationinsideUAE");
		//txtlocationinsideUAE.sendKeys("Al Reem Island");
		extendedWebElement.insertDataIntoElement(txtlocationinsideUAE, "Al Reem Island", "txtlocationinsideUAE");
	}

	public void insertEmirateDropDownList() {
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='localEmirate' and @ng-model='emirateId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='localEmirate' and @ng-model='emirateId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='localEmirate' and @ng-model='emirateId']/div[1]/div/div/ul/li/ul/li/div"), "ABU DHABI", "Emirate Drop Down List");
	}

	public void insertCityDropDownList() {
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='localCity' and @ng-model='cityId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='localCity' and @ng-model='cityId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='localCity' and @ng-model='cityId']/div[1]/div/div/ul/li/ul/li/div"), "ABU DHABI", "City Drop Down List");
	}

	public void insertLocalBuilding() {
		WebElement txtLocalBuilding = extendedWebElement.elementLocator(By.xpath("//input[@name='localBuildingName' and @ng-model='draft.request.buildingName']"),"txtLocalBuilding");
		//txtLocalBuilding.sendKeys("Horizon Tower");
		extendedWebElement.insertDataIntoElement(txtLocalBuilding, "Horizon Tower", "txtLocalBuilding");
	}

	public void insertLocalFlatNumber() {
		WebElement txtLocalFlatNumber = extendedWebElement.elementLocator(By.xpath("//input[@name='localFlatNumber' and @ng-model='draft.request.flatNumber']"),"txtLocalFlatNumber");
		// txtLocalFlatNumber.sendKeys("2008");
		extendedWebElement.insertDataIntoElement(txtLocalFlatNumber, "2008", "txtLocalFlatNumber");
	}

	public void insertUAEPhoneNumber() {
		WebElement txtUAEPhoneNumber = extendedWebElement.elementLocator(By.xpath("//input[@name='uaePhoneNumber' and @ng-model='draft.request.localHomePhone']"),"txtUAEPhoneNumber");
		//txtUAEPhoneNumber.sendKeys("503597414");
		extendedWebElement.insertDataIntoElement(txtUAEPhoneNumber, "503597414", "txtUAEPhoneNumber");
	}

	public void insertPermanentMobileNumber() {
		WebElement txtPermanentMobileNumber = extendedWebElement.elementLocator(By.xpath("//input[@name='MobileNumber' and @ng-model='draft.request.abroadPhone']"),"txtPermanentMobileNumber");
		// txtPermanentMobileNumber.sendKeys("250359741");
		extendedWebElement.insertDataIntoElement(txtPermanentMobileNumber, "250359741", "txtPermanentMobileNumber");
	}

	public void insertPermanentCountryDropDownList() {
		// Permanent Country  drop down list
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='residencyCountry' and @ng-model='draft.request.abroadCountryId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='residencyCountry' and @ng-model='draft.request.abroadCountryId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='residencyCountry' and @ng-model='draft.request.abroadCountryId']/div[1]/div/div/ul/li/ul/li/div"),"JORDAN", "Permanent Country  drop down list");	
	}

	public void insertEmail() {
		WebElement txtEmail = extendedWebElement.elementLocator(By.xpath("//input[@name='email' and @ng-model='draft.request.emailAddress']"), "txtEmail");
		// txtEmail.sendKeys("s.assaf@tahaluf.ae");
		extendedWebElement.insertDataIntoElement(txtEmail, "s.assaf@tahaluf.ae", "txtEmail");
	}

	public void insertApplicantlocationoutsideUAE() {
		WebElement txtApplicantlocationoutsideUAE = extendedWebElement.elementLocator(By.xpath("//input[@name='abroadAddressName' and @ng-model='draft.request.abroadAddress.name']"), "txtApplicantlocationoutsideUAE");
		txtApplicantlocationoutsideUAE.sendKeys("Amman");
		extendedWebElement.insertDataIntoElement(txtApplicantlocationoutsideUAE, "Amman", "txtApplicantlocationoutsideUAE");
	}

	public void clickNextButton() {
		//Click on the next button element
		WebElement btnNext = extendedWebElement.elementLocator(By.xpath("//button[@type='button' and @ng-click='addRequestDraft()' and @name='btnsaveAndClose']"), "btnNext");
		// btnNext.click();
		extendedWebElement.clickOnElement(btnNext, "btnNext");
	}
}
