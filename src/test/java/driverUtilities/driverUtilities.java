package driverUtilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class driverUtilities {

    private static driverUtilities instanceOfDriverUtilities;
    private WebDriver driver;

    public static driverUtilities getInstanceOfDriverUtilities() {
        if (instanceOfDriverUtilities == null) {
            instanceOfDriverUtilities = new driverUtilities();
        }
        return instanceOfDriverUtilities;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            CreateDriver();
        }
        return driver;
    }

    private String GetDriverName() {
        Properties config = new Properties();
        String driverName = "";

        try {
            config.load(new FileInputStream("config.properties"));
        } catch (FileNotFoundException e) {
            System.out.println("Config file is not present");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error when loading config file");
            e.printStackTrace();
        }

        for (String key : config.stringPropertyNames()) {
            if (key.equals("browser")) {
                driverName = config.getProperty(key);
            }
        }
        return driverName;
    }

    private void CreateDriver() {
        String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            this.driver = createRemoteDriver(remoteUrl);
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            this.driver.manage().window().maximize();
            return;
        }

        String driverName = GetDriverName();

        switch (driverName) {
            case "Google Chrome":
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser in config.properties: " + driverName);
        }
    }

    private WebDriver createRemoteDriver(String remoteUrl) {
        String browser = System.getenv("BROWSER");
        String browserName = (browser == null || browser.isBlank()) ? "chrome" : browser.toLowerCase();

        try {
            switch (browserName) {
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("-headless");
                    return new RemoteWebDriver(new URL(remoteUrl), firefoxOptions);
                case "chrome":
                default:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    return new RemoteWebDriver(new URL(remoteUrl), chromeOptions);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid SELENIUM_REMOTE_URL: " + remoteUrl, e);
        }
    }
}
