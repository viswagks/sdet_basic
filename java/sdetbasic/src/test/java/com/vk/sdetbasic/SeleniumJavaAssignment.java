package com.vk.sdetbasic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SeleniumJavaAssignment extends Utility
{
	
  @BeforeTest
  public void beforeTest()
  {
	  setDriver("firefox");
	  configureDriver();
	  navigateTo("https://www.makemytrip.com/");
  }
	  
  @Test
  public void ps3()
  {
	  Assert.assertEquals(getElement(By.xpath("//img[@alt='Make My Trip']")).isDisplayed(), true);
  }
  
  @Test()
  public void ps4() throws InterruptedException
  {
	  clickElement(By.xpath("//span[text()='Flights']/parent::a[contains(@class, 'header')]"));
	  clickElement(By.xpath("//li[@data-cy='oneWayTrip']"));
	  clickElement(By.xpath("//label[@for='fromCity']"));
	  setText(By.xpath("//input[@placeholder='From']"), "Chennai");
	  clickElement(By.xpath("//p[contains(text(), 'Chennai, ')]"));
	  clickElement(By.xpath("//label[@for='toCity']"));
	  setText(By.xpath("//input[@placeholder='To']"), "Delhi");
	  clickElement(By.xpath("//p[contains(text(), 'New Delhi, ')]"));
	  Thread.sleep(5000);
  }
  
 @AfterTest(alwaysRun = true)
  public void afterTest()
  {
	  getDriver().quit();
  }

}
