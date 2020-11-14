/*
 *       Main.java
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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author jarberan
 */
public class Main {
    private static WebDriver driver;
    private static String nodeUrl;
    private static String snapshotDir = "C:\\Users\\jarberan\\Desktop\\Screens\\";
    
    public static void main(String args[]) throws InterruptedException, MalformedURLException, Exception {
        //WebDriver driver = getGridDriver();
        WebDriver driver = getFirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.get("http://localhost:8181/SVJIS/Dispatcher?setcompany=1");
        takeSnapShot(driver, "test01.png");
        WebElement usernameInput = driver.findElement(By.id("login-input"));
        usernameInput.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        passwordInput.sendKeys("masterkey");
        passwordInput.submit();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.elementToBeClickable(driver.findElement(By.id("logout-submit")))
                )
        );
        Thread.sleep(2000);
        takeSnapShot(driver, "test02.png");
        driver.findElement(By.id("logout-submit")).click();
        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.elementToBeClickable(driver.findElement(By.id("login-submit")))
                )
        );
        Thread.sleep(2000);
        takeSnapShot(driver, "test03.png");
        driver.quit();
    }

    public static WebDriver getFirefoxDriver() {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        //options.setHeadless(true);
        driver = new FirefoxDriver(options);
        return driver;
    }

    public static WebDriver getGridDriver() throws MalformedURLException {
        WebDriver driver;
        String nodeUrl;

        nodeUrl = "";
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
        return driver;
    }

    public static void takeSnapShot(WebDriver webdriver, String file) throws Exception {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(snapshotDir + file);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
