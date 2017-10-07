package com.qaautomation.app.homework3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 29.09.2017
 * 22:57
 * Created by Roxy
 */
public class DashboardPage {
    private EventFiringWebDriver driver;
    private By logoutImage = By.cssSelector("span.employee_avatar_small");
    private By logoutButton = By.id("header_logout");
    private By catalogTab = By.id("subtab-AdminCatalog");
    private By header = By.tagName("h2");
    private By addCategoryButton = By.id("page-header-desc-category-new_category");
    private By newCategoryField = By.id("name_1");
    private By submitNewCategory = By.id("category_form_submit_btn");
    private By alert = By.cssSelector("#content > div:nth-child(4) > div");
    private By nameFilter = By.name("categoryFilter_name");
    private String testCategory = "Бижутерия";
    private By submitFilter = By.cssSelector("#submitFilterButtoncategory > i");
    private By filterResult = By.xpath("//*/td[3]");

    public DashboardPage(EventFiringWebDriver driver){
        this.driver = driver;
    }

    public void clickLogoutImage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions. elementToBeClickable(logoutImage));

        driver.findElement(logoutImage).click();
    }

    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }

    public void selectCatalogItem() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutImage));

        WebElement catalogTabElement = driver.findElement(catalogTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogTabElement).build().perform();

        catalogTabElement.findElements(By.cssSelector("li")).get(1).click();

        WebElement headerElement = driver.findElement(header);
        String headerName = headerElement.getText();
        if(headerName.equals("категории")) {
            System.out.println("Category opened successfully");
        } else {
            throw new Exception("Wrong page opened!");
        }
    }

    public void createCategory() throws Exception {
        WebElement category = driver.findElement(addCategoryButton);
        category.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement headerElement = driver.findElement(header);
        String headerName = headerElement.getText();
        if(headerName.equals("Добавить")) {
            System.out.println("Add page opened successfully");
        } else {
            throw new Exception("Wrong page opened!");
        }

        WebElement newCategory = driver.findElement(newCategoryField);
        newCategory.sendKeys(testCategory);

        WebElement submitCategory = driver.findElement(submitNewCategory);
        submitCategory.click();

        WebElement alertElement = driver.findElement(alert);
        String alertText = alertElement.getText();
        if(alertText.equals("Создано")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        }
    }

    public void filterCategoriesByName() throws Exception {
        WebElement filterElem = driver.findElement(nameFilter);
        filterElem.sendKeys(testCategory);

        WebElement submitName = driver.findElement(submitFilter);
        submitName.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameFilter));

        WebElement result = driver.findElement(filterResult);
        String resultText = result.getText();
        if(resultText.equals(testCategory)){
            System.out.println("Correct category name was found");
        } else {
            throw new Exception("Category not found");
        }
    }
}
