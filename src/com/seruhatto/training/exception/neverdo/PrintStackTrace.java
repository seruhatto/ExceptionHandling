package com.seruhatto.training.exception.neverdo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Don’t use printStackTrace() statement or similar methods
 * @author seruhatto
 */
public class PrintStackTrace {
    private static Logger logger = Logger.getLogger(PrintStackTrace.class.getName());

    public static void main(String[] args) {
	doMethod();
    }

    private static void doMethod() {

	try {
	    // Something is Wrong
	    String abc = null;
	    abc.toString();
	} catch (Exception e) {
	    e.printStackTrace();//don't do this.
	    System.out.println("Error Print:"+e.getMessage());//don't do this
	    logger.log(Level.SEVERE, "Error occured " + e.getMessage());//You can pass "e" variable to log method instead of e.getMessage
	}
    }

}
