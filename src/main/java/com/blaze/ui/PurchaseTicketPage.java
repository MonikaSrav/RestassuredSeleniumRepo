package com.blaze.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.test.base.TestBase;
import com.test.util.UiUtil;

public class PurchaseTicketPage extends TestBase{
	
	SoftAssert sAssert= new SoftAssert();
	public PurchaseTicketPage(WebDriver driver) {
		
	}
	
	
	public void submitPurchaseTicket() {
		WebElement purchaseFlight =driver.findElement(By.xpath("*//input[@type='submit' and @value='Purchase Flight']"));
		UiUtil.waitForElement(driver,purchaseFlight);
		purchaseFlight.click();
		Reporter.log("submitPurchaseTicket: purchase flight selected",true); 
	}
}
