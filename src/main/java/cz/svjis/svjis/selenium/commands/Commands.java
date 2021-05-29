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
package cz.svjis.svjis.selenium.commands;

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
    
    private static final int TMOUT_SEC = 15;
    
    public static void getUrl(WebDriver driver, String url) {
        driver.get(url);
    }
    
    protected static void fillIn(WebElement e, String text) {
        e.clear();
        e.sendKeys(text);
    }
    
    protected static void checkIn(WebElement e, boolean checked) {
        if (checked && !e.isSelected()) {
            e.click();
        }
        
        if (!checked && e.isSelected()) {
            e.click();
        }
    }
    
    protected static void clickAndWaitForClickable(WebDriver driver, By clickBy, By expectedBy) {
        WebDriverWait wait = new WebDriverWait(driver, TMOUT_SEC);
        driver.findElement(clickBy).click();
        wait.until(
            ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(driver.findElement(expectedBy))
            )
        );
    }
    
    protected static void clickAndWaitForValue(WebDriver driver, By clickBy, By expectedBy, String expectedValue) {
        WebDriverWait wait = new WebDriverWait(driver, TMOUT_SEC);
        driver.findElement(clickBy).click();
        wait.until(
            ExpectedConditions.or(
                ExpectedConditions.textToBe(expectedBy, expectedValue)
            )
        );
    }
    
    protected static void waitAMoment() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
