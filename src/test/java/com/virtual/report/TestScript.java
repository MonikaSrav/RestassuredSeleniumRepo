package com.virtual.report;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;
import com.spacex.api.SpaceXApi;
import com.test.base.TestBase;
import com.test.util.TestInfo;
import com.test.util.UiUtil;
import com.blaze.ui.BlazeWelcomePage;

public class TestScript extends TestBase {
	static Logger log = Logger.getLogger(TestScript.class);
	private SpaceXApi spacApi=null;
	private TestInfo apiSpaceInfo=null;
//	private TestInfo uiSpaceInfo=null;
	private BlazeWelcomePage hmPage=null;
//	private MapPage mapPage=null;

	@BeforeSuite
	public void start() {
		TestBase.uiSetup();
		TestBase.apiSetup();
	}

	@AfterSuite
	public void clean() {
		driver.quit();
	}

	@Test(enabled=true,description="get SpaceX Api Launch Latest details")
	public void getSpaceXApiLaunchLatest() throws InterruptedException {
		
		String flightNumber=apiProd.getProperty("flight_number");
		String flightName=apiProd.getProperty("name");
		String flightSuccess=apiProd.getProperty("success");
		SoftAssert sAssert= new SoftAssert();
		spacApi= new SpaceXApi();
		apiSpaceInfo=spacApi.getMethod();		
	
		UiUtil.apivalidator(apiSpaceInfo, flightNumber, flightName, flightSuccess);
		log.info("SpaceX API response details are received"+apiSpaceInfo.toString());
		
		
	}
	@Test(enabled=true,description="Blaze UI Home Page")
	public void blazeUIHomePage() throws InterruptedException {
		
	
	hmPage = new BlazeWelcomePage(driver);
	hmPage.HomePage();
	}
}
