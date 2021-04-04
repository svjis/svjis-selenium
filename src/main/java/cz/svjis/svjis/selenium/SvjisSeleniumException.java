/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.svjis.svjis.selenium;

import java.io.IOException;

/**
 *
 * @author jarberan
 */
public class SvjisSeleniumException extends Exception {
    
    private static final long serialVersionUID = -6967396863637035108L;

    /**
     * Creates a new instance of <code>SvjisSeleniumException</code> without
     * detail message.
     */
    public SvjisSeleniumException() {
    }

    /**
     * Constructs an instance of <code>SvjisSeleniumException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SvjisSeleniumException(String msg) {
        super(msg);
    }

    SvjisSeleniumException(IOException ex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
