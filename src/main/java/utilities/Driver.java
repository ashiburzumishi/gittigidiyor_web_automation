package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private Driver(){}
    private static WebDriver webDriver;
    public static WebDriver getWebDriver(){
        if(webDriver == null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("disable-popup-blocking");
            options.addArguments("--disable-infobars");
            options.addArguments("incognito");
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }
    public static void closeDriver(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
}
