package pageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentalsPage {
	
	public static WebElement toggleChat(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/ul/li[6]/a"));
	}

}
