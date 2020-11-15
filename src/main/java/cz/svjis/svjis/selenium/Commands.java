/*
 *       Commands.java
 *
 *       This file is part of SVJIS project.
 *       https://github.com/svjis/svjis-selenium
 *
 *       SVJIS is free software; you can redistribute it and/or modify
 *       it under the terms of the GNU General Public License as published by
 *       the Free Software Foundation; either version 3 of the License, or
 *       (at your option) any later version. <http://www.gnu.org/licenses/>
 */
package cz.svjis.svjis.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author jarberan
 */
public class Commands {
    
    public static void getUrl(WebDriver driver, String url) {
        driver.get(url);
    }
    
    public static void loginUser(WebDriver driver, String user, String password) {        
        WebElement usernameInput = driver.findElement(By.id("login-input"));
        usernameInput.sendKeys(user);
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        passwordInput.sendKeys(password);
        clickAndWaitForClickable(driver, By.id("login-submit"), By.id("logout-submit"));
    }
    
    public static void logoutUser(WebDriver driver) {
        clickAndWaitForClickable(driver, By.id("logout-submit"), By.id("login-submit"));
    }
    
    public static void fillInCompany(WebDriver driver) {        
        clickAndWaitForClickable(driver, By.linkText(Constants.MENU_ADM), By.linkText(Constants.ADM_COMPANY));
        fillIn(driver.findElement(By.id("name-input")), Constants.ADM_COMPANY_NAME);
        fillIn(driver.findElement(By.id("address-input")), Constants.ADM_COMPANY_ADDRESS);
        fillIn(driver.findElement(By.id("city-input")), Constants.ADM_COMPANY_CITY);
        fillIn(driver.findElement(By.id("postcode-input")), Constants.ADM_COMPANY_POSTCODE);
        fillIn(driver.findElement(By.id("phone-input")), Constants.ADM_COMPANY_PHONE);
        fillIn(driver.findElement(By.id("fax-input")), Constants.ADM_COMPANY_FAX);
        fillIn(driver.findElement(By.id("email-input")), Constants.ADM_COMPANY_EMAIL);
        fillIn(driver.findElement(By.id("regno-input")), Constants.ADM_COMPANY_REGNO);
        fillIn(driver.findElement(By.id("vatregno-input")), Constants.ADM_COMPANY_VAT_REGNO);
        fillIn(driver.findElement(By.id("idomain-input")), Constants.ADM_COMPANY_DOMAIN);
        clickAndWaitForValue(driver, By.id("submit"), By.className("message"), Constants.ADM_COMPANY_SAVED);
    }
    
    public static void fillInBuilding(WebDriver driver) {
        clickAndWaitForClickable(driver, By.linkText(Constants.MENU_ADM), By.linkText(Constants.ADM_COMPANY));
        clickAndWaitForClickable(driver, By.linkText(Constants.ADM_BUILDING), By.linkText(Constants.ADM_BUILDING));
        fillIn(driver.findElement(By.id("address-input")), Constants.ADM_BUILDING_ADDRESS);
        fillIn(driver.findElement(By.id("city-input")), Constants.ADM_BUILDING_CITY);
        fillIn(driver.findElement(By.id("postcode-input")), Constants.ADM_BUILDING_POSTCODE);
        fillIn(driver.findElement(By.id("regno-input")), Constants.ADM_BUILDING_REGNO);
        clickAndWaitForValue(driver, By.id("submit"), By.className("message"), Constants.ADM_BUILDING_SAVED);
    }
    
    private static void fillIn(WebElement e, String text) {
        e.clear();
        e.sendKeys(text);
    }
    
    private static void clickAndWaitForClickable(WebDriver driver, By clickBy, By expectedBy) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.findElement(clickBy).click();
        wait.until(
            ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(driver.findElement(expectedBy))
            )
        );
    }
    
    private static void clickAndWaitForValue(WebDriver driver, By clickBy, By expectedBy, String expectedValue) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.findElement(clickBy).click();
        wait.until(
            ExpectedConditions.or(
                ExpectedConditions.textToBe(expectedBy, expectedValue)
            )
        );
    }
}
