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
    
    public static String ADM_ENTRANCE = "Seznam vchodů";
    public static String ADM_ENTRANCE_NEW = "Přidat nový vchod";
    public static String ADM_ENTRANCE_E1D = "vchod 1";
    public static String ADM_ENTRANCE_E1A = "Práčská 1";
    public static String ADM_ENTRANCE_E2D = "vchod 2";
    public static String ADM_ENTRANCE_E2A = "Práčská 3";
    
    public static String ADM_BU = "Seznam jednotek";
    public static String ADM_BU_NEW = "Přidat novou jednotku";
    public static String ADM_BU_TYPE_1 = "Byt";
    public static String ADM_BU_ID_1 = "001";
    public static String ADM_BU_DESC_1 = "Byt 001";
    public static String ADM_BU_NUM_1 = "1";
    public static String ADM_BU_DEN_1 = "10";
    public static String ADM_BU_TYPE_2 = "Byt";
    public static String ADM_BU_ID_2 = "002";
    public static String ADM_BU_DESC_2 = "Byt 002";
    public static String ADM_BU_NUM_2 = "1";
    public static String ADM_BU_DEN_2 = "10";
    
    public static String ADM_USER = "Seznam uživatelů";
    public static String ADM_USER_NEW = "Přidat nového uživatele";
    public static String ADM_USER_SAVED = "Uživatel byl uložen.";
    public static String ADM_USER_1_SALUTATION = "Ing.";
    public static String ADM_USER_1_FNAME = "Petr";
    public static String ADM_USER_1_LNAME = "Staněk";
    public static String ADM_USER_1_LANGUAGE = "Čeština";
    public static String ADM_USER_1_INT_NOTICE = "Předseda";
    public static String ADM_USER_1_ADDRESS = "Práčská 1";
    public static String ADM_USER_1_CITY = "Praha";
    public static String ADM_USER_1_POSTCODE = "102 00";
    public static String ADM_USER_1_COUNTRY = "CZ";
    public static String ADM_USER_1_FIXED_PHONE = "+420 111 111 111";
    public static String ADM_USER_1_MOBILE_PHONE = "+420 608 111 111";
    public static String ADM_USER_1_EMAIL = "petr.stanek@myseznam.cz";
    public static boolean ADM_USER_1_SHOW_IN_CONTACTS = true;
    public static String ADM_USER_1_LOGIN = "petr";
    public static String ADM_USER_1_PASSWORD = "petrpass";
    public static boolean ADM_USER_1_SEND_PASSWORD = false;
    public static boolean ADM_USER_1_ENABLED = true;
    public static String ADM_USER_1_ROLES = "Člen výboru;Redaktor;Vlastník";
    public static String ADM_USER_2_SALUTATION = "Mgr.";
    public static String ADM_USER_2_FNAME = "Jana";
    public static String ADM_USER_2_LNAME = "Hamplová";
    public static String ADM_USER_2_LANGUAGE = "Čeština";
    public static String ADM_USER_2_INT_NOTICE = "Vlastník od 19.11.2020";
    public static String ADM_USER_2_ADDRESS = "Práčská 2";
    public static String ADM_USER_2_CITY = "Praha";
    public static String ADM_USER_2_POSTCODE = "102 00";
    public static String ADM_USER_2_COUNTRY = "CZ";
    public static String ADM_USER_2_FIXED_PHONE = "+420 211 111 111";
    public static String ADM_USER_2_MOBILE_PHONE = "+420 608 211 111";
    public static String ADM_USER_2_EMAIL = "jana.hamplova@myseznam.cz";
    public static boolean ADM_USER_2_SHOW_IN_CONTACTS = false;
    public static String ADM_USER_2_LOGIN = "jana";
    public static String ADM_USER_2_PASSWORD = "janapass";
    public static boolean ADM_USER_2_SEND_PASSWORD = false;
    public static boolean ADM_USER_2_ENABLED = true;
    public static String ADM_USER_2_ROLES = "Vlastník";
}
