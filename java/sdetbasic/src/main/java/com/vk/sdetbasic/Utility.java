package com.vk.sdetbasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utility 
{
	private WebDriver driver;
	public void setDriver(String browser)
    {
        if (browser.equalsIgnoreCase("firefox"))
        {
        	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir").split("java")[0] + "drivers\\geckodriver.exe");
        	this.driver = new FirefoxDriver();
        }
        else
        {
        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").split("java")[0] + "drivers\\chromedriver.exe");
        	this.driver = new ChromeDriver();
        }
    }
	
	public void configureDriver()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	public WebDriver getDriver()
	{
		return this.driver;
	}
	
	public void navigateTo(String url)
    {
        this.driver.get(url);
    }
	
	public WebElement getElement(By identifier)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.elementToBeClickable(identifier));
	}
	
	public void clickElement(By identifier)
	{
		this.getElement(identifier).click();
	}
	
	public void setText(By identifier, String text)
	{
		WebElement element = this.getElement(identifier);
		element.click();
		element.sendKeys(text);
	}
	
}
