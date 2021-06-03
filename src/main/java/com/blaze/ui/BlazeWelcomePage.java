package com.blaze.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.test.base.TestBase;
import com.test.util.UiUtil;


public class BlazeWelcomePage extends TestBase {
	public BlazeWelcomePage(WebDriver driver) {
		
	}
	public void HomePage() {
		WebElement submit =driver.findElement(By.xpath("//input[@type='submit']"));
		UiUtil.waitForElement(driver,submit);
		if(submit.isEnabled()) { 
	         System.out.println("Test 1 Pass"); 
	      } else { 
	         System.out.println("Test 1 Fail"); 
	      } 	       
	}
	
}
