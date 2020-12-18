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
import cz.svjis.svjis.selenium.commands.EndUserCommands;
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
        RedactionCommands.createNews(driver, 1);
        SeleniumUtils.takeSnapShot(driver, "redaction03.png");
        RedactionCommands.createInquiry(driver, 1);
        SeleniumUtils.takeSnapShot(driver, "redaction04.png");
        AdminCommands.logoutUser(driver);
        SeleniumUtils.takeSnapShot(driver, "redaction05.png");
    }
    
    public static void doEndUserTest(WebDriver driver) throws IOException, SvjisSeleniumException {
        Constants c = Constants.getInstance();
        
        /* Petr */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 1), c.getString("adm.user.password", 1));
        SeleniumUtils.takeSnapShot(driver, "euser01.png");
        EndUserCommands.voteInquiry(driver, "vote-1", 1);
        SeleniumUtils.takeSnapShot(driver, "euser02.png");
        AdminCommands.logoutUser(driver);
        SeleniumUtils.takeSnapShot(driver, "euser03.png");
        
        /* Jana */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 2), c.getString("adm.user.password", 2));
        SeleniumUtils.takeSnapShot(driver, "euser04.png");
        EndUserCommands.voteInquiry(driver, "vote-1", 1);
        SeleniumUtils.takeSnapShot(driver, "euser05.png");
        AdminCommands.logoutUser(driver);
        SeleniumUtils.takeSnapShot(driver, "euser06.png");
        
        /* Jiri */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 5), c.getString("adm.user.password", 5));
        SeleniumUtils.takeSnapShot(driver, "euser07.png");
        EndUserCommands.voteInquiry(driver, "vote-3", 1);
        SeleniumUtils.takeSnapShot(driver, "euser08.png");
        AdminCommands.logoutUser(driver);
        SeleniumUtils.takeSnapShot(driver, "euser09.png");
        
        /* Tomas */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 6), c.getString("adm.user.password", 6));
        SeleniumUtils.takeSnapShot(driver, "euser10.png");
        EndUserCommands.voteInquiry(driver, "vote-2", 1);
        SeleniumUtils.takeSnapShot(driver, "euser11.png");
        AdminCommands.logoutUser(driver);
        SeleniumUtils.takeSnapShot(driver, "euser12.png");
        
        /* Article comment */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 5), c.getString("adm.user.password", 5));
        SeleniumUtils.takeSnapShot(driver, "euser13.png");
        EndUserCommands.createArticleComment(driver, c.getString("redaction.articles.header", 1) , "Dobrý den,\nprosím podívejte se na https://www.seznam.cz/\n S pozdravem " + c.getString("adm.user.email", 5));
        SeleniumUtils.takeSnapShot(driver, "euser14.png");
        AdminCommands.logoutUser(driver);
        SeleniumUtils.takeSnapShot(driver, "euser15.png");
    }
}
