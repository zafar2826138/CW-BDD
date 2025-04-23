package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverHelper {

    private static WebDriver driver;

    private DriverHelper(){}
    public static WebDriver getDriver(){
        if (driver==null || ((RemoteWebDriver)driver).getSessionId()==null) {
            switch (ConfigReader.ReadProperty("browser").toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                    case  "headless":
                    driver = HeadlessChromeDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
        }
        public static WebDriver HeadlessChromeDriver (){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Headless mode
            options.addArguments("--disable-gpu"); // For compatibility
            options.addArguments("--window-size=1920,1080"); // Optional, helpful for layout consistency
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            return new ChromeDriver(options);
        }
    }

