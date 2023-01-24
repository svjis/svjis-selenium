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

import cz.svjis.svjis.selenium.Constants;
import cz.svjis.svjis.selenium.SeleniumUtils;
import cz.svjis.svjis.selenium.SvjisSeleniumException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    
    public static void createFaultReport(WebDriver driver, String header, String entrance, String body) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.fault.reporting")), By.linkText(c.getString("menu.fault.reporting.new")));
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.fault.reporting.new")), By.id("submit"));
        fillIn(driver.findElement(By.id("subject-input")), header);
        driver.findElement(By.id("entrance-input")).sendKeys(entrance);
        fillIn(driver.findElement(By.id("body-textarea")), body);
        driver.findElement(By.id("submit")).click();
    }
    
    private static void goToFaultReport(WebDriver driver, String header) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.fault.reporting")), By.linkText(c.getString("menu.fault.reporting.new")));
        
        WebElement baseTable = driver.findElement(By.xpath("//table[@class='list']"));
        List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
        int r = 0;
        for(WebElement e : tableRows) {
            r++;
            if (e.getText().contains(header)) {
                break;
            }
        }
        clickAndWaitForClickable(driver, By.xpath("//table[@class='list']/tbody/tr[" + r + "]/td[1]"), By.id("submit"));
    }
    
    public static void addFaultReportAttachment(WebDriver driver, String header, String attachment) throws SvjisSeleniumException {
        goToFaultReport(driver, header);
        
        WebElement elem = driver.findElement(By.id("file-upload"));
        elem.sendKeys(SeleniumUtils.getResourcePath(attachment));
        driver.findElement(By.id("file-submit")).click();
    }
    
    public static void takeFaultReport(WebDriver driver, String header) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        
        goToFaultReport(driver, header);
        driver.findElement(By.linkText(c.getString("menu.fault.reporting.take"))).click();
    }
    
    public static void addFaultReportComment(WebDriver driver, String header, String comment) throws SvjisSeleniumException {
        goToFaultReport(driver, header);
        fillIn(driver.findElement(By.id("body")), comment);
        driver.findElement(By.id("submit")).click();
    }
    
    public static void closeFaultReport(WebDriver driver, String header) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        
        goToFaultReport(driver, header);
        driver.findElement(By.linkText(c.getString("menu.fault.reporting.close"))).click();
    }
    
    public static void createAdvert(WebDriver driver, String header, String section, String body) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adverts")), By.linkText(c.getString("menu.adverts.new")));
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adverts.new")), By.id("submit"));
        fillIn(driver.findElement(By.id("header-input")), header);
        driver.findElement(By.id("type-input")).sendKeys(section);
        fillIn(driver.findElement(By.id("body-textarea")), body);
        driver.findElement(By.id("submit")).click();
    }
    
    public static void addAdvertAttachment(WebDriver driver, String attachment) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adverts")), By.linkText(c.getString("menu.adverts.edit")));
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adverts.edit")), By.id("file-submit"));
        
        WebElement elem = driver.findElement(By.id("file-upload"));
        elem.sendKeys(SeleniumUtils.getResourcePath(attachment));
        driver.findElement(By.id("file-submit")).click();
    }
}
