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
    
    public static void doParametrization(WebDriver driver) throws IOException, SvjisSeleniumException {
        Constants c = Constants.getInstance();
        Commands.getUrl(driver, c.getString("app.url"));
        SeleniumUtils.takeSnapShot(driver, "param01.png");
        Commands.loginUser(driver, c.getString("app.adm.user"), c.getString("app.adm.pass"));
        SeleniumUtils.takeSnapShot(driver, "param02.png");
        Commands.fillInCompany(driver);
        SeleniumUtils.takeSnapShot(driver, "param03.png");
        Commands.fillInBuilding(driver);
        SeleniumUtils.takeSnapShot(driver, "param04.png");
        Commands.fillInEntrances(driver, 1);
        Commands.fillInEntrances(driver, 2);
        SeleniumUtils.takeSnapShot(driver, "param05.png");
        Commands.fillInBuildingUnits(driver, 1);
        Commands.fillInBuildingUnits(driver, 2);
        SeleniumUtils.takeSnapShot(driver, "param06.png");
        Commands.fillInUsers(driver, 1);
        Commands.fillInUsers(driver, 2);
        SeleniumUtils.takeSnapShot(driver, "param06.png");
        Commands.fillInBoard(driver, 1);
        SeleniumUtils.takeSnapShot(driver, "param07.png");
        Commands.logoutUser(driver);
        SeleniumUtils.takeSnapShot(driver, "param08.png");
    }
}
