package logInTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import baseClass.WebUI;
import helper.EnumHelper.Result;
import helper.AssertionHelper;
import logIn.LogIn;

public class LogInTest extends BaseClass{
	public static final Logger log = Logger.getLogger(LogInTest.class.getName());
	BaseClass baseClass = new BaseClass();
	LogIn logIn ;
		
	@BeforeClass
	public void LogIn(){
		log.info("**********************Start Work Visa LogIn Step Class*****************************");
		setPageWait(10, TimeUnit.SECONDS);
		logIn = new LogIn();
		//waitUntilTheLoadingFlagGetHidden();
	}

	@Test(priority=1)
	public void LogInApply(){
		Result emailResult = WebUI.setText(WebUI.findTestObject(By.xpath("/html/body/div[4]/div[3]/ui-view/div[2]/div[3]/div[2]/div[2]/div[1]/div[5]/form/div[1]/input"), "txtEmail"), "federalgovernment.echannels@gmail.com", "txtEmail");
		Result passwordResult = WebUI.setText(WebUI.findTestObject(By.xpath("/html/body/div[4]/div[3]/ui-view/div[2]/div[3]/div[2]/div[2]/div[1]/div[5]/form/div[2]/input"), "txtPassword"), "Test@1234", "txtPassword");
		Result loginButtonResult = WebUI.clickOnElement(WebUI.findTestObject(By.xpath("/html/body/div[4]/div[3]/ui-view/div[2]/div[3]/div[2]/div[2]/div[1]/div[5]/form/div[4]/div[1]/button"), "btnSubmit"), "btnSubmit");
		
		AssertionHelper.makeTrue(emailResult);
		AssertionHelper.makeTrue(passwordResult);
		AssertionHelper.makeTrue(loginButtonResult);
	}
	
	@Test(priority=0)
	public void LogInVerifyElementAttribute(){
		WebUI.verifyElementAttributeValue(WebUI.findTestObject(By.xpath("/html/body/div[4]/div[3]/ui-view/div[2]/div[3]/div[2]/div[2]/div[1]/div[5]/form/div[1]/input"), "txtEmail"), "name", "txtEmail");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@Test(priority=0)
	public void checkEmailPresent(){
		//log.info("Check Email is Present");
		boolean isEmailPresent = logIn.checkElementIsPresent("txtEmail");
		Assert.assertTrue(isEmailPresent);
		log.info("The Email field present in the form is ("+ isEmailPresent + ")");
	}
	
	@Test(priority=0)
	public void checkPasswordPresent(){
		log.info("Check Password is Present");
		boolean isPasswordPresent = logIn.checkElementIsPresent("txtPassword");
		Assert.assertTrue(isPasswordPresent);
		log.info("The Email field present in the form is ("+ isPasswordPresent + ")");
	}
	
	@Test(priority=0)
	public void checkLogInButtonPresent(){
		log.info("Check LogIn Button is Present");
		boolean isLogInButton = logIn.checkElementIsPresent("btnSubmit");
		Assert.assertTrue(isLogInButton);
		log.info("The LogIn Button present in the form is ("+ isLogInButton + ")");
	}
	
	@Test(priority=1, dependsOnMethods={"checkEmailPresent","checkPasswordPresent","checkLogInButtonPresent"})
	*/
	
	
	
	
	
	/*
	@Test(priority=1)
	public void checkEmailProperties(){
		log.info("Check Email Properties");
		
		String txtEmailType = logIn.getElementProperty("type", "txtEmail");
		
		AssertionHelper.checkEqual(txtEmailType, "text");
		// Assert.assertEquals(txtEmailType, "text", "Faild!, because the actual type is "+txtEmailType+", but the expecte is text");
		log.info("The Email field type is ("+ txtEmailType + ")");
		
		String txtEmailClass = logIn.getElementProperty("class", "txtEmail");
		AssertionHelper.checkEqual(txtEmailClass, "form-control ng-pristine ng-untouched ng-empty ng-valid-maxlength ng-invalid ng-invalid-validation");
		//Assert.assertEquals(txtEmailClass, "form-control ng-pristine ng-untouched ng-empty ng-valid-maxlength ng-invalid ng-invalid-validation", "Faild!, because the actual class is "+txtEmailClass+", but the expecte is form-control ng-pristine ng-empty ng-valid-maxlength ng-invalid ng-invalid-validation ng-touched");
		log.info("The Email field class is ("+ txtEmailClass + ")");
		
		String txtEmailName = logIn.getElementProperty("name", "txtEmail");
		AssertionHelper.checkEqual(txtEmailName, "txtEmail");
		//Assert.assertEquals(txtEmailName, "txtEmail", "Faild!, because the actual name is "+txtEmailName+", but the expecte txtEmail ");
		log.info("The Email field name is ("+ txtEmailName + ")");
	}
	
	
	@Test(priority=2)
	public void checkPasswordProperties(){
		log.info("check Password Properties");
		
		String txtPasswordMaxlength = logIn.getElementProperty("maxlength", "txtPassword");
		AssertionHelper.checkEqual(txtPasswordMaxlength, "100");
		
		String txtPasswordType = logIn.getElementProperty("type", "txtPassword");
		AssertionHelper.checkEqual(txtPasswordType, "password");
		
		String txtPasswordClass = logIn.getElementProperty("class", "txtPassword");
		AssertionHelper.checkEqual(txtPasswordClass, "form-control ng-pristine ng-untouched ng-empty ng-valid-maxlength ng-invalid ng-invalid-validation");
	}
	
	@Test(priority=3)
	public void checkLogInButonProperties(){
		log.info("check Buton Properties");
		
		String btnSubmitType = logIn.getElementProperty("type", "btnSubmit");
		AssertionHelper.checkEqual(btnSubmitType, "submit");
		
		String btnSubmitClass = logIn.getElementProperty("class", "btnSubmit");
		AssertionHelper.checkEqual(btnSubmitClass, "btn btn-lg btn-danger bg-gd-dk pull-right ng-binding");
	}
	
	@Test(priority=4)
	public void insertEmail(){
		Result insertEmailresult = logIn.insertEmail("federalgovernment.echannels@gmail.com");
		AssertionHelper.makeTrue(insertEmailresult);
		log.info("Email insertd");
	}
	
	@Test(priority=5)
	public void insertPassword(){
		Result insertPasswordresult = logIn.insertPassword("Test@1234");
		AssertionHelper.makeTrue(insertPasswordresult);
		log.info("Password insertd");
	}
	
	@Test(priority=6)
	public void clickSubmit(){
		Result clickSubmitresult = logIn.clickSubmit();
		AssertionHelper.makeTrue(clickSubmitresult);
		log.info("Submit button clicked");
	}
	
	
	@Test(priority=7)
	public void closeAdBoxTC() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("Call the method waitUntilTheLoadingFlagGetHidden inside the method closeAdBox");
		logIn.waitUntilTheLoadingFlagGetHidden();
		logIn.closeAdBox();
		log.info("closeAdBoxTC Method has been called");
	}
	*/
	
	
	
	/*
	@Test(priority=6)
	public void checkLogInSUccessfully(){
		if(logIn.checkLogOutLinkAvailable() == true){
			Assert.assertTrue(true);
		}else{
			Assert.assertFalse(true);
		}
	}
	*/
	
	@AfterClass
	public void tearLogInPage(){
		log.info("**********************Tear Down Login Page Step Class*****************************");
	}
}
