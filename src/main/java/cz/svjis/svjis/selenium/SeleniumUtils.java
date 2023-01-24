/*
 *       SeleniumUtils.java
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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author jarberan
 */
public class SeleniumUtils {
    
    public static void init(WebDriver driver) {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
    }
    
    public static void close(WebDriver driver) {
        driver.quit();
    }
    
    public static WebDriver getFirefoxDriver() throws SvjisSeleniumException {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", Constants.getInstance().getString("driver.gecko"));
        FirefoxOptions options = new FirefoxOptions();
        //options.setHeadless(true);
        driver = new FirefoxDriver(options);
        return driver;
    }
    
    public static WebDriver getChromeDriver() throws SvjisSeleniumException {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        String path = Constants.getInstance().getString("driver.chrome");
        File f = new File(path);
        if (f.exists()) {
            System.setProperty("webdriver.chrome.driver", path);
        } else {
            options.addArguments("--headless");
            options.addArguments("window-size=1200,1200");
        }
        driver = new ChromeDriver(options);
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
    
    public static void takeSnapShot(WebDriver webdriver, String file) throws IOException, SvjisSeleniumException {
        String snapshotDir = Constants.getInstance().getString("snapshot.dir");
        if ((snapshotDir == null) || (snapshotDir.equals("")))
            return;
        
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(snapshotDir + file);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public static String getResourcePath(String resource) throws SvjisSeleniumException {
        String path = Constants.getInstance().getResourcePath(resource);
        if (!path.startsWith("/") && !path.startsWith("C:/")) {
            path = String.format("/%s", path);
        }
        return path;
    }
}
