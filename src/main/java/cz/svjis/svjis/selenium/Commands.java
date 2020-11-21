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

import java.util.List;
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
    
    public static void fillInCompany(WebDriver driver) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adm")), By.linkText(c.getString("adm.company")));
        fillIn(driver.findElement(By.id("name-input")), c.getString("adm.company.name"));
        fillIn(driver.findElement(By.id("address-input")), c.getString("adm.company.address"));
        fillIn(driver.findElement(By.id("city-input")), c.getString("adm.company.city"));
        fillIn(driver.findElement(By.id("postcode-input")), c.getString("adm.company.postcode"));
        fillIn(driver.findElement(By.id("phone-input")), c.getString("adm.company.phone"));
        fillIn(driver.findElement(By.id("fax-input")), c.getString("adm.company.fax"));
        fillIn(driver.findElement(By.id("email-input")), c.getString("adm.company.email"));
        fillIn(driver.findElement(By.id("regno-input")), c.getString("adm.company.regno"));
        fillIn(driver.findElement(By.id("vatregno-input")), c.getString("adm.company.vatregno"));
        fillIn(driver.findElement(By.id("idomain-input")), c.getString("adm.company.domain"));
        clickAndWaitForValue(driver, By.id("submit"), By.className("message"), c.getString("adm.company.saved"));
    }
    
    public static void fillInBuilding(WebDriver driver) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adm")), By.linkText(c.getString("adm.building")));
        clickAndWaitForClickable(driver, By.linkText(c.getString("adm.building")), By.id("submit"));
        fillIn(driver.findElement(By.id("address-input")), c.getString("adm.building.address"));
        fillIn(driver.findElement(By.id("city-input")), c.getString("adm.building.city"));
        fillIn(driver.findElement(By.id("postcode-input")), c.getString("adm.building.postcode"));
        fillIn(driver.findElement(By.id("regno-input")), c.getString("adm.building.regno"));
        clickAndWaitForValue(driver, By.id("submit"), By.className("message"), c.getString("adm.building.saved"));
    }
    
    public static void fillInEntrances(WebDriver driver, int i) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adm")), By.partialLinkText(c.getString("adm.entrance")));
        clickAndWaitForClickable(driver, By.partialLinkText(c.getString("adm.entrance")), By.linkText(c.getString("adm.entrance.new")));
        
        clickAndWaitForClickable(driver, By.linkText(c.getString("adm.entrance.new")), By.id("submit"));
        fillIn(driver.findElement(By.id("desc-input")), c.getString("adm.entrance.ed", i));
        fillIn(driver.findElement(By.id("address-input")), c.getString("adm.entrance.ea", i));
        clickAndWaitForClickable(driver, By.id("submit"), By.linkText(c.getString("adm.entrance.new")));
    }
    
    public static void fillInBuildingUnits(WebDriver driver, int i) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adm")), By.partialLinkText(c.getString("adm.bu")));
        clickAndWaitForClickable(driver, By.partialLinkText(c.getString("adm.bu")), By.linkText(c.getString("adm.bu.new")));
        
        clickAndWaitForClickable(driver, By.linkText(c.getString("adm.bu.new")), By.id("submit"));
        driver.findElement(By.id("type-input")).sendKeys(c.getString("adm.bu.type", i));
        fillIn(driver.findElement(By.id("regno-input")), c.getString("adm.bu.id", i));
        fillIn(driver.findElement(By.id("desc-input")), c.getString("adm.bu.desc", i));
        fillIn(driver.findElement(By.id("num-input")), c.getString("adm.bu.num", i));
        fillIn(driver.findElement(By.id("deno-input")), c.getString("adm.bu.den", i));
        clickAndWaitForClickable(driver, By.id("submit"), By.linkText(c.getString("adm.bu.new")));
    }
    
    public static void fillInUsers(WebDriver driver, int i) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adm")), By.partialLinkText(c.getString("adm.user")));
        clickAndWaitForClickable(driver, By.partialLinkText(c.getString("adm.user")), By.linkText(c.getString("adm.user.new")));
        
        clickAndWaitForClickable(driver, By.linkText(c.getString("adm.user.new")), By.id("submit"));
        
        fillIn(driver.findElement(By.id("salutation-input")), c.getString("adm.user.salutation", i));
        fillIn(driver.findElement(By.id("firstname-input")), c.getString("adm.user.fname", i));
        fillIn(driver.findElement(By.id("lastname-input")), c.getString("adm.user.lname", i));
        driver.findElement(By.id("lang-input")).sendKeys(c.getString("adm.user.language", i));
        fillIn(driver.findElement(By.id("note-textarea")), c.getString("adm.user.int.notice", i));
        
        fillIn(driver.findElement(By.id("address-input")), c.getString("adm.user.address", i));
        fillIn(driver.findElement(By.id("city-input")), c.getString("adm.user.city", i));
        fillIn(driver.findElement(By.id("postcode-input")), c.getString("adm.user.postcode", i));
        fillIn(driver.findElement(By.id("country-input")), c.getString("adm.user.country", i));
        fillIn(driver.findElement(By.id("fphone-input")), c.getString("adm.user.fixed.phone", i));
        fillIn(driver.findElement(By.id("cphone-input")), c.getString("adm.user.mobile.phone", i));
        fillIn(driver.findElement(By.id("email-input")), c.getString("adm.user.email", i));
        checkIn(driver.findElement(By.id("show-input")), c.getBoolean("adm.user.show.in.contacts", i));
        
        fillIn(driver.findElement(By.id("lname-input")), c.getString("adm.user.login", i));
        fillIn(driver.findElement(By.id("lpass-input")), c.getString("adm.user.password", i));
        checkIn(driver.findElement(By.id("sendc-input")), c.getBoolean("adm.user.send.password", i));
        checkIn(driver.findElement(By.id("enabled-input")), c.getBoolean("adm.user.enabled", i));
        
        String role[] = c.getString("adm.user.roles", i).split(";");
        for (String r : role) {
            checkIn(driver.findElement(By.xpath("//label[contains(text(), '" + r + "')]/../input")), true);
        }
        clickAndWaitForValue(driver, By.id("submit"), By.className("message"), c.getString("adm.user.saved"));
    }
    
    public static void fillInBoard(WebDriver driver, int i) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adm")), By.partialLinkText(c.getString("adm.board")));
        clickAndWaitForClickable(driver, By.partialLinkText(c.getString("adm.board")), By.linkText(c.getString("adm.board.new")));
        
        clickAndWaitForClickable(driver, By.linkText(c.getString("adm.board.new")), By.id("submit"));
        driver.findElement(By.id("user-input")).sendKeys(c.getString("adm.board.user", i));
        driver.findElement(By.id("type-input")).sendKeys(c.getString("adm.board.type", i));
        clickAndWaitForClickable(driver, By.id("submit"), By.linkText(c.getString("adm.board.new")));
    }
    
    public static void fillInUserUnit(WebDriver driver, int i) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adm")), By.partialLinkText(c.getString("adm.userunit")));
        clickAndWaitForClickable(driver, By.partialLinkText(c.getString("adm.userunit")), By.linkText(c.getString("adm.user.new")));
        
        WebElement baseTable = driver.findElement(By.xpath("//table[@class='list']"));
        List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
        int r = 0;
        for(WebElement e : tableRows) {
            r++;
            if (e.getText().contains(c.getString("adm.userunit.user", i))) {
                break;
            }
        }
        clickAndWaitForClickable(driver, By.xpath("//table[@class='list']/tbody/tr[" + r + "]/td[3]"), By.id("submit"));
        driver.findElement(By.id("unit-input")).sendKeys(c.getString("adm.userunit.flat", i));
        clickAndWaitForClickable(driver, By.id("submit"), By.id("submit"));
    }
    
    public static void fillInRoles(WebDriver driver, int i) throws SvjisSeleniumException {
        Constants c = Constants.getInstance();
        clickAndWaitForClickable(driver, By.linkText(c.getString("menu.adm")), By.partialLinkText(c.getString("adm.role")));
        clickAndWaitForClickable(driver, By.partialLinkText(c.getString("adm.role")), By.linkText(c.getString("adm.role.new")));
        
        clickAndWaitForClickable(driver, By.linkText(c.getString("adm.role.new")), By.id("submit"));
        driver.findElement(By.id("name-input")).sendKeys(c.getString("adm.role.name", i));
        
        String role[] = c.getString("adm.role.perms", i).split(";");
        for (String r : role) {
            checkIn(driver.findElement(By.xpath("//label[contains(text(), '" + r + "')]/../input")), true);
        }
        clickAndWaitForClickable(driver, By.id("submit"), By.linkText(c.getString("adm.role.new")));
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
