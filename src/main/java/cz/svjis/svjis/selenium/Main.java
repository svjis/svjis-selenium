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

import static cz.svjis.svjis.selenium.SeleniumUtils.getChromeDriver;
import cz.svjis.svjis.selenium.commands.AdminCommands;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author jarberan
 */
public class Main {
    
    public static void main(String args[]) throws IOException, SvjisSeleniumException {
        //WebDriver driver = getGridDriver();
        //WebDriver driver = getFirefoxDriver()í;
        WebDriver driver = getChromeDriver();
        SeleniumUtils.init(driver);
        AdminCommands.getUrl(driver, Constants.getInstance().getString("app.url"));
        
        UseCases.doParametrization(driver);
        UseCases.doRedactionTest(driver);
        UseCases.doEndUserTest(driver);
        
        SeleniumUtils.close(driver);
        System.out.println("Done!");
    }  
}
