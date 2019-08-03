package landingPageTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import landingPage.LandingPage;
import logInTest.LogInTest;

public class LandingPageTest extends BaseClass{
	public static final Logger log = Logger.getLogger(LogInTest.class.getName());
	
	LandingPage landingPage = new LandingPage();
	
	@BeforeClass
	public void initLandingPage(){
		log.info("**********************Tear Down Landing Page Step Class*****************************");
		setPageWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 7)
	public void navigateToWorkVisa() {
		landingPage.navigateToService();
	}
	
	@AfterClass
	public void tearLandingPage(){
		log.info("**********************Tear Down Landing Page Step Class*****************************");
	}
}
