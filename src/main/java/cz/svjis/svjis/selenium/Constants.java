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

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author jarberan
 */
public class Constants {
    private static Constants instance = null;
    private Properties props;
    
    public static Constants getInstance() throws SvjisSeleniumException {
        if (instance == null) {
            instance = new Constants();
        }
        return instance;
    }
    
    private Constants() throws SvjisSeleniumException {
        Class cls = Constants.class;
        ClassLoader cLoader = cls.getClassLoader();
        try (InputStream is = cLoader.getResourceAsStream("constants.properties")) {
            props = new Properties();
            props.load(is);
        } catch (IOException ex) {
            throw new SvjisSeleniumException(ex);
        }
    }
    
    public String getString(String key) throws SvjisSeleniumException {
        String result = props.getProperty(key);
        if (result == null) {
            throw new SvjisSeleniumException("Key doesn't exist: " + key);
        }
        return result;
        
    }
    
    public String getString(String key, int i) throws SvjisSeleniumException {
        key = key + "." + i;
        return getString(key);
    }
    
    public boolean getBoolean(String key) throws SvjisSeleniumException {
        String result = props.getProperty(key);
        if (result == null) {
            throw new SvjisSeleniumException("Key doesn't exist: " + key);
        }
        if (result.equals("true")) {
            return true;
        }
        if (result.equals("false")) {
            return false;
        }
        throw new SvjisSeleniumException("Bad boolean value: " + result);
    }
    
    public boolean getBoolean(String key, int i) throws SvjisSeleniumException {
        key = key + "." + i;
        return getBoolean(key);
    }
}
