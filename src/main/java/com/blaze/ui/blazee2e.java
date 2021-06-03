package com.blaze.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.testng.Reporter;

import com.test.base.TestBase;
import com.test.util.UiUtil;

public class blazee2e extends TestBase{
	public blazee2e(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public void TraveltheworldSelection() {
		WebElement travel =driver.findElement(By.xpath("//a[contains(text(),'Travel The World')]"));
		UiUtil.waitForElement(driver,travel);
		travel.click();
		Reporter.log("TraveltheworldSelection: Selection of Travel The World link:",true);
	}
}
