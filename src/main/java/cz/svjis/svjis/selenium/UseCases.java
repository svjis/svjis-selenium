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

import cz.svjis.svjis.selenium.commands.AdminCommands;
import cz.svjis.svjis.selenium.commands.RedactionCommands;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author jarberan
 */
public class UseCases {
    
    public static void doParametrization(WebDriver driver) throws IOException, SvjisSeleniumException {
        Constants c = Constants.getInstance();
        
        AdminCommands.loginUser(driver, c.getString("app.adm.user"), c.getString("app.adm.pass"));
        SeleniumUtils.takeSnapShot(driver, "param01.png");
        AdminCommands.fillInCompany(driver);
        SeleniumUtils.takeSnapShot(driver, "param02.png");
        AdminCommands.fillInBuilding(driver);
        SeleniumUtils.takeSnapShot(driver, "param03.png");
        AdminCommands.fillInEntrances(driver, 1);
        AdminCommands.fillInEntrances(driver, 2);
        SeleniumUtils.takeSnapShot(driver, "param04.png");
        AdminCommands.fillInBuildingUnits(driver, 1);
        AdminCommands.fillInBuildingUnits(driver, 2);
        AdminCommands.fillInBuildingUnits(driver, 3);
        AdminCommands.fillInBuildingUnits(driver, 4);
        SeleniumUtils.takeSnapShot(driver, "param05.png");
        AdminCommands.fillInRoles(driver, 1);
        SeleniumUtils.takeSnapShot(driver, "param06.png");
        AdminCommands.fillInUsers(driver, 1);
        AdminCommands.fillInUsers(driver, 2);
        AdminCommands.fillInUsers(driver, 3);
        AdminCommands.fillInUsers(driver, 4);
        AdminCommands.fillInUsers(driver, 5);
        AdminCommands.fillInUsers(driver, 6);
        SeleniumUtils.takeSnapShot(driver, "param07.png");
        AdminCommands.fillInBoard(driver, 1);
        AdminCommands.fillInBoard(driver, 2);
        AdminCommands.fillInBoard(driver, 3);
        AdminCommands.fillInBoard(driver, 4);
        SeleniumUtils.takeSnapShot(driver, "param08.png");
        AdminCommands.fillInUserUnit(driver, 1); 
        AdminCommands.fillInUserUnit(driver, 2);
        AdminCommands.fillInUserUnit(driver, 3);
        AdminCommands.fillInUserUnit(driver, 4);
        AdminCommands.fillInUserUnit(driver, 5);
        SeleniumUtils.takeSnapShot(driver, "param09.png");
        AdminCommands.logoutUser(driver);
        SeleniumUtils.takeSnapShot(driver, "param10.png");
    }
    
    public static void doRedactionTest(WebDriver driver) throws IOException, SvjisSeleniumException {
        Constants c = Constants.getInstance();
        
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 1), c.getString("adm.user.password", 1));
        SeleniumUtils.takeSnapShot(driver, "redaction01.png");
        RedactionCommands.createArticle(driver, 1);
        SeleniumUtils.takeSnapShot(driver, "redaction02.png");
        AdminCommands.logoutUser(driver);
        SeleniumUtils.takeSnapShot(driver, "redaction03.png");
    }
}
