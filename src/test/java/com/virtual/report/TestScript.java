package com.virtual.report;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import com.spacex.api.SpaceXApi;
import com.test.base.TestBase;
import com.test.util.TestInfo;
import com.test.util.UiUtil;
import com.blaze.ui.*;

public class TestScript extends TestBase {
	static Logger log = Logger.getLogger(TestScript.class);
	private SpaceXApi spacApi=null;
	private TestInfo apiSpaceInfo=null;
	private BlazeWelcomePage hmPage=null;
	private blazee2e cmPage=null;
	private BlazeFlightsPage flightsPage=null;
	private PurchaseTicketPage purchasePage=null;
	private BookingConfirmationPage confimationPage=null;
	String depCity, depCitye2e;
	String destCity, destCitye2e;
	
	@BeforeSuite
	public void start() {
		TestBase.uiSetup();
		TestBase.apiSetup();
		hmPage = new BlazeWelcomePage(driver);
		cmPage = new blazee2e(driver);
		flightsPage = new BlazeFlightsPage(driver);
		purchasePage = new PurchaseTicketPage(driver);
		confimationPage = new BookingConfirmationPage(driver);		
		depCity=uiProd.getProperty("departureCity");
		destCity=uiProd.getProperty("destinationCity");
		depCitye2e=uiProd.getProperty("departureCityE2E");
		destCitye2e=uiProd.getProperty("destinationCityE2E");
		
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
		
		spacApi= new SpaceXApi();
		apiSpaceInfo=spacApi.getMethod();		
	
		UiUtil.apivalidator(apiSpaceInfo, flightNumber, flightName, flightSuccess);
		log.info("SpaceX API response details are received"+apiSpaceInfo.toString());
		
		
	}
	@Test(enabled=true,description="Blaze UI: Home Page Verification")
	public void blazeUIHomePageVerification() throws InterruptedException {		
	
	hmPage = new BlazeWelcomePage(driver);
	hmPage.HomePageVerification();
	
	}
	@Test(enabled=true,priority=1,description="Blaze UI: Find Flights by selecting source and destination")
	public void blazeUIFindFlights() throws InterruptedException {		
	
	
	hmPage.HomePageVerification();
	hmPage.HomePageTitleVerification("Welcome to the Simple Travel Agency!");
	hmPage.chooseDepartureCity(depCity);
	hmPage.chooseDestinationCity(destCity);
	hmPage.submittoFindFlights();
	}
	
	@Test(enabled=true,priority=2,description="Blaze UI: End 2 End Flow Book a flight")
	public void blazeUIEnd2EndFlow() throws InterruptedException {

	cmPage.TraveltheworldSelection();
	hmPage.HomePageVerification();
	hmPage.HomePageTitleVerification("Welcome to the Simple Travel Agency!");
	hmPage.chooseDepartureCity(depCitye2e);
	hmPage.chooseDestinationCity(destCitye2e);
	hmPage.submittoFindFlights();
	flightsPage.verifyFlightPageHeader(depCitye2e,destCitye2e);
	flightsPage.choosethisflight(1);
	purchasePage.submitPurchaseTicket();
	confimationPage.getConfirmation();
	}			

}
