package com.blaze.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.test.base.TestBase;
import com.test.util.UiUtil;
public class BookingConfirmationPage extends TestBase {	
		
		SoftAssert sAssert= new SoftAssert();
		public BookingConfirmationPage(WebDriver driver) {
			
		}		
		
		public void getConfirmation() {
			WebElement id =driver.findElement(By.xpath("*//td[contains(text(),'Id')]/following-sibling::td"));
			UiUtil.waitForElement(driver,id);
			String confimationId=id.getText();
			Reporter.log("getConfirmation: Purchase Flight Ticket Confirmation ID"+confimationId,true); 
		}
	}


