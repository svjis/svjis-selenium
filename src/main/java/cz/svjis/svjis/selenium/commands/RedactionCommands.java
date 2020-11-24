/*
 *       RedactionCommands.java
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

import cz.svjis.svjis.selenium.Constants;
import cz.svjis.svjis.selenium.SvjisSeleniumException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author jarberan
 */
public class RedactionCommands extends Commands {
    
    public static void createArticle(WebDriver driver, int i) throws SvjisSeleniumException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.redaction")), By.partialLinkText(c.getString("redaction.articles")));
        clickAndWaitForClickable(driver, By.partialLinkText(c.getString("redaction.articles")), By.linkText(c.getString("redaction.articles.new")));
        clickAndWaitForClickable(driver, By.linkText(c.getString("redaction.articles.new")), By.id("submit"));
        
        fillIn(driver.findElement(By.id("header-input")), c.getString("redaction.articles.header", i));
        
        driver.switchTo().frame(0);
        {
          WebElement element = driver.findElement(By.id("tinymce"));
          js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '" + c.getString("redaction.articles.descr", i) + "'}", element);
        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        {
          WebElement element = driver.findElement(By.id("tinymce"));
          js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '" + c.getString("redaction.articles.body", i) + "'}", element);
        }
        driver.switchTo().defaultContent();
        
        driver.findElement(By.id("menu-input")).sendKeys(c.getString("redaction.articles.menu", i));
        driver.findElement(By.id("lang-input")).sendKeys(c.getString("redaction.articles.lang", i));
        checkIn(driver.findElement(By.id("comments-input")), c.getBoolean("redaction.articles.comments", i));
        checkIn(driver.findElement(By.id("publish-input")), c.getBoolean("redaction.articles.publish", i));
        
        String role[] = c.getString("redaction.articles.visible", i).split(";");
        for (String r : role) {
            checkIn(driver.findElement(By.xpath("//label[contains(text(), '" + r + "')]/../input")), true);
        }
        clickAndWaitForValue(driver, By.id("submit"), By.className("message"), c.getString("saved"));
    }
    
    public static void createNews(WebDriver driver, int i) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.redaction")), By.partialLinkText(c.getString("redaction.news")));
        clickAndWaitForClickable(driver, By.partialLinkText(c.getString("redaction.news")), By.linkText(c.getString("redaction.news.new")));
        clickAndWaitForClickable(driver, By.linkText(c.getString("redaction.news.new")), By.id("submit"));
        
        fillIn(driver.findElement(By.id("body-textarea")), c.getString("redaction.news.body", i));
        driver.findElement(By.id("lang-input")).sendKeys(c.getString("redaction.news.lang", i));
        checkIn(driver.findElement(By.id("publish-input")), c.getBoolean("redaction.news.publish", i));

        clickAndWaitForValue(driver, By.id("submit"), By.className("message"), c.getString("saved"));
    }
}
