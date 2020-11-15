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

import static cz.svjis.svjis.selenium.SeleniumUtils.getFirefoxDriver;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author jarberan
 */
public class Main {
    
    public static void main(String args[]) throws IOException {
        //WebDriver driver = getGridDriver();
        WebDriver driver = getFirefoxDriver();
        SeleniumUtils.init(driver);
        
        UseCases.doParametrization(driver);
        
        SeleniumUtils.close(driver);
    }  
}