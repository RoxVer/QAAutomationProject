package com.qaautomation.app.homework3.tests;

import com.qaautomation.app.homework3.BaseTest;
import com.qaautomation.app.homework3.pages.DashboardPage;
import com.qaautomation.app.homework3.pages.LoginPage;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * 29.09.2017
 * 23:00
 * Created by Roxy
 */
public class CategoryCreationTest extends BaseTest {

    public static void main(String[] args) throws Exception {
        EventFiringWebDriver driver = getConfiguredDriver();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.fillEmailInput();
        loginPage.fillPasswordInput();
        loginPage.clickLoginButton();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.selectCatalogItem();
        dashboardPage.createCategory();
        dashboardPage.filterCategoriesByName();
        dashboardPage.clickLogoutImage();
        dashboardPage.clickLogoutButton();
        quitDriver(driver);
    }
}
