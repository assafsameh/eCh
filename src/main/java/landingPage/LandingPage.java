package landingPage;

import baseClass.BaseClass;

public class LandingPage extends BaseClass{
	
	public void navigateToService(){
		navigateToURL(configProp.getProperty("visaURL"));
		// driver.get(configProp.getProperty("visaURL"));
	}
}
