package com.blaze.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.test.base.TestBase;
import com.test.util.UiUtil;


public class BlazeWelcomePage extends TestBase {
	SoftAssert sAssert= new SoftAssert();
	public BlazeWelcomePage(WebDriver driver) {
		
	}
	public void HomePageVerification() {
		WebElement submit =driver.findElement(By.xpath("//input[@type='submit']"));
		UiUtil.waitForElement(driver,submit);
		if(submit.isEnabled()) { 
			Reporter.log("HomePageVerification: find flights submit button is not enabled",true);
	      } else { 
	    	  Reporter.log("HomePageVerification: find flights submit button is enabled",true); 
	      } 	       
	}
	
	public void chooseDepartureCity(String departurecity) {		
		Select drpCountry = new Select(driver.findElement(By.name("fromPort")));
		drpCountry.selectByVisibleText(departurecity);
		Reporter.log("chooseDepartureCity: Selection of Departure :"+departurecity,true);
	}
	
	public void chooseDestinationCity(String destinationcity) {
		Select drpCountry = new Select(driver.findElement(By.name("toPort")));
		drpCountry.selectByVisibleText( destinationcity);
		Reporter.log("chooseDestinationCity: Selection of Destination :"+destinationcity,true);
	}
	public void submittoFindFlights() {
		WebElement findflights =driver.findElement(By.xpath("//input[@type='submit']"));
		UiUtil.waitForElement(driver,findflights);
		findflights.click();
		Reporter.log("submittoFindFlights: Find Flight submitted  :",true);
	}	
	public void HomePageTitleVerification(String sTitle)
	{
		WebElement header =driver.findElement(By.tagName("h1"));
		UiUtil.waitForElement(driver,header);
		String title=header.getText();
		sAssert.assertEquals(title, sTitle);
		Reporter.log("HomePageTitleVerification: Title Verified  :"+sTitle,true);
		
	}
}
