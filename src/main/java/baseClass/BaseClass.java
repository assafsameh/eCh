package baseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import com.relevantcodes.extentreports.LogStatus;

import excelReader.ExcelReader;
import helper.ExtendedWebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public Robot robot;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	ExcelReader excel;
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	String propFilePath = System.getProperty("user.dir") + "\\Config\\Configuation.properties";
	public Properties configProp;
	String log4jConfPath = System.getProperty("user.dir") + "\\Config\\log4j.properties";
	// Initialize Log4j instance
	public static final Logger log = Logger.getLogger(BaseClass.class.getName());

	public BaseClass() {
		try {
			loadConfiguationPropertyFile();
			PropertyConfigurator.configure(log4jConfPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadConfiguationPropertyFile() throws IOException {
		// System.setProperty("webdriver.gecko.driver",
		// System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(propFilePath));
		configProp = new Properties();
		configProp.load(bufferedReader);
	}

	public void takeScreenShot(ITestResult result) throws IOException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String methodName = result.getName();
		// Call getScreenshotAs method to create image file
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\screenShots\\";
		File destFile = new File(
				(String) reportDirectory + methodName + "-" + formater.format(calendar.getTime()) + ".png");
		FileUtils.copyFile(srcFile, destFile);
		test.log(LogStatus.INFO, "<a href='" + destFile + "'> <img src='" + destFile.getAbsolutePath()
				+ "' height='100' width='100'/> </a>");
	}

	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir") + "\\data\\" + excelName;
		excel = new ExcelReader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}

	@BeforeSuite
	public void startUp() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "\\reports\\eChanelsReport-"
				+ formater.format(calendar.getTime()) + ".html", false);

		selectBrowser(configProp.getProperty("browser"));
		maxmizeBroswe();
		navigateToURL(configProp.getProperty("URL"));
	}

	@BeforeMethod
	public void beforeMethod(Method result) {
		setPageWait(30, TimeUnit.SECONDS);
		log.info("****************Start the (" + result.getName() + ") Test Case**********************");
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " Test Case Started");
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " Test Case is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " Test Case is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " Test Case is failed" + result.getThrowable());
			takeScreenShot(result);
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " Test Case is started");
		}
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
		// driver.close();
		log.info("Close the browser");
	}

	public boolean checkElementIsPresent(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public String getElementProperty(WebElement element, String propertyType, String elementName) {
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

		test.log(LogStatus.INFO, "Get the value of the property (" + propertyType + ") of the Element (" + elementName
				+ ") which is (" + valueOfProperty + ")");
		return valueOfProperty;
	}

	public void maxmizeBroswe() {
		driver.manage().window().maximize();
		log.info("Maxmize Broswe");
	}

	public void navigateToURL(String URL) {
		driver.get(URL);
		log.info("Navigate To URL " + URL);
		setPageWait(30, TimeUnit.SECONDS);
	}

	public void selectBrowser(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrom")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		log.info("Select Broser " + browserName);
	}

	public List<WebElement> elementsLocator(By by, String elementVariableName) {
		List<WebElement> elements = null;
		elements = driver.findElements(by);
		return elements;
	}

	public WebElement elementLocator(String path, String locatorType, String elementVariableName) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(path));
			waitForElementClickable(element, 2, elementVariableName);
		}
		return element;
	}

	public WebElement elementLocatorBU(By by, String elementVariableName) {
		if (checkElementIsDisplayed(by, elementVariableName) == true) {
			WebElement element = driver.findElement(by);
			waitForElementClickable(element, 2, elementVariableName);
			Assert.assertTrue(true, "The " + elementVariableName + " is Exist");
			return element;
		} else {
			Assert.assertTrue(false, "The " + elementVariableName + " is NOT Exist");
			return null;
		}
	}

	public WebElement elementLocator(By by, String elementVariableName) {
		ExtendedWebElement ewe = new ExtendedWebElement(driver);
		WebElement webElement = ewe.elementLocator(by, elementVariableName);
		return webElement;
	}

	public Boolean checkElementIsDisplayed(By by, String elementVariableName) {
		List<WebElement> elements = driver.findElements(by);
		if (elements != null && !elements.isEmpty()) {
			if (elements.size() == 1) {
				log.info("Finding webElement (" + elementVariableName + ") 1 time with " + by);
				return true;
			} else if (elements.size() > 1) {
				log.info("Finding webElement (" + elementVariableName + ") " + elements.size() + " times with " + by);
				return true;
			} else {
				log.info("The webElement (" + elementVariableName + ") is NOT present on the page");
				return false;
			}
		} else {
			return null;
		}
	}

	public void tahalufDropDownList(By byListElement, By byTextElement, By byFilteredElement, String dataElement,
			String elementVariableName) {
		log.info("Inside " + new Throwable().getStackTrace()[0].getMethodName());
		WebElement lstWebElement = elementLocator(byListElement, elementVariableName);
		lstWebElement.click();
		WebElement txtWebElement = elementLocator(byTextElement, elementVariableName);
		txtWebElement.sendKeys(dataElement);
		log.info("Insert " + dataElement);
		WebElement filteredWebElement = elementLocator(byFilteredElement, elementVariableName);
		filteredWebElement.click();
		log.info("Click on the " + dataElement + " in the drop down list");
		waitUntilTheLoadingFlagGetHidden();
	}

	public void tahalufProfessionsDropDownList(By byListElement, By byTextElement, By byFilteredElement,
			String dataElement, String elementVariableName) {
		log.info("Inside " + new Throwable().getStackTrace()[0].getMethodName());
		WebElement lstWebElement = elementLocator(byListElement, elementVariableName);
		lstWebElement.click();
		WebElement txtWebElement = elementLocator(byTextElement, elementVariableName);
		txtWebElement.sendKeys(dataElement);
		log.info("Insert " + dataElement);
		sleep(3);
		WebElement filteredWebElement = elementLocator(byFilteredElement, elementVariableName);
		filteredWebElement.click();
		log.info("Clicked on the elemnt in the drop down list");
		waitUntilTheLoadingFlagGetHidden();
	}

	public void sleep(double d) {
		double miliSecond = d * 1000;
		log.info("sleep " + d + " second");
		try {
			Thread.sleep((long) miliSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean closeAdBoxBC() {
		WebElement popUpAdbox = elementLocator(By.xpath("/html/body/div[4]/div[4]/div/ui-view/div[3]/div/div[1]/a"),
				"popUpAdbox");
		try {
			if (popUpAdbox.isEnabled()) {
				popUpAdbox.click();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForElementClickable(WebElement element, int timeOutInSeconds, String elementVariableName) {
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

	public void waitUntilProfessionsListIsDisplayed() {
		try {
			String elementVariableName = "Professions drop down List";
			final WebElement professionsList = elementLocator(
					By.xpath(
							"/html/body/div[4]/div[4]/div/ui-view/div/div[2]/div[4]/div[2]/form/div[1]/div[3]/div[4]/div[2]/uib-accordion/div/div[2]/div[2]/div/div/div[26]/tahaluf-dropdownlist/div[1]/div/div/ul/li/ul/li[1]/div"),
					elementVariableName);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			log.info("Wait Until Professions drop down List List Is Displayed");
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					String professionsListClass = professionsList.getAttribute("class");
					if (professionsListClass.equalsIgnoreCase(
							"ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active")) {
						log.info("The Professions drop down List Is Displayed");
						return true;
					} else {
						log.info("loading Flag has NOT been foumded");
						return false;
					}
				}
			});
		} catch (Exception e) {
		}
	}

	public void waitUntilTheLoadingFlagGetHidden() {
		String elementVariableName = "Flag";
		try {
			final WebElement loadingFlag = elementLocator(By.xpath("//*[@id='loaderDiv']"), elementVariableName);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			log.info("Wait loading Flag");
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					String loadingFlagClass = loadingFlag.getAttribute("class");
					if (loadingFlagClass.equalsIgnoreCase("ng-hide")) {
						log.info("loading Flag has been foumded");
						return true;
					} else {
						log.info("loading Flag has NOT been foumded");
						return false;
					}
				}
			});
		} catch (Exception e) {
		}
	}

	public void setImpliciteWait(long timeout, TimeUnit unit) {
		log.info("Implicite Wait has been set to " + timeout + " " + unit);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

	public void setPageWait(long timeout, TimeUnit unit) {
		log.info("Waiting for page to be loaded for: (" + timeout + ") " + unit);
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("Page is loaded!!!");
	}

	public void uploadAttachmentRobot() {
		String attachPath = configProp.getProperty("attachmentPath");
		StringSelection stringSelection = new StringSelection(attachPath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		try {
			robot = new Robot();
			robot.setAutoDelay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
