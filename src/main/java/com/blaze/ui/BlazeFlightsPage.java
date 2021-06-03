package com.blaze.ui;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
    import org.testng.Reporter;
    import org.testng.asserts.SoftAssert;

     import com.test.base.TestBase;
	 import com.test.util.UiUtil;


	public class BlazeFlightsPage extends TestBase {	
		SoftAssert sAssert= new SoftAssert();
		public BlazeFlightsPage(WebDriver driver) {
			
		}
		
		
		public void verifyFlightPageHeader(String src,String dest) {
			WebElement h3title =driver.findElement(By.tagName("h3"));
			UiUtil.waitForElement(driver,h3title);
			sAssert.assertEquals(h3title.getText().contains(src), true);
			sAssert.assertEquals(h3title.getText().contains(dest), true);
			sAssert.assertEquals(h3title.getText().contains("Flights from"), true);
			Reporter.log("verifyFlightPageHeader: flights page header verified from:"+src+" ,and to:"+dest+  " ,city names",true); 
		}
		
		public void choosethisflight(int flightno) {
			WebElement chooseButton =driver.findElement(By.xpath("(*//input[@type='submit'])[1]"));
			UiUtil.waitForElement(driver,chooseButton);
			chooseButton.click();
			Reporter.log("choosethisflight: Choose this flights button selected",true); 
		}
		

	}


