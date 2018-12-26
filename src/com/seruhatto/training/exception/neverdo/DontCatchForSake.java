package com.seruhatto.training.exception.neverdo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Always catch only those exceptions that you can actually handle.
 * It doesn't help anything
 * @author seruhatto
 *
 */
public class DontCatchForSake {
    private static Logger logger = Logger.getLogger(DontCatchForSake.class.getName());

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
	} catch (Exception e) {
	    throw e;
	}
    }
}
