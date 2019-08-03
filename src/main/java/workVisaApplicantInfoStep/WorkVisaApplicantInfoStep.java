package workVisaApplicantInfoStep;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import helper.ExtendedWebElement;

public class WorkVisaApplicantInfoStep extends BaseClass{
	
	public static final Logger log = Logger.getLogger(WorkVisaApplicantInfoStep.class.getName());
	ExtendedWebElement extendedWebElement;
	
	WebElement buttonUploadBox ;
	WebElement buttonCropImage;
	WebElement textFullNameEnglish;
	WebElement textFullNameArabic;
	WebElement textDOB;
	WebElement textPlaceOfBirthEnglish;
	WebElement textPlaceOfBirthArabic;
	WebElement textMotherNameEnglish;
	WebElement textMotherNameArabic;
	WebElement textEducationLevelDetails;
	WebElement textVisitReason;
	WebElement textPassportNo;
	WebElement textPassportIssueDate;
	WebElement textPassportExpireDate;
	WebElement textPassportIssuePlaceEnglish;
	WebElement textPassportIssuePlaceArabic;

	public WorkVisaApplicantInfoStep(){
		log.info("**********************Start Work Visa Applicant Info Step Class*****************************");
		extendedWebElement = new ExtendedWebElement(driver);
	}

	public void uploadPassportAttachment(){
		waitUntilTheLoadingFlagGetHidden();
		buttonUploadBox = extendedWebElement.elementLocator(By.xpath("/html/body/div[4]/div[4]/div/ui-view/div/div[2]/div[4]/div[2]/form/div[1]/div[3]/div[3]/div/button"), "buttonUploadBox");
		extendedWebElement.clickOnElement(buttonUploadBox, "buttonUploadBox");
		log.info("Upload Box has been clicked");
		waitUntilTheLoadingFlagGetHidden();
		uploadAttachmentRobot();
		log.info("Passport image has been choosen");
		waitUntilTheLoadingFlagGetHidden();
		buttonCropImage = extendedWebElement.elementLocator(By.xpath("/html/body/div[4]/div[4]/div/ui-view/div/div[2]/div[4]/div[2]/form/div[1]/div[3]/div[1]/tahaluf-image-crop/div[2]/div/div/div[7]/button"), "buttonCropImage");
		waitUntilTheLoadingFlagGetHidden();
		extendedWebElement.clickOnElement(buttonCropImage, "buttonCropImage");
		log.info("Crop Image button uploaded");
	}
	
	public void insertFullNameEnglish(String FullNameEnglish) {
		textFullNameEnglish = elementLocator(By.xpath("//input[@name='englishName' and @ng-model='draft.request.englishName']"), "textFullNameEnglish");
		//textFullNameEnglish.click();
		//textFullNameEnglish.clear();
		//textFullNameEnglish.sendKeys(FullNameEnglish);
		extendedWebElement.insertDataIntoElement(textFullNameEnglish, FullNameEnglish, "textFullNameEnglish");
	}

	public void insertFullNameArabic(String FullNameArabic) {
		textFullNameArabic = elementLocator(By.xpath("//input[@name='arabicName' and @ng-model='draft.request.arabicName']"), "textFullNameArabic");
		//textFullNameArabic.click();
		//textFullNameArabic.clear();
		//textFullNameArabic.sendKeys(FullNameArabic);
		extendedWebElement.insertDataIntoElement(textFullNameArabic, FullNameArabic, "textFullNameArabic");
	}

	public void insertCurrentNationality(String CurrentNationality) {
		//Current Nationality drop down list
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='currentNationality' and @ng-model='draft.request.currentNationalityId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='currentNationality' and @ng-model='draft.request.currentNationalityId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='currentNationality' and @ng-model='draft.request.currentNationalityId']/div[1]/div/div/ul/li/ul/li/div"), CurrentNationality, "Current Nationality");
	}
	
	public void insertDateOfBirth(String DateOfBirth) {
		textDOB = elementLocator(By.xpath("//input[@name='dateOfBirth' and @ng-model='draft.request.dateOfBirth']"), "textDOB");
		//textDOB.click();
		//textDOB.clear();
		//textDOB.sendKeys("10/03/1987");
		extendedWebElement.insertDataIntoElement(textDOB, DateOfBirth, "textDOB");
	}
	
	public void insertGender(String Gender) {
		//Gender drop down list
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='gender' and @ng-model='draft.request.genderId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='gender' and @ng-model='draft.request.genderId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='gender' and @ng-model='draft.request.genderId']/div[1]/div/div/ul/li/ul/li/div"), Gender, "Gender");
	}
	
	public void insertBirthCountry(String BirthCountry) {
		//Birth Country drop down list
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='countryOfBirth' and @ng-model='draft.request.countryOfBirthId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='countryOfBirth' and @ng-model='draft.request.countryOfBirthId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='countryOfBirth' and @ng-model='draft.request.countryOfBirthId']/div[1]/div/div/ul/li/ul/li/div"), BirthCountry, "Birth Country drop down list");
	}
	
	public void insertMaritalStatus(String MaritalStatus) {
		//Marital Status drop down list
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='maritalStatus' and @ng-model='draft.request.maritalStatusId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='maritalStatus' and @ng-model='draft.request.maritalStatusId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='maritalStatus' and @ng-model='draft.request.maritalStatusId']/div[1]/div/div/ul/li/ul/li/div"), MaritalStatus, "Marital Status drop down list");
	}
	
	public void insertPlaceOfBirthEnglish(String PlaceOfBirthEnglish) {
		textPlaceOfBirthEnglish = elementLocator(By.xpath("//input[@name='englishPlaceOfBirth' and @ng-model='draft.request.englishPlaceOfBirth']"), "textPlaceOfBirthEnglish");
		//textPlaceOfBirthEnglish.click();
		//textPlaceOfBirthEnglish.clear();
		//textPlaceOfBirthEnglish.sendKeys(PlaceOfBirthEnglish);
		extendedWebElement.insertDataIntoElement(textPlaceOfBirthEnglish, PlaceOfBirthEnglish, "textPlaceOfBirthEnglish");
	}

	public void insertPlaceOfBirthArabic(String PlaceOfBirthArabic) {
		textPlaceOfBirthArabic = elementLocator(By.xpath("//input[@name='arabicPlaceOfBirth' and @ng-model='draft.request.arabicPlaceOfBirth']"), "textPlaceOfBirthArabic");
		//textPlaceOfBirthArabic.click();
		//textPlaceOfBirthArabic.clear();
		//textPlaceOfBirthArabic.sendKeys(PlaceOfBirthArabic);
		extendedWebElement.insertDataIntoElement(textPlaceOfBirthArabic, PlaceOfBirthArabic, "textPlaceOfBirthArabic");
	}

	public void insertMotherNameEnglish(String MotherNameEnglish) {
		textMotherNameEnglish = elementLocator(By.xpath("//input[@name='englishMotherName' and @ng-model='draft.request.motherEnglishName']"), "textMotherNameEnglish");
		//textMotherNameEnglish.click();
		//textMotherNameEnglish.clear();
		//textMotherNameEnglish.sendKeys(MotherNameEnglish);
		extendedWebElement.insertDataIntoElement(textMotherNameEnglish, MotherNameEnglish, "textMotherNameEnglish");
	}

	public void insertMotherNameArabic(String MotherNameArabic) {
		textMotherNameArabic = elementLocator(By.xpath("//input[@name='arabicMotherName' and @ng-model='draft.request.motherArabicName']"), "textMotherNameArabic");
		//textMotherNameArabic.click();
		//textMotherNameArabic.clear();
		//textMotherNameArabic.sendKeys(MotherNameArabic);
		extendedWebElement.insertDataIntoElement(textMotherNameArabic, MotherNameArabic, "textMotherNameArabic");
	}

	public void insertReligion(String ReligionString) {
		//Religion drop down list
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='religion' and @ng-model='draft.request.religionId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='religion' and @ng-model='draft.request.religionId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='religion' and @ng-model='draft.request.religionId']/div[1]/div/div/ul/li/ul/li/div"), ReligionString, "Religion drop down list");	
	}

	public void insertFaith(String Faith) {
		//Faith drop down list
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='faith' and @ng-model='draft.request.faithId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='faith' and @ng-model='draft.request.faithId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='faith' and @ng-model='draft.request.faithId']/div[1]/div/div/ul/li/ul/li/div"), Faith, "Faith drop down list");
	}

	public void insertQualification(String Qualification) {
		//Qualification drop down list
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='educationLevel' and @ng-model='draft.request.educationLevelId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='educationLevel' and @ng-model='draft.request.educationLevelId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='educationLevel' and @ng-model='draft.request.educationLevelId']/div[1]/div/div/ul/li/ul/li/div"), Qualification, "Qualification drop down list");
	}
	
	public void insertWorkType(String WorkType) {
		//Qualification drop down list
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='workType' and @ng-model='draft.request.workTypeId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='workType' and @ng-model='draft.request.workTypeId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='workType' and @ng-model='draft.request.workTypeId']/div[1]/div/div/ul/li/ul/li/div"), WorkType, "WorkType drop down list");
	}
	
	public void insertProfessions(String Professions) {
		//Professions drop down list
		// tahalufProfessionsDropDownList(By.xpath("//tahaluf-dropdownlist[@name='professions' and @ng-model='draft.request.professionId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='professions' and @ng-model='draft.request.professionId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='professions' and @ng-model='draft.request.professionId']/div[1]/div/div/ul/li/ul/li[1]/div"), Professions, "Professions drop down list");	
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='professions' and @ng-model='draft.request.professionId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='professions' and @ng-model='draft.request.professionId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='professions' and @ng-model='draft.request.professionId']/div[1]/div/div/ul/li/ul/li[1]/div"), Professions, "Professions drop down list");
	}

	public void insertEducationLevelCountry() {
		//Education Level Country drop down list
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='educationLevelCountry' and @ng-model='draft.request.educationLevelCountryId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='educationLevelCountry' and @ng-model='draft.request.educationLevelCountryId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='educationLevelCountry' and @ng-model='draft.request.educationLevelCountryId']/div[1]/div/div/ul/li/ul/li/div"), "JORDAN", "Education Level Country drop down list");
	}
	
	public void insertEducationLevelDetails(String EducationLevelDetails) {
		textEducationLevelDetails = elementLocator(By.xpath("//input[@name='educationLevelDetails' and @ng-model='draft.request.educationLevelDetails']"), "textEducationLevelDetails");
		//textEducationLevelDetails.click();
		//textEducationLevelDetails.clear();
		//textEducationLevelDetails.sendKeys(EducationLevelDetails);
		extendedWebElement.insertDataIntoElement(textEducationLevelDetails, EducationLevelDetails, "textEducationLevelDetails");
	}
	
	public void insertVisitReason(String VisitReason) {
		textVisitReason = elementLocator(By.xpath("//input[@name='vistReason' and @ng-model='draft.request.vistReason']"), "textVisitReason");
		//textVisitReason.click();
		//textVisitReason.clear();
		//textVisitReason.sendKeys(VisitReason);
		extendedWebElement.insertDataIntoElement(textVisitReason, VisitReason, "textVisitReason");
	}

	public void insertPassportType(String PassportType) {
		//Passport Type drop down list
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='passportType' and @ng-model='draft.request.passportTypeId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='passportType' and @ng-model='draft.request.passportTypeId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='passportType' and @ng-model='draft.request.passportTypeId']/div[1]/div/div/ul/li/ul/li/div"), PassportType, "Passport Type drop down list");
	}

	public void insertPassportNo(String PassportNo) {
		textPassportNo = elementLocator(By.xpath("//input[@name='passportNo' and @ng-model='draft.request.passportNumber']"), "textPassportNo");
		//textPassportNo.click();
		//textPassportNo.clear();
		//textPassportNo.sendKeys(PassportNo);
		extendedWebElement.insertDataIntoElement(textPassportNo, PassportNo, "textPassportNo");
	}

	public void insertPassportIssueDate(String PassportIssueDate) {
		textPassportIssueDate = elementLocator(By.xpath("//input[@name='passportIssueDate' and @ng-model='draft.request.passportIssueDate']"), "textPassportIssueDate");
		//textPassportIssueDate.click();
		//textPassportIssueDate.clear();
		//textPassportIssueDate.sendKeys("10/03/2018");
		extendedWebElement.insertDataIntoElement(textPassportIssueDate, PassportIssueDate, "textPassportIssueDate");
	}
	
	public void insertPassportExpiryDate(String PassportExpireDate) {
		textPassportExpireDate = elementLocator(By.xpath("//input[@name='passportExpireDate' and @ng-model='draft.request.passportExpiryDate']"), "textPassportExpireDate");
		//textPassportExpireDate.click();
		//textPassportExpireDate.clear();
		//textPassportExpireDate.sendKeys("10/03/2022");
		extendedWebElement.insertDataIntoElement(textPassportExpireDate, PassportExpireDate, "textPassportExpireDate");
	}

	public void insertPassportIssuePlaceEnglish(String PassportIssuePlaceEnglish) {
		textPassportIssuePlaceEnglish = elementLocator(By.xpath("//input[@name='englishPassportIssuePlace' and @ng-model='draft.request.passportEnglishIssuePlace']"), "textPassportIssuePlaceEnglish");
		//textPassportIssuePlaceEnglish.click();
		//textPassportIssuePlaceEnglish.clear();
		//textPassportIssuePlaceEnglish.sendKeys(PassportIssuePlaceEnglish);
		extendedWebElement.insertDataIntoElement(textPassportIssuePlaceEnglish, PassportIssuePlaceEnglish, "textPassportIssuePlaceEnglish");
	}

	public void insertPassportIssuePlaceArabic(String PassportIssuePlaceArabic) {
		textPassportIssuePlaceArabic = elementLocator(By.xpath("//input[@name='arabicPassportIssuePlace' and @ng-model='draft.request.passportArabicIssuePlace']"), "textPassportIssuePlaceArabic");
		// textPassportIssuePlaceArabic.click();
		//textPassportIssuePlaceArabic.clear();
		//textPassportIssuePlaceArabic.sendKeys(PassportIssuePlaceArabic);
		extendedWebElement.insertDataIntoElement(textPassportIssuePlaceArabic, PassportIssuePlaceArabic, "textPassportIssuePlaceArabic");
	}

	public void insertPassportIssueCountry(String PassportIssueCountry) {
		// Passport Issue Country drop down list 
		extendedWebElement.tahalufDropDownList(By.xpath("//tahaluf-dropdownlist[@name='passportCountry' and @ng-model='draft.request.passportCountryId']/div[1]/div/a"), By.xpath("//tahaluf-dropdownlist[@name='passportCountry' and @ng-model='draft.request.passportCountryId']/div[1]/div/div/div[1]/input"), By.xpath("//tahaluf-dropdownlist[@name='passportCountry' and @ng-model='draft.request.passportCountryId']/div[1]/div/div/ul/li/ul/li/div"), PassportIssueCountry, "Passport Issue Country drop down list");
	}

	public void clickNextButton() {
		//Click on the next button element
		WebElement buttonNext = extendedWebElement.elementLocator(By.xpath("//button[@type='button' and @ng-click='saveRequestDraft()']"), "buttonNext");
		extendedWebElement.clickOnElement(buttonNext, "buttonNext");
		extendedWebElement.clickOnElement(buttonNext, "buttonNext");
	}
}
