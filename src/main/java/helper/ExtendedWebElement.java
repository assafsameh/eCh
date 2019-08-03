package helper;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import baseClass.BaseClass;
import helper.EnumHelper.Result;

public class ExtendedWebElement extends BaseClass{

	public static final Logger log = Logger.getLogger(ExtendedWebElement.class.getName());
	public WebDriver driver;
	public WebElement element;
	private static int waitTime = 30;

	public ExtendedWebElement(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement elementLocator(By by, String elementVariableName) {
		if (checkElementIsDisplayed(by, elementVariableName) == true) {
			WebElement element = driver.findElement(by);
			// waitForElementClickable(element, 2, elementVariableName);
			// Assert.assertTrue(true, "The " + elementVariableName + " is
			// Exist");
			return element;
		} else {
			// Assert.assertTrue(false, "The " + elementVariableName + " is NOT
			// Exist");
			return null;
		}
	}
	
	public List<WebElement> elementsLocator(By by, String elementVariableName) {
		int elapsedTime = 0;
		boolean retry = true;
		boolean result = false;
		List<WebElement> elements = null;
		do{
			elements = driver.findElements(by);
			if(!elements.isEmpty() && elements != null){
				retry = false;
				result = true;
			}else{
				retry = true;
				result = false;
			}
			
			if (result || elapsedTime >= waitTime) {
				retry = false;
			} else {
				retry = true;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				elapsedTime += 1;
			}
		}
		while(retry);
		return elements;
	}
	
	public Boolean checkElementIsDisplayed(By by, String elementVariableName) {
		int elapsedTime = 0;
		boolean retry = true;
		boolean result = false;
		do {
			try {
				List<WebElement> elements = driver.findElements(by);
				log.info("elements.size() "+elements.size());
				if (elements != null && !elements.isEmpty()) {
					if (elements.size() == 1) {
						result = true;
						retry = false;
						log.info("Finding webElement (" + elementVariableName + ") 1 time with " + by);
					} else if (elements.size() > 1) {
						result = true;
						retry = false;
						log.info("Finding webElement (" + elementVariableName + ") " + elements.size() + " times with "+ by);
					} else {
						log.info("The webElement (" + elementVariableName + ") is NOT present on the page");
						result = false;
						retry = true;
					}
				} else {
					result = false;
					retry = true;
					log.info("The element " + elementVariableName	+ ", is NOT present: Unable to find the element as the following exception happend, exception message = ");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			// if(result == Result.Passed || elapsedTime >= waitTime)
			if (result || elapsedTime >= waitTime) {
				retry = false;
			} else {
				retry = true;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				elapsedTime += 1;
			}
		} while (retry);
		return result;
	}

	public void waitForElementToBeClickable(WebElement element, int timeOutInSeconds, String elementVariableName) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		log.info("Waiting for " + elementVariableName + " to be Clickable for " + timeOutInSeconds + " seconds");
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is Clickable now");
	}

	public void waitForElementVisible(WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		log.info("Waiting for element to be visible for " + timeOutInSeconds + " seconds");
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("ELement is visible now");
	}

	public Result insertDataIntoElement(WebElement element, String Text, String elementVariableName) {
		int elapsedTime = 0;
		Result result = Result.Unknown;
		Boolean retry = true;
		do {
			try {
				if (element != null && element.isDisplayed()) {
					element.click();
					element.clear();
					element.sendKeys(Text);
					// result = Result.Passed;
					result = Result.Passed;
					log.info("Insert "+Text+" into " + elementVariableName + ", Passed: Data has been inserted into the Element successfully");
					test.log(LogStatus.INFO, "Insert "+Text+" into " + elementVariableName + ", Passed: Data has been inserted into the Element successfully");
				} else {
					// result = Result.Failed;
					result = Result.Failed;
					log.info("Insert "+Text+" into " + elementVariableName + ", FAILED: Data has NOT been inserted into the Element");
					test.log(LogStatus.INFO, "Insert "+Text+" into " + elementVariableName + ", FAILED: Data has NOT been inserted into the Element");
				}

			} catch (Exception e) {
				// result = Result.Failed;
				result = Result.Failed;
				log.info("Insert "+Text+" into " + elementVariableName + ", FAILED: Unable to Insert data into the element as the following exception happend, exception message = ");
				test.log(LogStatus.INFO, "Insert "+Text+" into " + elementVariableName + ", FAILED: Unable to Insert data into the element as the following exception happend, exception message = ");
			}

			if(result == Result.Passed || elapsedTime >= waitTime){
				retry = false;
			} else {
				retry = true;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				elapsedTime += 1;
			}
		} while (retry);

		if(result.equals(Result.Passed)){
			return Result.Passed;
		}else if(result.equals(Result.Failed)){
			return Result.Failed;
		}else if(result.equals(Result.Warning)){
			return Result.Warning;
		}else{
			return Result.Unknown;
		}
	}

	public Result clickOnElement(WebElement element, String elementVariableName) {
		int elapsedTime = 0;
		Result result = Result.Unknown;
		Boolean retry = true;
		
		do {
			try {
				if (element != null && element.isDisplayed()) {
					element.click();
					result = Result.Passed;
					log.info("Clicking on " + elementVariableName + ", Passed: Element has been clicked successfully");
					test.log(LogStatus.INFO, "Clicking on " + elementVariableName + ", Passed: Element has been clicked successfully");
				} else {
					result = Result.Failed;
					log.info("Clicking on " + elementVariableName + ", FAILED: Unable to click on the element as the element does not exist");
					test.log(LogStatus.INFO, "Clicking on " + elementVariableName + ", FAILED: Unable to click on the element as the element does not exist");
				}

			} catch (Exception e) {
				result = Result.Failed;
				log.info("Clicking on " + elementVariableName + ", FAILED: Unable to click on the element as the following exception happend, exception message = ");
				test.log(LogStatus.INFO, "Clicking on " + elementVariableName + ", FAILED: Unable to click on the element as the following exception happend, exception message = ");
			}

			if (result.equals(Result.Passed) || elapsedTime >= waitTime) {
				retry = false;
			} else {
				retry = true;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				elapsedTime += 1;
			}
		} while (retry);
		
		if(result.equals(Result.Passed)){
			return Result.Passed;
		}else if(result.equals(Result.Failed)){
			return Result.Failed;
		}else if(result.equals(Result.Warning)){
			return Result.Warning;
		}else{
			return Result.Unknown;
		}
	}

	public String checkElementProperty(WebElement element, String propertyType, String elementName) {
		String valueOfProperty = null;
		if (propertyType.equalsIgnoreCase("class")) {
			valueOfProperty = element.getAttribute("class");
		} else if (propertyType.equalsIgnoreCase("getText")) {
			valueOfProperty = element.getText();
		} else if (propertyType.equalsIgnoreCase("name")) {
			valueOfProperty = element.getAttribute("name");
		} else if (propertyType.equalsIgnoreCase("value")) {
			valueOfProperty = element.getAttribute("value");
		} else if (propertyType.equalsIgnoreCase("id")) {
			valueOfProperty = element.getAttribute("id");
		} else if (propertyType.equalsIgnoreCase("status")) {
			valueOfProperty = element.getAttribute("status");
		} else if (propertyType.equalsIgnoreCase("aria-label")) {
			valueOfProperty = element.getAttribute("aria-label");
		} else if (propertyType.equalsIgnoreCase("title")) {
			valueOfProperty = element.getAttribute("title");
		} else if (propertyType.equalsIgnoreCase("autocomplete")) {
			valueOfProperty = element.getAttribute("autocomplete");
		} else if (propertyType.equalsIgnoreCase("readonly")) {
			valueOfProperty = element.getAttribute("readonly");
		} else if (propertyType.equalsIgnoreCase("style")) {
			valueOfProperty = element.getAttribute("style");
		} else if (propertyType.equalsIgnoreCase("disabled")) {
			valueOfProperty = element.getAttribute("disabled");
		} else if (propertyType.equalsIgnoreCase("type")) {
			valueOfProperty = element.getAttribute("type");
		} else if (propertyType.equalsIgnoreCase("maxlength")) {
			valueOfProperty = element.getAttribute("maxlength");
		}
		// test.log(LogStatus.INFO, "Get the value of the property (" +
		// propertyType + ") of the Element (" + elementName + ") which is (" +
		// valueOfProperty + ")");
		return valueOfProperty;
	}

	public void tahalufDropDownList(By byListElement, By byTextElement, By byFilteredElement, String dataToInsertt,
			String elementVariableName) {
		log.info("Inside " + new Throwable().getStackTrace()[0].getMethodName());

		WebElement listMaritalStatus = elementLocator(byListElement, elementVariableName);
		clickOnElement(listMaritalStatus, elementVariableName);

		WebElement textMaritalStatus = elementLocator(byTextElement, elementVariableName);
		insertDataIntoElement(textMaritalStatus, dataToInsertt, elementVariableName);

		WebElement listMaritalStatusToSelect = elementLocator(byFilteredElement, elementVariableName);
		clickOnElement(listMaritalStatusToSelect, elementVariableName);

		log.info("Clicked on the elemnt " + elementVariableName + " in the drop down list");
		// waitUntilTheLoadingFlagGetHidden();
	}
	
	public void tahalufDropDownListSelect(By byListElement, By byFilteredElement, String elementVariableName) {
		log.info("Inside " + new Throwable().getStackTrace()[0].getMethodName());

		WebElement listMaritalStatus = elementLocator(byListElement, elementVariableName);
		clickOnElement(listMaritalStatus, elementVariableName);

		WebElement listMaritalStatusToSelect = elementLocator(byFilteredElement, elementVariableName);
		clickOnElement(listMaritalStatusToSelect, elementVariableName);

		log.info("Clicked on the elemnt " + elementVariableName + " in the drop down list");
		// waitUntilTheLoadingFlagGetHidden();
	}
}