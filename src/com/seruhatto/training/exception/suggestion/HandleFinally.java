package com.seruhatto.training.exception.suggestion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Never throw any exception from finally block Use finally blocks instead of
 * catch blocks if you are not going to handle exception
 * 
 * @author seruhatto
 *
 */
public class HandleFinally {
    private static Logger logger = Logger.getLogger(HandleFinally.class.getName());

    public static void main(String[] args) {
	try {
	    doMethod();
	} catch (Exception e) {
	    logger.log(Level.SEVERE, "Error occured ", e);
	}
    }

    private static void doMethod() throws Exception {

	try {
	    // Something is Wrong
	    String abc = null;
	    abc.toString();
	} finally {
	    releaseAndClear();
	}
    }

    private static void releaseAndClear() throws Exception {
	try {
	    throw new Exception("Error during Release");
	} catch (Exception e) {
	    logger.log(Level.SEVERE, "releaseAndClear does not run ", e);
	}
    }
}
