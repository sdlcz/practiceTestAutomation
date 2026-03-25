package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverUtilities.driverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageModels.HomePage;
import testData.Data;
import driverUtilities.driverUtilities;

public class Test_Homepage {
	WebDriver driver;
	
	@Before
	public void preConditions() {
		driverUtilities myDriverUtilities = new driverUtilities();
		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		driver.get("https://practicesoftwaretesting.com/");
		
	}
	
//	@Test
//	public void verifyHomepageURL() {
//		Assert.assertEquals(testData.Data.homePageURL, driver.getCurrentUrl());	
//	}
//	
//	@Test
//	public void verifyChatAssistant() {
//		pageModels.HomePage.toggleChat(driver).click();
//		Assert.assertEquals(testData.Data.chatAssistantHeading, pageModels.HomePage.chatAssistantHeading(driver).getText());
//		pageModels.HomePage.clickFindAProduct(driver).click();
//		Assert.assertEquals(testData.Data.chatFindProductResponse, pageModels.HomePage.clickFindAProductResponse(driver).getText());
//		pageModels.HomePage.closeChat(driver).click();
//	}
	
	@Test
	public void verifySortProducts() {
		pageModels.HomePage.selectSort(driver).click();
		pageModels.HomePage.selectSortAZ(driver).click();
//		Assert.assertEquals(testData.Data.sortByNameAZ, pageModels.HomePage.selectSortAZ(driver).getText());
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(d -> pageModels.HomePage.getProductNames(d).size() > 0);
	    
		java.util.List<String> productNames = pageModels.HomePage.getProductNames(driver);
		
		java.util.List<String> sortedNames = new java.util.ArrayList<>(productNames);
		java.util.Collections.sort(sortedNames);
		
	    System.out.println("Actual Products: " + productNames);
	    System.out.println("Sorted Products: " + sortedNames);
	    Assert.assertEquals("Products should be sorted A-Z", sortedNames, productNames);
	}
	
	@After
	public void tearDown() {
//		driver.quit();
	}
}
