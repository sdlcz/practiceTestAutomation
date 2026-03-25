package test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverUtilities.driverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageModels.HomePage;
import driverUtilities.driverUtilities;

public class Test1_GoogleSearch {
	WebDriver driver;
	
@Before
public void preConditions() {
	driverUtilities myDriverUtilities = new driverUtilities();
	driver = myDriverUtilities.getDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();
}

@Test
public void elementsDisplayedOnLoginPage() {
	
	driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(testData.Data.searchSite);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("/html/body/div[2]/div[4]/form/div[1]/div[1]/div[2]/div[4]/div[6]/center/input[1]")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	driver.findElement(By.xpath("//*[@id=\"_yrTDaY72L4rskdUP9YGSCQ_45\"]")).click();
	Assert.assertEquals(testData.Data.homePageURL, driver.getCurrentUrl());

	
}

@After
public void tearDown() {
//	driver.quit();
}


}
