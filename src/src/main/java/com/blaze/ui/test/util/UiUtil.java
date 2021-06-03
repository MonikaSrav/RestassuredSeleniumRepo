package src.main.java.com.blaze.ui.test.util;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class UiUtil {
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(UiUtil.class);
	//public static Boolean tempDegreeMatch,tempFahrMatch,windSpeedMatch=false;
	//public static Boolean tempDegree,tempFahr,windSpeed=false;
	public static JSONObject jsonObj=null;
	public static int TIMEOUT_SEC=30;
	public static WebDriverWait wait=null;

	public static void waitForElement(WebDriver driver,WebElement element) {
		wait = new WebDriverWait(driver,TIMEOUT_SEC);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void isCityChecked(String cityName, WebElement checkBox) throws InterruptedException {
		try {
			if(checkBox.isSelected()==false) {
				checkBox.click();
				waitForElement(driver,checkBox);
				wait = new WebDriverWait(driver,TIMEOUT_SEC);
				wait.until(ExpectedConditions.elementToBeClickable(checkBox));
			}
			else {
				log.info("City name is already selected by default\n");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void CityOnMap(String cityName,WebElement cityOnMap, WebElement zoomOut, Actions action) throws InterruptedException {
		if(cityOnMap.isDisplayed()==false) {
			zoomOut.click();
			for(int i=0;i<3;i++) {
				action.sendKeys(Keys.ARROW_DOWN).perform();
				zoomOut.click();
			}
		}
	}	
	public static void apivalidator(TestInfo apiSpaceInfo,String para1, String para2, String para3)
	{
		SoftAssert sAssert= new SoftAssert();
		if(apiSpaceInfo.flightNumber!=null && apiSpaceInfo.flightName!=null && apiSpaceInfo.flightSuccess!=null)
		{
			sAssert.assertEquals(para1,apiSpaceInfo.flightNumber);		
			sAssert.assertEquals(para2,apiSpaceInfo.flightName);		
			sAssert.assertEquals(para3,apiSpaceInfo.flightSuccess);
			sAssert.assertAll();
	    }else {
				Assert.fail("No data returned from API");
			}
		Reporter.log("SpaceX API response details are received"+apiSpaceInfo.flightNumber);
	}
}
