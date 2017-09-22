package com.qaautomation.app;

/*
 * Set of test scripts for testing PrestaShop Website
 * The test scripts are developed using Selenium Framework
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Roxy
 *        Test Script 01
 *        **************
 *        Test Steps
 *        1. Go to the Admin Panel
 *        2. Enter valid user login, password and click the "Login" button
 *        3. Click every item of the main menu (Dashboard, Orders, Catalog, Clients etc.)
 *           to open the corresponding section and do the following
 *               a) Print to the console a header of the opened section
 *               b) Refresh the page and check if the user stays in the same section after refreshing
 */
public class TestScriptB {

    public static void main(String[] args) {

        // Setup Firefox driver
        System.setProperty("webdriver.gecko.driver", Util.DRIVER_EXE);

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        // Create explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Util.WAIT_TIME);

        // launch Firefox and direct it to the URL
        driver.navigate().to(Util.BASE_URL + "admin147ajyvk0/");

        // Enter login
        WebElement loginName = driver.findElement(By.name("email"));
        loginName.sendKeys(Util.LOGIN);

        // Enter password
        WebElement password = driver.findElement(By.name("passwd"));
        password.sendKeys(Util.PASSWD);

        // Click login
        WebElement loginButton = driver.findElement(By.name("submitLogin"));
        loginButton.click();

        // Get all locators
        By[] locators = {By.id("tab-AdminDashboard"), By.id("subtab-AdminParentOrders"), By.id("subtab-AdminCatalog"),
                By.xpath("/html/body/nav/ul/li[5]"), By.id("subtab-AdminParentCustomerThreads"), By.id("subtab-AdminStats"),
                By.id("subtab-AdminParentModulesSf"), By.xpath("/html/body/nav/ul/li[10]"), By.id("subtab-AdminParentShipping"),
                By.id("subtab-AdminParentPayment"), By.id("subtab-AdminInternational"), By.id("subtab-ShopParameters"),
                By.id("subtab-AdminAdvancedParameters")};

        // find all elements by locators and click on them and get section name before and after refresh
        for (int i = 0; i < locators.length; i++) {
            WebElement element = driver.findElement(locators[i]);
            element.click();
            String beforeHeader =  driver.findElement(By.tagName("h2")).getText();
            System.out.println("Before refresh: " + beforeHeader);

            driver.navigate().refresh();

            String afterHeader = driver.findElement(By.tagName("h2")).getText();
            System.out.println("After refresh: " + afterHeader);
            if(beforeHeader.equals(afterHeader)){
                System.out.println("Test case PASSED!");
            } else {
                System.out.println("Test case FAILED!");
            }
        }

        // wait until user pictogram load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_employee_box")));

        // Click User pictogram
        WebElement userPic = driver.findElement(By.id("header_employee_box"));
        userPic.click();

        // Click the "Logout" button
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();

        // Close the browser
        driver.quit();
    }
}


