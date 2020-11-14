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
        passwordInput.submit();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(
            ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(driver.findElement(By.id("logout-submit")))
            )
        );
    }
    
    public static void logoutUser(WebDriver driver) {
        driver.findElement(By.id("logout-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(
            ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(driver.findElement(By.id("login-submit")))
            )
        );
    }
}
