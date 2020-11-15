/*
 *       Constants.java
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

/**
 *
 * @author jarberan
 */
public class Constants {
    public static String APP_URL = "http://localhost:8181/SVJIS/Dispatcher?setcompany=1";
    public static String APP_ADM_USER = "admin";
    public static String APP_ADM_PASS = "masterkey";
    public static String SNAPSHOT_DIR = "C:\\Users\\jarberan\\Desktop\\Screens\\";
    public static String DRIVER_GECKO = "src\\test\\resources\\drivers\\geckodriver.exe";
    
    public static String MENU_ADM = "Administrace";
    
    public static String ADM_COMPANY = "Společenství";
    public static String ADM_COMPANY_NAME = "Společenství vlastníků domu Práčská 1";
    public static String ADM_COMPANY_ADDRESS = "Práčská 1";
    public static String ADM_COMPANY_CITY = "Praha";
    public static String ADM_COMPANY_POSTCODE = "102 00";
    public static String ADM_COMPANY_PHONE = "+420 111 111";
    public static String ADM_COMPANY_FAX = "+420 111 112";
    public static String ADM_COMPANY_EMAIL = "pracska@seznam.cz";
    public static String ADM_COMPANY_REGNO = "123456";
    public static String ADM_COMPANY_VAT_REGNO = "CZ123456";
    public static String ADM_COMPANY_DOMAIN = "www.pracska.cz";
    public static String ADM_COMPANY_SAVED = "Uloženo";
    
    public static String ADM_BUILDING = "Dům";
    public static String ADM_BUILDING_ADDRESS = "Práčská 1";
    public static String ADM_BUILDING_CITY = "Praha";
    public static String ADM_BUILDING_POSTCODE = "102 00";
    public static String ADM_BUILDING_REGNO = "KAT001";
    public static String ADM_BUILDING_SAVED = "Uloženo";
    
}
