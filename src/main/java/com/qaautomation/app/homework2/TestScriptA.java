package com.qaautomation.app.homework2;

/*
 * Set of test scripts for testing PrestaShop Website
 * The test scripts are developed using Selenium Framework
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Roxy
 *        Test Script 01
 *        **************
 *        Test Steps
 *        1. Go to the Admin Panel
 *        2. Enter valid user login, password and click the "Login" button
 *        3. Click the user pictogram in the upper right corner and choose the "Logout" option
 */
public class TestScriptA {

    public static void main(String[] args) {

        // Setup Firefox driver
        System.setProperty("webdriver.chrome.driver", Util.DRIVER_EXE);

        WebDriver driver = new ChromeDriver();

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

        // wait until user pictogram load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_employee_box")));

        //Click User pictogram
        WebElement userPic = driver.findElement(By.id("header_employee_box"));
        userPic.click();

        // Click the "Logout" button
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();

        // Close the browser
        driver.quit();
    }
}


