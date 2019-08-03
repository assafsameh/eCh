package workVisaApplicantInfoStepTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import workVisaApplicantInfoStep.WorkVisaApplicantInfoStep;

public class WorkVisaApplicantInfoStepTest extends BaseClass{
	public static final Logger log = Logger.getLogger(WorkVisaApplicantInfoStepTest.class.getName());

	WorkVisaApplicantInfoStep workVisaApplicantInfoStep ;
	
	@BeforeClass
	public void initWorkVisaApplicantInfoStep(){	
		workVisaApplicantInfoStep = new WorkVisaApplicantInfoStep();
		setPageWait(10, TimeUnit.SECONDS);
	}
	
	@DataProvider(name="workVisaData")
	public String[][] getWorkVisaData(){
		String[][] data = getData("eChannels-data.xlsx", "WorkVisa");
		return data;
	}	
	
	@Test(priority = 8,dataProvider="workVisaData", description = "fill Out Applicant Info Step of Work Visa")
	public void insertDataApplicantInfoStep(String FullNameEnglish, String FullNameArabic, String CurrentNationality, String Gender, String DateOfBirth, String BirthCountry, String MaritalStatus, String PlaceOfBirthEnglish, String PlaceOfBirthArabic, String MotherNameEnglish, String MotherNameArabic, String ReligionString, String Faith, String Qualification, String WorkType, String Professions, String VisitReason, String PassportType, String PassportNo, String PassportIssueDate, String PassportExpireDate, String PassportIssuePlaceEnglish, String PassportIssuePlaceArabic, String PassportIssueCountry){
		sleep(20);
		workVisaApplicantInfoStep.uploadPassportAttachment();
		workVisaApplicantInfoStep.insertFullNameEnglish(FullNameEnglish);
		workVisaApplicantInfoStep.insertFullNameArabic(FullNameArabic);
		workVisaApplicantInfoStep.insertCurrentNationality(CurrentNationality);
		workVisaApplicantInfoStep.insertDateOfBirth(DateOfBirth);
		workVisaApplicantInfoStep.insertGender(Gender);
		workVisaApplicantInfoStep.insertBirthCountry(BirthCountry);
		workVisaApplicantInfoStep.insertMaritalStatus(MaritalStatus);
		workVisaApplicantInfoStep.insertPlaceOfBirthEnglish(PlaceOfBirthEnglish);
		workVisaApplicantInfoStep.insertPlaceOfBirthArabic(PlaceOfBirthArabic);
		workVisaApplicantInfoStep.insertMotherNameEnglish(MotherNameEnglish);
		workVisaApplicantInfoStep.insertMotherNameArabic(MotherNameArabic);
		workVisaApplicantInfoStep.insertReligion(ReligionString);
		workVisaApplicantInfoStep.insertFaith(Faith);
		workVisaApplicantInfoStep.insertQualification(Qualification);
		workVisaApplicantInfoStep.insertWorkType(WorkType);
		workVisaApplicantInfoStep.insertProfessions(Professions);
		//workVisaApplicantInfoStep.insertEducationLevelCountry(EducationLevelCountry);
		//workVisaApplicantInfoStep.insertEducationLevelDetails(EducationLevelDetails);
		workVisaApplicantInfoStep.insertVisitReason(VisitReason);
		workVisaApplicantInfoStep.insertPassportType(PassportType);
		workVisaApplicantInfoStep.insertPassportNo(PassportNo);
		workVisaApplicantInfoStep.insertPassportIssueDate(PassportIssueDate);
		workVisaApplicantInfoStep.insertPassportExpiryDate(PassportExpireDate);
		workVisaApplicantInfoStep.insertPassportIssuePlaceEnglish(PassportIssuePlaceEnglish);
		workVisaApplicantInfoStep.insertPassportIssuePlaceArabic(PassportIssuePlaceArabic);
		workVisaApplicantInfoStep.insertPassportIssueCountry(PassportIssueCountry);
		workVisaApplicantInfoStep.clickNextButton();
		
		//waitUntilTheLoadingFlagGetHidden();
	}

	/*
	@Test(priority = 10, description = "fill Out Attachment Step of Work Visa")
	public void insertDataInStepThree(){
		
	}
	
	@Test(priority = 11, description = "Review Step of Work Visa")
	public void insertDataInStepFour(){
		
	}
	
	@Test(priority = 12, description = "fill Out Payment Step of Work Visa")
	public void insertDataInStepFour(){
		
	}
	
	*/
	
	@AfterClass
	public void tearDownWorkVisaApplicantInfoStep(){	
		log.info("**********************Tear Down Work Visa Addresses Info Step Class*****************************");
	}
}
