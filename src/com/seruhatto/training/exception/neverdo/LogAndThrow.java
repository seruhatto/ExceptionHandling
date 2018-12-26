package com.seruhatto.training.exception.neverdo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Either log the exception or throw it but never do the both
 * @author seruhatto
 */
public class LogAndThrow {
    private static Logger logger = Logger.getLogger(LogAndThrow.class.getName());

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
	    logger.log(Level.SEVERE, "Error on doMethod()", e);//remove this line.
	    throw new Exception(e);
	}
    }
}
