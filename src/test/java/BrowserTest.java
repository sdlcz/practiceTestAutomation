import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	
	public static void main(String[] args) {
//		WebDriverManager.chromedriver().browserVersion(null).setup();
		WebDriverManager.firefoxdriver().browserVersion(null).setup();
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://practicesoftwaretesting.com/");
//		firefoxdriver.get("https://practicesoftwaretesting.com/");

//		Assert.assertEquals("https://practicesoftwaretesting.com/", driver.getCurrentUrl());
	}
	
	

}
