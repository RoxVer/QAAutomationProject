package com.qaautomation.app.homework3;

import com.qaautomation.app.homework3.utilities.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * 29.09.2017
 * 23:01
 * Created by Roxy
 */
public abstract class BaseTest {
    private static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "Selenium drivers/Firefox driver/geckodriver.exe");
            return new FirefoxDriver();
        } else if (browser.equals("internet explorer")) {
            System.setProperty("webdriver.ie.driver", "Selenium drivers/IE driver/IEDriverServer.exe");
            return new InternetExplorerDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "Selenium drivers/Chrome driver/chromedriver.exe");
            return new ChromeDriver();
        }
    }

    public static EventFiringWebDriver getConfiguredDriver(){
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        EventFiringWebDriver wrappedDriver = new EventFiringWebDriver(driver);

        wrappedDriver.register(new EventHandler());

        return wrappedDriver;
    }

    public static void quitDriver(WebDriver driver){
        driver.quit();
    }
}
