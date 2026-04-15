package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverUtilities.driverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageModels.HomePage;
import pageModels.RentalsPage;
import testData.Data;
import driverUtilities.driverUtilities;

public class Test_Rentals {
	
	WebDriver driver;
	
	@Before
	public void preConditions() {
		driverUtilities myDriverUtilities = new driverUtilities();
		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		driver.get("https://practicesoftwaretesting.com/");
	}
	
	@Test
	public void verifyRentalsPageUrl() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		pageModels.HomePage.clickCategories(driver).click();
		pageModels.HomePage.clickRental(driver).click();
//		wait.until(d -> d.getCurrentUrl().equals(testData.Data.rentalsPageURL));
		Assert.assertEquals(testData.Data.rentalsPageURL, driver.getCurrentUrl());
	}
	
	@After
	public void verifyRentalListings() {
		
	}
}
