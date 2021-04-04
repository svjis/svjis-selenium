/*
 *       EndUserCommands.java
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

import cz.svjis.svjis.selenium.SvjisSeleniumException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author jarberan
 */
public class EndUserCommands extends Commands {
    
    public static void voteInquiry(WebDriver driver, String vote, int i) throws SvjisSeleniumException {
        clickAndWaitForClickable(driver, By.linkText("Články"), By.id("vote-submit"));
        driver.findElement(By.id(vote)).click();
        driver.findElement(By.id("vote-submit")).click();
        driver.findElement(By.id("vote-result"));
    }
    
    public static void createArticleComment(WebDriver driver, String article, String commentText) throws SvjisSeleniumException {
        clickAndWaitForClickable(driver, By.linkText("Články"), By.linkText(article));
        driver.findElement(By.linkText(article)).click();
        fillIn(driver.findElement(By.id("body")), commentText);
        driver.findElement(By.id("submit")).click();
    }
}
