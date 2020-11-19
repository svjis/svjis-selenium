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
        clickAndWaitForClickable(driver, By.linkText(Constants.MENU_ADM), By.linkText(Constants.ADM_BUILDING));
        clickAndWaitForClickable(driver, By.linkText(Constants.ADM_BUILDING), By.linkText(Constants.ADM_BUILDING));
        fillIn(driver.findElement(By.id("address-input")), Constants.ADM_BUILDING_ADDRESS);
        fillIn(driver.findElement(By.id("city-input")), Constants.ADM_BUILDING_CITY);
        fillIn(driver.findElement(By.id("postcode-input")), Constants.ADM_BUILDING_POSTCODE);
        fillIn(driver.findElement(By.id("regno-input")), Constants.ADM_BUILDING_REGNO);
        clickAndWaitForValue(driver, By.id("submit"), By.className("message"), Constants.ADM_BUILDING_SAVED);
    }
    
    public static void fillInEntrances(WebDriver driver) {
        clickAndWaitForClickable(driver, By.linkText(Constants.MENU_ADM), By.partialLinkText(Constants.ADM_ENTRANCE));
        clickAndWaitForClickable(driver, By.partialLinkText(Constants.ADM_ENTRANCE), By.linkText(Constants.ADM_ENTRANCE_NEW));
        
        clickAndWaitForClickable(driver, By.linkText(Constants.ADM_ENTRANCE_NEW), By.id("submit"));
        fillIn(driver.findElement(By.id("desc-input")), Constants.ADM_ENTRANCE_E1D);
        fillIn(driver.findElement(By.id("address-input")), Constants.ADM_ENTRANCE_E1A);
        clickAndWaitForClickable(driver, By.id("submit"), By.linkText(Constants.ADM_ENTRANCE_NEW));
        
        clickAndWaitForClickable(driver, By.linkText(Constants.ADM_ENTRANCE_NEW), By.id("submit"));
        fillIn(driver.findElement(By.id("desc-input")), Constants.ADM_ENTRANCE_E2D);
        fillIn(driver.findElement(By.id("address-input")), Constants.ADM_ENTRANCE_E2A);
        clickAndWaitForClickable(driver, By.id("submit"), By.linkText(Constants.ADM_ENTRANCE_NEW));
    }
    
    public static void fillInBuildingUnits(WebDriver driver) {
        clickAndWaitForClickable(driver, By.linkText(Constants.MENU_ADM), By.partialLinkText(Constants.ADM_BU));
        clickAndWaitForClickable(driver, By.partialLinkText(Constants.ADM_BU), By.linkText(Constants.ADM_BU_NEW));
        
        clickAndWaitForClickable(driver, By.linkText(Constants.ADM_BU_NEW), By.id("submit"));
        driver.findElement(By.id("type-input")).sendKeys(Constants.ADM_BU_TYPE_1);
        fillIn(driver.findElement(By.id("regno-input")), Constants.ADM_BU_ID_1);
        fillIn(driver.findElement(By.id("desc-input")), Constants.ADM_BU_DESC_1);
        fillIn(driver.findElement(By.id("num-input")), Constants.ADM_BU_NUM_1);
        fillIn(driver.findElement(By.id("deno-input")), Constants.ADM_BU_DEN_1);
        clickAndWaitForClickable(driver, By.id("submit"), By.linkText(Constants.ADM_BU_NEW));
        
        clickAndWaitForClickable(driver, By.linkText(Constants.ADM_BU_NEW), By.id("submit"));
        driver.findElement(By.id("type-input")).sendKeys(Constants.ADM_BU_TYPE_2);
        fillIn(driver.findElement(By.id("regno-input")), Constants.ADM_BU_ID_2);
        fillIn(driver.findElement(By.id("desc-input")), Constants.ADM_BU_DESC_2);
        fillIn(driver.findElement(By.id("num-input")), Constants.ADM_BU_NUM_2);
        fillIn(driver.findElement(By.id("deno-input")), Constants.ADM_BU_DEN_2);
        clickAndWaitForClickable(driver, By.id("submit"), By.linkText(Constants.ADM_BU_NEW));
    }
    
    public static void fillInUsers(WebDriver driver) {
        clickAndWaitForClickable(driver, By.linkText(Constants.MENU_ADM), By.partialLinkText(Constants.ADM_USER));
        clickAndWaitForClickable(driver, By.partialLinkText(Constants.ADM_USER), By.linkText(Constants.ADM_USER_NEW));
        
        clickAndWaitForClickable(driver, By.linkText(Constants.ADM_USER_NEW), By.id("submit"));
        
        fillIn(driver.findElement(By.id("salutation-input")), Constants.ADM_USER_1_SALUTATION);
        fillIn(driver.findElement(By.id("firstname-input")), Constants.ADM_USER_1_FNAME);
        fillIn(driver.findElement(By.id("lastname-input")), Constants.ADM_USER_1_LNAME);
        driver.findElement(By.id("lang-input")).sendKeys(Constants.ADM_USER_1_LANGUAGE);
        fillIn(driver.findElement(By.id("note-textarea")), Constants.ADM_USER_1_INT_NOTICE);
        
        fillIn(driver.findElement(By.id("address-input")), Constants.ADM_USER_1_ADDRESS);
        fillIn(driver.findElement(By.id("city-input")), Constants.ADM_USER_1_CITY);
        fillIn(driver.findElement(By.id("postcode-input")), Constants.ADM_USER_1_POSTCODE);
        fillIn(driver.findElement(By.id("country-input")), Constants.ADM_USER_1_COUNTRY);
        fillIn(driver.findElement(By.id("fphone-input")), Constants.ADM_USER_1_FIXED_PHONE);
        fillIn(driver.findElement(By.id("cphone-input")), Constants.ADM_USER_1_MOBILE_PHONE);
        fillIn(driver.findElement(By.id("email-input")), Constants.ADM_USER_1_EMAIL);
        checkIn(driver.findElement(By.id("show-input")), Constants.ADM_USER_1_SHOW_IN_CONTACTS);
        
        fillIn(driver.findElement(By.id("lname-input")), Constants.ADM_USER_1_LOGIN);
        fillIn(driver.findElement(By.id("lpass-input")), Constants.ADM_USER_1_PASSWORD);
        checkIn(driver.findElement(By.id("sendc-input")), Constants.ADM_USER_1_SEND_PASSWORD);
        checkIn(driver.findElement(By.id("enabled-input")), Constants.ADM_USER_1_ENABLED);
        
        String role[] = Constants.ADM_USER_1_ROLES.split(";");
        for (String r : role) {
            checkIn(driver.findElement(By.xpath("//label[contains(text(), '" + r + "')]/../input")), true);
        }
        clickAndWaitForValue(driver, By.id("submit"), By.className("message"), Constants.ADM_USER_SAVED);
        
        clickAndWaitForClickable(driver, By.linkText(Constants.MENU_ADM), By.partialLinkText(Constants.ADM_USER));
        clickAndWaitForClickable(driver, By.partialLinkText(Constants.ADM_USER), By.linkText(Constants.ADM_USER_NEW));
        
        clickAndWaitForClickable(driver, By.linkText(Constants.ADM_USER_NEW), By.id("submit"));
        fillIn(driver.findElement(By.id("salutation-input")), Constants.ADM_USER_2_SALUTATION);
        fillIn(driver.findElement(By.id("firstname-input")), Constants.ADM_USER_2_FNAME);
        fillIn(driver.findElement(By.id("lastname-input")), Constants.ADM_USER_2_LNAME);
        driver.findElement(By.id("lang-input")).sendKeys(Constants.ADM_USER_2_LANGUAGE);
        fillIn(driver.findElement(By.id("note-textarea")), Constants.ADM_USER_2_INT_NOTICE);
        
        fillIn(driver.findElement(By.id("address-input")), Constants.ADM_USER_2_ADDRESS);
        fillIn(driver.findElement(By.id("city-input")), Constants.ADM_USER_2_CITY);
        fillIn(driver.findElement(By.id("postcode-input")), Constants.ADM_USER_2_POSTCODE);
        fillIn(driver.findElement(By.id("country-input")), Constants.ADM_USER_2_COUNTRY);
        fillIn(driver.findElement(By.id("fphone-input")), Constants.ADM_USER_2_FIXED_PHONE);
        fillIn(driver.findElement(By.id("cphone-input")), Constants.ADM_USER_2_MOBILE_PHONE);
        fillIn(driver.findElement(By.id("email-input")), Constants.ADM_USER_2_EMAIL);
        checkIn(driver.findElement(By.id("show-input")), Constants.ADM_USER_2_SHOW_IN_CONTACTS);
        
        fillIn(driver.findElement(By.id("lname-input")), Constants.ADM_USER_2_LOGIN);
        fillIn(driver.findElement(By.id("lpass-input")), Constants.ADM_USER_2_PASSWORD);
        checkIn(driver.findElement(By.id("sendc-input")), Constants.ADM_USER_2_SEND_PASSWORD);
        checkIn(driver.findElement(By.id("enabled-input")), Constants.ADM_USER_2_ENABLED);
        
        role = Constants.ADM_USER_2_ROLES.split(";");
        for (String r : role) {
            checkIn(driver.findElement(By.xpath("//label[contains(text(), '" + r + "')]/../input")), true);
        }
        clickAndWaitForValue(driver, By.id("submit"), By.className("message"), Constants.ADM_USER_SAVED);
    }
    
    private static void fillIn(WebElement e, String text) {
        e.clear();
        e.sendKeys(text);
    }
    
    private static void checkIn(WebElement e, boolean checked) {
        if (checked && !e.isSelected()) {
            e.click();
        }
        
        if (!checked && e.isSelected()) {
            e.click();
        }
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
