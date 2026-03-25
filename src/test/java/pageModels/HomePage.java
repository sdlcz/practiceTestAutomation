package pageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	//Chat assistant workflow
	public static WebElement toggleChat(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/app-root/app-chat-widget/div/button"));
	}
	public static WebElement chatAssistantHeading(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/app-root/app-chat-widget/div/div/div[1]/span"));
	}
	public static WebElement clickFindAProduct(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/app-root/app-chat-widget/div/div/div[2]/div[1]/div[2]/button[1]"));
	}
	public static WebElement clickFindAProductResponse(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/app-root/app-chat-widget/div/div/div[2]/div[2]/div[1]"));
	}
	public static WebElement closeChat(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/app-root/app-chat-widget/div/div/div[1]/button"));
	}
	
//	Sort & Filtering
	public static WebElement selectSort(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"filters\"]/form[1]/div/select"));
	}
	public static WebElement selectSortAZ(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"filters\"]/form[1]/div/select/option[2]"));
	}
	public static java.util.List<String> getProductNames(WebDriver driver) {
	    java.util.List<org.openqa.selenium.WebElement> productElements = 
	        driver.findElements(By.xpath("/html/body/app-root/div[2]/app-overview/div[3]/div[2]/div[1]"));
	    java.util.List<String> productNames = new java.util.ArrayList<>();
	    
	    for (org.openqa.selenium.WebElement product : productElements) {
	        productNames.add(product.getText());
	    }
	    return productNames;
	}

	public static WebElement clickMinimumFilter(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"filters\"]/div[1]/ngx-slider/span[5]"));
	}
	
	public static WebElement clickMaximumFilter(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"filters\"]/div[1]/ngx-slider/span[6]"));
	}
	
	public static WebElement signIn(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a"));
	}
}
