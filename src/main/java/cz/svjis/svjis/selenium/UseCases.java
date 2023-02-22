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
        SeleniumUtils.takeSnapShot(driver, "1-param-01-login.png");
        AdminCommands.fillInCompany(driver);
        SeleniumUtils.takeSnapShot(driver, "1-param-02-company.png");
        AdminCommands.uploadPicture(driver);
        AdminCommands.fillInBuilding(driver);
        SeleniumUtils.takeSnapShot(driver, "1-param-03-building.png");
        AdminCommands.fillInEntrances(driver, 1);
        AdminCommands.fillInEntrances(driver, 2);
        SeleniumUtils.takeSnapShot(driver, "1-param-04-entrances.png");
        AdminCommands.fillInBuildingUnits(driver, 1);
        AdminCommands.fillInBuildingUnits(driver, 2);
        AdminCommands.fillInBuildingUnits(driver, 3);
        AdminCommands.fillInBuildingUnits(driver, 4);
        SeleniumUtils.takeSnapShot(driver, "1-param-05-building-units.png");
        AdminCommands.fillInRoles(driver, 1);
        SeleniumUtils.takeSnapShot(driver, "1-param-06-roles.png");
        AdminCommands.fillInUsers(driver, 1);
        AdminCommands.fillInUsers(driver, 2);
        AdminCommands.fillInUsers(driver, 3);
        AdminCommands.fillInUsers(driver, 4);
        AdminCommands.fillInUsers(driver, 5);
        AdminCommands.fillInUsers(driver, 6);
        SeleniumUtils.takeSnapShot(driver, "1-param-07-user.png");
        AdminCommands.goToUserList(driver);
        SeleniumUtils.takeSnapShot(driver, "1-param-09-users.png");
        AdminCommands.fillInBoard(driver, 1);
        AdminCommands.fillInBoard(driver, 2);
        AdminCommands.fillInBoard(driver, 3);
        AdminCommands.fillInBoard(driver, 4);
        SeleniumUtils.takeSnapShot(driver, "1-param-10-board.png");
        AdminCommands.fillInUserUnit(driver, 1); 
        AdminCommands.fillInUserUnit(driver, 2);
        AdminCommands.fillInUserUnit(driver, 3);
        AdminCommands.fillInUserUnit(driver, 4);
        AdminCommands.fillInUserUnit(driver, 5);
        SeleniumUtils.takeSnapShot(driver, "1-param-11-users-unit.png");
        AdminCommands.logoutUser(driver);
        SeleniumUtils.takeSnapShot(driver, "1-param-12-logout.png");
    }
    
    public static void doRedactionTest(WebDriver driver) throws IOException, SvjisSeleniumException {
        Constants c = Constants.getInstance();
        
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 1), c.getString("adm.user.password", 1));
        SeleniumUtils.takeSnapShot(driver, "2-redaction-01-login.png");
        RedactionCommands.createArticle(driver, 1);
        SeleniumUtils.takeSnapShot(driver, "2-redaction-02-create-article.png");
        AdminCommands.logoutUser(driver);

        AdminCommands.loginUser(driver, c.getString("adm.user.login", 4), c.getString("adm.user.password", 4));
        RedactionCommands.createArticle(driver, 2);
        EndUserCommands.goToArticle(driver, c.getString("redaction.articles.header", 2));
        SeleniumUtils.takeSnapShot(driver, "2-redaction-03-create-article.png");
        AdminCommands.logoutUser(driver);

        AdminCommands.loginUser(driver, c.getString("adm.user.login", 5), c.getString("adm.user.password", 5));
        RedactionCommands.createArticle(driver, 3);
        AdminCommands.logoutUser(driver);

        AdminCommands.loginUser(driver, c.getString("adm.user.login", 1), c.getString("adm.user.password", 1));
        SeleniumUtils.takeSnapShot(driver, "2-redaction-04-login.png");
        RedactionCommands.createNews(driver, 1);
        RedactionCommands.createNews(driver, 2);
        SeleniumUtils.takeSnapShot(driver, "2-redaction-05-news.png");
        RedactionCommands.createInquiry(driver, 1);
        SeleniumUtils.takeSnapShot(driver, "2-redaction-06-inquiry.png");
        AdminCommands.logoutUser(driver);

        SeleniumUtils.takeSnapShot(driver, "2-redaction-07-logout.png");
    }
    
    public static void doEndUserTest(WebDriver driver) throws IOException, SvjisSeleniumException {
        Constants c = Constants.getInstance();
        
        /* Petr vote inquiry */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 1), c.getString("adm.user.password", 1));
        SeleniumUtils.takeSnapShot(driver, "3-euser-01-login.png");
        EndUserCommands.voteInquiry(driver, "vote-1", 1);
        SeleniumUtils.takeSnapShot(driver, "3-euser-02-vote.png");
        AdminCommands.logoutUser(driver);
        
        /* Jana vote inquiry */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 2), c.getString("adm.user.password", 2));
        SeleniumUtils.takeSnapShot(driver, "3-euser-03-login.png");
        EndUserCommands.voteInquiry(driver, "vote-1", 1);
        SeleniumUtils.takeSnapShot(driver, "3-euser-04-vote.png");
        AdminCommands.logoutUser(driver);
        
        /* Jiri vote inquiry */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 5), c.getString("adm.user.password", 5));
        SeleniumUtils.takeSnapShot(driver, "3-euser-05-login.png");
        EndUserCommands.voteInquiry(driver, "vote-3", 1);
        SeleniumUtils.takeSnapShot(driver, "3-euser-06-vote.png");
        AdminCommands.logoutUser(driver);
        
        /* Tomas vote inquiry */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 6), c.getString("adm.user.password", 6));
        SeleniumUtils.takeSnapShot(driver, "3-euser-07-login.png");
        EndUserCommands.voteInquiry(driver, "vote-2", 1);
        SeleniumUtils.takeSnapShot(driver, "3-euser-08-vote.png");
        AdminCommands.logoutUser(driver);
        
        /* Jiri create article comment */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 5), c.getString("adm.user.password", 5));
        SeleniumUtils.takeSnapShot(driver, "3-euser-09-login.png");
        EndUserCommands.createArticleComment(driver, c.getString("redaction.articles.header", 1) , "Dobrý den,\nprosím podívejte se na https://www.seznam.cz/\n S pozdravem " + c.getString("adm.user.email", 5));
        SeleniumUtils.takeSnapShot(driver, "3-euser-10-article-comment.png");
        AdminCommands.logoutUser(driver);
        
        /* Jana create fault report */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 2), c.getString("adm.user.password", 2));
        SeleniumUtils.takeSnapShot(driver, "3-euser-11-login.png");
        EndUserCommands.createFaultReport(driver, c.getString("fault.header", 1), c.getString("adm.entrance.ed", 1), c.getString("fault.body", 1));
        EndUserCommands.addFaultReportAttachment(driver, c.getString("fault.header", 1), c.getString("fault.attachment", 1));
        SeleniumUtils.takeSnapShot(driver, "3-euser-12-create-fault.png");
        AdminCommands.logoutUser(driver);
        
        /* Petr create fault report */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 1), c.getString("adm.user.password", 1));
        SeleniumUtils.takeSnapShot(driver, "3-euser-13-login.png");
        EndUserCommands.createFaultReport(driver, c.getString("fault.header", 2), c.getString("adm.entrance.ed", 2), c.getString("fault.body", 2));
        SeleniumUtils.takeSnapShot(driver, "3-euser-14-create-fault.png");
        EndUserCommands.goToFaultReports(driver);
        SeleniumUtils.takeSnapShot(driver, "3-euser-15-faults.png");

        AdminCommands.logoutUser(driver);
        
        /* Karel take fault report */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 3), c.getString("adm.user.password", 3));
        SeleniumUtils.takeSnapShot(driver, "3-euser-16-login.png");
        EndUserCommands.takeFaultReport(driver, c.getString("fault.header", 1));
        SeleniumUtils.takeSnapShot(driver, "3-euser-17-take-fault.png");
        EndUserCommands.addFaultReportComment(driver, c.getString("fault.header", 1), c.getString("fault.comment", 1));
        SeleniumUtils.takeSnapShot(driver, "3-euser-18-create-fault-comment.png");
        EndUserCommands.goToFaultReports(driver);
        SeleniumUtils.takeSnapShot(driver, "3-euser-19-faults.png");
        AdminCommands.logoutUser(driver);
        
        /* Karel close fault report */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 3), c.getString("adm.user.password", 3));
        SeleniumUtils.takeSnapShot(driver, "3-euser-20-login.png");
        EndUserCommands.addFaultReportComment(driver, c.getString("fault.header", 1), "Hotovo");
        SeleniumUtils.takeSnapShot(driver, "3-euser-21-create-fault-comment.png");
        EndUserCommands.closeFaultReport(driver, c.getString("fault.header", 1));
        SeleniumUtils.takeSnapShot(driver, "3-euser-22-close-fault.png");
        EndUserCommands.goToFaultReports(driver);
        SeleniumUtils.takeSnapShot(driver, "3-euser-23-faults.png");
        AdminCommands.logoutUser(driver);
        
        /* Jana create advert */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 2), c.getString("adm.user.password", 2));
        SeleniumUtils.takeSnapShot(driver, "3-euser-24-login.png");
        EndUserCommands.createAdvert(driver, c.getString("advert.header", 1), c.getString("advert.section", 1), c.getString("advert.body", 1));
        EndUserCommands.addAdvertAttachment(driver, c.getString("advert.attachment", 1));
        SeleniumUtils.takeSnapShot(driver, "3-euser-25-create-advert.png");
        AdminCommands.logoutUser(driver);
        
        /* Jiri create advert */
        AdminCommands.loginUser(driver, c.getString("adm.user.login", 5), c.getString("adm.user.password", 5));
        SeleniumUtils.takeSnapShot(driver, "3-euser-26-login.png");
        EndUserCommands.createAdvert(driver, c.getString("advert.header", 2), c.getString("advert.section", 2), c.getString("advert.body", 2));
        SeleniumUtils.takeSnapShot(driver, "3-euser-27-create-advert.png");
        AdminCommands.logoutUser(driver);
    }
}
