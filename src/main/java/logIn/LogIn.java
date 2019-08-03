package logIn;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import helper.EnumHelper.Result;
import helper.ExtendedWebElement;

public class LogIn extends BaseClass{
	
	ExtendedWebElement extendedWebElement = new ExtendedWebElement(driver);
	public static final Logger log = Logger.getLogger(LogIn.class.getName());

	WebElement txtEmail    = extendedWebElement.elementLocator(By.xpath("/html/body/div[4]/div[3]/ui-view/div[2]/div[3]/div[2]/div[2]/div[1]/div[5]/form/div[1]/input"), "txtEmail");
	WebElement txtPassword = extendedWebElement.elementLocator(By.xpath("/html/body/div[4]/div[3]/ui-view/div[2]/div[3]/div[2]/div[2]/div[1]/div[5]/form/div[2]/input"), "txtPassword");
	WebElement btnSubmit   = extendedWebElement.elementLocator(By.xpath("/html/body/div[4]/div[3]/ui-view/div[2]/div[3]/div[2]/div[2]/div[1]/div[5]/form/div[4]/div[1]/button"), "btnSubmit");

	public LogIn(){
		log.info("**********************Start LogIn Class*****************************");
	}
	
	public void closeAdBox(){
		closeAdBoxBC();
	}
	
	public String getElementProperty(String propertyType, String elementName){
		String ElementPropertyResult = null;
		if(elementName.equalsIgnoreCase("txtEmail")){
			ElementPropertyResult = getElementProperty(txtEmail, propertyType, elementName);
		}else if(elementName.equalsIgnoreCase("txtPassword")){
			ElementPropertyResult = getElementProperty(txtPassword, propertyType, elementName);
		}else if(elementName.equalsIgnoreCase("btnSubmit")){
			ElementPropertyResult = getElementProperty(btnSubmit, propertyType, elementName);
		}
		return ElementPropertyResult;
	}
	
	public boolean checkLogOutInButtonNotAvailable(){
		return btnSubmit.isEnabled();
	}
	
	public boolean checkLogOutLinkAvailable(){
		WebElement lnkLogOut = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/div[1]/ul/li[5]/a"));
		return lnkLogOut.isDisplayed();
	}
	
	public boolean checUaserNameAvailable(){
		WebElement lnkUserName = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/div[1]/ul/li[4]/a"));
		return lnkUserName.isDisplayed();
	}
	
	public boolean checkElementIsPresent(String elementName){
		if(elementName.equalsIgnoreCase("txtEmail")){
			return checkElementIsPresent(txtEmail);
		}else if(elementName.equalsIgnoreCase("txtPassword")){
			return checkElementIsPresent(txtPassword);
		}else if(elementName.equalsIgnoreCase("btnSubmit")){
			return checkElementIsPresent(btnSubmit);
		}
		return false;
	}
	
	public Result insertEmail(String value){
		Result result = extendedWebElement.insertDataIntoElement(txtEmail, value, "txtEmail");
		return result;
		// txtEmail.sendKeys(value);
		// test.log(LogStatus.INFO, "insert Email");
	}
	
	public Result insertPassword(String value){
		Result result = extendedWebElement.insertDataIntoElement(txtPassword, value, "txtPassword");
		return result;
		//txtPassword.sendKeys(value);
	}
	
	public Result clickSubmit(){
		Result result = extendedWebElement.clickOnElement(btnSubmit, "btnSubmit");
		return result;
		//btnSubmit.click();
	}
}
