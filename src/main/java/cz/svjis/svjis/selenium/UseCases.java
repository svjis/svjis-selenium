/*
 *       UseCases.java
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

import java.io.IOException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author jarberan
 */
public class UseCases {
    
    public static void doParametrization(WebDriver driver) throws IOException {
        Commands.getUrl(driver, Constants.APP_URL);
        SeleniumUtils.takeSnapShot(driver, "test01.png");
        Commands.loginUser(driver, Constants.APP_ADM_USER, Constants.APP_ADM_PASS);
        SeleniumUtils.takeSnapShot(driver, "test02.png");
        Commands.logoutUser(driver);
        SeleniumUtils.takeSnapShot(driver, "test03.png");
    }
}
