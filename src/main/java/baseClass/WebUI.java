package baseClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import helper.EnumHelper.Result;

public class WebUI extends BaseClass{
	private static int waitTime = 30;

	public static WebElement findTestObject(By by, String elementVariableName){
		WebElement element = null;
		if(checkElementIsDisplayed2(by, elementVariableName)){
			element = driver.findElement(by);
		}
		return element;
	}
	
	public static Result clickOnElement(WebElement element, String elementVariableName){
		int elapsedTime = 0;
		Result result = Result.Unknown;
		Boolean retry = true;
		
		do {
			try {
				if (element != null && element.isDisplayed()) {
					highlightWebElement(element);
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
	
	public static Result setText(WebElement element, String Text, String elementVariableName){
		int elapsedTime = 0;
		Result result = Result.Unknown;
		Boolean retry = true;
		do {
			try {
				if (element != null && element.isDisplayed()) {
					highlightWebElement(element);
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
	
	public static Boolean checkElementIsDisplayed2(By by, String elementVariableName) {
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
	
	public static Result verifyElementAttributeValue(WebElement element, String attributeName, String expectedResult) {
		String actualResult = null;
		Result result = Result.Unknown;

		actualResult = element.getAttribute(attributeName);
		if(actualResult.equalsIgnoreCase(expectedResult)){
			result = Result.Passed;
		}else if(!actualResult.equalsIgnoreCase(expectedResult)){
			result = Result.Failed;
		}
		return result;
	}
	
	public static void highlightWebElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ScrollIntoElement(element);
		for(int i=0; i<3; i++){
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			js.executeScript("arguments[0].style.border=''", element);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		js.executeScript("arguments[0].style.border=''", element);
	}
	
	public static void ScrollIntoElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
