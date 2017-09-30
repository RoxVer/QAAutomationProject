package com.qaautomation.app.homework3.pages;

import com.qaautomation.app.homework3.utilities.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * 29.09.2017
 * 22:09
 * Created by Roxy
 */
public class LoginPage {
    private EventFiringWebDriver driver;
    private By emailInput = By.id("email");
    private By passwordInput = By.id("passwd");
    private By loginBtn = By.name("submitLogin");
    private String email = "webinar.test@gmail.com";
    private String password = "Xcg7299bnSmMuRLp9ITw";

    public LoginPage(EventFiringWebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(Properties.getBaseAdminUrl());
    }

    public void fillEmailInput(){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPasswordInput(){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginBtn).click();
    }
}
